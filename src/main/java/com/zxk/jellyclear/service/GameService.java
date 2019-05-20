package com.zxk.jellyclear.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxk.jellyclear.controller.ErrorCode;
import com.zxk.jellyclear.entity.Board;
import com.zxk.jellyclear.entity.Player;
import com.zxk.jellyclear.util.Log;
import com.zxk.jellyclear.util.SessionGenerator;

import entity.BoardTemplate;
import entity.PlayerInfo;
import mapper.BoardTemplateMapper;
import mapper.PlayerInfoMapper;

/**
 * 
 * @author xingkai.zhang
 *
 */
@Service
public class GameService {

    @Resource
    private BoardTemplateMapper boardTemplateDao;
    @Resource
    private PlayerInfoMapper playerDao;
    @Autowired
    private LockHelper lockHelper;

    public String startLevel(int level) {
        BoardTemplate template = boardTemplateDao.selectByPrimaryKey(level);
        if (template == null) {
            Log.error("Invalid param : level={}", level);
            return ErrorCode.ERROR_MSG;
        }

        String sessionId = SessionGenerator.gen();
        Player player = new Player(sessionId, template.getBoard());
        if (!persistence(player)) {
            Log.error("Insert new player error, sessionId is duplicate : {}", sessionId);
            return ErrorCode.ERROR_MSG;
        }
        return player.getStartResponse();
    }

    public String move(String sessionId, int row0, int col0, int row1, int col1) {
        if (sessionId == null || sessionId.length() != SessionGenerator.LENGTH) {
            return ErrorCode.ERROR_MSG;
        }
        if (lockHelper.lock(sessionId)) {
            try {
                return move0(sessionId, row0, col0, row1, col1);
            } finally {
                lockHelper.unlock(sessionId);
            }
        } else {
            Log.error("Fail to get lock : {}", sessionId);
        }
        return ErrorCode.ERROR_MSG;
    }

    private String move0(String sessionId, int row0, int col0, int row1, int col1) {
        if (!isLegalParam(row0, col0, row1, col1)) {
            return ErrorCode.ERROR_MSG;
        }
        PlayerInfo info = playerDao.selectByPrimaryKey(sessionId);
        if (info == null) {
            Log.error("Player not found, sessionId={}", sessionId);
            return ErrorCode.ERROR_MSG;
        }
        Player player = new Player(info);
        return player.move(row0, col0, row1, col1);
    }

    private boolean isLegalParam(int row0, int col0, int row1, int col1) {
        int colSize = Board.COL_SIZE;
        int rowSize = Board.ROW_SIZE;
        return row0 >= 0 && row0 < rowSize && col0 >= 0 && col0 < colSize && row1 >= 0 && row1 < rowSize && col1 >= 0
                && col1 < colSize && row0 <= row1 && col0 <= col1;
    }

    private boolean persistence(Player player) {
        PlayerInfo record = new PlayerInfo();
        record.setSessionid(player.getSessionId());
        record.setBoard(player.getBoardStr());
        return playerDao.insert(record) > 0;
    }

}

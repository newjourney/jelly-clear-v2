package com.zxk.jellyclear.entity;

import entity.PlayerInfo;

/**
 * 
 * @author xingkai.zhang
 *
 */
public class Player {

    private String sessionId;
    private Board board;
    
    
    public Player(PlayerInfo info) {
        this(info.getSessionid(), info.getBoard());
    }

    public Player(String sessionId, String boardStr) {
        this.sessionId = sessionId;
        this.board = new Board().parseFrom(boardStr);
    }

    public String move(int row0, int col0, int row1, int col1) {
        board.move(row0, col0, row1, col1);
        return board.toShowString();
    }

    public String getStartResponse() {
        StringBuilder ret = new StringBuilder();
        ret.append(sessionId).append("\n");
        ret.append(board.toShowString());
        return ret.toString();
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getBoardStr() {
        return board.toString();
    }

}

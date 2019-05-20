package com.zxk.jellyclear.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zxk.jellyclear.util.Log;

import entity.LockInfo;
import mapper.LockInfoMapper;

/**
 * 通过数据库实现简单的分布式锁。
 * 牺牲一定的可用性，保证一致性。
 * 
 * @author xingkai.zhang
 *
 */
@Component
public class LockHelper {

    @Resource
    private LockInfoMapper lockDao;

    public boolean lock(String sessionId) {
        int tryCnt = 0;
        for (;;) {
            LockInfo record = new LockInfo();
            record.setSessionid(sessionId);
            try {
                if (lockDao.insert(record) > 0) {
                    return true;
                }
            } catch (Exception e) {
                String message = e.getMessage();
                if (message == null || !message.contains("Duplicate entry")) {
                    Log.error("Get lock error", e);
                } else {
                    // Ignore duplicate key error
                }
            }
            if (++tryCnt == 5) { // 自旋n次
                return false;
            }
        }
    }

    public void unlock(String sessionId) {
        lockDao.deleteByPrimaryKey(sessionId);
    }

}

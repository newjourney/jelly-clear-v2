package com.zxk.jellyclear.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zxk.jellyclear.service.GameService;

/**
 * 
 * @author xingkai.zhang
 *
 */
@RestController
public class GameController extends AbstractController {

    @Resource
    private GameService service;

    @RequestMapping(value="start-level", method=RequestMethod.GET)
    public ResponseEntity<String> startLevel(int level) {
        return plainResponse(service.startLevel(level));
    }
    
    @RequestMapping(value="move", method=RequestMethod.GET)
    public ResponseEntity<String> move(String sessionId, int row0, int col0, int row1, int col1) {
        return plainResponse(service.move(sessionId, row0, col0, row1, col1));
    }

}

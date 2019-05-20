package com.zxk.jellyclear.controller;

import org.springframework.http.ResponseEntity;

/**
 * 
 * @author xingkai.zhang
 *
 */
public abstract class AbstractController {

    protected ResponseEntity<String> plainResponse(String resp) {
        return ResponseEntity.ok()
                .header("Content-Type", "text/plain")
                .body(resp);
    }
}

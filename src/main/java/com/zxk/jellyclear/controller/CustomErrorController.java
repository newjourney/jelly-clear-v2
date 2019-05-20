package com.zxk.jellyclear.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 定制错误页面
 * 
 * @author xingkai.zhang
 *
 */
@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping(ErrorCode.ERROR_PATH)
    @ResponseBody
    public String error(HttpServletRequest request) {
        return ErrorCode.ERROR_MSG;
    }

    @Override
    public String getErrorPath() {
        return ErrorCode.ERROR_PATH;
    }

}

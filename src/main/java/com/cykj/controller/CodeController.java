package com.cykj.controller;

import com.cykj.utils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: LQB
 * @Description: 验证码
 * @create: 2022/11/26 11:38
 */
@Controller()
@RequestMapping()
public class CodeController {

    @RequestMapping("/checkCode")
    @ResponseBody
    protected void sendCode(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ImageUtil.writeCheckCode(req, resp);
            System.out.println("验证码：" + req.getSession().getAttribute("codeString"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

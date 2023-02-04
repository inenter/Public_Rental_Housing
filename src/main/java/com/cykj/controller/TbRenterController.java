package com.cykj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.*;
import com.cykj.service.TbRenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: LQB
 * @Description: 租客
 * @create: 2022/11/26 9:49
 */
@Controller
@RequestMapping("/user")
public class TbRenterController {
    private  int renterId;
    private MessageBean messageBean = new MessageBean();

    @Autowired
    private TbRenterService tbRenterService;

    /**
     * 验证码校验
     */
    @RequestMapping("/check")
    @ResponseBody
    public MessageBean checkCode(String code, HttpServletRequest req) {
        String currCode = (String) req.getSession().getAttribute("codeString");
        if (code.equals(currCode)) {
            messageBean.setCode(200);
        }
        return messageBean;
    }

    /**
     * 登录验证
     */
    @RequestMapping("/login")
    @ResponseBody
    public MessageBean login(@RequestParam("userAcc") String userAcc, @RequestParam("password") String password, HttpServletRequest req) {
        TbRenter tbRenter = tbRenterService.login(userAcc, password);
        if (tbRenter != null) {
            // 将账号存在session
            HttpSession session = req.getSession();
            session.setAttribute("acc", tbRenter.getRenterName());
            messageBean.setCode(200);
            renterId = tbRenter.getRenterId();
        } else {
            messageBean.setCode(-200);
        }
        return messageBean;
    }

    /**
     * 注册
     */
    @RequestMapping("/register")
    @ResponseBody
    public MessageBean register(@RequestParam("obj") String obj) {
        TbRenter tbRenter = JSONObject.parseObject(obj, TbRenter.class);
        TbRenter renter = tbRenterService.login(tbRenter.getRenterAcc(), "");
        if (renter == null) {
            int n = tbRenterService.register(JSONObject.parseObject(obj, TbRenter.class));
            if (n > 0) {
                messageBean.setCode(200);
                messageBean.setMessage("注册成功");
            } else {
                messageBean.setCode(-200);
                messageBean.setMessage("注册失败");
            }
        } else {
            messageBean.setCode(-400);
            messageBean.setMessage("该账号已存在");
        }
        return messageBean;
    }

    /**
     * 用户资料保存
     */
    @RequestMapping("/save")
    @ResponseBody
    public MessageBean save(@RequestParam("person") String person, @RequestParam("family") String family){
        // 判断原先是否已有数据
        int i = 0;
        TbApply tbApply = JSON.parseObject(person, TbApply.class);  // 申请人个人信息
        if (tbRenterService.selectApplyById(renterId) == null){
            // 插入数据
            i = tbRenterService.insertApply(tbApply, renterId);
            message(i);
        }else {
            // 更新数据
            i = tbRenterService.updateApplyById(tbApply, renterId);
            message(i);
        }
        // 更新家庭成员数据
        List<TbFamily> familyList = JSON.parseArray(family, TbFamily.class);    // 家庭成员信息
        tbRenterService.deleteFamilyById(renterId);     // 删除家庭成员数据
        if (tbRenterService.selectFamilyById(renterId) != null){
            int n = tbRenterService.insertFamily(renterId, familyList);
            message(n);
        }
        return messageBean;
    }

    /**
     * 用户家庭信息提交
     */
    @RequestMapping("/submit")
    @ResponseBody
    public MessageBean submit(@RequestParam("applyState")String applyState){
        int i = tbRenterService.updateApplyStateById(applyState, renterId);
        if (i > 0){
            messageBean.setMessage("提交成功");
        }else {
            messageBean.setMessage("提交失败");
        }
        return messageBean;
    }

    /**
     * 查询个人信息已经家庭信息
     */
    @RequestMapping("/showInfo")
    @ResponseBody
    public MessageBean info(){
        List<Object> list = new ArrayList<>();
        // 查询申请人信息
        List<TbApply> applyList = tbRenterService.selectApplyById(renterId);
        System.out.println(applyList);
        list.add(applyList);
        // 查询家庭成员信息
        List<TbFamily> familyList = tbRenterService.selectFamilyById(renterId);
        System.out.println(familyList);
        list.add(familyList);
        messageBean.setCode(200);
        messageBean.setData(list);
        return messageBean;
    }

    /**
     * 查询区域
     */
    @RequestMapping("/findArea")
    @ResponseBody
    public MessageBean findArea(@RequestParam("pid") int pid){
        List<TbArea> tbAreas = tbRenterService.selectArea(pid);
        messageBean.setCode(200);
        messageBean.setData(tbAreas);
        return messageBean;
    }

    /**
     * 查询小区
     */
    @RequestMapping("/findTown")
    @ResponseBody
    public MessageBean findTown(@RequestParam("areaId")int areaId){
        List<TbCommunity> tbCommunityList = tbRenterService.selectTown(areaId);
        messageBean.setData(tbCommunityList);
        return messageBean;
    }

    /**
     * 查询消息
     */
    @RequestMapping("/findMsg")
    @ResponseBody
    public MessageBean findMsg(){
        List<TbMessage> messageList = tbRenterService.findMsg(renterId);
        messageBean.setData(messageList);
        return messageBean;
    }

    /**
     * 更改信息状态
     */
    @RequestMapping("/updateMsgState")
    @ResponseBody
    public MessageBean updateMsgState(@RequestParam("messageId")int messageId){
        int n  = tbRenterService.updateMsgState(messageId);
        if (n > 0){
            messageBean.setCode(200);
        }else {
            messageBean.setCode(-200);
        }
        return messageBean;
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    @ResponseBody
    public MessageBean logout(HttpServletRequest req){
        req.getSession().setAttribute("acc", null);
        messageBean.setCode(200);
        return messageBean;
    }

    /**
     * 查询密码
     */
    @RequestMapping("/selectPwd")
    @ResponseBody
    public MessageBean selectPwd(@RequestParam("oldPwd") String oldPwd){
        if (oldPwd.equals(tbRenterService.selectPwd(renterId))){
            System.out.println("111111111111");
            messageBean.setCode(200);
        }else {
            messageBean.setCode(-200);
        }
        return messageBean;
    }

    /**
     * 修改密码
     */
    @RequestMapping("/updatePwd")
    @ResponseBody
    public MessageBean updatePwd(@RequestParam("pwd") String pwd){
        int i = tbRenterService.updatePwd(pwd, renterId);
        if (i > 0){
            messageBean.setCode(200);
            messageBean.setMessage("修改成功");
        }else {
            messageBean.setCode(-200);
            messageBean.setMessage("修改失败");
        }
        return messageBean;
    }

    public void message(int i){
        if (i > 0){
            messageBean.setMessage("保存成功！");
        }else {
            messageBean.setMessage("保存失败！");
        }
    }
}

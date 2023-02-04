package com.cykj.service;

import com.cykj.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: LQB
 * @Description: 租客
 * @create: 2022/11/26 9:47
 */
public interface TbRenterService {

    /**
     * 验证登录
     */
    TbRenter login(String userAcc, String password);

    /**
     * 验证注册
     */
    int register(TbRenter tbRenter);

    /**
     * 添加申请人信息
     */
    int insertApply(TbApply tbApply, int renterId);

    /**
     * 添加家庭成员
     */
    int insertFamily(int renterId, List<TbFamily> list);

    /**
     * 查询申请人信息
     */
    List<TbApply> selectApplyById(int renterId);

    /**
     * 查询家庭成员信息
     */
    List<TbFamily> selectFamilyById(int renterId);

    /**
     * 更新个人信息
     */
    int updateApplyById(TbApply tbApply, int renterId);

    /**
     * 删除家庭成员信息
     */
    int deleteFamilyById(int renterId);

    /**
     * 更新申请资料的状态
     */
    int updateApplyStateById(String applyState, int renterId);

    /**
     * 查询区域
     */
    List<TbArea> selectArea(int pid);

    /**
     * 查询小区
     */
    List<TbCommunity> selectTown(int areaId);

    /**
     * 查询消息
     */
    List<TbMessage> findMsg(int renterId);

    /**
     * 更改信息状态
     */
    int updateMsgState(int messageId);

    /**
     * 查询密码
     */
    String selectPwd(int renterId);

    /**
     * 修改密码
     */
    int updatePwd(String pwd, int renterId);

}

package com.cykj.mapper;

import com.cykj.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: LQB
 * @Description: 租客
 * @create: 2022/11/26 9:47
 */
public interface TbRenterMapper {

    /**
     * 验证登录
     */
    TbRenter login(@Param("userAcc")String userAcc, @Param("password")String password);

    /**
     * 验证注册
     */
    int register(@Param("renter") TbRenter tbRenter);

    /**
     * 添加申请人信息
     */
    int insertApply(@Param("apply") TbApply tbApply, @Param("renterId") int renterId);

    /**
     * 添加家庭成员
     */
    int insertFamily(@Param("renterId")int renterId, @Param("familyList") List<TbFamily> list);

    /**
     * 查询申请人信息
     */
    List<TbApply> selectApplyById(@Param("renterId")int renterId);

    /**
     * 查询家庭成员信息
     */
    List<TbFamily> selectFamilyById(@Param("renterId")int renterId);

    /**
     * 更新个人信息
     */
    int updateApplyById(@Param("apply") TbApply tbApply, @Param("renterId")int renterId);

    /**
     * 删除家庭成员信息
     */
    int deleteFamilyById(@Param("renterId")int renterId);

    /**
     * 更新申请资料的状态
     */
    int updateApplyStateById(@Param("applyState")String applyState, @Param("renterId")int renterId);

    /**
     * 查询区域
     */
    List<TbArea> selectArea(@Param("pid")int pid);

    /**
     * 查询小区
     */
    List<TbCommunity> selectTown(@Param("areaId")int areaId);

    /**
     * 查询消息
     */
    List<TbMessage> findMsg(@Param("renterId")int renterId);

    /**
     * 更改信息状态
     */
    int updateMsgState(@Param("messageId")int messageId);


    /**
     * 查询密码
     */
    String selectPwd(@Param("renterId")int renterId);

    /**
     * 修改密码
     */
    int updatePwd(@Param("pwd")String pwd, @Param("renterId")int renterId);

}

package com.cykj.service.impl;

import com.cykj.bean.*;
import com.cykj.mapper.TbRenterMapper;
import com.cykj.service.TbRenterService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: LQB
 * @Description: 租客
 * @create: 2022/11/26 9:48
 */
@Service
public class TbRenterServiceImpl implements TbRenterService {

    @Autowired
    private TbRenterMapper tbRenterMapper;

    @Override
    public TbRenter login(String userAcc, String password) {
        TbRenter tbRenter = tbRenterMapper.login(userAcc, password);
        return tbRenter;
    }

    @Override
    public int register(TbRenter tbRenter) {
        int n = tbRenterMapper.register(tbRenter);
        return n;
    }

    @Override
    public int insertApply(TbApply tbApply, int renterId) {
        int n = tbRenterMapper.insertApply(tbApply, renterId);
        return n;
    }

    @Override
    public List<TbApply> selectApplyById(int renterId) {
        List<TbApply> apply = tbRenterMapper.selectApplyById(renterId);
        return apply;
    }

    @Override
    public List<TbFamily> selectFamilyById(int renterId) {
        List<TbFamily> family = tbRenterMapper.selectFamilyById(renterId);
        return family;
    }

    @Override
    public int insertFamily(int renterId, List<TbFamily> list) {
        int n = tbRenterMapper.insertFamily(renterId, list);
        return n;
    }

    @Override
    public int updateApplyById(TbApply tbApply, int renterId) {
        int n = tbRenterMapper.updateApplyById(tbApply, renterId);
        return n;
    }

    @Override
    public int deleteFamilyById(int renterId) {
        int n = tbRenterMapper.deleteFamilyById(renterId);
        return n;
    }

    @Override
    public int updateApplyStateById(String applyState, int renterId) {
        int n = tbRenterMapper.updateApplyStateById(applyState, renterId);
        return n;
    }

    @Override
    public List<TbArea>  selectArea(int pid) {
        List<TbArea>  tbArea = tbRenterMapper.selectArea(pid);
        return tbArea;
    }


    @Override
    public List<TbCommunity> selectTown(int areaId) {
        List<TbCommunity> tbCommunityList = tbRenterMapper.selectTown(areaId);
        return tbCommunityList;
    }

    @Override
    public List<TbMessage> findMsg(int renterId) {
        List<TbMessage> list = tbRenterMapper.findMsg(renterId);
        return list;
    }

    @Override
    public int updateMsgState(int messageId) {
        int n = tbRenterMapper.updateMsgState(messageId);
        return n;
    }

    @Override
    public String selectPwd(int renterId) {
        return tbRenterMapper.selectPwd(renterId);
    }

    @Override
    public int updatePwd(String pwd, int renterId) {
        int n = tbRenterMapper.updatePwd(pwd, renterId);
        return n;
    }
}

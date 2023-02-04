package com.cykj.service.impl;

import com.cykj.bean.TbHouse;
import com.cykj.mapper.TbHouseMapper;
import com.cykj.mapper.TbRenterMapper;
import com.cykj.service.TbHouseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: LQB
 * @Description:
 * @create: 2022/12/2 11:17
 */
@Service
public class TbHouseServiceImpl implements TbHouseService {

    @Autowired
    private TbHouseMapper tbHouseMapper;

    @Override
    public List<TbHouse> findHouse(Integer provId, Integer cityId, String search, Integer areaId, Integer townId,
                                   Integer roomNum, Integer livingroomNum,
                                   Integer fromRent, Integer endRent) {
        List<TbHouse> tbHouses = tbHouseMapper.findHouse(provId, cityId, search, areaId, townId, roomNum, livingroomNum, fromRent, endRent);
        for (TbHouse t: tbHouses) {
            t.setHouseType();
        }
        return tbHouses;
    }

}

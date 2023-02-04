package com.cykj.service;

import com.cykj.bean.TbHouse;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;

import java.util.List;

/**
 * @author: LQB
 * @Description:
 * @create: 2022/12/2 11:14
 */
public interface TbHouseService {

    /**
     * 房屋查询
     */
    List<TbHouse> findHouse(
            Integer provId,
            Integer cityId,
            String search,
            Integer areaId,
            Integer townId,
            Integer roomNum,
            Integer livingroomNum,
            Integer fromRent,
            Integer endRent);

}

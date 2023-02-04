package com.cykj.mapper;

import com.cykj.bean.TbHouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: LQB
 * @Description:
 * @create: 2022/12/2 11:07
 */
public interface TbHouseMapper {

    /**
     * 房屋查询
     */
    List<TbHouse> findHouse(
            @Param("provId") Integer provId,
            @Param("cityId") Integer cityId,
            @Param("search") String search,
            @Param("areaId") Integer areaId,
            @Param("townId") Integer townId,
            @Param("roomNum") Integer roomNum,
            @Param("livingroomNum") Integer livingroomNum,
            @Param("fromRent") Integer fromRent,
            @Param("endRent") Integer endRent);
}

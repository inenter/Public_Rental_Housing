package com.cykj.controller;

import com.cykj.bean.MessageBean;
import com.cykj.bean.TbHouse;
import com.cykj.service.TbHouseService;
import com.cykj.service.TbRenterService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: LQB
 * @Description:
 * @create: 2022/12/2 10:53
 */
@Controller
@RequestMapping("/house_source")
public class TbHouseController {

    private MessageBean messageBean = new MessageBean();

    @Autowired
    private TbHouseService tbHouseService;

    @RequestMapping("/findHouse")
    @ResponseBody
    public MessageBean findHouse(@Param("provId") Integer provId,
                                 @Param("cityId") Integer cityId, @Param("search") String search,
                                 @Param("areaId") Integer areaId, @Param("townId") Integer townId,
                                 @Param("houseType") String houseType, @Param("houseRent") String houseRent,
                                 @Param("currPage") Integer currPage) {
        int roomNum = 0;
        int livingroomNum = 0;
        if (!houseType.equals("no")){
            roomNum = Integer.parseInt(houseType.split("-")[0]);
            livingroomNum = Integer.parseInt(houseType.split("-")[1]);
        }
        int fromRent = 0;
        int endRent = 0;
        if (!houseRent.equals("no")) {
            fromRent = Integer.parseInt(houseRent.split("-")[0]);
            endRent = Integer.parseInt(houseRent.split("-")[1]);
        }
        List<Object> list = new ArrayList<>();
        Page<Object> page = PageHelper.startPage(currPage, 3);
        List<TbHouse> houseList = tbHouseService.findHouse(provId, cityId,
                search, areaId, townId, roomNum, livingroomNum, fromRent, endRent);
        System.out.println("分页：" + page);
        System.out.println(houseList);
        list.add(houseList);
        list.add(page.getPages());
        messageBean.setData(list);
        return messageBean;
    }

}

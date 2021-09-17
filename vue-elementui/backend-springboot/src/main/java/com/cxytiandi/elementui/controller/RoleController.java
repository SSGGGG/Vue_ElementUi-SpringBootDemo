package com.cxytiandi.elementui.controller;

import com.cxytiandi.elementui.base.ResponseData;
import com.cxytiandi.elementui.utils.JsonUtils;
import com.cxytiandi.elementui.vo.RoleVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Excelman
 * @date 2021/9/17 上午10:24
 * @description
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    /**
     * 获取列表
     * @param page 当前页
     * @param pageSize 页的大小
     * @return
     */
    @GetMapping("list")
    public ResponseData list(Integer page, Integer pageSize) throws InterruptedException {

        System.out.println("这里是/role/list");

        List<RoleVo> roleList = new ArrayList<>();
        roleList.add(new RoleVo("1", "ADMIN", "/user"));
        roleList.add(new RoleVo("2", "ROOT", "/user,/role"));

        Integer total = roleList.size();

        if(page == null){
            page = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }

        Thread.sleep(1000);

        Map map = new HashMap();
        map.put("list", roleList);
        map.put("total", total);
        map.put("currentPage", page);
        map.put("pageSize", pageSize);
        return ResponseData.ok(map);
    }
}

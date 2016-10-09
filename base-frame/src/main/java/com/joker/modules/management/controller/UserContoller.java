package com.joker.modules.management.controller;


import com.github.pagehelper.PageInfo;
import com.joker.common.datatable.ResponseData;
import com.joker.common.util.ViewUtil;
import com.joker.modules.management.entity.TableUser;
import com.joker.modules.management.entity.User;
import com.joker.modules.management.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author zhangjian
 * @Date 2015/12/7
 */
@RestController("RMSUserController")
@RequestMapping("/admin/user")
public class UserContoller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView listUI(HttpServletRequest request, HttpServletResponse response, ModelAndView mav) {
        mav.setViewName(ViewUtil.getManagementPage("/user/list"));
        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseData<TableUser> listData(HttpServletRequest request, HttpServletResponse response, ModelAndView mav) {

        String strdraw = request.getParameter("draw");

        int draw = 0;

        if(StringUtils.isNotEmpty(strdraw)){
            draw = Integer.parseInt(request.getParameter("draw"));
        }

        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));


        //获取查询条件
        String searchValue = request.getParameter("search[value]");

        //查询出分页数据
        PageInfo<User> page =  userService.findUserByPage(start,length,searchValue);

        List<TableUser> tableUsers = TableUser.tansferUsersToTableUsers(page.getList());

        //将查询对象封装成DataTables需要的对象
        ResponseData<TableUser> responseData = new ResponseData<>(draw,page.getTotal(),page.getTotal(),tableUsers);

        return responseData;
    }


}

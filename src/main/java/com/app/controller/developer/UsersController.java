package com.app.controller.developer;
import com.app.pojo.AppCategory;
import com.app.pojo.DataDictionary;
import com.app.pojo.Users;
import com.app.service.developer.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dev")
public class UsersController {
    //业务数据
    @Resource
    private UsersService usersService;

    @RequestMapping(value ="/login")
    public String login(){
        //转发
        return "devlogin";  //devlogin.jsp
    }

    @RequestMapping(value ="/dologin")
    public String dologin(ModelMap map, String devCode, String devPassword){

        Users users=usersService.loginUsers(devCode);

        if (users==null){
            return "devlogin";
        }else {
            if (!users.getDevPassword().equals(devPassword)){
                return "devlogin";
            } else {
                map.addAttribute("devUserSession",users);
                return "/jsp/developer/main";
            }
        }
    }

    @RequestMapping(value ="/logout")
    public String login(HttpSession session){
        session.removeAttribute("devUserSession");
        session.invalidate();
        //转发
        return "devlogin";  //devlogin.jsp
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        List<DataDictionary> statusList = usersService.statusList();

        List<DataDictionary> flatFormList = usersService.flatFormList();

        List<AppCategory> categoryLevel1List = usersService.categoryLevel1List();

        //保存数据
        map.addAttribute("statusList", statusList);
        map.addAttribute("flatFormList", flatFormList);
        map.addAttribute("categoryLevel1List", categoryLevel1List);


        return "/jsp/developer/common/appinfolist"; //直接跳转
    }


}

package com.app.service.developer;

import com.app.pojo.AppCategory;
import com.app.pojo.DataDictionary;
import com.app.pojo.Users;

import java.util.List;

public interface UsersService {

    //    登录
    public Users loginUsers(String devCode);

    public List<DataDictionary> statusList();

    public List<DataDictionary> flatFormList();

    public List<AppCategory> categoryLevel1List();
}

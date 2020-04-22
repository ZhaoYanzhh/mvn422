package com.app.service.developer.Impl;

import com.app.dao.UsersDao;
import com.app.pojo.AppCategory;
import com.app.pojo.DataDictionary;
import com.app.pojo.Users;
import com.app.service.developer.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service           //业务
@Transactional     //事务
public class UsersServiceImpl implements UsersService {


    @Resource
    private UsersDao usersDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Users loginUsers(String devCode) {

        return usersDao.loginUsers(devCode);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<DataDictionary> statusList() {
        return usersDao.statusList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<DataDictionary> flatFormList() {
        return usersDao.flatFormList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<AppCategory> categoryLevel1List() {
        return usersDao.categoryLevel1List();
    }
}

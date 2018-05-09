package com.conpany.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.model.User;
import com.company.project.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class Test extends Tester {
    @Autowired
    private UserService  userService;
    @org.junit.Test
    public void test(){
    	PageHelper.startPage(1, 3);
    	List<User> list = userService.findAll();
    	PageInfo<User> p=new PageInfo<User>(list);
    	System.out.println(p);
    	//sysUserService.
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	}

}

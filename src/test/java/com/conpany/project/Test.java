package com.conpany.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.model.SysUser;
import com.company.project.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class Test extends Tester {
    @Autowired
    private SysUserService  sysUserService;
    @org.junit.Test
    public void test(){
    	PageHelper.startPage(1, 3);
    	List<SysUser> list = sysUserService.findAll();
    	PageInfo<SysUser> p=new PageInfo<SysUser>(list);
    	System.out.println(p);
    	//sysUserService.
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	}

}

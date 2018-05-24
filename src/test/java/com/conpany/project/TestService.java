package com.conpany.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.model.TMember;
import com.company.project.service.TMemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TestService extends Tester{
	@Autowired
    private TMemberService  tMemberService;
    @org.junit.Test
    public void test(){
    	PageHelper.startPage(1, 3);
    	List<TMember> list = tMemberService.findAll();
    	PageInfo<TMember> p=new PageInfo<TMember>(list);
    	System.out.println(p);
    	//sysUserService.
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	}
}

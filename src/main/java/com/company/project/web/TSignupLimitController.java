package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TSignupLimit;
import com.company.project.service.TSignupLimitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by tanfan on 2018/05/14.
*/
@RestController
@RequestMapping("/signuplimit")
public class TSignupLimitController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TSignupLimitService tSignupLimitService;

    @PostMapping("/add")
    public Result add(TSignupLimit tSignupLimit) {
        tSignupLimitService.save(tSignupLimit);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tSignupLimitService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TSignupLimit tSignupLimit) {
        tSignupLimitService.update(tSignupLimit);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TSignupLimit tSignupLimit = tSignupLimitService.findById(id);
        return ResultGenerator.genSuccessResult(tSignupLimit);
    }

    /*@PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<TSignupLimit> list = tSignupLimitService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }*/
    @PostMapping("/list")
    public Result listByMap(HttpServletRequest request) {
    	try {
   		 Integer mid = null;
	    	 if(request.getParameter("mid") !=null) {
	    		 mid = Integer.parseInt(request.getParameter("mid"));
	    	 }else {
			   		return ResultGenerator.genParmeterErrorResult();
			   	} 
	    	 Integer mtype = null;
	    	 if(request.getParameter("mtype") !=null) {
	    		 mtype = Integer.parseInt(request.getParameter("mtype"));
	    	 } 
   		     
	    	 Integer type = null;
	    	 if(request.getParameter("type") !=null) {
	    		 type = Integer.parseInt(request.getParameter("type"));
	    	 }else {
			   		return ResultGenerator.genParmeterErrorResult();
			   	} 
	    	 Map<String,Object> map = new HashMap();
	    	 
		    	if(type !=null) {
		    		map.put("type", type);
		    	}
		    	 
		    	if(mid !=null) {
		    		map.put("mid", mid);
		    	}
		    	if(mtype !=null) {
		    		map.put("mtype", mtype);
		    	}
		    	
         
		    	List<TSignupLimit> list = tSignupLimitService.selectTSignupLimitByMap(map);
        
		    	return ResultGenerator.genSuccessResult(list);
    	}catch (Exception e) {
			// TODO: handle exception
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
    }
    
}

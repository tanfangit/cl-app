package com.company.project.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TArticle;
import com.company.project.service.TArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/homepage")
public class HomePageController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private TArticleService tArticleService;
	
	@PostMapping("/articleList")
    public Result articleList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size,HttpServletRequest request) {
		try {
			Integer mid = null;
		   	 if(request.getParameter("mid") !=null) {
		   		 mid = Integer.parseInt(request.getParameter("mid"));
		   	 }else {
			   		//参数错误
			        return ResultGenerator.genParmeterErrorResult();
			 }
		   	  
		   	 Integer mtype = null;
		   	 if(request.getParameter("mtype") !=null) {
		   		mtype = Integer.parseInt(request.getParameter("mtype"));
		   	 }else {
			   		//参数错误
			        return ResultGenerator.genParmeterErrorResult();
			  }
		   	Map<String,Object> map = new HashMap();
		   	 
		   	if(mid !=null) {
		   		map.put("mid", mid);
		   	}
		   	 
		   	if(mtype !=null) {
		   		map.put("mtype", mtype);
		   	}
	        PageHelper.startPage(page, size);
	        
	        List<TArticle> list = tArticleService.selectTArticleByMap(map);
	        return ResultGenerator.genSuccessResult(list);
		} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
    }
	
	@PostMapping("/index")
    public Result index(HttpServletRequest request) {
		try {
			Integer mid = null;
		   	 if(request.getParameter("mid") !=null) {
		   		 mid = Integer.parseInt(request.getParameter("mid"));
		   	 }else {
			   		//参数错误
			        return ResultGenerator.genParmeterErrorResult();
			 }
		   	  
		   	 Integer mtype = null;
		   	 if(request.getParameter("mtype") !=null) {
		   		mtype = Integer.parseInt(request.getParameter("mtype"));
		   	 }else {
			   		//参数错误
			        return ResultGenerator.genParmeterErrorResult();
			  }
		   	Map<String,Object> map = new HashMap();
		   	 
		   	if(mid !=null) {
		   		map.put("mid", mid);
		   	}
		   	 
		   	if(mtype !=null) {
		   		map.put("mtype", mtype);
		   	}
	       
	        
		   	List<Map> list = tArticleService.selectpagehomebanner(map);
	        return ResultGenerator.genSuccessResult(list);
		} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
    }
	
}

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
import com.company.project.dto.TAccommodationDTO;
import com.company.project.model.TAccommodation;
import com.company.project.model.TAccommodationDetail;
import com.company.project.service.TAccommodationDetailService;
import com.company.project.service.TAccommodationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* Created by tanfan on 2018/05/14.
*/
@RestController
@RequestMapping("/accommodation")
public class TAccommodationController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TAccommodationService tAccommodationService;
    @Resource
    private TAccommodationDetailService tAccommodationDetailService;

    @PostMapping("/add")
    public Result add(TAccommodation tAccommodation) {
        tAccommodationService.save(tAccommodation);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tAccommodationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TAccommodation tAccommodation) {
        tAccommodationService.update(tAccommodation);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TAccommodation tAccommodation = tAccommodationService.findById(id);
        return ResultGenerator.genSuccessResult(tAccommodation);
    }

    @PostMapping("/index")
    public Result list(HttpServletRequest request) {
    	 try {
	    	 Integer mid = null;
		   	 if(request.getParameter("mid") !=null) {
		   		 mid = Integer.parseInt(request.getParameter("mid"));
		   	 }
		   	 
		   	Integer mtype = null;
		   	 if(request.getParameter("mtype") !=null) {
		   		mtype = Integer.parseInt(request.getParameter("mtype"));
		   	 }
		   	Map<String,Object> map = new HashMap();
		   	 
		   	if(mid !=null) {
		   		map.put("mid", mid);
		   	}else {
		   		//参数错误
		        return ResultGenerator.genParmeterErrorResult();
		   	}
		   
		   	if(mtype !=null && (mtype ==1 || mtype == 2) ) {
		   		map.put("mtype", mtype);
		   	}else {
		   		return ResultGenerator.genParmeterErrorResult();
		   	}
	         
		   	List<TAccommodationDTO> list = tAccommodationService.selectTAccommodationDTOByCondition(map);
         
        	return ResultGenerator.genSuccessResult(list);
    	 } catch (Exception e) {
    	  		logger.error(e.getMessage(), e);
    	  		return ResultGenerator.genServerResult("服务器异常");
    		}
    }
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size,HttpServletRequest request) {
    	try {
    		Integer mid = null;
		   	 if(request.getParameter("mid") !=null) {
		   		 mid = Integer.parseInt(request.getParameter("mid"));
		   	 }
		   	 
		   	Integer mtype = null;
		   	 if(request.getParameter("mtype") !=null) {
		   		mtype = Integer.parseInt(request.getParameter("mtype"));
		   	 }
		    
		   	Map<String,Object> map = new HashMap();
		   	 
		   	if(mid !=null) {
		   		map.put("mid", mid);
		   	}else {
		   		//参数错误
		        return ResultGenerator.genParmeterErrorResult();
		   	}
		   
		   	if(mtype !=null && (mtype ==1 || mtype == 2) ) {
		   		map.put("mtype", mtype);
		   	}else {
		   		return ResultGenerator.genParmeterErrorResult();
		   	}
		   	  
	        PageHelper.startPage(page, size);
	        List<TAccommodationDetail> list = tAccommodationDetailService.findAll();
	        return ResultGenerator.genSuccessResult(list);
    	} catch (Exception e) {
       		logger.error(e.getMessage(), e);
       		return ResultGenerator.genServerResult("服务器异常");
    	}
    }
}

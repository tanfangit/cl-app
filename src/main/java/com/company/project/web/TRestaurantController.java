package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dto.TExperienceDTO;
import com.company.project.dto.TRestaurantDTO;
import com.company.project.model.TRestaurant;
import com.company.project.model.TRestaurantDetail;
import com.company.project.service.TRestaurantDetailService;
import com.company.project.service.TRestaurantService;
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
* Created by tanfan on 2018/05/11.
*/
@RestController
@RequestMapping("/restaurant")
public class TRestaurantController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TRestaurantService tRestaurantService;
    @Resource
    private TRestaurantDetailService tRestaurantDetailService;

    @PostMapping("/add")
    public Result add(TRestaurant tRestaurant) {
        tRestaurantService.save(tRestaurant);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tRestaurantService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TRestaurant tRestaurant) {
        tRestaurantService.update(tRestaurant);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TRestaurant tRestaurant = tRestaurantService.findById(id);
        return ResultGenerator.genSuccessResult(tRestaurant);
    }

    @PostMapping("/index")
    public Result index(HttpServletRequest request) {
         
       
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
	         
		   	List<TRestaurantDTO> list = tRestaurantService.selectTRestaurantDTOByCondition(map);
	         
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
		   	Integer typeid = null;
		   	 if(request.getParameter("typeid") !=null) {
		   		typeid = Integer.parseInt(request.getParameter("typeid"));
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
		   	if(typeid !=null   ) {
		   		map.put("typeid", typeid);
		   	} 
	         
	        PageHelper.startPage(page, size);
	        List<TRestaurantDetail> list = tRestaurantDetailService.selectTRestaurantDetailByCondition(map);
	        
	        return ResultGenerator.genSuccessResult(list);
    	} catch (Exception e) {
       		logger.error(e.getMessage(), e);
       		return ResultGenerator.genServerResult("服务器异常");
    	}
    }
}

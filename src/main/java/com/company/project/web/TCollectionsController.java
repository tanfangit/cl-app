package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dto.TCourseCollectionsDTO;
import com.company.project.model.TCollections;
import com.company.project.service.TCollectionsService;
import com.company.project.util.StringUtils;
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
* Created by tanfan on 2018/05/16.
*/
@RestController
@RequestMapping("/collections")
public class TCollectionsController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TCollectionsService tCollectionsService;

    @PostMapping("/add")
    public Result add(TCollections tCollections) {
        tCollectionsService.save(tCollections);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tCollectionsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TCollections tCollections) {
        tCollectionsService.update(tCollections);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TCollections tCollections = tCollectionsService.findById(id);
        return ResultGenerator.genSuccessResult(tCollections);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size,HttpServletRequest request) {
    	try {
			 // TODO: handle exception
			 Integer mid = null;
	    	 if(request.getParameter("mid") !=null) {
	    		 mid = Integer.parseInt(request.getParameter("mid"));
	    	 }else {
			   		//参数错误
			        return ResultGenerator.genParmeterErrorResult();
			 }
	    	 Integer type = null;
	    	 if(request.getParameter("type") !=null) {
	    		 type = Integer.parseInt(request.getParameter("type"));
	    	 }
	    	Map<String,Object> map = new HashMap();
	    	 
	    	if(mid !=null) {
	    		map.put("mid", mid);
	    	}
	    	PageHelper.startPage(page, size);
	    	if(type == 1) {
	    		 List<TCourseCollectionsDTO> list = tCollectionsService.selectTCourseCollectionsDTOByMap(map);
	    		 return ResultGenerator.genSuccessResult(list);
	    	}else {
	    		 return ResultGenerator.genSuccessResult();
	    	}
	         
	          
	        
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		return ResultGenerator.genServerResult("服务器异常");
	}
       
    }
}

package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dto.TExperienceDTO;
import com.company.project.dto.TantiqueDTO;
import com.company.project.model.TExperience;
import com.company.project.model.TExperienceDetail;
import com.company.project.service.TExperienceDetailService;
import com.company.project.service.TExperienceService;
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
@RequestMapping("/experience")
public class TExperienceController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TExperienceService tExperienceService;
    @Resource
    private TExperienceDetailService tExperienceDetailService;
    @PostMapping("/add")
    public Result add(TExperience tExperience) {
        tExperienceService.save(tExperience);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tExperienceService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TExperience tExperience) {
        tExperienceService.update(tExperience);
        return ResultGenerator.genSuccessResult();
    }

   /* @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TExperience tExperience = tExperienceService.findById(id);
        return ResultGenerator.genSuccessResult(tExperience);
    }*/

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
	         
		   	List<TExperienceDTO> list = tExperienceService.selectTExperienceDTOByCondition(map);
	         
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
	        List<TExperienceDetail> list = tExperienceDetailService.selectTExperienceDetailByMap(map);
	         
	        return ResultGenerator.genSuccessResult(list);
    	} catch (Exception e) {
       		logger.error(e.getMessage(), e);
       		return ResultGenerator.genServerResult("服务器异常");
    	}
    }
    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
    	Map<String,Object> map = new HashMap();
    	map.put("id", id);
    	List<TExperienceDetail> list = tExperienceDetailService.selectTExperienceDetailByMap(map);
        return ResultGenerator.genSuccessResult(list.get(0));
    }
}

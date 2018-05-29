package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TDict;
import com.company.project.service.TDictService;
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
@RequestMapping("/dict")
public class TDictController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TDictService tDictService;

    @PostMapping("/add")
    public Result add(TDict tDict) {
        tDictService.save(tDict);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tDictService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TDict tDict) {
        tDictService.update(tDict);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TDict tDict = tDictService.findById(id);
        return ResultGenerator.genSuccessResult(tDict);
    }

    @PostMapping("/list")
    public Result list(HttpServletRequest request) {
    	 try {
		    	 Integer type = null;
			   	 if(request.getParameter("type") !=null) {
			   		type = Integer.parseInt(request.getParameter("type"));
			   	 }
			   	 
			   	 
			   	Map<String,Object> map = new HashMap();
			   	 
			   	if(type !=null) {
			   		if(type ==1) {
			   			map.put("TYPE_CODE", "rtype");
			   			 
			   		}else if(type ==2) {
			   			map.put("TYPE_CODE", "atype");
			   			 
			   		}else if(type ==3) {
			   			map.put("TYPE_CODE", "goods_category");
			   			 
			   		}else if(type ==4) {
			   			map.put("TYPE_CODE", "goods_source");
			   			 
			   		}else if(type ==5) {
			   			map.put("TYPE_CODE", "goods_years");
			   			 
			   		}
			   		
			   	}else {
			   		//参数错误
			        return ResultGenerator.genParmeterErrorResult();
			   	}
			   
			   	 
		        List<TDict> list = tDictService.selectTDictByCondition(map);
		         
		        return ResultGenerator.genSuccessResult(list);
    	 } catch (Exception e) {
    	  		logger.error(e.getMessage(), e);
    	  		return ResultGenerator.genServerResult("服务器异常");
    		}
    }
}

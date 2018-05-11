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
import com.company.project.dto.TAntiqueDetailDTO;
import com.company.project.dto.TantiqueDTO;
import com.company.project.model.TAntique;
import com.company.project.model.TAntiqueSource;
import com.company.project.model.TAntiqueType;
import com.company.project.service.TAntiqueDetailService;
import com.company.project.service.TAntiqueService;
import com.company.project.service.TAntiqueSourceService;
import com.company.project.service.TAntiqueTypeService;
import com.company.project.util.StringUtils;
import com.github.pagehelper.PageHelper;

/**
* Created by tanfan on 2018/05/10.
*/
@RestController
@RequestMapping("/antique")
public class TAntiqueController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TAntiqueService tAntiqueService;
    @Resource
    private TAntiqueDetailService tAntiqueDetailService;
    @Resource
    private TAntiqueTypeService tAntiqueTypeService;
    @Resource
    private TAntiqueSourceService tAntiqueSourceService;
    @PostMapping("/add")
    public Result add(TAntique tAntique) {
        tAntiqueService.save(tAntique);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tAntiqueService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TAntique tAntique) {
        tAntiqueService.update(tAntique);
        return ResultGenerator.genSuccessResult();
    }

  /*  @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TAntique tAntique = tAntiqueService.findById(id);
        return ResultGenerator.genSuccessResult(tAntique);
    }*/

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
		   	 Integer type = null;
		   	 if(request.getParameter("type") !=null) {
		   		type = Integer.parseInt(request.getParameter("type"));
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
		   	if(type !=null) {
		   		map.put("type", type);
		   	}
		   	if(mtype !=null) {
		   		map.put("mtype", mtype);
		   	}
	         
	        List<TantiqueDTO> list = tAntiqueService.selectTAntiqueByCondition(map);
	         
	        return ResultGenerator.genSuccessResult(list);
    	} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
    }
    @PostMapping("/detailList")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size,HttpServletRequest request) {
    	try {
	    	 Integer mid = null;
		   	 if(request.getParameter("mid") !=null) {
		   		 mid = Integer.parseInt(request.getParameter("mid"));
		   	 }else {
			   		//参数错误
			        return ResultGenerator.genParmeterErrorResult();
			  }
		   	 Integer aid = null;
		   	 if(request.getParameter("aid") !=null) {
		   		aid = Integer.parseInt(request.getParameter("aid"));
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
		   	Integer typeid = null;
		   	 if(request.getParameter("typeid") !=null) {
		   		typeid = Integer.parseInt(request.getParameter("typeid"));
		   	 }
		   	Integer sid = null;
		   	 if(request.getParameter("sid") !=null) {
		   		sid = Integer.parseInt(request.getParameter("sid"));
		   	 }
		   	 String year = request.getParameter("year");
		   	Map<String,Object> map = new HashMap();
		   	 
		   	if(mid !=null) {
		   		map.put("mid", mid);
		   	}
		   	if(aid !=null) {
		   		map.put("aid", aid);
		   	}
		   	if(typeid !=null) {
		   		map.put("typeid", typeid);
		   	}
		   	if(sid !=null) {
		   		map.put("sid", sid);
		   	}
	        if(! StringUtils.isEmpty(year)) {
	        	map.put("year", year);
	        } 
	        PageHelper.startPage(page, size);
	        List<TAntiqueDetailDTO> list = tAntiqueDetailService.selectTAntiqueDetailByCondition(map);
	        return ResultGenerator.genSuccessResult(list);
    	} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
    }
    @PostMapping("/typelist")
    public Result typelist(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<TAntiqueType> list = tAntiqueTypeService.findAll();
        return ResultGenerator.genSuccessResult(list);
    }
    @PostMapping("/sourcelist")
    public Result sourcelist(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<TAntiqueSource> list = tAntiqueSourceService.findAll();
        return ResultGenerator.genSuccessResult(list);
    }
    @PostMapping("/detail")
    public Result detail(HttpServletRequest request) {
    	try {
	    	 Integer mid = null;
		   	 if(request.getParameter("mid") !=null) {
		   		 mid = Integer.parseInt(request.getParameter("mid"));
		   	 }else {
			   		//参数错误
			        return ResultGenerator.genParmeterErrorResult();
			   	}
		   	 Integer id = null;
		   	 if(request.getParameter("id") !=null) {
		   		id = Integer.parseInt(request.getParameter("id"));
		   	 }else {
			   		//参数错误
			        return ResultGenerator.genParmeterErrorResult();
			   	}
		   
		   	Map<String,Object> map = new HashMap();
		   	 
		   	if(mid !=null) {
		   		map.put("mid", mid);
		   	}
		   	if(id !=null) {
		   		map.put("id", id);
		   	}
		   	
	         
	        List<TAntiqueDetailDTO> list = tAntiqueDetailService.selectTAntiqueDetailByCondition(map);
	        return ResultGenerator.genSuccessResult(list.get(0));
   	} catch (Exception e) {
   		logger.error(e.getMessage(), e);
   		return ResultGenerator.genServerResult("服务器异常");
		}
    }
}

package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dto.TCourseDTO;
import com.company.project.dto.TCourseDetailDTO;
import com.company.project.dto.TCourseSignUpDTO;
import com.company.project.model.TCourse;
import com.company.project.model.TCourseType;
import com.company.project.model.TTeacher;
import com.company.project.service.TCourseService;
import com.company.project.service.TCourseTypeService;
import com.company.project.service.TTeacherService;
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
* Created by tanfan on 2018/05/09.
*/
@RestController
@RequestMapping("/course")
public class TCourseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TCourseService tCourseService;
    @Resource
    private TCourseTypeService tCourseTypeService;
    @Resource
    private TTeacherService tTeacherService;
    @PostMapping("/add")
    public Result add(TCourse tCourse) {
        tCourseService.save(tCourse);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tCourseService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TCourse tCourse) {
        tCourseService.update(tCourse);
        return ResultGenerator.genSuccessResult();
    }

  /*  @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TCourse tCourse = tCourseService.findById(id);
        return ResultGenerator.genSuccessResult(tCourse);
    }
*/
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size,HttpServletRequest request) {
    	List<TCourseDTO> list =null;
    	try {
    			 
    			logger.info("info 方法 进入/course/list");
		
    			// TODO: handle exception
    			 Integer mid = null;
		    	 if(request.getParameter("mid") !=null) {
		    		 mid = Integer.parseInt(request.getParameter("mid"));
		    	 }else {
				   		//参数错误
				        return ResultGenerator.genParmeterErrorResult();
				 }
		    	 Integer cTypeId = null;
		    	 if(request.getParameter("cTypeId") !=null) {
		    		 cTypeId = Integer.parseInt(request.getParameter("cTypeId"));
		    	 }
		    	 Integer teacherId = null;
				 if(request.getParameter("teacherId") !=null) {
					 teacherId = Integer.parseInt(request.getParameter("teacherId"));
		    	 }
				 Integer cid = null;
				 if(request.getParameter("cid") !=null) {
					 cid =Integer.parseInt(request.getParameter("cid"));
		    	 }
				 String data  = request.getParameter("data");
				 String cName = request.getParameter("cName");
				 String tName = request.getParameter("tName");
		         
		         
		    	Map<String,Object> map = new HashMap();
		    	if(! StringUtils.isEmpty(data)) {
		    		map.put("data", data);
		    	}
		    	if(mid !=null) {
		    		map.put("mid", mid);
		    	}
		    	if(cTypeId !=null) {
		    		map.put("cTypeId", cTypeId);
		    	}
		    	if(teacherId !=null) {
		    		map.put("teacherId", teacherId);
		    	}
		    	if(cid !=null) {
		    		map.put("cid", cid);
		    	}
		    	
		        PageHelper.startPage(page, size);
		        list = tCourseService.selectTCourseByCondition(map);
		        return ResultGenerator.genSuccessResult(list);
    	} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
    	
    }
    @PostMapping("/detail")
    public Result detail(HttpServletRequest request) {
    	TCourseDetailDTO tCourseDetailDTO =null;
    	try {
    			logger.info("info 方法 进入/course/detail");
		
    			// TODO: handle exception
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
		    	tCourseDetailDTO = tCourseService.selectTCourseDetailByCondition(map);
		        return ResultGenerator.genSuccessResult(tCourseDetailDTO);
    	} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
    	
    }
    @PostMapping("/typeList")
    public Result typeList() {
    	try {
		         
		        List<TCourseType> list = tCourseTypeService.findAll();
		       // PageInfo pageInfo = new PageInfo(list);
		        return ResultGenerator.genSuccessResult(list);
    	}catch (Exception e) {
			// TODO: handle exception
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
    }
    
    @PostMapping("/teacherList")
    public Result teacherList(HttpServletRequest request) {
    	try {
    		 Integer typeId = null;
	    	 if(request.getParameter("typeId") !=null) {
	    		 typeId = Integer.parseInt(request.getParameter("typeId"));
	    	 } 
	    	 Map<String,Object> map = new HashMap();
	    	 
		    	if(typeId !=null) {
		    		map.put("typeId", typeId);
		    	}
	        List<TTeacher> list = tTeacherService.selectTTeacherByCondition(map);
	        return ResultGenerator.genSuccessResult(list);
    	}catch (Exception e) {
			// TODO: handle exception
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
    }
    @PostMapping("/operation")
    public Result operation(HttpServletRequest request) {
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
	    	 } else {
			   		return ResultGenerator.genParmeterErrorResult();
			   	} 
    		 Integer cid = null;
	    	 if(request.getParameter("cid") !=null) {
	    		 cid = Integer.parseInt(request.getParameter("cid"));
	    	 }else {
			   		return ResultGenerator.genParmeterErrorResult();
			   	} 
	    	 Integer type = null;
	    	 if(request.getParameter("type") !=null) {
	    		 type = Integer.parseInt(request.getParameter("type"));
	    	 }else {
			   		return ResultGenerator.genParmeterErrorResult();
			   	} 
	    	 Map<String,Integer> map = new HashMap();
	    	 
		    	if(type !=null) {
		    		map.put("type", type);
		    	}
		    	if(cid !=null) {
		    		map.put("cid", cid);
		    	}
		    	if(mid !=null) {
		    		map.put("mid", mid);
		    	}
		    	if(mtype !=null) {
		    		map.put("mtype", mtype);
		    	}
	           
	        return tCourseService.tCourseOperation(map);
    	}catch (Exception e) {
			// TODO: handle exception
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
    }
    @PostMapping("/signUpList")
    public Result signUpList(HttpServletRequest request) {
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
	    	 } else {
			   		return ResultGenerator.genParmeterErrorResult();
			   	} 
	    	 Integer type = null;
	    	 if(request.getParameter("type") !=null) {
	    		 type = Integer.parseInt(request.getParameter("type"));
	    	 } else {
			   		return ResultGenerator.genParmeterErrorResult();
			   	}  
	    	 Map<String,Object> map = new HashMap();
	    	 
		    	 
		    	if(mid !=null) {
		    		map.put("mid", mid);
		    	}
		    	if(mtype !=null) {
		    		map.put("mtype", mtype);
		    	}
		    	if(type !=null) {
		    		map.put("type", type);
		    	}
		    List<TCourseSignUpDTO> list = tCourseService.selectTCourseSignUpDTOByMap(map);
	        return ResultGenerator.genSuccessResult(list);
   	}catch (Exception e) {
			// TODO: handle exception
   		logger.error(e.getMessage(), e);
   		return ResultGenerator.genServerResult("服务器异常");
		}
    }
}

package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dto.TCourseDTO;
import com.company.project.model.TCourse;
import com.company.project.service.TCourseService;
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

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TCourse tCourse = tCourseService.findById(id);
        return ResultGenerator.genSuccessResult(tCourse);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size,HttpServletRequest request) {
    	 Integer mid = null;
    	 if(request.getParameter("mid") !=null) {
    		 mid = Integer.parseInt(request.getParameter("mid"));
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
		 String data  = request.getParameter("teacherId");
		 String cName = request.getParameter("teacherId");
		 String tName = request.getParameter("teacherId");
         
         
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
    	if(teacherId !=null) {
    		map.put("teacherId", teacherId);
    	}
    	if(cid !=null) {
    		map.put("cid", cid);
    	}
    	
        PageHelper.startPage(page, size);
        List<TCourseDTO> list = tCourseService.selectTCourseByCondition(map);
        return ResultGenerator.genSuccessResult(list);
    }
}

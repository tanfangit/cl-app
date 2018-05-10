package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TCourseType;
import com.company.project.service.TCourseTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by tanfan on 2018/05/09.
*/
@RestController
@RequestMapping("/coursetype")
public class TCourseTypeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TCourseTypeService tCourseTypeService;

    @PostMapping("/add")
    public Result add(TCourseType tCourseType) {
        tCourseTypeService.save(tCourseType);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tCourseTypeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TCourseType tCourseType) {
        tCourseTypeService.update(tCourseType);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TCourseType tCourseType = tCourseTypeService.findById(id);
        return ResultGenerator.genSuccessResult(tCourseType);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
    	try {
		        PageHelper.startPage(page, size);
		        List<TCourseType> list = tCourseTypeService.findAll();
		       // PageInfo pageInfo = new PageInfo(list);
		        return ResultGenerator.genSuccessResult(list);
    	}catch (Exception e) {
			// TODO: handle exception
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
    }
}

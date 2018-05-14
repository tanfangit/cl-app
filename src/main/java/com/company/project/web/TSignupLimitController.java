package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TSignupLimit;
import com.company.project.service.TSignupLimitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
* Created by tanfan on 2018/05/14.
*/
@RestController
@RequestMapping("/t/signup/limit")
public class TSignupLimitController {
    @Resource
    private TSignupLimitService tSignupLimitService;

    @PostMapping("/add")
    public Result add(TSignupLimit tSignupLimit) {
        tSignupLimitService.save(tSignupLimit);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tSignupLimitService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TSignupLimit tSignupLimit) {
        tSignupLimitService.update(tSignupLimit);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TSignupLimit tSignupLimit = tSignupLimitService.findById(id);
        return ResultGenerator.genSuccessResult(tSignupLimit);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<TSignupLimit> list = tSignupLimitService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/listByMap")
    public Result listByMap(HttpServletRequest request) {
        Map map = new HashMap();
        map.put("mtype", 1);
        map.put("type", 1);
        List<TSignupLimit> list = tSignupLimitService.selectTSignupLimitByMap(map);
        
        return ResultGenerator.genSuccessResult(list);
    }
    
}

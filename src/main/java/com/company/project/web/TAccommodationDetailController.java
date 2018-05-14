package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TAccommodationDetail;
import com.company.project.service.TAccommodationDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by tanfan on 2018/05/14.
*/
@RestController
@RequestMapping("/t/accommodation/detail")
public class TAccommodationDetailController {
    @Resource
    private TAccommodationDetailService tAccommodationDetailService;

    @PostMapping("/add")
    public Result add(TAccommodationDetail tAccommodationDetail) {
        tAccommodationDetailService.save(tAccommodationDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tAccommodationDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TAccommodationDetail tAccommodationDetail) {
        tAccommodationDetailService.update(tAccommodationDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TAccommodationDetail tAccommodationDetail = tAccommodationDetailService.findById(id);
        return ResultGenerator.genSuccessResult(tAccommodationDetail);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<TAccommodationDetail> list = tAccommodationDetailService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

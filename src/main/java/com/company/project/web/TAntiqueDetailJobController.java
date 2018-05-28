package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TAntiqueDetailJob;
import com.company.project.service.TAntiqueDetailJobService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by tanfan on 2018/05/28.
*/
@RestController
@RequestMapping("/t/antique/detail/job")
public class TAntiqueDetailJobController {
    @Resource
    private TAntiqueDetailJobService tAntiqueDetailJobService;

    @PostMapping("/add")
    public Result add(TAntiqueDetailJob tAntiqueDetailJob) {
        tAntiqueDetailJobService.save(tAntiqueDetailJob);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tAntiqueDetailJobService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TAntiqueDetailJob tAntiqueDetailJob) {
        tAntiqueDetailJobService.update(tAntiqueDetailJob);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TAntiqueDetailJob tAntiqueDetailJob = tAntiqueDetailJobService.findById(id);
        return ResultGenerator.genSuccessResult(tAntiqueDetailJob);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<TAntiqueDetailJob> list = tAntiqueDetailJobService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

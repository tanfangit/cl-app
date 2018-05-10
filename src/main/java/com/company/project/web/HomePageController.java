package com.company.project.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TArticle;
import com.company.project.service.TArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/homepage")
public class HomePageController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private TArticleService tArticleService;
	
	@PostMapping("/articleList")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<TArticle> list = tArticleService.findAll();
        return ResultGenerator.genSuccessResult(list);
    }
}

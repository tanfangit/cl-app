package com.company.project.web;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dto.TOtherreservationsDTO;
import com.company.project.model.TOtherreservations;
import com.company.project.model.TOtherreservationsAccommodation;
import com.company.project.service.TOtherreservationsService;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
* Created by tanfan on 2018/05/15.
*/
@RestController
@RequestMapping("/otherReservations")
public class TOtherreservationsController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TOtherreservationsService tOtherreservationsService;

    @PostMapping("/add")
    public Result add(TOtherreservations tOtherreservations) {
        tOtherreservationsService.save(tOtherreservations);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tOtherreservationsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TOtherreservations tOtherreservations) {
        tOtherreservationsService.update(tOtherreservations);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TOtherreservations tOtherreservations = tOtherreservationsService.findById(id);
        return ResultGenerator.genSuccessResult(tOtherreservations);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<TOtherreservations> list = tOtherreservationsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/signUp")
    public Result signUp(HttpServletRequest request,TOtherreservationsDTO tOtherreservationsDTO) {
    	 String sdates = request.getParameter("sdates");
    	 String edates = request.getParameter("edates");
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 if(StringUtils.isEmpty(sdates) || StringUtils.isEmpty(edates)) {
    		 return ResultGenerator.genParmeterErrorResult();
    	 }else {
    		 try {
				tOtherreservationsDTO.setSdate(sdf.parse(sdates));
				tOtherreservationsDTO.setEdate(sdf.parse(edates));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
        //
    	try {
    		if(StringUtils.isEmpty(tOtherreservationsDTO.getUnames()) || StringUtils.isEmpty(tOtherreservationsDTO.getUphone()) || tOtherreservationsDTO.getUsex() ==null
    				|| StringUtils.isEmpty(tOtherreservationsDTO.getDates()) || tOtherreservationsDTO.getDays() == null
    				) {
    			//参数错误
		        return ResultGenerator.genParmeterErrorResult();
    		}
    		String alist = request.getParameter("alist");
    		//JSONObject obj = new JSONObject();
    		JSONArray  jsonArr =  JSONArray.parseArray(alist);
    		List<TOtherreservationsAccommodation>  accommodations= new ArrayList();
    		TOtherreservationsAccommodation tOtherreservationsAccommodation;
    		for(Object object : jsonArr) {
    			 	JSONObject jsonObjectone = (JSONObject) object;
    		        String typename = jsonObjectone.getString("typename");
    		        Integer id = jsonObjectone.getInteger("id");
    		        Integer count = jsonObjectone.getInteger("count");
    		        Integer rcount = jsonObjectone.getInteger("rcount");
    		        tOtherreservationsAccommodation = new TOtherreservationsAccommodation();
    		        tOtherreservationsAccommodation.setTypeid(id);
    		        tOtherreservationsAccommodation.setTypename(typename);
    		        tOtherreservationsAccommodation.setCount(count);
    		        tOtherreservationsAccommodation.setRcount(rcount);
    		        accommodations.add(tOtherreservationsAccommodation);
    		}
    		tOtherreservationsDTO.setAccommodations(accommodations);
    		return tOtherreservationsService.signUp(tOtherreservationsDTO); 
    	}catch (Exception e) {
			// TODO: handle exception
    		logger.error(e.getMessage(), e);
    		return ResultGenerator.genServerResult("服务器异常");
		}
          
    }
    @PostMapping("/cancel")
    public Result cancel(@RequestParam Integer id) {
         
        return tOtherreservationsService.cancel(id);
    }
    
}

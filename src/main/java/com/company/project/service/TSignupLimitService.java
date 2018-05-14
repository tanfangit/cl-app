package com.company.project.service;
import com.company.project.model.TSignupLimit;

import java.util.List;
import java.util.Map;

import com.company.project.core.Service;


/**
 * Created by tanfan on 2018/05/14.
 */
public interface TSignupLimitService extends Service<TSignupLimit> {
   List<TSignupLimit> selectTSignupLimitByMap(Map<String,Object> map);
}

package com.company.project.service;
import com.company.project.model.TMember;

import java.util.Map;

import com.company.project.core.Service;


/**
 * Created by tanfan on 2018/05/14.
 */
public interface TMemberService extends Service<TMember> {
    int insertTMemberByTMember(TMember tMember);
    
    int updateTMemberByTMember(TMember tMember);
    
    TMember selectTMemberByMap(Map<String,Object> map);
    
    int deleteTMemberByMap(Map<String,Object> map);
}

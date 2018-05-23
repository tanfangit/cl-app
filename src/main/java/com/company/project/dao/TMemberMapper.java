package com.company.project.dao;

import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.model.TMember;

public interface TMemberMapper extends Mapper<TMember> {
    int insertTMemberByTMember(TMember tMember);
    
    int updateTMemberByTMember(TMember tMember);
    
    TMember selectTMemberByMap(Map<String,Object> map);
    
    int deleteTMemberByMap(Map<String,Object> map);
}
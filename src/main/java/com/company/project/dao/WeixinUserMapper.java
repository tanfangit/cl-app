package com.company.project.dao;

import java.util.Map;

import com.company.project.dto.UserDTO;

public interface WeixinUserMapper {
     int insertUserDTO(UserDTO userDTO); 
     UserDTO selectUserDTO(Map<String,Object> map); 
}

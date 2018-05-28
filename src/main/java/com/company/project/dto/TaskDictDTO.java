package com.company.project.dto;

import java.util.List;

import com.company.project.model.TaskDict;

/**
 * 用于定时任务同步文玩数据 字典 实体类
 * @author tanfan
 *
 */
public class TaskDictDTO {
     private String code;
     private int isDeleted;
     private List<TaskDict> detailList;
     private String name;
     private String description;
     private int id;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public List<TaskDict> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<TaskDict> detailList) {
		this.detailList = detailList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
     
}

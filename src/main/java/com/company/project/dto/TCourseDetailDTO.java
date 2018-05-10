package com.company.project.dto;

import java.util.List;

import com.company.project.model.TCatalog;
import com.company.project.model.TCourse;
import com.company.project.model.TTeacher;

public class TCourseDetailDTO extends TCourse {
      private List<TCatalog> tCatalog;
      private TTeacher tTeacher;
      private int aStatus;
    
	public int getaStatus() {
		return aStatus;
	}
	public void setaStatus(int aStatus) {
		this.aStatus = aStatus;
	}
	public List<TCatalog> gettCatalog() {
		return tCatalog;
	}
	public void settCatalog(List<TCatalog> tCatalog) {
		this.tCatalog = tCatalog;
	}
	public TTeacher gettTeacher() {
		return tTeacher;
	}
	public void settTeacher(TTeacher tTeacher) {
		this.tTeacher = tTeacher;
	}
      
}

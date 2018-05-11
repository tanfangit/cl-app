package com.company.project.dto;

import com.company.project.model.TAntiqueDetail;

public class TAntiqueDetailDTO extends TAntiqueDetail{
	/**
     * 来源名称
     */
    private String sourcename;
    /**
     * 类别名称
     */
    private String typename;
	public String getSourcename() {
		return sourcename;
	}
	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
    
    
}

package com.company.project.model;

import javax.persistence.*;

@Table(name = "t_dict")
public class TDict {
    /**
     * 字典ID
     */
    @Id
    @Column(name = "DICT_ID")
    private Long dictId;

    /**
     * 键
     */
    @Column(name = "KEYY")
    private int keyy;

    /**
     * 值
     */
    @Column(name = "VALUEE")
    private String valuee;

    /**
     * 字段名称
     */
    @Column(name = "FIELD_NAME")
    private String fieldName;

    /**
     * 表名
     */
    @Column(name = "TABLE_NAME")
    private String tableName;
    
    /**
     * 字段分类 code
     */
    @Column(name = "TYPE_CODE")
    private String typeCode;
    
    /**
     * 字段分类 名称
     */
    @Column(name = "TYPE_NAME")
    private String typeName;
    
    
    public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
     * 获取字典ID
     *
     * @return DICT_ID - 字典ID
     */
    public Long getDictId() {
        return dictId;
    }

    /**
     * 设置字典ID
     *
     * @param dictId 字典ID
     */
    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    /**
     * 获取键
     *
     * @return KEYY - 键
     */
    public int getKeyy() {
        return keyy;
    }

    /**
     * 设置键
     *
     * @param keyy 键
     */
    public void setKeyy(int keyy) {
        this.keyy = keyy;
    }

    /**
     * 获取值
     *
     * @return VALUEE - 值
     */
    public String getValuee() {
        return valuee;
    }

    /**
     * 设置值
     *
     * @param valuee 值
     */
    public void setValuee(String valuee) {
        this.valuee = valuee;
    }

    /**
     * 获取字段名称
     *
     * @return FIELD_NAME - 字段名称
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 设置字段名称
     *
     * @param fieldName 字段名称
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 获取表名
     *
     * @return TABLE_NAME - 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置表名
     *
     * @param tableName 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
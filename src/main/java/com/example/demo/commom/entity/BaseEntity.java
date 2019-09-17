package com.example.demo.commom.entity;

import java.io.Serializable;

/**
 * 基类
 * @author zhener
 * @date 16:07 2019/8/22
 */
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

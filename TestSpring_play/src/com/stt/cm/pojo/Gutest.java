package com.stt.cm.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Gutest implements Serializable{
	
	private String id;
	private String s1;
	private int i1;
	private int i2;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public int getI1() {
		return i1;
	}
	public void setI1(int i1) {
		this.i1 = i1;
	}
	public int getI2() {
		return i2;
	}
	public void setI2(int i2) {
		this.i2 = i2;
	}

}

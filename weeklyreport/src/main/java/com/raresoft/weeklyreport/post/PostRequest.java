package com.raresoft.weeklyreport.post;

public class PostRequest {

	private String proName;
	private String proThisWeek;
	private String proNextWeek;
	private Short proProgress;
	private int listId;
	private Short cateCode;
	
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProThisWeek() {
		return proThisWeek;
	}
	public void setProThisWeek(String proThisWeek) {
		this.proThisWeek = proThisWeek;
	}
	public String getProNextWeek() {
		return proNextWeek;
	}
	public void setProNextWeek(String proNextWeek) {
		this.proNextWeek = proNextWeek;
	}
	public Short getProProgress() {
		return proProgress;
	}
	public void setProProgress(Short proProgress) {
		this.proProgress = proProgress;
	}
	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public Short getCateCode() {
		return cateCode;
	}
	public void setCateCode(Short cateCode) {
		this.cateCode = cateCode;
	}
}

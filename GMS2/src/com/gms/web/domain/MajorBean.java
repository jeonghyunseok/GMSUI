package com.gms.web.domain;

public class MajorBean {
	private String major_id, title, id, subjId;

	@Override
	public String toString() {
		return "MajorBean [major_id=" + major_id + ", title=" + title + ", id=" + id + ", subjId=" + subjId + "]";
	}

	public String getMajor_id() {
		return major_id;
	}

	public void setMajor_id(String major_id) {
		this.major_id = major_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubjId() {
		return subjId;
	}

	public void setSubjId(String subjId) {
		this.subjId = subjId;
	}

}

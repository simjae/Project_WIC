package kr.or.wic.dto;

import java.util.Date;

public class CustomerServiceDTO {
	private int cs_num;
	private String cs_title;
	private String cs_content;
	private String cs_file;
	private int cs_reffer;
	private int cs_depth;
	private int cs_step;
	private int cs_count;
	private Date cs_date;
	private int cs_notice;
	private String id;
	public int getCs_num() {
		return cs_num;
	}
	public void setCs_num(int cs_num) {
		this.cs_num = cs_num;
	}
	public String getCs_title() {
		return cs_title;
	}
	public void setCs_title(String cs_title) {
		this.cs_title = cs_title;
	}
	public String getCs_content() {
		return cs_content;
	}
	public void setCs_content(String cs_content) {
		this.cs_content = cs_content;
	}
	public String getCs_file() {
		return cs_file;
	}
	public void setCs_file(String cs_file) {
		this.cs_file = cs_file;
	}
	public int getCs_reffer() {
		return cs_reffer;
	}
	public void setCs_reffer(int cs_reffer) {
		this.cs_reffer = cs_reffer;
	}
	public int getCs_depth() {
		return cs_depth;
	}
	public void setCs_depth(int cs_depth) {
		this.cs_depth = cs_depth;
	}
	public int getCs_step() {
		return cs_step;
	}
	public void setCs_step(int cs_step) {
		this.cs_step = cs_step;
	}
	public int getCs_count() {
		return cs_count;
	}
	public void setCs_count(int cs_count) {
		this.cs_count = cs_count;
	}
	public Date getCs_date() {
		return cs_date;
	}
	public void setCs_date(Date cs_date) {
		this.cs_date = cs_date;
	}
	public int getCs_notice() {
		return cs_notice;
	}
	public void setCs_notice(int cs_notice) {
		this.cs_notice = cs_notice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CustumoerServiceDTO [cs_num=" + cs_num + ", cs_title=" + cs_title + ", cs_content=" + cs_content
				+ ", cs_file=" + cs_file + ", cs_reffer=" + cs_reffer + ", cs_depth=" + cs_depth + ", cs_step="
				+ cs_step + ", cs_count=" + cs_count + ", cs_date=" + cs_date + ", cs_notice=" + cs_notice + ", id="
				+ id + "]";
	}
	
	
	
}

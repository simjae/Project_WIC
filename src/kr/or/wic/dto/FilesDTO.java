package kr.or.wic.dto;

public class FilesDTO {
	private int files_num;
	private String files_name;
	private String files_path;
	private int prd_num;
	public int getFiles_num() {
		return files_num;
	}
	public void setFiles_num(int files_num) {
		this.files_num = files_num;
	}
	public String getFiles_name() {
		return files_name;
	}
	public void setFiles_name(String files_name) {
		this.files_name = files_name;
	}
	public String getFiles_path() {
		return files_path;
	}
	public void setFiles_path(String files_path) {
		this.files_path = files_path;
	}
	public int getPrd_num() {
		return prd_num;
	}
	public void setPrd_num(int prd_num) {
		this.prd_num = prd_num;
	}
	@Override
	public String toString() {
		return "FilesDTO [files_num=" + files_num + ", files_name=" + files_name + ", files_path=" + files_path
				+ ", prd_num=" + prd_num + "]";
	}
	
	
}

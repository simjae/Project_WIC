package kr.or.wic.dto;

public class ClosetDTO {
	private int closet_num;
	private String closet_title;
	private String closet_content;
	public int getCloset_num() {
		return closet_num;
	}
	public void setCloset_num(int closet_num) {
		this.closet_num = closet_num;
	}
	public String getCloset_title() {
		return closet_title;
	}
	public void setCloset_title(String closet_title) {
		this.closet_title = closet_title;
	}
	public String getCloset_content() {
		return closet_content;
	}
	public void setCloset_content(String closet_content) {
		this.closet_content = closet_content;
	}
	@Override
	public String toString() {
		return "ClosetDTO [closet_num=" + closet_num + ", closet_title=" + closet_title + ", closet_content="
				+ closet_content + "]";
	}
	
	
}

package kr.or.wic.dto;

public class CartDTO {
	private int prd_num;
	private String id;
	public int getPrd_num() {
		return prd_num;
	}
	public void setPrd_num(int prd_num) {
		this.prd_num = prd_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CartDTO [prd_num=" + prd_num + ", id=" + id + "]";
	}
	
	
	
	
}

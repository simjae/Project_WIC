package kr.or.wic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.wic.dto.ProductDTO;

public class ProductDAO {
	static DataSource ds;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	static {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			Context envctx = (Context)ctx.lookup("java:comp/env");
			ds = (DataSource)envctx.lookup("/jdbc/oracle");
		} catch (Exception e) {
			System.out.println("look up Fail: " + e.getMessage());
		}
	}
	
	//1.상품정보 보기(return the product list)
	public List<ProductDTO> getAllProductList(){
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		try {
			conn = ds.getConnection();
			
			String sql = "select prd_num, prd_title, prd_price, prd_date, prd_content, prd_state, prd_count, closet_num from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				
				product.setPrd_num(rs.getInt("prd_num"));
				product.setPrd_title(rs.getString("prd_title"));
				product.setPrd_price(rs.getInt("prd_price"));
				product.setPrd_date(rs.getDate("prd_date"));
				product.setPrd_content(rs.getString("prd_content"));
				product.setPrd_state(rs.getInt("prd_state"));
				product.setPrd_count(rs.getInt("prd_count"));
				product.setCloset_num(rs.getInt("closet_num"));
				
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}
	
	//2.회원별 상품 보기(return the productList by ID)
	public List<ProductDTO> getProductListById(String id) {
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		try {
			conn = ds.getConnection();
			String sql = "p.prd_num, p.prd_title, p.prd_price, p.prd_date, p.prd_content, p.prd_state, p.prd_count, p.closet_num,"
						+ "from product p, member m where p.closet_num = m.closet_num and m.id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				
				product.setPrd_num(rs.getInt("prd_num"));
				product.setPrd_title(rs.getString("prd_title"));
				product.setPrd_price(rs.getInt("prd_price"));
				product.setPrd_date(rs.getDate("prd_date"));
				product.setPrd_content(rs.getString("prd_content"));
				product.setPrd_state(rs.getInt("prd_state"));
				product.setPrd_count(rs.getInt("prd_count"));
				product.setCloset_num(rs.getInt("closet_num"));
				
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}
	
	//3.상품 정보 등록(insert the new product)
	public int insertProduct(ProductDTO product) {
		int result = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into product(prd_num, prd_title, prd_price, prd_date,prd_content,prd_state,prd_count,closet_num)"
						+ "values(?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			/*
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getIp());
			*/
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//4.상품 정보 수정(update the member's info)
	public int updateMember(String id, String name, int age, String gender, String email) {
		int row =0;
		
		try {
			conn = ds.getConnection();
			String sql = "update koreamember set name=? , age=? , email=? , gender=? where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, email);
			pstmt.setString(4, gender);
			pstmt.setString(5, id);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	//5.상품 정보 삭제(delte the memeber's info)
	public int deleteMember(String id) {
		int row = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "delete from koreamember where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
}

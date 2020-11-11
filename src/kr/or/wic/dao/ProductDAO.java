package kr.or.wic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	//1.상품정보 조회(return the product list)
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
	
	//1-1.상품정보 조회(ProductListPage 정보만 조회(prd_num, prd_title, prd_content)
	//(굳이 세개만 조회해야 하나? 이게 효율이 좋나, 아니면 그냥 정보 조회 모두 한 다음에 prd객체에서 해당 정보만 뽑아 오는 것이 좋나?)
	public List<ProductDTO> getProductNumTitleContentList(){
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		try {
			conn = ds.getConnection();
			String sql = "select prd_num, prd_title, prd_content from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setPrd_num(rs.getInt("prd_num"));
				product.setPrd_title(rs.getString("prd_title"));
				product.setPrd_content(rs.getString("prd_content"));
				
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
	
	//2.회원별 상품 조회(return the productList by ID)
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
	
	//2-1.상품번호로 상품 조회(return the product by prd_num)
	public ProductDTO getProduct(int prd_num) {
		ProductDTO product = new ProductDTO();
		try {
			conn = ds.getConnection();
			String sql = "select prd_title, prd_price, prd_date, prd_content, prd_state, prd_count, closet_num from product where prd_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prd_num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				product.setPrd_num(prd_num);
				product.setPrd_title(rs.getString("prd_title"));
				product.setPrd_price(rs.getInt("prd_price"));
				product.setPrd_date(rs.getDate("prd_date"));
				product.setPrd_content(rs.getString("prd_content"));
				product.setPrd_state(rs.getInt("prd_state"));
				product.setPrd_count(rs.getInt("prd_count"));
				product.setCloset_num(rs.getInt("closet_num"));
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
		return product;
	}
	
	//3.상품 정보 등록(insert the new product)
	public int insertProduct(ProductDTO product) {
		int result = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into product(prd_num, prd_title, prd_price, prd_date, prd_content, prd_state, prd_count, closet_num)"
						+ "values(?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, product.getPrd_num());
			pstmt.setString(2, product.getPrd_title());
			pstmt.setInt(3, product.getPrd_price());
			pstmt.setDate(4, (java.sql.Date)product.getPrd_date());
			pstmt.setString(5, product.getPrd_content());
			pstmt.setInt(6, product.getPrd_state());
			pstmt.setInt(7, product.getPrd_count());
			pstmt.setInt(8, product.getCloset_num());
			
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
	
	//4.상품 정보 수정(update the information of product)
	public int updateProduct(int prd_num, String prd_title, int prd_price, String prd_content, int prd_state) {
		int row =0;
		
		try {
			conn = ds.getConnection();
			String sql = "update product set prd_title=? , prd_price=? , prd_content=? , prd_state=? where prd_num=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, prd_title);
			pstmt.setInt(2, prd_price);
			pstmt.setString(3, prd_content);
			pstmt.setInt(4, prd_state);
			pstmt.setInt(5, prd_num);
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
	
	//5.상품 정보 삭제(delete the product)
	public int deleteProduct(int prd_num) {
		int row = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "delete from product where prd_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prd_num);
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
	
	//6.파일 등록 (upload the file)
	public int updateFile(String files_name, String files_path) {
		int row = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "select max(prd_num) from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				
				System.out.println("maxprdnum: " + rs.getInt("max(prd_num)"));
				sql = "insert into files (files_num,files_name,files_path,prd_num) values(prd_num.nextval,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, files_name);
				pstmt.setString(2, files_path);
				pstmt.setInt(3, rs.getInt("max(prd_num)"));
				row = pstmt.executeUpdate();
				
			}else {
				System.out.println("rs 없음 ");
			}
			
		
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
	
	public int deleteFile(String files_name) {
		int row=0;
		try {
			conn = ds.getConnection();
			String sql = "delete from files where files_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, files_name);
			row = pstmt.executeUpdate();
			
		}catch (SQLException e) {
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

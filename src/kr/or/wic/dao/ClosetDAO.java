package kr.or.wic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.wic.dto.MemberDTO;

public class ClosetDAO {
	
	static DataSource ds;
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	
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
	
	
		
	//Closet - Select Info member + closet
	public MemberDTO getMemberInfoForCloset(String id){
		MemberDTO member = new MemberDTO();
		/*ClosetDTO closet=new ClosetDTO();*/
		
		try {
			conn = ds.getConnection();
			/*
			String sql = "select m.id, m.name, m.addr, m.profile_pic, c.closet_num, c.closet_title, c.closet_content\n"
					+ "from member m  join closet c\n"
					+ "on m.closet_num = c.closet_num\n"
					+ "where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				
				
				member.setId(rs.getString("m.id"));
				member.setName(rs.getString("m.name"));
				member.setAddr(rs.getString("m.addr"));
				member.setProcile_pic(rs.getString("m.procile_pic"));
				closet.setCloset_num(rs.getInt("c.closet_num"));
				closet.setCloset_title(rs.getString("c.closet_title"));
				closet.setCloset_content(rs.getString("c.closet_content"));
			*/
			String sql = "select id, name, addr, profile_pic, closet_num from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
				member.setProcile_pic(rs.getString("profile_pic"));
				member.setCloset_num(rs.getInt("closet_num"));
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
		
		return member;
	}
	
	//Mypage - update
}

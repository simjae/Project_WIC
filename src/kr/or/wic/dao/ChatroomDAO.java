package kr.or.wic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.wic.dto.ChatroomDTO;

public class ChatroomDAO {
	static DataSource ds;
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;

	static {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			Context envctx = (Context) ctx.lookup("java:comp/env");
			ds = (DataSource) envctx.lookup("/jdbc/oracle");
		} catch (Exception e) {
			System.out.println("look up Fail: " + e.getMessage());
		}
	}

	public int chatRoomCount(int prd_num) {
		int result = 0;
		try {
			conn = ds.getConnection();
			String sql = "select count(*) from PRD_CHATROOM where prd_num =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prd_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
				System.out.println(result);
				System.out.println("chatRoomCoun 실행완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" chatRoomCoun 오류");
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<ChatroomDTO> chatRoomList(int prd_num, int currentPage, int pageSize) {
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		List<ChatroomDTO> result = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from\n" + "(select ROWNUM as rnum, cm.* from\n"
					+ "(select c.ch_num , c.ch_title , m.name from \n"
					+ "prd_chatroom c, member m WHERE c.id = m.id and prd_num=?\n" + "order by c.ch_num desc)cm)\n"
					+ "where ? <= rnum and rnum  <= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prd_num);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ChatroomDTO dto = new ChatroomDTO();
				dto.setCh_num(rs.getInt("ch_num"));
				dto.setCh_title(rs.getString("ch_title"));
				dto.setName(rs.getString("name"));
				result.add(dto);
				System.out.println(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" chatRoomList 오류");
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}

}

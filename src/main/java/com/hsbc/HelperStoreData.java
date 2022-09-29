package com.hsbc;
import java.sql.*;

public class HelperStoreData {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	
	public String storeData(String name,String city,int distance,int summary) {
		try {
			String sql = "insert into travelcost values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setInt(3,distance);
			pstmt.setInt(4,summary);
			int i=pstmt.executeUpdate();  
            System.out.println(i+" records inserted");
            return i+" records inserted";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}
	
}

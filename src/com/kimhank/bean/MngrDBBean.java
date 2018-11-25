package com.kimhank.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.security.MessageDigest;

import org.apache.tomcat.jdbc.pool.DataSource;


public class MngrDBBean {
	private static MngrDBBean instance = new MngrDBBean();
	
	public static MngrDBBean getInstance() {
		return instance;
	}
	
	private MngrDBBean() {};
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		return ds.getConnection();
	}
	
	 
	private String  Encoder(String base) {
	 
	        try{
	 
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(base.getBytes("UTF-8"));
	            StringBuffer hexString = new StringBuffer();
	 
	            for (int i = 0; i < hash.length; i++) {
	                String hex = Integer.toHexString(0xff & hash[i]);
	                if(hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	 
	            return hexString.toString();
	 
	        } catch(Exception ex){
	            throw new RuntimeException(ex);
	        }
	 
	    }
	 
	public int userCheck(String id, String passwd) {
		int rtn = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String orgPass = passwd;
			String shaPass = Encoder(orgPass);
			String sql = "select manager_password from manager where managerid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("manager_password");
				// to do  password matching
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs != null) try { rs.close();} catch(SQLException ex) {}
			if(pstmt !=null) try { pstmt.close();} catch(SQLException ex) {}
			if(con != null) try { con.close(); } catch(SQLException ex) {}
		}
		
		
		return rtn;
	}
	
	
}

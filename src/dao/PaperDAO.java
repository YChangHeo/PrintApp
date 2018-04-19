package dao;

import model.Order;
import model.Paper;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperDAO {
	private String SQL_001="Select PaperId, PaperName, Width, Height, Price, SupplyName from Paper";
	private String SQL_002="Insert into Paper(PaperId, PaperName, Width, Height, Price, SupplyName) Values(?, ?, ?, ?, ?, ?) ";
	private String SQL_003="Update Paper set PaperName=?, Width=?, Height=?, Price=? , SupplyName=? where PaperId=?";
	private String SQL_004="Delete from Paper where PaperId=?";
	private String SQL_005="Select top 1 1 from Paper where PaperId=?";
	
	public List<Paper> GetPaperData(){
		Connection con= null;
		Statement stm= null;
		List<Paper> lst =null;
		try {
			con= CommonDAO.getSQLConnection();
		    stm= con.createStatement();
		    lst =new ArrayList<Paper>();
		    ResultSet rs=stm.executeQuery(SQL_001);
		    
		    while(rs.next()) {
		    	Paper paper=new Paper();
		    	paper.setPaperID(rs.getString("PaperId"));
		    	paper.setPaperName(rs.getString("PaperName"));
		    	paper.setWidth(rs.getFloat("Width"));
		    	paper.setHeight(rs.getFloat("Height"));
		    	paper.setPrice(rs.getInt("Price"));
		    	paper.setSupplyName(rs.getString("SupplyName"));
		    	lst.add(paper);
		    }		    
		    
		    rs.close();
		    stm.close();
		    con.close();
		    
		    return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean InsertPaperData(Paper paper){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_002);
		    pstm.setString(1, paper.getPaperID());
		    pstm.setString(2, paper.getPaperName());
		    //pstm.setFloat(3, paper.getWidth());
		    //pstm.setFloat(4, paper.getHeight());
		    pstm.setInt(5, paper.getPrice());
		    pstm.setString(6, paper.getSupplyName());		    
		    int rs=pstm.executeUpdate();
		    
		    if(rs>0) {		    	
		    	result=true;
		    }
		    pstm.close();
		    con.close();
		    
		    return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Boolean UpdatePaperData(Paper paper){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_003);			
		    pstm.setString(1, paper.getPaperName());
		    //pstm.setFloat(2, paper.getWidth());
		    //pstm.setFloat(3, paper.getHeight());
		    pstm.setInt(4, paper.getPrice());
		    pstm.setString(5, paper.getSupplyName());
		    pstm.setString(6, paper.getPaperID());
		    int rs=pstm.executeUpdate();
		    
		    if(rs>0) {		    	
		    	result=true;
		    }
		    pstm.close();
		    con.close();
		    
		    return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Boolean DeletePaperData(String paperId){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_004);
		    pstm.setString(1, paperId);
		    int rs=pstm.executeUpdate();
		    
		    if(rs>0) {		    	
		    	result=true;
		    }
		    pstm.close();
		    con.close();
		    
		    return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}

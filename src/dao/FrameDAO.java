package dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Frame;
public class FrameDAO {
	private String SQL_001="Select FrameId, FrameName, MarginTop, MarginBot, MarginLeft, MarginRight from Frame";
	private String SQL_002="Insert into Frame(FrameId, FrameName, MarginTop, MarginBot, MarginLeft, MarginRight) Values(?, ?, ?, ?, ?, ?) ";
	private String SQL_003="Update Frame set FrameName=?, MarginTop=?, MarginBot=?, MarginLeft=?, MarginRight=? where FrameId=?";
	private String SQL_004="Delete from Frame where FrameId=?";
	private String SQL_005="Select top 1 1 from Frame where FrameId=?";
	
	
	public List<Frame> GetFrameData(){
		Connection con= null;
		Statement stm= null;
		List<Frame> lst =null;
		try {			
			con= CommonDAO.getSQLConnection();
		    stm= con.createStatement();
		    lst =new ArrayList<Frame>();
		    ResultSet rs=stm.executeQuery(SQL_001);
		    
		    while(rs.next()) {
		    	Frame frame=new Frame();
		    	frame.setFrameID(rs.getString("FrameId"));
		    	frame.setFrameName(rs.getString("FrameName"));
		    	frame.setMarginTop(rs.getFloat("MarginTop"));
		    	frame.setMarginBot(rs.getFloat("MarginBot"));
		    	frame.setMarginLeft(rs.getFloat("MarginLeft"));
		    	frame.setMarginRight(rs.getFloat("MarginRight"));
		    	
		    	lst.add(frame);
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
	
	public Boolean InsertFrameData(Frame frame){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_002);
		    pstm.setString(1, frame.getFrameID());
		    pstm.setString(2, frame.getFrameName());
		    //pstm.setFloat(3, frame.getMarginTop());
		   // pstm.setFloat(4, frame.getMarginBot());
		    //pstm.setFloat(5, frame.getMarginLeft());
		    //pstm.setFloat(6, frame.getMarginRight());
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
	
	public Boolean UpdateFrameData(Frame frame){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_003);
		    pstm.setString(1, frame.getFrameName());
		    //pstm.setFloat(2, frame.getMarginTop());
		    //pstm.setFloat(3, frame.getMarginBot());
		    //pstm.setFloat(4, frame.getMarginLeft());
		    //pstm.setFloat(5, frame.getMarginRight());
		    pstm.setString(6, frame.getFrameID());
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
	
	public Boolean DeleteFrameData(String frameID){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_004);
		    pstm.setString(1, frameID);
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

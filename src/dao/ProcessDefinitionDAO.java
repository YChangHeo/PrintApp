package dao;
import model.Paper;
import model.ProcessDefinition;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessDefinitionDAO {
	private String SQL_001="Select OrderId, ProcessId, ProcessSeq, Time, StartDate, EndDate from ProcessDefinition";
	private String SQL_002="Insert into ProcessDefinition(OrderId, ProcessId, ProcessSeq, Time, StartDate, EndDate) Values(?, ?, ?, ?, ?, ?) ";
	private String SQL_003="Update ProcessDefinition set ProcessSeq?, Time=? , StartDate=?, EndDate=? where OrderId=?, ProcessId=?";
	private String SQL_004="Delete from ProcessDefinition where OrderId=?, ProcessId=?";
	private String SQL_005="Select top 1 1 from ProcessDefinition where OrderId=?, ProcessId=?";
	
	public List<ProcessDefinition> ProcessDefinition(){
		Connection con= null;
		Statement stm= null;
		List<ProcessDefinition> lst =null;
		try {
			con= CommonDAO.getSQLConnection();
		    stm= con.createStatement();
		    lst =new ArrayList<ProcessDefinition>();
		    ResultSet rs=stm.executeQuery(SQL_001);
		    
		    while(rs.next()) {
		    	ProcessDefinition processDefinition=new ProcessDefinition();
		    	processDefinition.setOrderID(rs.getString("OrderId"));
		    	processDefinition.setProcessID(rs.getString("ProcessId"));
		    	processDefinition.setProcessSeq(rs.getInt("ProcessSeq"));
		    	processDefinition.setTime(rs.getString("Time"));
		    	processDefinition.setStartDate(rs.getDate("StartDate"));
		    	processDefinition.setEndDate(rs.getDate("EndDate"));
		    	lst.add(processDefinition);
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
	
	public Boolean InsertPaperData(ProcessDefinition processDefinition){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_002);
		    pstm.setString(1, processDefinition.getOrderID());
		    pstm.setString(2, processDefinition.getProcessID());
		    pstm.setInt(3, processDefinition.getProcessSeq());
		    pstm.setString(4, processDefinition.getTime());
		    pstm.setDate(5, (Date) processDefinition.getStartDate());
		    pstm.setDate(6, (Date) processDefinition.getEndDate());
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
	
	public Boolean UpdatePaperData(ProcessDefinition processDefinition){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_002);
		    pstm.setInt(1, processDefinition.getProcessSeq());
		    pstm.setString(2, processDefinition.getTime());
		    pstm.setDate(3, (Date) processDefinition.getStartDate());
		    pstm.setDate(4, (Date) processDefinition.getEndDate());
		    pstm.setString(5, processDefinition.getOrderID());
		    pstm.setString(6, processDefinition.getProcessID());
		    
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
	
	public Boolean DeletePaperData(String orderID, String processID){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_004);
		    pstm.setString(1, orderID);
		    pstm.setString(2, processID);
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

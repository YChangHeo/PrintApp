package dao;
import model.Paper;
import model.Process;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessDAO {
	private String SQL_001="Select ProcessId, ProcessName from Process";
	private String SQL_002="Insert into Process(PaperId, PaperName) Values(?, ?) ";
	private String SQL_003="Update Paper set PaperName=? where ProcessId=?";
	private String SQL_004="Delete from Process where ProcessId=?";
	private String SQL_005="Select top 1 1 from Process where ProcessId=?";
	
	public List<Process> GetProcessData(){
		Connection con= null;
		Statement stm= null;
		List<Process> lst =null;
		try {
			con= CommonDAO.getSQLConnection();
		    stm= con.createStatement();
		    lst =new ArrayList<Process>();
		    ResultSet rs=stm.executeQuery(SQL_001);
		    
		    while(rs.next()) {
		    	Process process=new Process();
		    	process.setProcessID(rs.getString("ProcessId"));
		    	process.setProcessName(rs.getString("ProcessName"));
		    	lst.add(process);
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
	
	public Boolean InsertPaperData(Process process){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_002);
		    pstm.setString(1, process.getProcessID());
		    pstm.setString(2, process.getProcessName());	    
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
	
	public Boolean UpdatePaperData(Process process){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_003);	
			pstm.setString(1, process.getProcessName());
		    pstm.setString(2, process.getProcessID());		    
		    
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
	
	public Boolean DeletePaperData(String processID){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_004);
		    pstm.setString(1, processID);
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

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Frame;
import model.Order;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
	private String SQL_001="Select OrderId, ProductId, Amount, DeliveryDate, CustomerName, CustomerAddress,CustomerPhone,User,Price from Order";
	private String SQL_002="Insert into Order(OrderId, ProductId, Amount, DeliveryDate, CustomerName, CustomerAddress,CustomerPhone,User,Price) Values(?, ?, ?, ?, ?, ?,?,?,?) ";
	private String SQL_003="Update Order set ProductId=?, Amount=?, DeliveryDate=?, CustomerName=?, CustomerAddress=?,CustomerPhone=?,User=?,Price=? where OrderId=?";
	private String SQL_004="Delete from Order where OrderId=?";
	private String SQL_005="Select top 1 1 from Order where OrderId=?";
	
	public List<Order> GetOrderData(){
		Connection con= null;
		Statement stm= null;
		List<Order> lst =null;
		try {
			con= CommonDAO.getSQLConnection();
		    stm= con.createStatement();
		    lst =new ArrayList<Order>();
		    ResultSet rs=stm.executeQuery(SQL_001);
		    
		    while(rs.next()) {
		    	Order order=new Order();
		    	order.setOrderID(rs.getString("OrderId"));
		    	order.setProductID(rs.getString("ProductId"));
		    	order.setAmount(rs.getInt("Amount"));
		    	order.setDeliveryDate(rs.getDate("DeliveryDate"));
		    	order.setCustomerName(rs.getString("CustomerName"));
		    	order.setCustomerAddress(rs.getString("CustomerAddress"));
		    	order.setUser(rs.getString("User"));
		    	order.setPrice(rs.getInt("Price"));
		    	lst.add(order);
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
	
	public Boolean InsertOrderData(Order order){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_002);
		    pstm.setString(1, order.getOrderID());
		    pstm.setString(2, order.getProductID());
		    pstm.setInt(3, order.getAmount());
		    pstm.setDate(4, (Date) order.getDeliveryDate());
		    pstm.setString(5, order.getCustomerName());
		    pstm.setString(6, order.getCustomerAddress());
		    pstm.setString(7, order.getUser());
		    pstm.setInt(8, order.getPrice());
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
	
	public Boolean UpdateOrderData(Order order){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_003);		
		    pstm.setString(1, order.getProductID());
		    pstm.setInt(2, order.getAmount());
		    pstm.setDate(3, (Date) order.getDeliveryDate());
		    pstm.setString(4, order.getCustomerName());
		    pstm.setString(5, order.getCustomerAddress());
		    pstm.setString(6, order.getUser());
		    pstm.setInt(87, order.getPrice());
		    pstm.setString(8, order.getOrderID());
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
	
	public Boolean DeleteOrderData(String orderID){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();
			pstm = con.prepareStatement(SQL_004);
		    pstm.setString(1, orderID);
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

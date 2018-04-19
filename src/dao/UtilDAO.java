package dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Frame;

public class UtilDAO<T> {
	private T clazz;
	public T getTObject() {
	       return this.clazz;
	   }
	
	public UtilDAO(Class<T> tclass) throws InstantiationException, IllegalAccessException{
		this.clazz = (T) tclass.newInstance();		

	}
	
	private void setProperty(Object clazz, String fieldName, Object columnValue) {
	    try {	    	
	      // get all fields of the class (including public/protected/private)
	      Field field = clazz.getClass().getDeclaredField(fieldName);
	      // this is necessary in case the field visibility is set at private
	      field.setAccessible(true);
	      field.set(clazz, columnValue);
	    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
	      e.printStackTrace();
	    }
	  }

	public List<T> GetData(String sql) throws InstantiationException, IllegalAccessException{
		List<T> outputList = null;
		Connection con= null;
		Statement stm= null;
		
		try {			
			con= CommonDAO.getSQLConnection();
		    stm= con.createStatement();

		    ResultSet rs=stm.executeQuery(sql);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        Field[] fields = this.clazz.getClass().getDeclaredFields();
	        
		    while(rs.next()) {
		    	T bean = (T) clazz;
		    	for(int i=0;i<rsmd.getColumnCount();i++) {
		    		String columnName= rsmd.getColumnName(i+1);
		    		Object columnValue=rs.getObject(i+1);
		    		
		    		for (Field field : fields) {
		    			if(columnName.equals(field.getName())){		    				
		    				this.setProperty(bean, field.getName(), columnValue);
		    				break;
		    			}
		            }
		    	}
		    	if (outputList == null) {
		              outputList = new ArrayList<T>();
		            }
		            outputList.add(bean);
		    }		    
		    
		    rs.close();
		    stm.close();
		    con.close();
		    
		    return outputList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outputList;
	}
	
	public Boolean InsertData(String sql, T pClass){
		Connection con= null;
		Boolean result =false;
		PreparedStatement pstm =null;
		try {			
			con= CommonDAO.getSQLConnection();			
			Field[] fields=pClass.getClass().getDeclaredFields();
			System.out.println("A");
			System.out.println(fields.length);
			System.out.println("B");
			//Chưa lấy dược giá trị từ bên TestDAO 
			pstm = con.prepareStatement(sql);
			System.out.println("C");
			for(Field field:fields) {
				System.out.println(field.getName());
			}
			
		    int rs=0;//pstm.executeUpdate();
		    
		    if(rs>0) {		    	
		    	result=true;
		    }
		    pstm.close();
		    con.close();
		    
		    return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}
}

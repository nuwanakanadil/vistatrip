package TourGuide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TourGuideController {

	  // Connection DB
		private static boolean isSuccess;
	    private static Connection con = null;
	    private static Statement stmt = null;
	    private static ResultSet rs = null;

	    // Insert Data Function
	    public static boolean insertdata(String name, String gmail, String password, String phone) {
	        boolean isSuccess = false;
	        try {
	        	//DB CONNECTION CALL
	            con = DBConnection.getConnection();
	            stmt = con.createStatement();
	            
	            //SQL QUERY
	            String sql = "INSERT INTO newguide VALUES (0, '" + name + "', '" + gmail + "', '" + password + "', '" + phone + "')";
	            int rs = stmt.executeUpdate(sql);
	            isSuccess = rs > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return isSuccess;
	    }
	    
	    // Login Validate Function
	    public static List<TourGuideModel> loginValidate(String gmail, String password) {
	        ArrayList<TourGuideModel> guideList = new ArrayList<>();
	        try {
	            con = DBConnection.getConnection();
	            stmt = con.createStatement();
	            String sql = "SELECT * FROM newguide WHERE gmail = '" + gmail + "' AND password = '" + password + "'";
	            rs = stmt.executeQuery(sql); // FIXED: executeQuery instead of executeUpdate

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String email = rs.getString("gmail");
	                String pass = rs.getString("password");
	                String phone = rs.getString("phone");

	                TourGuideModel t= new TourGuideModel(id, name, email, pass, phone);
	                guideList.add(t);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return guideList; // FIXED: return the list
	    }

	    //GetById
	     public static List<TourGuideModel> getById (String Id){
	    	 int convertID = Integer.parseInt(Id);
	    	 
	    	 ArrayList <TourGuideModel> guide = new ArrayList<>();
	    	 
	    	 try {
	    		//DBConnection
	    		 con=DBConnection.getConnection();
	    		 stmt=con.createStatement();
	    		 
	    		 //Query
	    		 String sql = "select * from newguide where id '"+convertID+"'";
	    		 
	    		 rs = stmt.executeQuery(sql);
	    		 
	    		 while(rs.next()) {
	    			 int id = rs.getInt(1);
	    			 String name =rs.getString(2);
	    			 String email =rs.getString(3);
	    			 String pass =rs.getString(4);
	    			 String phone =rs.getString(5);
	    			
	    			 
	    			 TourGuideModel t = new TourGuideModel(id,name,email,pass,phone);
	    			 guide.add(t);
	    		 }
	    		 
	    	 }
	    	 catch(Exception e) {
	    		 e.printStackTrace();
	    	 }
	    	 return guide;
	    	 
	     }
      
	     //GetAll Data
	     public static List<TourGuideModel> getAllTourGuides (){
	    	 ArrayList <TourGuideModel> guides = new ArrayList<>();
	    	 try {
	     		//DBConnection
	     		 con=DBConnection.getConnection();
	     		 stmt=con.createStatement();
	     		 
	     		 //Query
	     		 String sql = "select * from newguide";
	     		 
	     		 rs = stmt.executeQuery(sql);
	     		 
	     		 while(rs.next()) {
	     			 int id = rs.getInt(1);
	     			String name =rs.getString(2);
	    			String email =rs.getString(3);
	    			String pass =rs.getString(4);
	    			String phone =rs.getString(5);
	     			 
	     			TourGuideModel t = new TourGuideModel(id,name,email,pass,phone);
	     			 guides.add(t);
	     		 }
	     		 
	     	 }
	     	 catch(Exception e) {
	     		 e.printStackTrace();
	     	 }
	     	 return guides;
	     	  
	     }
	     //Update Data
	     public static boolean updatedata(String id,String name ,String gmail ,String password,String phone) {
	    	try {
	    		//DBConnection
	    		con=DBConnection.getConnection();
	    		stmt=con.createStatement();
	    		
	    		//SQL Query
	    		String sql = "update newguide set name='"+name+"',gmail='"+gmail+"',password='"+password+"',phone='"+phone+"'"
	    	                 +"where id='"+id+"'";
	    		
	    		int rs = stmt.executeUpdate(sql);
	    		if(rs>0) {
	    			isSuccess = true;
	    		}
	    		else {
	    			isSuccess = false;
	    		}
	    		
	    		
	    	} 
	    	 catch(Exception e) {
	    		 e.printStackTrace();
	    		 
	    	 }
	    	return isSuccess;
	     }
     
	     
	     // Delete Data
	     public static boolean deletedata(String id) {
	    	 int convID = Integer.parseInt(id);
	    	 try {
	    		 //DBConnection
	    		 con=DBConnection.getConnection();
	    		 stmt=con.createStatement();
	    		 String sql = "delete from newguide where id='"+convID+"'";
	    	int rs = stmt.executeUpdate(sql);
	    	
	    	if(rs > 0) {
	    		isSuccess = true;
	    	}
	    	else {
	    		isSuccess = false;
	    	}
	    	
	    	 }
	    	 catch(Exception e) {
	    		 e.printStackTrace();
	    	 }
	    	 return isSuccess;
	    	 
	     }

	   

	
}

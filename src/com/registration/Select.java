package com.registration;
import java.sql.ResultSet;

public class Select {
	public void select() throws Exception {
		int id;
		String name;
		String city;
		int orderid;
		try {
			DbConnection db = new DbConnection();
			String sql = "select * from customer";
			db.stmt = db.con.createStatement();
			ResultSet rs = db.stmt.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt("cid");
		        name = rs.getString("cname");
		        city = rs.getString("city");
		        orderid = rs.getInt("orderid");
		        // print the results
		        System.out.format("%s, %s, %s, %s\n", id, name, city, orderid);		        
		     }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}

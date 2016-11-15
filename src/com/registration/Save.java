package com.registration;
import com.registration.DbConnection;
import java.sql.SQLException;

public class Save {

	public  void save(int cid, String name, String city, int orderid) throws Exception {

		try {
			DbConnection db = new DbConnection();	
			String sql = "insert into customer (cid, cname, city, orderid) values ('"+cid+"', '"+name+"', "
																			+ "'"+city+"', '"+orderid+"')";
			db.runPreparedStmt(sql);				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

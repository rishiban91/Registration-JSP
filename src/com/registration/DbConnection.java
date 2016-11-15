package com.registration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author			:
 * @created date	:
 * @modified by		:
 * @modified date	:
 */
public class DbConnection extends java.lang.Object {
	Statement stmt = null;
	protected int records;
	PreparedStatement pstmt = null;
	Connection con = null;
	CallableStatement callstmt = null;
	private Statement stmtForCustomRS = null;
	/**
	 * 
	 * @throws Exception
	 */
	public DbConnection() throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo", "postgres", "root");
			stmt = con.createStatement();
			System.out.println("Connection established successfully in DbConnection class. Connection object -->" + con);
			try {
				System.out.println("\nConnected to War Db -->" + this.con.getCatalog() + "<-- CATALOG in '"
						+ this.con.getMetaData().getDatabaseProductName().toUpperCase() + "' DATABASE\n");
			} catch (SQLException sqlErr) {
			}
		} catch (Exception e) {
			System.out.println("Exception in loading drivers in DbConnection class" + e);
			throw e;
		}
	}
	/**
	 * 
	 * @param records
	 */
	public void setRecords(int records) {
		this.records = records;
	}
	/**
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return this.con;
	}
	/**
	 * 
	 * @param c
	 */
	public void setConnection(Connection c) {
		this.con = c;
	}
	/**
	 * 
	 */
	public void closeConnection() {
		try {
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
			System.out.println(" closing the connecion (in DbConnection class).........");
		} catch (Exception e) {
			System.out.println("Exception while calling closeConection function in DbConnection class.. " + e);
		}
	}
	/**
	 * 
	 * @return
	 */
	public int getRecords() {
		return this.records;
	}
	/**
	 * 
	 * @param strSql
	 * @return
	 * @throws Exception
	 */
	public ResultSet executeSelectQuery(String strSql) throws Exception {
		ResultSet myRs = null;
		try {
			myRs = stmt.executeQuery(strSql);
		} catch (Exception e) {
			System.out.println("Failed Query = " + strSql);
			System.out.println("Exception in executeSelectQuery Function in DbConnection class" + e);
			throw e;
		}
		return myRs;
	}
	/**
	 * 
	 * @param strSql
	 * @return
	 * @throws Exception
	 */
	public PreparedStatement executePreparedStmt(String strSql) throws Exception {
		try {
			pstmt = con.prepareStatement(strSql);
		} catch (SQLException se) {
			System.out.println("Failed Query = " + strSql);
			System.out.println("SQL Exception in Prepared Statement Query in DbConnection class" + se);
			throw se;
		} catch (Exception e) {
			System.out.println("General Exception Prepared Statement Query in  DbConnection class" + e);
			throw e;
		}
		return pstmt;
	}
	/**
	 * 
	 * @param strSql
	 * @throws Exception
	 */
	public void runPreparedStmt(String strSql) throws Exception {
		int count = 0;
		try {
			pstmt = con.prepareStatement(strSql);
			count = pstmt.executeUpdate();
			pstmt.close();

			if (count == 0) {
				System.out.println("NOTICE: ZERO ROWS AFFECTED BY THIS QUERY\n " + strSql);
			}
		} catch (SQLException se) {
			System.out.println("Failed Query = " + strSql);
			System.out.println("SQL Exception in Prepared Statement Query in DbConnection class" + se);
			throw se;
		} catch (Exception e) {
			System.out.println("Failed Query = " + strSql);
			System.out.println("General Exception in Prepared Statement Query in DbConnection class" + e);
			throw e;
		}
	}
	/**
	 * 
	 * @param strQuery
	 * @return
	 * @throws Exception
	 */
	public CallableStatement prepCall(String strQuery) throws Exception {
		try {
			callstmt = con.prepareCall(strQuery);
		} catch (SQLException se) {
			System.out.println("Failed Query = " + strQuery);
			System.out.println("SQL Exception in Prepared Statement Query in DbConnection class" + se);
			throw se;
		}

		catch (Exception e) {
			System.out.println("General Exception in Prepared Statement Query in DbConnection class" + e);
			throw e;
		}
		return callstmt;
	}
	/**
	 * 
	 * @param strQuery
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @return
	 * @throws NullPointerException
	 * @throws SQLException
	 * @throws Exception
	 */
	public ResultSet getCustomRS(String strQuery, int resultSetType, int resultSetConcurrency)
			throws NullPointerException, SQLException, Exception {
		ResultSet customRS = null;
		try {
			stmtForCustomRS = con.createStatement(resultSetType, resultSetConcurrency);
			customRS = stmtForCustomRS.executeQuery(strQuery);
		} catch (NullPointerException nullPtrExcep) {
			System.out.println(
					"Error handling a null value while generating the Custom Resultset -- in getCustomRS() method in DbConnection.java . \nObject stmtForCustomRS --> "
							+ stmtForCustomRS + " \nObject customRS --> " + customRS + " \nSystem Message:"
							+ nullPtrExcep);
			throw nullPtrExcep;
		} catch (SQLException sqlExcep) {
			System.out.println(
					"Error accessing the DataBase while generating the Custom Resultset -- in getCustomRS() method in DbConnection.java . \nSystem Message:"
							+ sqlExcep);
			throw sqlExcep;
		} catch (Exception excep) {
			System.out.println(
					"General Error while generating the Custom Resultset -- in getCustomRS() method in DbConnection.java . \nSystem Message:"
							+ excep);
			throw excep;
		}

		return customRS;
	}
	/**
	 * 
	 * @param strQuery
	 * @return
	 * @throws NullPointerException
	 * @throws SQLException
	 * @throws Exception
	 */
	public ResultSet getScrollableRS(String strQuery) throws NullPointerException, SQLException, Exception {
		return getCustomRS(strQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	}
	/**
	 * 
	 * @param strQuery
	 * @return
	 * @throws NullPointerException
	 * @throws SQLException
	 * @throws Exception
	 */
	public ResultSet getUpdatableRS(String strQuery) throws NullPointerException, SQLException, Exception {
		return getCustomRS(strQuery, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	}
	/**
	 * 
	 * @param strQuery
	 * @return
	 * @throws NullPointerException
	 * @throws SQLException
	 * @throws Exception
	 */
	public ResultSet getUpdtScrlRS(String strQuery) throws NullPointerException, SQLException, Exception {
		return getCustomRS(strQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	}
	/**
	 * 
	 * @param ar
	 */
	public static void main(String ar[]) {
		try {
			DbConnection obj = new DbConnection();
		} catch (Exception es) {
		}
	}
}
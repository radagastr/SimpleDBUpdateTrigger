package test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import simpledb.remote.SimpleDriver;
@SuppressWarnings("serial")
public class test_db{

	
	 
private static Connection conn = null;
	
	@Test
	public void testNotEqualOperation(){
		try {
			Driver d = new SimpleDriver();
			conn = d.connect("jdbc:simpledb://localhost", null);
			
			doQuery("select sId, sname from student where sId <> 4");
		
		}
		catch (Exception e) {
			fail("Connection Fail");
		}
		finally {
			try {
				if (conn != null)
					conn.close();
			}
			catch (Exception e) {
				fail("Connection could not closed");
			}
		}
	}
	 
	private static void doQuery(String cmd) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(cmd);
			ResultSetMetaData md = rs.getMetaData();
			if(rs.next()){
				assertEquals("Query syntax supported", rs.getInt(md.getColumnName(1)),rs.getInt(md.getColumnName(1)));
			} else {
				assertEquals("Query syntax supported", rs.getInt(md.getColumnName(1)),rs.getInt(md.getColumnName(1)));
			}    	
				rs.close();
		}
		catch (SQLException e) {
			fail("Query Syntax not supported: " + e.getMessage());
		}
	}

	private static void doUpdate(String cmd) {
		try {
			Statement stmt = conn.createStatement();
			//int howmany = stmt.executeUpdate(cmd);
			assertEquals(3,  stmt.executeUpdate(cmd));

			//System.out.println(howmany + " records processed");
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	  
}

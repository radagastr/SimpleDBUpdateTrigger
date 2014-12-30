package test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import simpledb.remote.SimpleDriver;
import studentClient.simpledb.SQLInterpreter;
@SuppressWarnings({ "unused" })
public class test_db{

	
	 
private static Connection conn = null;
	
	@Test
	public void testNotEqualOperation(){
		try {
			Driver d = new SimpleDriver();
			conn = d.connect("jdbc:simpledb://localhost", null);
			
			Statement stmt = conn.createStatement();
			String s = "create table TEST5(testýd int, testname varchar(10) )";
			 stmt.executeUpdate(s);
			System.out.println("Table TEST5 created.");

			s = "insert into TEST5(testýd, testname) values ";
			String[] testvals = {"(100, 'test1')",
								 "(200, 'test2')",
								 "(300, 'test3')",
								 "(400, 'test4')"};
			
			System.out.println("aaa");
			 for (int i=0; i<testvals.length; i++)
			 	stmt.executeUpdate(s + testvals[i]);
			System.out.println("TEST records inserted.");
			
			doUpdate("update TEST5 set testýd=1000 where testýd=100");
			
			doQuery("select testýd from TEST5");
			doUpdate2("DELETE FROM TEST5");
			 
					
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
			int numcols = md.getColumnCount();
			int totalwidth = 0;

			// print header
			for (int i = 1; i <= numcols; i++) {
				int width = md.getColumnDisplaySize(i);
				totalwidth += width;
				String fmt = "%" + width + "s";
				System.out.format(fmt, md.getColumnName(i));
			}
			System.out.println();
			for (int i = 0; i < totalwidth; i++)
				System.out.print("-");
			System.out.println();

			// print records
			while (rs.next()) {
				for (int i = 1; i <= numcols; i++) {
					String fldname = md.getColumnName(i);
					int fldtype = md.getColumnType(i);
					String fmt = "%" + md.getColumnDisplaySize(i);
					if (fldtype == Types.INTEGER)
						System.out.format(fmt + "d", rs.getInt(fldname));
					else
						System.out.format(fmt + "s", rs.getString(fldname));
				}
				System.out.println();
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}


	private static void doUpdate(String cmd) {
		try {
			Statement stmt = conn.createStatement();
			//int howmany = stmt.executeUpdate(cmd);
			assertEquals(1,  stmt.executeUpdate(cmd));

			//System.out.println(howmany + " records processed");
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	private static void doUpdate2(String cmd) {
		try {
			Statement stmt = conn.createStatement();
			 int howmany = stmt.executeUpdate(cmd);
			 

			//System.out.println(howmany + " records processed");
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	  
}

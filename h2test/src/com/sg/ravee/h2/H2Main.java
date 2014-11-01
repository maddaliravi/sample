package com.sg.ravee.h2;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.jdbcx.JdbcConnectionPool;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;

public class H2Main {

	public static void main(String... args)
	{
		JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:mem:test;MODE=Oracle", "sa", "sa");
		
		//String url = "jdbc:h2:mem;" + "INIT=RUNSCRIPT FROM '~/initialLoad.sql'\\;";
		
		//JdbcConnectionPool cp1 = JdbcConnectionPool.create(url, "sa", "sa");
		
		
		
		DbSetup dbSetup;
		
		try {
			
			dbSetup = new DbSetup(new DataSourceDestination(cp), DatabaseSetup.getInstance().InitialLoad());
			dbSetup.launch();
			
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		String sql = "select 1.0 as read_only from dual";
		Connection conn;
		try {
			conn = cp.getConnection();
			Statement s = conn.createStatement();
			
			s.execute(sql);
			//System.out.println(s.getResultSet());
			ResultSet rs = s.getResultSet();
			 rs.next();
			boolean abc= ((BigDecimal) rs.getObject("READ_ONLY")).intValue() == 1;
			System.out.println(abc);
			
	        conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
        cp.dispose();
	}
}
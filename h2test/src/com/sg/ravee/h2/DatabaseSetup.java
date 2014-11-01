package com.sg.ravee.h2;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;

public class DatabaseSetup {
	
	public Operation InitialLoad() throws URISyntaxException, IOException
	{
		File f = new File(this.getClass().getResource("initialLoad.sql").toURI());
		List<String> lines = FileUtils.readLines(f);
		Operation  inserts = Operations.sql(lines);
		
		
		return inserts;
	}

	public static DatabaseSetup s = null;
	static
	{
		s = new DatabaseSetup();
	}
	private DatabaseSetup()
	{
		
	}

	public static DatabaseSetup getInstance()
	{
		
		if(s == null)
			s = new DatabaseSetup();
		
		return s;
	}
}

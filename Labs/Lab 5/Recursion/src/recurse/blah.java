package lab5proj;

import java.io.*;
import java.util.*;


public class Lister 
{
	private File			file;
	private boolean			showHidden;
	
	
	public Lister(File file, boolean showHidden)
	{
		this.file = file;
		this.showHidden = showHidden;
	}
	
	
	public void list()
	{
		listRecurse(file, "");
	}
	
	
	private void listRecurse(File f, String indent)
	{
		if (f.isFile())
		{
			// Print a file name.
			System.out.println(indent + f.getName());
		}
		else
		{
			// Print a dir name, increase the indent, and recurse.
			System.out.println(indent + f.getName() + ":");
			indent += "  ";
			for (String kid: f.list())
			{
				if (showHidden  ||  !kid.startsWith("."))  // if I want to print this file
				{
					File kidf = new File(f, kid);
					listRecurse(kidf, indent);
				}
			}
		}
	}
	
	
	public void setShowHidden(boolean showHidden)
	{
		this.showHidden = showHidden;
	}
	
	
	public static void main(String[] args)
	{
		File f = new File("/Users/philipheller/Desktop");
		assert f.exists();
		Lister lister = new Lister(f, true);
		lister.list();
	}
	
}

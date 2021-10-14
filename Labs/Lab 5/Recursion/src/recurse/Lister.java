package recurse;

import java.io.File;
import java.io.IOException;

//CAN ONLY BE WRITTEN RECURSIVELY

public class Lister {

	private File file;
	private boolean showHidden;
	
	public Lister(File file, boolean showHidden)
	{
		this.file = file;
		this.showHidden = showHidden;
	}
	
	public void list()
	{
		this.listRecurse(file, "");
	}

	//NON-HIDDEN AND HIDDEN FILES
	/*private void listRecurse(File file, String indent)
	{
		if(file.isDirectory())											//checks if it is a directory
		{
			System.out.println(indent + file.getName() + ":");			//prints DIRECTORY NAME:
			File[] files = file.listFiles();							//gets contents of directory
			indent += "   ";
			for(int i = 0; i < files.length; i++)						//prints names of objects in directory
			{
				if(files[i].isFile())
					System.out.println(indent + files[i].getName());	//if file, simple prints name of file
				else
					listRecurse(files[i], indent);						//if directory, recurses
			}
		}
	}*/
	
	//PROFESSOR'S ANSWER
	static void sop(Object x)
	{
		System.out.println(x);
	}
	
	private void listRecurse(File file, String indent)
	{
		if(file.isFile())
		{
			sop(indent + file.getName() + ":");			//"sop" same as "System.out.println()"
		}
		else
		{
			sop(indent + file.getName() + ":");
			String[] members = file.list();
			indent += "   ";
			for(String member: members)
			{
				File memberFile = new File(file, member);
				listRecurse(memberFile,indent);
			}
		}
	}
	
	//HIDDEN FILES ONLY
	/*private void listRecurse(File file, String indent)
	{
		if(file.isDirectory())											//checks if it is a directory
		{
			System.out.println(indent + file.getName() + ":");			//prints DIRECTORY NAME:
			File[] files = file.listFiles();							//gets contents of directory
			indent += "   ";
			for(int i = 0; i < files.length; i++)						//prints names of objects in directory
			{
				if(files[i].isFile() && files[i].isHidden())
					System.out.println(indent + files[i].getName());	//if HIDDEN file, simple prints name of file
				else
					listRecurse(files[i], indent);						//if directory, recurses
			}
		}
	}*/
	
	public static void main(String[] args) 
	{
		File testFile = new File("C:\\Users\\shaya\\Desktop\\CS_46B\\Lab\\lab2workspace");
		Lister test = new Lister(testFile, testFile.isHidden());
		test.list();
	}
}

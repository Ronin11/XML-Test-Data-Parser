package manager;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

public class Aggregator {
	String homeDirectory = "";
	ArrayList<Data> data = new ArrayList<Data>();
	
	public Aggregator(){
		
	}
	
	public static ArrayList<File> getAllData(){
		Collection<File> files = FileUtils.listFiles(
				  new File("."), 
				  new RegexFileFilter("full_test.xml"), 
				  DirectoryFileFilter.DIRECTORY
				);
		return new ArrayList<File>(files);
	}
	
}

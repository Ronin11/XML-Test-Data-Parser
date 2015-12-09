package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import manager.Aggregator;
import manager.Data;
import io.JSON;
import io.XML;

public class Main {
	public static void main(String args[]){
		ArrayList<File> files = Aggregator.getAllData();
		
		ArrayList<Data> data = new ArrayList<Data>();
		for(File f : files)
			data.add(XML.read(f));
		Collections.sort(data, new Data.DataComparator());
		JSON.toFile(JSON.output(data));
	}
}

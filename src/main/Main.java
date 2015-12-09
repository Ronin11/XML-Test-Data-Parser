package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		JSON.toFile(JSON.output(data));
		
		System.out.println("done");
	}
}

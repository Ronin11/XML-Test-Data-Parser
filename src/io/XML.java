package io;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import manager.Data;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XML {
	
	public static Data read(File file){
    	Data data = new Data();
	    try {
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	Document doc = dBuilder.parse(file);
	    			
	    	//optional, but recommended
	    	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	    	doc.getDocumentElement().normalize();
	    	
	    	Element root = doc.getDocumentElement();
			data.setTotal(Integer.parseInt(root.getAttribute("tests")));
			data.setFailures(Integer.parseInt(root.getAttribute("failures")));
			data.setDisabled(Integer.parseInt(root.getAttribute("disabled")));
			data.setErrors(Integer.parseInt(root.getAttribute("errors")));
	    	String time = root.getAttribute("timestamp");
	    	time = time.replace('T', ' ');
	    	Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
	    	data.setTimestamp(date.getTime());

	    	/*
	    	//This can be used to iterate through each suite, ATM were not doing that
	    	NodeList nList = doc.getElementsByTagName("testsuite");
	    			
	    	//System.out.println("----------------------------");

	    	for (int temp = 0; temp < nList.getLength(); temp++) {

	    		Node nNode = nList.item(temp);
	    				
	    		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
	    				
	    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	    			
	    			Element eElement = (Element) nNode;
	    			System.out.println(eElement.getAttributeNode("name"));
	    			
	    			data.appendTotal(Integer.parseInt(eElement.getAttribute("tests")));
	    			data.appendFailures(Integer.parseInt(eElement.getAttribute("failures")));
	    			data.appendDisabled(Integer.parseInt(eElement.getAttribute("disabled")));
	    			data.appendErrors(Integer.parseInt(eElement.getAttribute("errors")));
	    		}
	    	}
	    	*/
	        } catch (Exception e) {
	    	e.printStackTrace();
	        }
	    return data;
	}
}

package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import manager.Data;

public class JSON {
	
	public static void toFile(String s){
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File("Results.json"));
			writer.write(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			writer.close();
		}
	}

	public static String output(ArrayList<Data> data){
		JSONObject root = new JSONObject();
		
		JSONObject total = new JSONObject();
		JSONObject successes = new JSONObject();
		JSONObject failures = new JSONObject();
		JSONObject disabled = new JSONObject();
		JSONObject errors = new JSONObject();
		root.put("total", total);
		root.put("successes", successes);
		root.put("failures", failures);
		root.put("disabled", disabled);
		root.put("errors", errors);
		
		total.put("name", "Total Tests");
		successes.put("name", "Successes");
		failures.put("name", "Failures");
		disabled.put("name", "Disables");
		errors.put("name", "Errors");
		
		JSONArray totalData = new JSONArray();
		JSONArray successesData = new JSONArray();
		JSONArray failuresData = new JSONArray();
		JSONArray disabledData = new JSONArray();
		JSONArray errorsData = new JSONArray();
		
		for(int i = 0; i < data.size(); i++){
			JSONArray tempTotal = new JSONArray();
			tempTotal.add(data.get(i).getTimestamp());
			tempTotal.add(data.get(i).getTotal());
			totalData.add(tempTotal);
			
			JSONArray tempSuccess = new JSONArray();
			tempSuccess.add(data.get(i).getTimestamp());
			tempSuccess.add(data.get(i).getTotal()-data.get(i).getFailures());
			successesData.add(tempSuccess);
			
			JSONArray tempFailures = new JSONArray();
			tempFailures.add(data.get(i).getTimestamp());
			tempFailures.add(data.get(i).getFailures());
			failuresData.add(tempFailures);
			
			JSONArray tempDisabled = new JSONArray();
			tempDisabled.add(data.get(i).getTimestamp());
			tempDisabled.add(data.get(i).getDisabled());
			disabledData.add(tempDisabled);
			
			JSONArray tempErrors = new JSONArray();
			tempErrors.add(data.get(i).getTimestamp());
			tempErrors.add(data.get(i).getErrors());
			errorsData.add(tempErrors);
			
		}
		total.put("data", totalData);
		successes.put("data", successesData);
		failures.put("data", failuresData);
		disabled.put("data", disabledData);
		errors.put("data", errorsData);
		
		return root.toJSONString();
	}
}

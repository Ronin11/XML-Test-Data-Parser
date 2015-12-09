package manager;

public class Data {
	int total = 0;
	int failures = 0;
	int disabled = 0;
	int errors = 0;
	long timestamp;
	
	public Data(){}
	
	public void setTotal(int i){total = i;}
	public void setFailures(int i){failures = i;}
	public void setDisabled(int i){disabled = i;}
	public void setErrors(int i){errors = i;}
	public void setTimestamp(long t){timestamp = t;}
	
	public void appendTotal(int i){total += i;}
	public void appendFailures(int i){failures += i;}
	public void appendDisabled(int i){disabled += i;}
	public void appendErrors(int i){errors += i;}
	
	public int getTotal(){return total;}
	public int getFailures(){return failures;}
	public int getDisabled(){return disabled;}
	public int getErrors(){return errors;}
	public long getTimestamp(){return timestamp;}
	
}

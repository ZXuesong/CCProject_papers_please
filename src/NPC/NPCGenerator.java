package NPC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class NPCGenerator {
	
	
	public List<String> firstNameList=new  ArrayList<String>();
	public List<String> lastNameList=new  ArrayList<String>();
	public static List<String> countryList=new  ArrayList<String>();
	public static Map<String, List<String>> countryMap=new HashMap<String, List<String>>();
	
	
	public NPCGenerator(){
		String rootPath = System.getProperty("user.dir").replace("\\", "/");
		String path_1 = rootPath+ "/src/NPC/firstNames.json";
		String json = readJsonFile(path_1);
		JSONObject jobj = JSON.parseObject(json);
		String fNStr = jobj.getString("firstNames");
		fNStr=fNStr.replaceAll("[\"\\[\\]]", "");
		for(String n:fNStr.split(",")){
			this.firstNameList.add(n);
		}
		
		String path_2 = rootPath+ "/src/NPC/lastNames.json";
		String json_2 = readJsonFile(path_2);
		JSONObject jobj_2 = JSON.parseObject(json_2);
		String lNStr = jobj_2.getString("lastNames");
		lNStr=lNStr.replaceAll("[\"\\[\\]]", "");
		for(String n:lNStr.split(",")){
			this.lastNameList.add(n);
		}
		
		String path_3 = rootPath+ "/src/NPC/city_.json";
		String json_3 = readJsonFile(path_3);
		JSONObject jobj_3 = JSON.parseObject(json_3);
		JSONArray countries = jobj_3.getJSONArray("country");
		for (int i = 0 ; i < countries.size();i++){
			JSONObject co = (JSONObject)countries.get(i);
			List<String> ci = new  ArrayList<String>();
			ci.add(co.getString("city_1"));
			ci.add(co.getString("city_2"));
			ci.add(co.getString("city_3"));
			String n = co.getString("name");
			this.countryList.add(n);
			this.countryMap.put(n,ci);
		}
		
	}
	
	public NPCBase generator(int wrongRate, int countryEvent) {
		Random rand = new Random();
		boolean fore = false;
		int wrong = -1;
		String firstName = firstNameList.get(rand.nextInt(firstNameList.size()));
		String lastName = lastNameList.get(rand.nextInt(lastNameList.size()));
		String name = firstName+" "+lastName;
		
		String coun = countryList.get(rand.nextInt(countryList.size()));
		String city = countryMap.get(coun).get(rand.nextInt(3));
		switch(countryEvent) {
		case -1:
			break;
		case 0:
			if(rand.nextInt(100)<20) {
				coun = "Antegria";
				city = countryMap.get(coun).get(rand.nextInt(3));
			}
			break;
		case 1:
			if(rand.nextInt(100)<20) {
				coun = "Impor";
				city = countryMap.get(coun).get(rand.nextInt(3));
			}
			break;
		case 2:
			if(rand.nextInt(100)<20) {
				coun = "Kolechia";
				city = countryMap.get(coun).get(rand.nextInt(3));
			}
			break;
		case 3:
			if(rand.nextInt(100)<20) {
				coun = "Republia";
				city = countryMap.get(coun).get(rand.nextInt(3));
			}
			break;
		case 4:
			if(rand.nextInt(100)<20) {
				coun = "United Federation";
				city = countryMap.get(coun).get(rand.nextInt(3));
			}
			break;
		}
		
		
		if(coun.contentEquals("Arstotzka")) {
			fore=false;
		}else {
			fore=true;
			if(rand.nextInt(100)<wrongRate) {
				wrong = rand.nextInt(4);
				//w=-1 no error
				//w=0 no visa
				//w=1 expied date
				//w=2 id error
				//w=3 city error
			}
		}
		
		NPCBase n = new NPCBase(name,coun,city,fore,wrong);
		
		return n;
	}
	
	public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public static void main(String[] args) {
		
	}

	
}

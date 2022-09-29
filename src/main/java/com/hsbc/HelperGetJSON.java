package com.hsbc;

import java.io.BufferedReader;
import java.io.FileReader;

public class HelperGetJSON {
	public String getJson() {
		try {
			
			FileReader fr = new FileReader("C:\\Users\\DELL1\\Desktop\\HSBC assignments\\day12-assignment-jjbhatewara\\src\\main\\webapp\\costs.json");
			BufferedReader br = new BufferedReader(fr);
//			StringBuffer jsonText = new StringBuffer("");
			String jsonText = "";
			String str = br.readLine();
            while(str != null){
            	jsonText+=str;
                str = br.readLine();
            } 
            System.out.println(jsonText);
			return jsonText;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return null;
	}
}

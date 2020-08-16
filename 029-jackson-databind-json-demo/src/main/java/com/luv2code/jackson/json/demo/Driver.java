package com.luv2code.jackson.json.demo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Student stu = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println(stu);
			System.out.println(stu.getAddress());
			for (String str : stu.getLanguages()) {
				System.out.println(str);
			}
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}

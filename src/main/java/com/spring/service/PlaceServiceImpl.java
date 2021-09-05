package com.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.spring.pojo.PlacePojo;

@Service
public class PlaceServiceImpl implements PlaceService{
	
	

	@SuppressWarnings("unchecked")
	@Override
	public 	Map<Integer,PlacePojo>  getData() {

 Map<Integer,PlacePojo> pojoList=null;
 Map<Integer,PlacePojo> diceData=null;
 
   PlacePojo p1=new PlacePojo();
   pojoList = new HashMap<Integer,PlacePojo>();
   
   Integer dice1=  (int) (Math.random()*6);
	Integer dice2=  (int) (Math.random()*6);
	Integer d= dice1+dice2;
   
   p1.setPlace("Old Kent Road");
   p1.setPrice(60);
   p1.setRent(30);
   
   PlacePojo p2=new PlacePojo();
   p2.setPlace("Whitechapel Road");
   p2.setPrice(60);
   p2.setRent(30);
  
   PlacePojo p3=new PlacePojo();
   p3.setPlace("King's Cross station");
   p3.setPrice(200);
   p3.setRent(100);
   
   PlacePojo p4=new PlacePojo();
   p4.setPlace("The Angel Islington");
   p4.setPrice(100);
   p4.setRent(50);
   
   PlacePojo p5=new PlacePojo();
   p5.setPlace("Euston Road");
   p5.setPrice(100);
   p5.setRent(50);

   PlacePojo p6=new PlacePojo();
   p6.setPlace("Pentonville Road");
   p6.setPrice(120);
   p6.setRent(60);

   PlacePojo p7=new PlacePojo();
   p7.setPlace("Pall Mall");
   p7.setPrice(140);
   p7.setRent(70);
   
   PlacePojo p8=new PlacePojo();
   p8.setPlace("Whitehall");
   p8.setPrice(140);
   p8.setRent(70);
   
   PlacePojo p9=new PlacePojo();
   p9.setPlace("Noorthhuberland Avenue");
   p9.setPrice(160);
   p9.setRent(80);
   
   PlacePojo p10=new PlacePojo();
   p10.setPlace("Marylebone Station");
   p10.setPrice(200);
   p10.setRent(100);
   
		
   pojoList.put(1,p1);
   pojoList.put(2,p2);
   pojoList.put(3,p3);
   pojoList.put(4,p4);
   pojoList.put(5,p5);
   pojoList.put(6,p6);
   pojoList.put(7,p7);
   pojoList.put(8,p8);
   pojoList.put(9,p9);
   pojoList.put(10,p10);
		
		return pojoList;
	}

	
}

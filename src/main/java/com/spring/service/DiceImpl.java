package com.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pojo.PlacePojo;

@Service
public class DiceImpl implements DiceFunctions{

	@Autowired
	PlaceService placeService;
	
	@Override
	public Integer rollDice() {
		
		Integer dice1=  (int) (Math.random()*6);
		Integer dice2=  (int) (Math.random()*6);
		
		Integer returnValue =dice1+dice2;
		
		if(returnValue < 1) {
			returnValue = returnValue+1;
			
		}
		
		
		return returnValue;
	}

	@Override
	public PlacePojo moneyDeducted(Integer index, String player) {
		
		List<Integer> player1 = new ArrayList<Integer>();
		List<Integer> player2 = new ArrayList<Integer>();
		
		Map<Integer,PlacePojo> pojoList=null;
		
		if(player == "1") {
			Integer lastIndexofP1=index;
		}
		if(player == "1") {
			Integer lastIndexofP1=index;
		}
		
		Integer lastIndexofP1=index;
		Integer lastIndexofP2=index;
		
		 
		
		   PlacePojo p1=new PlacePojo();
		   pojoList = new HashMap<Integer,PlacePojo>();
		   
		   p1.setIndex(1);
		   p1.setPlace("Old Kent Road");
		   p1.setPrice(60);
		   p1.setRent(30);
		   
		   PlacePojo p5=new PlacePojo();
		   p5.setIndex(5);
		   p5.setPlace("Whitechapel Road");
		   p5.setPrice(60);
		   p5.setRent(30);
		  
		   PlacePojo p4=new PlacePojo();
		   p4.setIndex(4);
		   p4.setPlace("King's Cross station");
		   p4.setPrice(200);
		   p4.setRent(100);
		   
		   PlacePojo p3=new PlacePojo();
		   p3.setIndex(3);
		   p3.setPlace("The Angel Islington");
		   p3.setPrice(100);
		   p3.setRent(50);
		   
		   PlacePojo p6=new PlacePojo();
		   p6.setIndex(6);
		   p6.setPlace("Euston Road");
		   p6.setPrice(100);
		   p6.setRent(50);

		   PlacePojo p2=new PlacePojo();
		   p2.setIndex(2);
		   p2.setPlace("Pentonville Road");
		   p2.setPrice(120);
		   p2.setRent(60);

		   PlacePojo p7=new PlacePojo();
		   p7.setIndex(7);
		   p7.setPlace("Pall Mall");
		   p7.setPrice(140);
		   p7.setRent(70);
		   
		   PlacePojo p8=new PlacePojo();
		   p8.setIndex(8);
		   p8.setPlace("Whitehall");
		   p8.setPrice(140);
		   p8.setRent(70);
		   
		   PlacePojo p9=new PlacePojo();
		   p9.setIndex(9);
		   p9.setPlace("Noorthhuberland Avenue");
		   p9.setPrice(160);
		   p9.setRent(80);
		   
		   PlacePojo p10=new PlacePojo();
		   p10.setIndex(10);
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
		   
		   
		   
		   
		   PlacePojo tab=null;
		   for ( Map.Entry<Integer, PlacePojo> entry : pojoList.entrySet()) {
			    Integer key = entry.getKey();
			     tab = entry.getValue();
			    if(key == index) {
			    	
			    	return tab;
			    
			    }
			   
			}

			if(index > 10) {
				
				index = index-10;
			}
			
			for(int i=1;i<pojoList.size();i++) {
				
				if ( pojoList.containsKey(i)) {
					
				}
			}
		
		return  tab;
	}

	@Override
	public Map<String, String> startGame() {

  Map<String,String> initialMoney = new HashMap<String,String>();
  initialMoney.put("palyer1", "1000");
  initialMoney.put("palyer2", "1000");
		
		return initialMoney;
	}

	@Override
	public Map<String, String> reStartGame() {
		
		 Map<String,String> initialMoney = new HashMap<String,String>();
		  initialMoney.put("palyer1", "1000");
		  initialMoney.put("palyer2", "1000");
		return initialMoney;
	}
	
	

}

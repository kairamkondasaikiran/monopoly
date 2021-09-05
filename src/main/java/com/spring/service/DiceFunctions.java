package com.spring.service;

import java.util.Map;

import com.spring.pojo.PlacePojo;

public interface DiceFunctions {

	Integer rollDice();
	Map<String,String> startGame();
	Map<String,String> reStartGame();
	
	PlacePojo moneyDeducted(Integer index,String place);
}

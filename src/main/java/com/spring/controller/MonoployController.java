package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pojo.PlacePojo;
import com.spring.service.DiceFunctions;
import com.spring.service.PlaceService;

@CrossOrigin(origins = "*")
@RestController
public class MonoployController {
	
   @Autowired
 private PlaceService ps;
   @Autowired
   private DiceFunctions ds;
	
 

	@GetMapping("/getData")
	public 	Map<Integer,PlacePojo>  getData() {
		
		return ps.getData();
		
	}

	@GetMapping("/startGame")
	public Map<String,String> startGame() {
		
		return ds.startGame();
		
	}
	
	@GetMapping("/reStartGame")
	public Map<String,String> reStartGame() {
		
		return ds.reStartGame();
		
	}
	@GetMapping("/moneyOpertaion/{index}/{player}")
	public PlacePojo moneyOpertaion(@PathVariable Integer index,@PathVariable String player) {
		
		return  ds.moneyDeducted(index, player);
	}
	
	@GetMapping("/rollDice")
	public Integer rollDice() {
		
		return ds.rollDice();
	}
}

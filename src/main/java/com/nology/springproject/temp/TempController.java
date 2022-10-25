package com.nology.springproject.temp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/temp")
public class TempController {
	@Autowired
private TempService tService;
	
	//API request
	@GetMapping
	public List<Temp> getAllTemps(){
		return tService.getAllTemps();
		
		
	}
	
	@PostMapping
	public Temp createTemp(@Valid @RequestBody TempDTO tempData ) {
		return tService.createTemp(tempData);
		
	}
}

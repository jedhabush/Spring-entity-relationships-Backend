package com.nology.springproject.temp;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@ResponseStatus(value = HttpStatus.CREATED)
	public Temp createTemp(@Valid @RequestBody TempDTO tempData ) {
		return tService.createTemp(tempData);
		
	}
	
	
	@GetMapping("/{id}")
	//takes in an ID and return the specefic temp of that ID
	public ResponseEntity<Optional<Temp>> getTemp(@PathVariable Long id){
		Optional<Temp> temp = tService.getTemp(id);
		
		//check 
		if(temp.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(temp, HttpStatus.OK);
		
	}
	
	//controller to call the update service
	
	@PatchMapping("/{id}")
	
	public ResponseEntity<Temp> tempPatch(@PathVariable Long id, @RequestBody TempDTO tempData){
		
		Temp temp = tService.tempUpdate(id, tempData);
		
		//check
		if(temp == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(temp, HttpStatus.OK);
	}
	
	//controller for the delete service
	@DeleteMapping("/{id}")
	public ResponseEntity<String> tempDelete(@PathVariable Long id) {
		
		String temp = tService.tempDelete(id);
		if(temp == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}
	
}

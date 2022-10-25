package com.nology.springproject.temp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TempService {
@Autowired
	private TempRepository tRepo;

// methods
//get method
public List<Temp> getAllTemps(){
	
	return tRepo.findAll();
}
	// post or create method
public Temp createTemp(TempDTO tempData) {
	
	Temp t = new Temp(tempData.getFirstName(), tempData.getLastName());
	
	return tRepo.save(t);
}
}

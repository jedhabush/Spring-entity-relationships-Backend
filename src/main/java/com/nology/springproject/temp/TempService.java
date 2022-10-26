package com.nology.springproject.temp;

import java.util.List;
import java.util.Optional;

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

//Gets specific temp if you use an ID
public Optional<Temp> getTemp(Long id){
	
	return tRepo.findById(id);
	
}


//Update method
public Temp tempUpdate(Long id, TempDTO tempData) {
	
	Optional<Temp> temp = getTemp(id);
	if(temp.isEmpty()) return null;
	
	Temp existentTemp = tRepo.findById(id).get();
	//check if data is null or equal to empty string
	if(tempData.getFirstName() != null && !tempData.getFirstName().equals("")) {
		existentTemp.setFirstName(tempData.getFirstName());
		
	}
	
	if(tempData.getLastName() != null && !tempData.getLastName().equals("")) {
		existentTemp.setLastName(tempData.getLastName());
		
	}
	
	return tRepo.save(existentTemp);
	
}

//Delete method
public String tempDelete(Long id ) {
	Optional<Temp> fetchTemp = getTemp(id);
	if(fetchTemp.isEmpty()) return null;
	tRepo.deleteById(id);
	
	return  "";
}
}

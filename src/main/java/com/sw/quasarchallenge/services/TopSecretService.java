package com.sw.quasarchallenge.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.quasarchallenge.models.Position;
import com.sw.quasarchallenge.models.Satellite;
import com.sw.quasarchallenge.models.Spaceship;

@Service
public class TopSecretService {
	
	@Autowired
	LocationService locationService;
	@Autowired
	MessageService messageService;
	
	public Spaceship resolveDistressCall(List<Satellite> satellites) throws Exception {
		Position position = null;
		String message = null;

		double[] distances= satellites.stream().mapToDouble(s -> s.getDistance()).toArray();
		List<List<String>> messages = satellites.stream().map(s -> s.getMessage()).collect(Collectors.toList());	
			
		position = locationService.getLocation(distances);
		message = messageService.getMessage(messages);	
		if(message==null||position==null) throw new Exception("No se pudo determinar posición/mensaje");
		
		return new Spaceship(position, message);
	}
}

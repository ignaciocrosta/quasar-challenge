package com.sw.quasarchallenge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sw.quasarchallenge.models.Satellite;
import com.sw.quasarchallenge.models.Spaceship;
import com.sw.quasarchallenge.models.TopSecretRequest;
import com.sw.quasarchallenge.services.TopSecretService;

@RestController

public class TopSecretResource {
	
	@Autowired
	TopSecretService topSecretService;
	
	@RequestMapping(method=RequestMethod.POST,value="/topsecret")
	public Spaceship getTopSecret (@RequestBody TopSecretRequest topSecretRequest) {
		Spaceship spaceship = null;
		List<Satellite> satellites = topSecretRequest.getSatellites();
		try {
			spaceship = topSecretService.resolveDistressCall(satellites);			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return spaceship;
	}
}

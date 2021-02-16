package com.sw.quasarchallenge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sw.quasarchallenge.models.Satellite;
import com.sw.quasarchallenge.models.Spaceship;
import com.sw.quasarchallenge.models.TopSecretSplitRequest;
import com.sw.quasarchallenge.services.SatelliteService;
import com.sw.quasarchallenge.services.TopSecretService;

@RestController

public class TopSecretSplitResource {
	
	@Autowired
	SatelliteService satelliteService;
	@Autowired
	TopSecretService topSecretService;
	
	@RequestMapping("/topsecret_split")	
	public Spaceship getTopSecretSplit(){
		Spaceship spaceship = null;
		
		List<Satellite> satellites = satelliteService.getSatellites();
		
		try {
			spaceship = topSecretService.resolveDistressCall(satellites);			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return spaceship;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topsecret_split/{satelliteName}")
	public Satellite postTopSecretSplit(@PathVariable("satelliteName") String satelliteName, @RequestBody TopSecretSplitRequest topSecretSplitRequest){
		Satellite satellite = satelliteService.getSatellite(satelliteName);
		if (satellite == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Satelite inexistente."); 
		}
		satellite.setDistance(topSecretSplitRequest.getDistance());
		satellite.setMessage(topSecretSplitRequest.getMessage());	
		
		return satelliteService.getSatellite(satelliteName);
	}		
}

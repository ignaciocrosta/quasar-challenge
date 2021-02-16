package com.sw.quasarchallenge.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.quasarchallenge.configurations.ApplicationYml;
import com.sw.quasarchallenge.models.Satellite;

@Service
public class SatelliteService {
	@Autowired
	private ApplicationYml applicationYml;
	
	private List<Satellite> satellites = null; 
	
	@PostConstruct
	private void postConstruct(){
		this.satellites = applicationYml.getSatellites();
	}	
		
	public double [][] getSatellitesPositionAsArray(){
		return satellites.stream().map(s->s.getPositionAsArray()).toArray(size -> new double[size][1]);
	}
	
	public Satellite getSatellite(String name) {
		return satellites.stream().filter(s->s.getName().toLowerCase().equals(name.toLowerCase())).findFirst().orElse(null);		
	}
	
	public void updateSatellite(String name, double distance, List<String> message) {
		Satellite satellite = this.getSatellite(name);
		satellite.setDistance(distance);
		satellite.setMessage(message);		
	}

	public List<Satellite> getSatellites() {
		return this.satellites;
	}
}

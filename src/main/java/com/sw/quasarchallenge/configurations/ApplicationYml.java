package com.sw.quasarchallenge.configurations;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.sw.quasarchallenge.models.Satellite;

@Configuration
@ConfigurationProperties("application")
public class ApplicationYml {
	private List<Satellite> satellites;

	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}
}

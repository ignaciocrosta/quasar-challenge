package com.sw.quasarchallenge.models;

import java.util.List;

public class TopSecretRequest {
	private List<Satellite> satellites;

	public TopSecretRequest() {
		super();
	}

	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}
}

package com.sw.quasarchallenge.models;

import java.util.List;

public class TopSecretSplitRequest {
	private double distance;
	private List<String> message;

	public TopSecretSplitRequest() {
		super();
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}
}

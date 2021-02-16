package com.sw.quasarchallenge.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Satellite {
	private Position position;
	private String name;
	private double distance;
	private List<String> message;
	
	public Satellite() {
		super();
	}

	public Satellite(Position position, String name, double distance, List<String> message) {
		super();
		this.position = position;
		this.name = name;
		this.distance = distance;
		this.message = message;
	}

	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	@JsonIgnore
	public double[] getPositionAsArray() {
		this.position.getX();
		this.position.getY();
		return new double[]{position.getX(), position.getY()};
	}
}

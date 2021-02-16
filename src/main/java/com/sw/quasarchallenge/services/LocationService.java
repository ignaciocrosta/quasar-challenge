package com.sw.quasarchallenge.services;

import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.sw.quasarchallenge.models.Position;

@Service
public class LocationService {
	
	@Autowired
	private SatelliteService satelliteService;
	
	public Position getLocation(double [] distances) {
		double[][] positions = satelliteService.getSatellitesPositionAsArray();
		
        TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positions, distances);
        NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());

        double[] result =  nSolver.solve().getPoint().toArray();	
        return new Position(result[0],result[1]);
	}
}

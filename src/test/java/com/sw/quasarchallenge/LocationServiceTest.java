package com.sw.quasarchallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sw.quasarchallenge.models.Position;
import com.sw.quasarchallenge.services.LocationService;

@SpringBootTest
public class LocationServiceTest {
	
	@Autowired
    private LocationService locationService;

    @Test
    public void calculateCoordinateFromDistances() throws Exception {      
        double[] distances = new double[]{100.0, 115.5, 142.7};
        double[] expectedCoordinate = new double[]{-58.315252587138595, -69.55141837312165};
        Position coordinate =  locationService.getLocation(distances);
        
        assertEquals(coordinate.getX(),expectedCoordinate[0]);
        assertEquals(coordinate.getY(),expectedCoordinate[1]);

    }

}
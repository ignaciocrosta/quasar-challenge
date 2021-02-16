package com.sw.quasarchallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sw.quasarchallenge.services.MessageService;

@SpringBootTest
public class MessageServiceTest {
	
	@Autowired
    private MessageService messageService;

    @Test
    public void resolveMessage() throws Exception {      
		List<List<String>> messages = new ArrayList<>(Arrays.asList(
				Arrays.asList("", "este", "es", "un", "mensaje"),
				Arrays.asList("este", "", "un", "mensaje"),
				Arrays.asList("", "", "es", "", "mensaje")
				));
		String result = messageService.getMessage(messages);
        String expectedResult = "este es un mensaje";
        assertEquals(result, expectedResult);
        

    }

}
package com.sw.quasarchallenge.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	public String getMessage(List<List<String>> messages) throws Exception {
		List<String> message = null;
		String word = null;
		
		int sizeMin = messages.stream().min(Comparator.comparingInt(List::size)).orElse(new ArrayList<>()).size();
		
		String [] messageResult = new String[sizeMin];
		
		for(int i = 0; i < messages.size(); i++){
			message = messages.get(i);
			
			for (int j = 0; j < sizeMin; j++) {
				if (messageResult[j] == null) {
					word = message.get(message.size()-(sizeMin-j));
					if (word != "")	messageResult[j] = word;
				}
			}	
        }
		if (!Arrays.stream(messageResult).filter(m -> m == null).collect(Collectors.toList()).isEmpty()) {
			throw new Exception("No se pudo determinar el mensaje. El mensaje incompleto es: "+ String.join(" ", messageResult)); 
		}
		return String.join(" ", messageResult);
	}
}

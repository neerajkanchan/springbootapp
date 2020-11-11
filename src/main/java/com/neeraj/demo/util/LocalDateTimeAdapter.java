package com.neeraj.demo.util;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime> , JsonDeserializer<LocalDateTime>{

	//private static final Logger LOGGER = LoggerFactory.getLogger(LocalDateTimeAdapter.class);

    @Override
    public JsonElement serialize(LocalDateTime date, Type typeOfSrc, JsonSerializationContext context) {
    	try {
    		
    		return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // "yyyy-mm-dd"
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		return null;
    	}
    }

    @Override
    public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext arg2)
                 throws JsonParseException {
    		
		try {
			return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString());
			
		}catch(DateTimeParseException ex ) {
			try {
				return LocalDate.parse(json.getAsJsonPrimitive().getAsString()).atStartOfDay();
			} catch (Exception e) {
				return null;
			}

		}
    }
}


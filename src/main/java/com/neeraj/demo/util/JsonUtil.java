package com.neeraj.demo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class JsonUtil {
	public static Gson GSON = new GsonBuilder().serializeNulls()
	        .addSerializationExclusionStrategy(new ExclusionStrategy() {
	            @Override
	            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
	                final Expose expose = fieldAttributes.getAnnotation(Expose.class);
	                return expose != null && !expose.serialize();
	            }

	            @Override
	            public boolean shouldSkipClass(Class<?> aClass) {
	                return false;
	            }
	        })
	        .addDeserializationExclusionStrategy(new ExclusionStrategy() {
	            @Override
	            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
	                final Expose expose = fieldAttributes.getAnnotation(Expose.class);
	                return expose != null && !expose.deserialize();
	            }

	            @Override
	            public boolean shouldSkipClass(Class<?> aClass) {
	                return false;
	            }
	        })
	        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
	        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
	        .create();
}

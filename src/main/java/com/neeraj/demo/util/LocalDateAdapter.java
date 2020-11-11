package com.neeraj.demo.util;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalDateAdapter implements JsonSerializer<LocalDate> , JsonDeserializer<LocalDate>{

    @Override
 public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
     return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
 }

    @Override
    public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext arg2)
                 throws JsonParseException {
           return LocalDate.parse(json.getAsJsonPrimitive().getAsString());

    }
}


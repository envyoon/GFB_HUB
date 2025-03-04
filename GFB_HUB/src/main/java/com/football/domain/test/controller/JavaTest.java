package com.football.domain.test.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JavaTest {
	
	public static void main(String[] args) {
		// JsonArray 생성
        JsonArray jsonArray = new JsonArray();

        // JsonObject 생성 후 JsonArray에 추가
        JsonObject john = new JsonObject();
        john.addProperty("name", "John");
        jsonArray.add(john);

        JsonObject jane = new JsonObject();
        jane.addProperty("name", "Jane");
        jsonArray.add(jane);

        JsonObject alice = new JsonObject();
        alice.addProperty("name", "Alice");
        jsonArray.add(alice);
        
        System.out.println(jsonArray.toString());
        
        // JsonArray를 List<JsonElement>로 변환한 후, stream 사용
        List<String> names = jsonArray.asList().stream()
            .map(jsonElement -> jsonElement.getAsJsonObject().get("name").getAsString())
            .collect(Collectors.toList());

        // 결과 출력
        names.forEach(System.out::println);
        
	}
}

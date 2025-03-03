package com.football.domain.test.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.slf4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.football.common.config.LoggingConfig;
import com.football.common.utils.LoggerUtil;

public class ApiTest {
	
	private static final Logger Log = LoggerUtil.getLogger(LoggingConfig.class);
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		HttpClient client = HttpClient.newHttpClient();
//		HttpRequest request = HttpRequest.newBuilder()
//		                                 .uri(URI.create("http://api.football-data.org/v4/teams/66"))  // API 요청 주소
//		                                 .header("X-Auth-Token", "7969d627b6294cabb25116cb3e67df2b")   // 개인 토큰
//		                                 .build();
		
		// 다가오는 경기 요청 API
		HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.football-data.org/v4/matches"))  // API 요청 주소
                .header("X-Auth-Token", "7969d627b6294cabb25116cb3e67df2b")   // 개인 토큰
                .build();
		
		HttpResponse<String> response = null;
		
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		
		//System.out.println(response.statusCode()); // 상태값 (404, 200, 402 ... )
		//System.out.println(response.body());       // API 요청 값
		
		// 응답 본문을 JsonObject로 변환
        JsonObject responseData = gson.fromJson(response.body(), JsonObject.class);

        // "matches" 배열을 가져옵니다.
        JsonArray matches = responseData.getAsJsonArray("matches");

        // "Spain", "Italy", "England" 지역 필터링 후 출력
        for (int i = 0; i < matches.size(); i++) {
            JsonObject match = matches.get(i).getAsJsonObject();
            JsonObject area = match.getAsJsonObject("area");
            
            Log.info("Match data: "+gson.toJson(match));
            
            // 지역 이름을 가져옵니다.
            String areaName = area.get("name").getAsString();

            // 지역 이름이 "Spain", "Italy", "England"인 경우 출력
            if ("Spain".equals(areaName) || "Italy".equals(areaName) || "England".equals(areaName)) {
                JsonObject homeTeam = match.getAsJsonObject("homeTeam");
                JsonObject awayTeam = match.getAsJsonObject("awayTeam");
                
                // 경기 정보 출력
                Log.info(homeTeam.get("name").getAsString() + " vs " + awayTeam.get("name").getAsString() + " (" + areaName + ")");
            }
        }
        
        
	}
}

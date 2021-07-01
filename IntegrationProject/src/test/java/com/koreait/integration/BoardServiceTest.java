package com.koreait.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.integration.service.BoardService;

public class BoardServiceTest {

	@Autowired
	BoardService boardService;
	
	@Test
	public void test() {
		
		// 제목에 공지가 포함된 게시글을 검색 
		// 다음 주소를 이용해서 테스트를 수행하시오.
		try {
			String query = URLEncoder.encode("공지","UTF-8");
			String apiURL = "http://localhost:9090/integration/selectQuery.do?column=TITLE&query=" + query;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while( (line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println(sb.toString());
			JSONObject obj = new JSONObject(sb.toString());
			JSONArray arr = obj.getJSONArray("list");
			for (int i = 0; i < arr.length(); i++) {
				JSONObject board = (JSONObject)arr.get(i);
				System.out.println("-----------------");
				System.out.println(board.get("no"));
				System.out.println(board.get("writer"));
				System.out.println(board.get("title"));
				System.out.println(board.get("content"));
				System.out.println(board.get("postdate"));
			}
			br.close();
			con.disconnect();
			assertNotNull(obj.get("message"));
			System.out.println("1) message:" + obj.get("message"));
			assertNotNull(obj.get("status"));
			System.out.println("2) status:" + obj.get("status"));
			assertEquals(200, obj.get("status"));
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

}

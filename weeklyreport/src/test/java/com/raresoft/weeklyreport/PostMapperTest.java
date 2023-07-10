package com.raresoft.weeklyreport;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.raresoft.weeklyreport.post.PostMapper;
import com.raresoft.weeklyreport.post.PostResponse;
import com.raresoft.weeklyreport.post.ProjectVo;

@SpringBootTest
public class PostMapperTest {

	@Autowired
	PostMapper postMapper;
	
	@Test
	void save() {
		ProjectVo params = new ProjectVo();
		params.setProName("프로젝트명");
		params.setProThisWeek("금주 업무");
		params.setProNextWeek("차주 내용");
		params.setProProgress((short) 50);
		params.setCateCode((short) 1);
		postMapper.save(params);
		
		List<PostResponse> posts = postMapper.findAll();
		System.out.println("전체 개수는 " + posts.size() + "개 입니다.");
	}
	
	@Test
	void findByListId() {
		PostResponse post = postMapper.findByListId(0);
		try {
			String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
			System.out.println(postJson);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		// ==> listId로 찾았을 때 결과가 하나만 나와야 하는데 지금 listId 0인 행이 4개 있어서 오류 발생
	}

	/*
	@Test
	void save() {
		PostRequest params = new PostRequest();
		params.setListTitle("제목");
		params.setUserId("작성자");
		postMapper.save(params);
		
		List<PostResponse> posts = postMapper.findAll();
		System.out.println("전체 글 수는 : " + posts.size() + "개입니다.");
	}
	
	@Test
	void findById() {
		PostResponse post = postMapper.findById(0);
		try {
			String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
			System.out.println(postJson);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	void update() {
		// 1. 수정
		PostRequest params = new PostRequest();
		params.setListId(0);
		params.setListTitle("제목 수정");
		params.setUserId("작성자 수정");
		postMapper.update(params);
		
		// 2. 상세정보 조회
		PostResponse post = postMapper.findById(0);
		try {
			String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
			System.out.println(postJson);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	*/
}
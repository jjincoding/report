package com.raresoft.weeklyreport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raresoft.weeklyreport.post.PostService;
import com.raresoft.weeklyreport.post.ProjectVo;

@SpringBootTest
public class PostServiceTest {

	@Autowired
	PostService postService;
	
	/*
	@Test
	void save() {
		PostRequest params = new PostRequest();
		params.setListId(1);
		params.setListTitle("테스트 제목");
		params.setUserId("테스트 아이디");
		params.setUserName("테스트 작성자");
		int listId = postService.savePost(params); //
		System.out.println("생성된 글 ID : " + listId);
	}
	*/
	
	@Test
	void save() {
		ProjectVo params = new ProjectVo();
		params.setProName("프로젝트명");
		params.setProThisWeek("이번주");
		params.setProNextWeek("다음주");
		params.setProProgress((short)10);
		params.setCateCode((short)1);
		int id = postService.savePost(params);
		System.out.println("생성된 글 ID : " + id);
	}
}

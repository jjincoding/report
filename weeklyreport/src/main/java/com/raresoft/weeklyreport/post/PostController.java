package com.raresoft.weeklyreport.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //
public class PostController {
	
	public final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/post/write.do")
	public String openPostWrite(Model model) {
		return "post/write";
	}
	
	/*
	@GetMapping("/post/write.do")
	public String openPostWrite(@RequestParam(value="listId", required=false) final int listId, Model model) {
		if (listId >= 0) {
			PostResponse post = postService.findPostById(listId);
			model.addAttribute("post", post);
		}
		return "post/write";
	}
	*/
	
	/*
	// 글 작성
	@PostMapping("/post/save.do")
	public String savePost(final PostRequest params) {
		postService.savePost(params);
		return "redirect:/post/list.do";
	}
	*/
	
	/*
	// 글 저장
	@PostMapping("/post/save.do")
	public String savePost(final PostRequest params) {
		postService.savePost(params);
		return "redirect:/post/list.do";
	}
	*/
	
	/*
	 * 글 저장
	 * @PostMapping("/post/save.do")
	 */
	public String savePost(final ProjectVo params) {
		postService.savePost(params);
		return "redirect:/post/list.do";
	}
	
	// 리스트 페이지
	@GetMapping("/post/list.do")
	public String openPostList(Model model) {
		List<PostResponse> posts = postService.findAllPost();
		model.addAttribute("posts", posts);
		return "post/list";
	}
}

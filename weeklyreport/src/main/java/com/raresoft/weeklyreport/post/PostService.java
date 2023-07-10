package com.raresoft.weeklyreport.post;

import javax.transaction.Transactional;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
// PostMapper 인터페이스의 @Mapper
// 해당 클래스가 비즈니스 로직을 담당하는 Service Layer의 클래스
public class PostService {
	
	private final PostMapper postMapper;
	
	public PostService(PostMapper postMapper) {
		this.postMapper = postMapper;
	}

    /**
     * 글 저장
     * @param params - 게시글 정보
     * @return PK
    @Transactional
    // 메서드 정상 종료 여부에 따라 Commit 또는 Rollback
    public int savePost(final PostRequest params) {
        postMapper.save(params);
        return params.getListId();
        // INSERT 완료되면 생성된 글 id 리턴
    }
    */
    
    /*
     * 글 저장 - 07.10
     * @param params - 프로젝트 정보
     * @return PK
     */
    @Transactional
    // 메서드 정상 종료 여부에 따라 Commit 또는 Rollback
    public int savePost(final ProjectVo params) {
    	postMapper.save(params);
    	return params.getListId();
    }

    /*
     * 상세 조회
     * @param listId - PK
     * @return 상세 정보
     */
    public PostResponse findPostById(final int listId) {
    	return postMapper.findByListId(listId);
    	// 특정 글 상세 정보 조회
    }
    
    /*
     * 수정
     * @param params - 글 정보
     * @return PK
     */
    @Transactional
    public int updatePost(final PostRequest params) {
    	postMapper.update(params);
    	return params.getListId();
    	// UPDATE 완료되면 글 id 리턴
    }
    
    /*
     * 리스트 조회
     * @return 글 리스트
     */
    public List<PostResponse> findAllPost(){
    	return postMapper.findAll();
    }
}
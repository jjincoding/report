package com.raresoft.weeklyreport.post;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

	/*
	 * 프로젝트 저장
	 * @param params - 프로젝트 정보
	void save(PostRequest params);
	*/
	
	/*
	 * 프로젝트 저장 - 07.10
	 * @param params - 프로젝트 정보
	 */
	 void save(ProjectVo params);
	
	 /*
	 * project 테이블의 list_id가
	 * report_list 테이블의 list_id를 참조하고 있는 것
	 * 근데 프로젝트 관련 정보 컬럼은 project 테이블에만 있고
	 * report_list 테이블에 프로젝트 관련 컬럼은
	 * list_id 뿐인데
	 * 그럼 프로젝트 관련 정보를 저장하려면
	 * report_list 테이블에 넣는건지
	 * project 테이블에 넣는건지
	 * 그리고 테이블에 auto_increment 속성 id 줘야하는지 ?
	*/
	
	/*
	 * 상세정보 조회
	 * @return 상세정보
	 * 특정 게시글을 조회하는 SELECT 쿼리 호출
	 * 파라미터로 listtId(PK)를 전달받아 SQL 쿼리의 WHERE 조건으로 사용하며,
	 * 쿼리가 실행되면 메서드의 리턴 타입인 응답 클래스 객체의 각 멤버 변수에 결괏값이 매핑됨
	 */
	PostResponse findByListId(int listId);
	
	/*
	 * 상세정보 조회 - 07.10
	 * @return 상세정보
	 * 특정 게시글을 조회하는 SELECT 쿼리 호출
	 * 파라미터로 listId(PK)를 전달 받아 SQL 쿼리의 WHERE 조건으로 사용하며,
	 * 쿼리가 실행되면 메서드의 리턴 타입인 응답 클래스 객체의 각 멤버 변수에 결괏값이 매핑됨
	 * ReportListVo findById(int listId);  
	 */
	ReportListVo findById(int listId);
	
	/*
	 * 프로젝트 수정
	 * @param params - 프로젝트 정보
	 * 게시글 정보를 수정하는 UPDATE 쿼리 호출
	 * 요청 (PostRequest) 클래스의 객체를 파라미터로 전달받으며,
	 * params에는 수정할 게시글 정보가 담기게 됨
	 */
	void update(PostRequest params);
	
	/*
	 * 프로젝트 수정 - 07.10
	 * @param parmas - 프로젝트 정보
	 * 게시글 정보를 수정하는 UPDATE 쿼리 호출
	 *  params에는 수정할 게시글 정보가 담기게 됨
	 *  void update(ReportListVo params);
	 */
	
	/*
	 * 리스트 조회
	 * @return 글 리스트
	 * 게시글 목록을 조회하는 SELECT 쿼리 호출
	 * 여러 개의 게시글(PostResponse)을 리스트에 담아 리턴해주는 역할
	 */
	List<PostResponse> findAll();
	
	/*
	 * 글 수 카운팅
	 * @return 글 수
	 */
	int count();
}

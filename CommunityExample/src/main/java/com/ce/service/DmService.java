package com.ce.service;

import java.util.List;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dto.DmDTO;
import com.ce.dto.MemberDTO;

public interface DmService {
	 public List<DmDTO> list(String mId,DmDTO dmDto, PageHelper pageHelper); //send컬럼에 해당 id와 page를 이용한 검색한 결과 가져오기
	 public DmDTO content(String stringDmIdx); //idx의 컬럼값들 가져와서 뿌리기, receivedate값 확인후 값이 없을시 receivedate수정, idx에 int가 아닌 값 들어올시 생기는 문제 수정할것
	 public int write(DmDTO dmDto); //입력된 값으로 row등록
	 public List<DmDTO> search(DmDTO dmDto, SearchHelper searchHelper, PageHelper pageHelper); //query와 target과 page를 이용해 검색한 결과 뿌리기
	 public int delete(int dmIdx); //해당 idx의 row 지우기

}

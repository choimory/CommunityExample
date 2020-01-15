package com.ce.dao;

import java.util.List;

import com.ce.dto.DmDTO;

public interface DmDAO {
	public List<DmDTO> list(DmDTO dmDto);	// dmReceiverId를 대상으로 page를 이용해 최신순 20개 select
	public DmDTO content(int dmIdx); // 해당 idx의 row select
	public int firstRead(int dmIdx); // receiveDate값을 now()로 변경
	public int write(DmDTO dmDto); // insert
	public List<DmDTO> search(DmDTO dmDto); // query와 target을 이용해 select
	public int delete(int dmIdx); // delete
	
	public int getTotalRow(String receiverId);//select count(*) 혹은 row전용테이블 select
	
}

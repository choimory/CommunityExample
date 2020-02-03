package com.ce.dao;

import java.util.List;

import com.ce.dto.DmDTO;
import com.ce.dto.DmFileDTO;

public interface DmDAO {
	public List<DmDTO> list(DmDTO dmDto);	
	public DmDTO content(int dmIdx); 
	public int firstRead(int dmIdx); 
	public int write(DmDTO dmDto); 
	public int delete(int dmIdx); 
	public int getTotalRow(String receiverId);
	public int getLatestIndex(DmDTO dmDto);
	public int insertDmFile(DmFileDTO dmFileDto);
	public List<DmFileDTO> contentFile(int dmIdx);
}

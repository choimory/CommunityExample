package com.ce.service;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dto.DmDTO;
import com.ce.dto.MemberDTO;

public interface DmService {
	 public Map<String,Object> list(MemberDTO memberDto, PageHelper pageHelper, SearchHelper searchHelper);
	 public Map<String,Object> content(String stringDmIdx, PageHelper pageHelper,SearchHelper searchHelper); 
	 public int write(DmDTO dmDto, List<MultipartFile> files);
	 public int delete(int dmIdx); 
	 public FileInputStream download(String fStoredName);
}

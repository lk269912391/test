package com.cy.pj.sys.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMenuDao {

	List<Map<String, Object>> findObjects();
	
	int getChildCount(Integer id);
	
	int deleteObject(Integer id);
}

package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.service.serviceException;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.service.SysMenusService;

@Service
public class SysMenusServiceImpl implements SysMenusService {

	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	public List<Map<String, Object>> findObjects() {

		List<Map<String, Object>> list = sysMenuDao.findObjects();
		if (list == null || list.size() == 0)
			throw new serviceException("没有对应的菜单信息");
		return list;
	}

	@Override
	public int deleteObject(Integer id) {
		if (id == null || id <= 0)
			throw new IllegalArgumentException("清先选择");
		int count = sysMenuDao.getChildCount(id);
		if (count > 0)
			throw new serviceException("请先删除子菜单");
		sysRoleMenuDao.deleteObjectsByMenuId(id);
        int rows = sysMenuDao.deleteObject(id);
        if(rows==0)
        	throw new serviceException("此菜单可能已经不存在");
		return rows;
	}

}

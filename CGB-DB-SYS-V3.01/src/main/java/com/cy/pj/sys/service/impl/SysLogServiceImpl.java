package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.service.serviceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
@Service
public class SysLogServiceImpl implements SysLogService {
    
	@Autowired
	private SysLogDao sysLogDao;
	
	
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysLogDao.getRowCount(username);
		if(rowCount==0)
			throw new serviceException("没有对应记录");
		int pageSize=10;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
	    PageObject<SysLog> pageObject=new PageObject<>();
		  pageObject.setPageCurrent(pageCurrent);
		  pageObject.setPageSize(pageSize);
		  pageObject.setRecords(records);
		  pageObject.setRowCount(rowCount);
	      pageObject.setPageCount((rowCount-1)/pageSize+1);
	 
		    return  pageObject;
	}


	@Override
	public int deleteObjects(Integer... ids) {
		if(ids==null||ids.length==0)
			throw new IllegalArgumentException("请选择一个");
		int rows;
		rows=sysLogDao.deleteObjects(ids);
		if(rows==0)
			throw new serviceException("记录可能已经不存在");
		return rows;
	}

}

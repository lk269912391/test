package com.cy.pj.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.SysMenusService;

@RestController
public class SysMenuController {
    @Autowired
	private SysMenusService sysMenusService;
	@RequestMapping("/menu/doFindObjects")
    public JsonResult doFindObjects() {
    	List<Map<String, Object>> findObjects = sysMenusService.findObjects();
    	return new JsonResult(findObjects);
    	
    }
	@RequestMapping("/menu/doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		sysMenusService.deleteObject(id);
		return new JsonResult("删除成功");
	}
	
	
	
	
}

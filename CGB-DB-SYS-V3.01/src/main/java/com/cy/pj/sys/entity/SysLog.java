package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SysLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8799081241453681134L;
	private Integer id;
	private String operation;
	private String method;
	private String params;
	private Long time;
	private String ip;
	private Date createdTime;
	
}

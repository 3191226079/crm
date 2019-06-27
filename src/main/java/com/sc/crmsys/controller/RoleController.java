package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.PermissionInformationBean;
import com.sc.crmsys.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Resource
	private RoleService roleServiceImpl;
	
	@RequestMapping("/addrole")
	public String addrole(Map<String, Object> map)
	{
		List<PermissionInformationBean> permissionList = roleServiceImpl.selectAllPermission();
		map.put("permissionList", permissionList);
		return "jsp/addrole";
	}
}

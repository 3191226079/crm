package com.sc.crmsys.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.PermissionInformationBean;
import com.sc.crmsys.bean.PermissionRoleBean;
import com.sc.crmsys.bean.PermissionSubfieldBean;
import com.sc.crmsys.bean.RoleBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Resource
	private RoleService roleServiceImpl;
	
	@RequiresPermissions("zhangheng:addrole")
	@RequestMapping("/addrole")
	public String addrole(Map<String, Object> map)
	{
		List<PermissionInformationBean> permissionList = roleServiceImpl.selectAllPermission();
		map.put("permissionList", permissionList);
		return "jsp/addrole";
	}
	
	@RequiresPermissions("zhangheng:addrole")
	@RequestMapping("/insertRole")
	public String insertRole(RoleBean roleBean, String result[])
	{
		String roleNumber = UUID.randomUUID().toString();
		roleBean.setRoleNumber(roleNumber);
		roleBean.setRoleLastTime(new Date());
		roleServiceImpl.insertRole(roleBean, result);
		return "redirect:showRole";
	}
	
	@RequiresPermissions("zhangheng:rolelist")
	@RequestMapping("/showRole")
	public String showRole(@RequestParam(defaultValue="1")Integer pn, @RequestParam(defaultValue="5")Integer size, Map<String, Object> map)
	{
		PageInfo<RoleBean> pageInfo = roleServiceImpl.selectAllRole(pn, size);
		map.put("pageInfo", pageInfo);
		return "jsp/showrole";
	}
	
	@RequiresPermissions("zhangheng:updaterole")
	@RequestMapping("/jumpToUpdateRole")
	public String jumpToUpdateRole(Map<String, Object> map, String roleNumber)
	{
		List<PermissionInformationBean> permissionList = roleServiceImpl.selectAllPermission();
		
		RoleBean roleBean = roleServiceImpl.selectRoleById(roleNumber);
		map.put("roleBean", roleBean);
		List<PermissionRoleBean> permissionRoleList = roleServiceImpl.selectPMSRoleByRoleId(roleNumber);
		
		for (Iterator iterator = permissionList.iterator(); iterator.hasNext();) {
			PermissionInformationBean permissionInformationBean = (PermissionInformationBean) iterator.next();
			
			for (Iterator iterator2 = permissionRoleList.iterator(); iterator2.hasNext();) {
				PermissionRoleBean permissionRoleBean = (PermissionRoleBean) iterator2.next();
				if(permissionInformationBean.getPermissionNumber().equals(permissionRoleBean.getPermissionNumber()))
				{
					permissionInformationBean.setCheck("checked");
				}
			}
			if(!permissionInformationBean.getPmsInfoBean().isEmpty())
			{
				for (Iterator iterator3 = permissionInformationBean.getPmsInfoBean().iterator(); iterator3.hasNext();) {
					PermissionInformationBean permissionInformationBean2 = (PermissionInformationBean) iterator3.next();
					
					for (Iterator iterator4 = permissionRoleList.iterator(); iterator4.hasNext();) {
						PermissionRoleBean permissionRoleBean = (PermissionRoleBean) iterator4.next();
						if(permissionInformationBean2.getPermissionNumber().equals(permissionRoleBean.getPermissionNumber()))
						{
							permissionInformationBean2.setCheck("checked");
						}
					}
					if(!permissionInformationBean2.getPmsInfoBean().isEmpty())
					{
						for (Iterator iterator5 = permissionInformationBean2.getPmsInfoBean().iterator(); iterator5.hasNext();) {
							PermissionInformationBean permissionInformationBean3 = (PermissionInformationBean) iterator5.next();
							
							for (Iterator iterator6 = permissionRoleList.iterator(); iterator6.hasNext();) {
								PermissionRoleBean permissionRoleBean = (PermissionRoleBean) iterator6.next();
								if(permissionInformationBean3.getPermissionNumber().equals(permissionRoleBean.getPermissionNumber()))
								{
									permissionInformationBean3.setCheck("checked");
								}
							}
						}
					}
				}
			}
		}
		
		map.put("permissionList", permissionList);
		return "jsp/updateRole";
	}
	
	@RequiresPermissions("zhangheng:updaterole")
	@RequestMapping("/updateRole")
	public String updateRole(RoleBean roleBean, String result[])
	{
		roleBean.setRoleLastTime(new Date());
		roleServiceImpl.updateRole(roleBean, result);
		return "redirect:showRole";
	}
	
	
	@RequestMapping("/getUserPMS")
	public String getUserPMS(Map<String, Object> map)
	{
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		List<PermissionSubfieldBean> subfieldList = roleServiceImpl.selectSubfieldByUserId(userBean.getUserId());
		map.put("subfieldList", subfieldList);
		return "forward:/inc/left.jsp";
	}
}

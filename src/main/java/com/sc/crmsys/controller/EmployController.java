package com.sc.crmsys.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.InfoBean;
import com.sc.crmsys.bean.InfoDetailBean;
import com.sc.crmsys.bean.JobBean;
import com.sc.crmsys.bean.RoleBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.bean.UserRoleBean;
import com.sc.crmsys.service.EmployService;
import com.sc.crmsys.service.InfoService;
import com.sc.crmsys.utils.MyUtils;

@Controller
@RequestMapping("/employ")
public class EmployController {

	@Resource
	private EmployService employServiceImpl;
	
	@Resource
	private InfoService infoService;
	
	@RequestMapping("/selectEmploy")
	public String selectInfo(Map<String, Object> map,InfoBean infoBean,EmployBean employBean)
	{
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		employBean.setEmployId(userBean.getEmployId());
		employServiceImpl.update(employBean.getEmployId());
		EmployBean selectInfo = employServiceImpl.selectInfo(infoBean,employBean.getEmployId());
		map.put("selectInfo", selectInfo);
		return "forward:/jsp/employLook.jsp";
	}
	
	@RequestMapping("/deleteInfo")
	public String delete(String infoDetailId,String infoId)
	{
		infoService.deleteByinfoDetailId(infoDetailId, infoId);
		return "redirect:selectEmploy";
	}
	
	@RequestMapping("/jumpToAddEmploy")
	public String jumpToAddEmploy(Map<String, Object> map)
	{
		List<JobBean> jobList = employServiceImpl.selectAllJobll();
		map.put("jobList", jobList);
		List<RoleBean> roleList = employServiceImpl.selectAllRole();
		map.put("roleList", roleList);
		return "jsp/addEmploy";
	}
	
	@RequestMapping("/addEmploy")
	public String addEmploy(EmployBean employBean, String roleNumber, UserBean userBean,@RequestParam(value="uploadImg")MultipartFile[] uploadImg, HttpServletRequest req)
	{
		String showPath = "";
		if(uploadImg != null)
		{
			MultipartFile mufile = uploadImg[0];
			String savePath = req.getServletContext().getRealPath("/upload/");
			File dir = new File(savePath);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			String fileName = System.currentTimeMillis() + mufile.getOriginalFilename();
			String filePath = savePath + fileName;
			try {
				mufile.transferTo(new File(filePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
			showPath = "upload/" + fileName;
		}
		
		String userId = UUID.randomUUID().toString();
		String employId = UUID.randomUUID().toString();
		
		employBean.setEmployId(employId);
		employBean.setEmployImg(showPath);
		employBean.setEmploySalary("4500");
		employBean.setCheckState("1");
		employBean.setEmployState("1");
		employBean.setEmployUpdateTime(new Date());
		
		userBean.setUserId(userId);
		String salt = MyUtils.getSalt();
		String md5 = MyUtils.md5("123456", salt, 1);
		userBean.setUserPassword(md5);
		userBean.setEmployId(employId);
		userBean.setUserState("1");
		userBean.setUserRegisterTime(new Date());
		userBean.setUserUpdateTime(new Date());
		userBean.setUserSalt(salt);
		
		UserRoleBean userRoleBean = new UserRoleBean();
		userRoleBean.setUserRoleId(UUID.randomUUID().toString());
		userRoleBean.setUserId(userId);
		userRoleBean.setRoleNumber(roleNumber);
		userRoleBean.setUserRoleUpdateTime(new Date());
		
		employServiceImpl.insertEmployAndUser(employBean, userBean, userRoleBean);
		
		return "redirect:showEmployll";
	}
	
	@RequestMapping("/showEmployll")
	public String showEmployll(@RequestParam(defaultValue="1")Integer pn, @RequestParam(defaultValue="5")Integer size, Map<String, Object> map)
	{
		PageInfo<EmployBean> pageInfo = employServiceImpl.selectAllEmployAndUser(pn, size);
		map.put("pageInfo", pageInfo);
		return "jsp/showEmploy";
	}
	
	@RequestMapping("/jumpToUpdateEmploy")
	public String jumpToUpdateEmploy(Map<String, Object> map, String employId)
	{
		List<JobBean> jobList = employServiceImpl.selectAllJobll();
		map.put("jobList", jobList);
		EmployBean employBean = employServiceImpl.selectEmployById(employId);
		map.put("employBean", employBean);
		List<RoleBean> roleList = employServiceImpl.selectAllRole();
		map.put("roleList", roleList);
		return "jsp/updateEmploy";
	}
	
	@RequestMapping("/updateEmploy")
	public String updateEmploy(EmployBean employBean, String userIdll, String roleNumber,@RequestParam(value="uploadImg")MultipartFile[] uploadImg, HttpServletRequest req)
	{
		String showPath = "";
		String temp = "";
		if(uploadImg != null)
		{
			MultipartFile mufile = uploadImg[0];
			String savePath = req.getServletContext().getRealPath("/upload/");
			File dir = new File(savePath);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			temp = System.currentTimeMillis() + "";
			String fileName = temp + mufile.getOriginalFilename();
			String filePath = savePath + fileName;
			try {
				mufile.transferTo(new File(filePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
			showPath = "upload/" + fileName;
		}
		
		if(!showPath.equals("upload/" + temp))
		{
			employBean.setEmployImg(showPath);
		}
		employBean.setEmployUpdateTime(new Date());
		
		UserBean userBean = new UserBean();
		userBean.setUserId(userIdll);
		employBean.setUserBean(userBean);
		
		employServiceImpl.updateByPrimaryKeySelective(employBean,roleNumber);
		
		return "redirect:showEmployll";
	}
	
	@RequestMapping("/deleteEmploy")
	public String deleteEmploy(String employId)
	{
		employServiceImpl.deleteEmployAndUser(employId);
		return "redirect:showEmployll";
	}

}

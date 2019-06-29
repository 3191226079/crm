package com.sc.crmsys.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.InfoBean;
import com.sc.crmsys.bean.InfoDetailBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.EmployService;
import com.sc.crmsys.service.InfoService;

@Controller
@RequestMapping("/info")
public class InfoController {

	@Resource
	private InfoService infoService;

	@Resource
	private EmployService employServiceImpl;
	
	@RequestMapping("/insertInfo")
	public String insertInfo(InfoBean infoBean,InfoDetailBean infoDetailBean)
	{
		String infoId = UUID.randomUUID().toString();
		infoBean.setInfoId(infoId);
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		infoBean.setInfoPerson(userBean.getEmployId());
		infoBean.setInfoUpdateTime(new Date());
		
		String infoDetailId = UUID.randomUUID().toString();
		infoDetailBean.setInfoId(infoId);
		infoDetailBean.setInfoDetailUpdateTime(new Date());
		infoDetailBean.setInfoDetailId(infoDetailId);
		infoDetailBean.setInfoDetailState("1");
		
		infoService.insert(infoDetailBean,infoBean);
		
		return "redirect:selectInfo";
	}

	
	@RequestMapping("/selectInfo")
	public String selectInfo(@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,String infoTitle,InfoDetailBean infoDetailBean,Map<String, Object> map)
	{
		if(infoDetailBean == null)
		{
			infoDetailBean = new InfoDetailBean();
		}
		PageInfo<InfoDetailBean> InfoDetailBean = infoService.selectAll(pn,size,infoDetailBean);
		map.put("title", infoTitle);
		map.put("InfoDetail", InfoDetailBean);
		return "forward:/jsp/lookInformation.jsp";
	}
	
	@RequestMapping("/jumptosend")
	public String jumptosend(Map<String, Object> map)
	{
		List<EmployBean> employList = employServiceImpl.selectAllEmploy();
		map.put("employList", employList);
		return "forward:/jsp/sendInformation.jsp";
	}
	
	@RequestMapping("/deleteInfo")
	public String deleteInfo(String infoDetailId,String infoId)
	{
		infoService.deleteByinfoDetailId(infoDetailId, infoId);
		return "redirect:selectInfo";
	}
}

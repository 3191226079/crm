package com.sc.crmsys.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.InfoBean;
import com.sc.crmsys.bean.InfoDetailBean;
import com.sc.crmsys.service.InfoService;

@Controller
@RequestMapping("/info")
public class InfoController {

	@Resource
	private InfoService infoService;

	@RequestMapping("/insertInfo")
	public String insertInfo(InfoBean infoBean,InfoDetailBean infoDetailBean,EmployBean employBean)
	{
		String infoId = UUID.randomUUID().toString();
		infoBean.setInfoId(infoId);
		infoBean.setInfoPerson("wre");
		infoBean.setInfoUpdateTime(new Date());
		infoService.insert(infoBean);
		
//		String employId = UUID.randomUUID().toString();
//		employBean.setEmployId(employId);
		
		
		String infoDetailId = UUID.randomUUID().toString();
		infoDetailBean.setInfoId(infoId);
		infoDetailBean.setInfoDetailUpdateTime(new Date());
		infoDetailBean.setInfoDetailId(infoDetailId);
		infoDetailBean.setInfoDetailState("1");
		infoService.insert(infoDetailBean);
		
		return "redirect:selectInfo";
	}

	
	@RequestMapping("/selectInfo")
	public String selectInfo(InfoDetailBean infoDetailBean,Map<String, Object> map)
	{
		if(infoDetailBean == null)
		{
			infoDetailBean = new InfoDetailBean();
		}
		List<InfoDetailBean> InfoDetailBean = infoService.selectAll(infoDetailBean);
		map.put("InfoDetail", InfoDetailBean);
		return "forward:/jsp/lookInformation.jsp";
	}
	
	@RequestMapping("/jumptosend")
	public String jumptosend(Map<String, Object> map)
	{
		//把员工表数据查询出来
		
		return "forward:/jsp/sendInformation.jsp";
	}
	
}

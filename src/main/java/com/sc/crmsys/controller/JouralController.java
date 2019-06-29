package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.JournalBean;
import com.sc.crmsys.service.JournalService;

@Controller
@RequestMapping("/journal")
public class JouralController {
	
	@Resource
	private JournalService journalService;
	
	@RequestMapping("/info")
	public String selectJournalInfo(Map map,@RequestParam(defaultValue="1")int pn,@RequestParam(defaultValue="5")int size) {
		PageInfo<JournalBean> pageJournal = journalService.selectJournal(pn, size);
		map.put("pageJournal", pageJournal);
		return "forward:/jsp/journal.jsp";
	}

}

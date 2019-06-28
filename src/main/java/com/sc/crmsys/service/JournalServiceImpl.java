package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.GetTimeBean;
import com.sc.crmsys.bean.JournalBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.mapper.JournalBeanMapper;
import com.sc.crmsys.mapper.PermissionInformationBeanMapper;
import com.sc.crmsys.utils.MyUtils;

@Service
public class JournalServiceImpl implements JournalService{
	
	@Resource
	private JournalBeanMapper journalMapper;
	
	@Resource
	private PermissionInformationBeanMapper permissionMapper;

	@Override
	public void addJoural(JournalBean journal) {
		
		String journald = UUID.randomUUID().toString();
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		String userId = userBean.getUserId();
		GetTimeBean time = MyUtils.getTime();
		Date date = time.getTime();
		journal.setJournalNumber(journald);
		journal.setUserId(userId);
		journal.setVisitTime(date);
		String permission = permissionMapper.selectPermission(journal.getVisitIp());
		
		System.out.println(permission);
		if (permission != null) {
			journal.setPermission(permission);//得到权限名
			journalMapper.insertSelective(journal);
		}
		
	}

	@Override
	public PageInfo<JournalBean> selectJournal(int pn,int size) {
		PageHelper.startPage(pn, size);
		List<JournalBean> journal = journalMapper.selectJournal();
		PageInfo<JournalBean> pageJournal = new PageInfo<>(journal);
		return pageJournal;
	}
	
	

}

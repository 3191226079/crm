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
import com.sc.crmsys.bean.CheckPointBean;
import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.TaskBean;
import com.sc.crmsys.bean.TaskDetailBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.CheckPointService;
import com.sc.crmsys.service.EmployService;
import com.sc.crmsys.service.TaskDetailService;
import com.sc.crmsys.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Resource
	private TaskService taskService;
	
	@Resource
	private EmployService employServiceImpl;
	
	@Resource
	private TaskDetailService taskDetailService;
	
	@Resource
	private CheckPointService checkPointService;
	
	@RequestMapping("/insertTask")
	public String insertTask(TaskBean taskBean,TaskDetailBean taskDetailBean)
	{
		String taskId = UUID.randomUUID().toString();
		taskBean.setTaskId(taskId);
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		taskBean.setTaskPerson(userBean.getEmployId());
		taskBean.setTaskUpdateTime(new Date());
		
		String taskDetailId = UUID.randomUUID().toString();
		taskDetailBean.setTaskId(taskId);
		taskDetailBean.setTaskDetailId(taskDetailId);
		taskDetailBean.setTaskDetailState("1");
		taskDetailBean.setTaskDetailUpdateTime(new Date());
		
		taskService.insert(taskBean, taskDetailBean);
		return "redirect:selectTask";
	}
	
	@RequestMapping("/selectTask")
	public String selectTask(@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,Map<String, Object> map,TaskBean taskBean)
	{
		PageInfo<TaskDetailBean> TaskDetailBean = taskService.selectAll(pn, size, taskBean);
		map.put("TaskDetailBean", TaskDetailBean);
		return "forward:/jsp/TaskLook.jsp";
	}
	
	@RequestMapping("/jumpToAdd")
	public String jumpToAdd(Map<String, Object> map)
	{
		List<EmployBean> EmployBean = employServiceImpl.selectAllEmploy();
		List<CheckPointBean> CheckPointBean = checkPointService.selectAllCheckPoint();
		map.put("EmployBean", EmployBean);
		map.put("CheckPointBean", CheckPointBean);
		return "forward:/jsp/taskAdd.jsp";
	}
	
	@RequestMapping("/delete")
	public String deleteTask(String taskId,String checkPointId,String taskDetailId)
	{
		taskService.deleteByPrimaryKey(taskId);
		taskDetailService.deleteByPrimaryKey(taskDetailId);
		return "redirect:selectTask";
	}
	
	@RequestMapping("/jumpToUpdate")
	public String jumpToUpdate(String taskId,String taskDetailId,String employId,String checkPointId,Map<String, Object> map)
	{
		TaskBean taskBean = taskService.selectByPrimaryKey(taskId);
		TaskDetailBean taskDetailBean = taskDetailService.selectByPrimaryKey(taskDetailId);
		EmployBean employBean = employServiceImpl.selectByPrimaryKey(employId);
		CheckPointBean checkPointBean = checkPointService.selectByPrimaryKey(checkPointId);
		taskBean.setCheckPointBean(checkPointBean);
		taskDetailBean.setEmployBean(employBean);
		taskDetailBean.setTaskBean(taskBean);
		
		List<CheckPointBean> CheckPointBean = checkPointService.selectAllCheckPoint();
		map.put("taskDetailBean", taskDetailBean);
		map.put("CheckPointBean", CheckPointBean);
		return "forward:/jsp/taskUpdate.jsp";
	}
	
	@RequestMapping("/updateTask")
	public String updateTask(TaskBean taskBean,TaskDetailBean taskDetailBean)
	{
		taskService.updateByPrimaryKeySelective(taskBean, taskDetailBean);
		return "redirect:selectTask";
	}
}

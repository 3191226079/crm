package com.sc.crmsys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.JobBean;

public interface JobBeanMapper {
    int deleteByPrimaryKey(String jobId);

    int insert(JobBean record);

    int insertSelective(JobBean record);

    JobBean selectByPrimaryKey(String jobId);

    int updateByPrimaryKeySelective(JobBean record);

    int updateByPrimaryKey(JobBean record);
    
    List<JobBean> selectAllJobll();
    
    String selectJobId(@Param("jobName")String jobName);
    
    List<JobBean> selectJobAndDept();
    
    void deleteJobs(String deptNumber);
    
}
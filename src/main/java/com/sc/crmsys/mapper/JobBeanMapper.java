package com.sc.crmsys.mapper;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.JobBean;

public interface JobBeanMapper {
    int deleteByPrimaryKey(String jobId);

    int insert(JobBean record);

    int insertSelective(JobBean record);

    JobBean selectByPrimaryKey(String jobId);

    int updateByPrimaryKeySelective(JobBean record);

    int updateByPrimaryKey(JobBean record);
    
    String selectJobId(@Param("jobName")String jobName);
    
}
package com.sc.crmsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.SignBean;


public interface SignBeanMapper {
    int deleteByPrimaryKey(String signId);

    int insert(SignBean record);

    int insertSelective(SignBean record);

    SignBean selectByPrimaryKey(String signId);

    int updateByPrimaryKeySelective(SignBean record);

    int updateByPrimaryKey(SignBean record);
    
    public List<SignBean> selectSignInfo(SignBean sign);
    
    Integer signNum(@Param( "userId")String userId,@Param( "signYear")String signYear,@Param( "signMonth")String signMonth);
   
    public SignBean getYerterDay(SignBean sign);
    
    public Integer getEmpty(SignBean sign);


}
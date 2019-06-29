package com.sc.crmsys.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.PermissionSubfieldBean;

public interface PermissionSubfieldBeanMapper {
    int deleteByPrimaryKey(String subfieldNumber);

    int insert(PermissionSubfieldBean record);

    int insertSelective(PermissionSubfieldBean record);

    PermissionSubfieldBean selectByPrimaryKey(String subfieldNumber);

    int updateByPrimaryKeySelective(PermissionSubfieldBean record);

    int updateByPrimaryKey(PermissionSubfieldBean record);
    
    List<PermissionSubfieldBean> selectSubfieldByUserId(@Param("uid")String userId);
    
}
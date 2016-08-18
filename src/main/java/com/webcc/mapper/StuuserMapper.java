package com.webcc.mapper;

import com.webcc.model.Stuuser;
import com.webcc.model.StuuserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StuuserMapper {
    int countByExample(StuuserExample example);

    int deleteByExample(StuuserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Stuuser record);

    int insertSelective(Stuuser record);

    List<Stuuser> selectByExample(StuuserExample example);

    Stuuser selectByPrimaryKey(Long id);

    Long selectIdByMap(Map<String,String> map);

    int updateByExampleSelective(@Param("record") Stuuser record, @Param("example") StuuserExample example);

    int updateByExample(@Param("record") Stuuser record, @Param("example") StuuserExample example);

    int updateByPrimaryKeySelective(Stuuser record);

    int updateByPrimaryKey(Stuuser record);

    String selectByName(String username);

    Stuuser selectStuByNo(String stuNO);

    List<Stuuser> selectStuList();

    Stuuser selectStuById(Long stuId);

    void updateStuInfo(Stuuser stuuser);


}
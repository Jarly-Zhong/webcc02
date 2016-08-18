package com.webcc.mapper;

import com.webcc.model.Teauser;
import com.webcc.model.TeauserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TeauserMapper {
    int countByExample(TeauserExample example);

    int deleteByExample(TeauserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Teauser record);

    int insertSelective(Teauser record);

    List<Teauser> selectByExample(TeauserExample example);

    Teauser selectByPrimaryKey(Long id);

    Long selectIdByMap(Map<String,String> map);

    int updateByExampleSelective(@Param("record") Teauser record, @Param("example") TeauserExample example);

    int updateByExample(@Param("record") Teauser record, @Param("example") TeauserExample example);

    int updateByPrimaryKeySelective(Teauser record);

    int updateByPrimaryKey(Teauser record);

    String selectByName(String username);

    Teauser selectTeaByNo(String teaNo);

    List<Teauser> selectTeaList();

    void updateTeaInfo(Teauser teauser);
}
package com.webcc.mapper;

import com.webcc.model.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StucourseMapper {
    int countByExample(StucourseExample example);

    int deleteByExample(StucourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Stucourse record);

    int insertSelective(Stucourse record);

    List<Stucourse> selectByExample(StucourseExample example);

    Stucourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Stucourse record, @Param("example") StucourseExample example);

    int updateByExample(@Param("record") Stucourse record, @Param("example") StucourseExample example);

    int updateByPrimaryKeySelective(Stucourse record);

    int updateByPrimaryKey(Stucourse record);

    List<StuCourC> selectCourByStuId(Long stuId);

    int insertStuCour(Stucourse stuC);

    List<StuCourC> selectExamByStuId(Long stuId);

    StuCourC selectCourByCourId(Map map);

    void deletStuCourByBean(Stucourse stucourse);

    List<Stuuser> selectStuListByCourId(Integer courid);

    void updataGrade(Stucourse stucourse);

    List<StuS> selectStuSByCourId(int courid);

}
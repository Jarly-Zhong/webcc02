package com.webcc.mapper;

import com.webcc.model.Course;
import com.webcc.model.CourseExample;
import java.util.List;

import com.webcc.model.CousrT;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    int countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer courseId);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<CousrT> selectCourList();

    List<Course> selectCourListByTeaId(Long teaid);

//    int insertOpenCour(Course course);

    List<CousrT> selectAllCourList();

    CousrT selectCourTeaById(int courseId);

    List<CousrT> selectExamList(int stuid);

    List<Course> selectCourListEndByTeaId(Long teaid);

    void updataCurrentSize(int courid);

    void updataCurrentSizeDel(int courid);

    void updataCourSta(int courid);

    void updataExamT(Course course);

}
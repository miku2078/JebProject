package com.yuri.spring.mapper;

import org.apache.ibatis.annotations.*;
import com.yuri.spring.entity.student;

import java.util.List;

@Mapper
public interface studentMapper {
    @Select("select * from student")
    List<student> findStudent();

    @Delete("delete from student where sname = #{name}")
    boolean deleteStudent(String name) ;

    @Insert("insert into student values(#{sno}, #{sname}, #{ssex}, #{sage}, #{sdept})")
    int insertStudent(student student_);

    @Update("update student set sname = #{sname}, ssex = #{ssex},sage = #{sage}, sdept = #{sdept} where sno = #{sno}")
    int updateStudent(student student_);

    @Select("select * from student where sno = #{sno}")
    student login(int sno);
}

package com.example.springbootcache.mapper;

import com.example.springbootcache.entity.Department;
import org.apache.ibatis.annotations.*;

//指定这是一个操作数据库的mapper
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "departmentName", property = "departmentName")
    })
    public Department getDeptById(@Param(value = "id") Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(@Param(value = "id") Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
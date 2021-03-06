package com.example.demo.DAO;

import com.example.demo.DO.CourseDO;
import com.example.demo.DO.ScDO;
import com.example.demo.DO.StudentDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer sno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated
     */
    int insert(StudentDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated
     */
    StudentDO selectByPrimaryKey(Integer sno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated
     */
    List<StudentDO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(StudentDO record);

    /**
     *
     * @param sno
     * @return
     */
    List<ScDO> findscoreById(@Param("sno") Integer sno);

    /**
     *
     * @param cnos
     * @return
     */
    List<CourseDO> findcourseByIds(@Param("cnos") List<String> cnos);
}
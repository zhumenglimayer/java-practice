package com.mayer.mybatis.crud.dao;

import com.mayer.mybatis.crud.beans.Employee;
import com.mayer.mybatis.crud.beans.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_employee
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    long countByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_employee
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    int deleteByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_employee
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_employee
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_employee
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    int insertSelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_employee
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    List<Employee> selectByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_employee
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_employee
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_employee
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_employee
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_employee
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    int updateByPrimaryKey(Employee record);
}
package com.mayer.mybatis.crud.beans;

public class Department {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_department.dept_id
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    private Integer deptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_department.dept_name
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    private String deptName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_department.dept_id
     *
     * @return the value of tbl_department.dept_id
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_department.dept_id
     *
     * @param deptId the value for tbl_department.dept_id
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_department.dept_name
     *
     * @return the value of tbl_department.dept_name
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_department.dept_name
     *
     * @param deptName the value for tbl_department.dept_name
     *
     * @mbg.generated Wed Sep 13 23:04:22 CST 2017
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}
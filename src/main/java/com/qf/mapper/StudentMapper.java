package com.qf.mapper;

import com.qf.pojo.Student;

public interface StudentMapper {
    public Student getStudentInfoByUid(int uid);

    public int updateStudentInfo(Student student);
}

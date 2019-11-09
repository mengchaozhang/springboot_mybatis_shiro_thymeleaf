package com.qf.service;

import com.qf.pojo.Student;

public interface StudentService {
    public Student getStudentInfoByUid(int uid);

    public int updateStudentInfo(Student student);
}

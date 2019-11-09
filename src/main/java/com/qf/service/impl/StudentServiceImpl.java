package com.qf.service.impl;

import com.qf.mapper.StudentMapper;
import com.qf.pojo.Student;
import com.qf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentInfoByUid(int uid) {
        return studentMapper.getStudentInfoByUid(uid);
    }

    @Override
    public int updateStudentInfo(Student student) {
        return studentMapper.updateStudentInfo(student);
    }
}

package com.qf.service.impl;

import com.qf.mapper.TeacherMapper;
import com.qf.pojo.Student;
import com.qf.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Student> getStudentList() {
        return teacherMapper.getStudentList();
    }
}

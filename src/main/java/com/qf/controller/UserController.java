package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.StudentService;
import com.qf.service.TeacherService;
import com.qf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private SecurityManager securityManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("goLogin")
    public String goLogin(User user, HttpSession session) {
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUname(), user.getUpwd());
        try {
            subject.login(usernamePasswordToken);
            if (subject.isAuthenticated() && subject.hasRole(user.getRolename())) {
                int uid = userService.getUidByUname(user.getUname());
                session.setAttribute(user.getRolename(),uid);
                return "redirect:index";
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "redirect:login";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("studentList")
    public String studentList(@RequestParam(defaultValue = "1") int pageNum, Model model) {
        PageHelper.startPage(pageNum, 5);
        List<Student> studentList = teacherService.getStudentList();
        PageInfo<Student> pageInfo = new PageInfo<>(studentList);
        model.addAttribute("pageInfo", pageInfo);
        return "studentList";
    }

    @RequestMapping("studentInfo")
    public String studentInfo(HttpSession session,HttpServletRequest request) {
        int uid = (int)session.getAttribute("student");
        Student student = studentService.getStudentInfoByUid(uid);
        request.setAttribute("student",student);
        return "studentInfo";
    }

    @RequestMapping("updateInfo")
    public String updateInfo(HttpSession session,HttpServletRequest request) {
        int uid = (int)session.getAttribute("student");
        Student student = studentService.getStudentInfoByUid(uid);
        request.setAttribute("student",student);
        return "updateInfo";
    }

    @RequestMapping("goUpdateInfo")
    public String goUpdateInfo(Student student) {
        int i = studentService.updateStudentInfo(student);
        if (i > 0) {
            return "redirect:studentInfo";
        }
        return "redirect:updateFail";
    }

    @RequestMapping("updateFail")
    public String updateFail() {
        return "updateFail";
    }
}

package com.qf.pojo;

public class User {
    private int uid;
    private String uname;
    private String upwd;
    private String rolename;
    private String pwd_salt;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getPwd_salt() {
        return pwd_salt;
    }

    public void setPwd_salt(String pwd_salt) {
        this.pwd_salt = pwd_salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", rolename='" + rolename + '\'' +
                ", pwd_salt='" + pwd_salt + '\'' +
                '}';
    }
}

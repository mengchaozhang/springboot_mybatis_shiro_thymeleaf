package com.qf.service;

import java.util.Set;

public interface UserService {
    public String getUpwdByUname(String uname);

    public String getSaltByUname(String uname);

    public Set<String> getRolenameByUname(String uname);

    public int getUidByUname(String uname);

}

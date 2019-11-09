package com.qf.mapper;

import java.util.Set;

public interface UserMapper {
    public String getUpwdByUname(String uname);

    public String getSaltByUname(String uname);

    public Set<String> getRolenameByUname(String uname);

    public int getUidByUname(String uname);
}

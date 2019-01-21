package com.wbb.swagger2oauth2.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPermissionDO {

    private Integer id ;
    private Integer userId;
    private Integer roleId;
    private String roleName;
}

package com.joker.modules.management.entity;

import java.util.List;

/**
 * author:zhangjian
 * date:2016-04-30
 * describe:
 **/
public class Role {
    private String id;
    private String roleName;
    private Role parent;
    private List<Role> children;
    private List<User> users;
    private List<String> permissions;
}

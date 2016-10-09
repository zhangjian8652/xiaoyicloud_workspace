package com.joker.modules.management.entity;

import com.joker.modules.management.enums.OrganizationType;

import java.util.List;

/**
 * author:zhangjian
 * date:2016-04-30
 * describe:
 * 组织机构，可以为公司，部门
 **/
public class Organization {
    private String id;
    private String code;
    private String name;
    private String address;
    private OrganizationType type;
    //负责人
    private User principal;
    //上级组织
    private Organization parent;
    //子组织
    private List<Organization> children;
}

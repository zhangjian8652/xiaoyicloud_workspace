package com.joker.modules.management.entity;

import java.util.List;

/**
 * author:zhangjian
 * date:2016-04-30
 * describe:
 * 菜单实体类，用与管理界面的菜单
 **/
public class Menu {
    private String id;
    //菜单的url
    private String link;
    //名称
    private String name;
    //图标样式
    private String icon;
    //排序编号
    private Integer sort;
    //是否显示
    private Integer display;
    //子菜单
    private List<Menu> children;
    //父级菜单
    private Menu parent;
    //权限名称
    private String permission;

    public Menu(String id, String link, String name, String icon, Integer sort, Integer display, List<Menu> children, Menu parent, String permission) {
        this.id = id;
        this.link = link;
        this.name = name;
        this.icon = icon;
        this.sort = sort;
        this.display = display;
        this.children = children;
        this.parent = parent;
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}

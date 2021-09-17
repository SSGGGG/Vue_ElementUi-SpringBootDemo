package com.cxytiandi.elementui.vo;

/**
 * @author Excelman
 * @date 2021/9/17 上午10:26
 * @description
 */
public class RoleVo {

    private String id;

    private String name;

    private String privilege;

    public RoleVo(String id, String name, String privilege) {
        this.id = id;
        this.name = name;
        this.privilege = privilege;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}

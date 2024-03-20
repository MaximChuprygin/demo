package com.example.demo.dao;


import com.example.demo.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role user);
    List<Role> listRoles();
    List<Role> getByName(String name);
}

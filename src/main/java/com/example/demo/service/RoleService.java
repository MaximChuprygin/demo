package com.example.demo.service;


import com.example.demo.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    List<Role> getByName(String name);
}


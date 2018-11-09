package com.chen.service;

import org.springframework.transaction.annotation.Transactional;

public class UserServiceTarget implements UserService {

    @Override
    @Transactional
    public void insert() {
        System.out.println("insert");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    @Transactional
    public void select() {
        System.out.println("select");
    }
}

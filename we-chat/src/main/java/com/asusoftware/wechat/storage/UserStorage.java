package com.asusoftware.wechat.storage;

import java.util.HashSet;
import java.util.Set;

/**
 * we-chat Created by Antonio on 3/16/2021
 */
public class UserStorage {
    private static UserStorage instance;
    private Set<String> users;

    private UserStorage() {
        users = new HashSet<>();
    }

    public static synchronized UserStorage getInstance() {
        if(instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUSer(String userName) throws Exception {
        if(users.contains(userName)) {
            throw new Exception("User aready exists with userNAme: " + userName);
        }
        users.add(userName);
    }
}

package com.gzcss.domain;


public class QueryVo {

    private User_crud user;

    public User_crud getUser() {
        return user;
    }

    public void setUser(User_crud user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                '}';
    }
}

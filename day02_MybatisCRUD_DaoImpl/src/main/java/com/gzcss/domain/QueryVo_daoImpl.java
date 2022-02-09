package com.gzcss.domain;


public class QueryVo_daoImpl {

    private User_daoImpl user;

    public User_daoImpl getUser() {
        return user;
    }

    public void setUser(User_daoImpl user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QueryVo_daoImpl{" +
                "user=" + user +
                '}';
    }
}

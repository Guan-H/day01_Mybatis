package com.gzcss.domain;


import java.util.List;

public class QueryVo_daoImpl {

    private User_daoImpl user;
    private List<Integer> ids;

    public User_daoImpl getUser() {
        return user;
    }

    public void setUser(User_daoImpl user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "QueryVo_daoImpl{" +
                "user=" + user +
                ", ids=" + ids +
                '}';
    }
}

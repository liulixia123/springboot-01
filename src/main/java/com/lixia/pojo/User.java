package com.lixia.pojo;

public class User {
    private Integer Id;
    private String userName;
    private String passWord;

    public User(Integer id, String userName, String passWord) {
        Id = id;
        this.userName = userName;
        this.passWord = passWord;
    }
    public User(){}

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}

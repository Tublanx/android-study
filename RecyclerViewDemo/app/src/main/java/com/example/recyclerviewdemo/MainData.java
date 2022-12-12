package com.example.recyclerviewdemo;

public class MainData {

    private int ivProfile;
    private String tvName;
    private String tvContent;

    public MainData(int ivProfile, String tvName, String tvContent) {
        this.ivProfile = ivProfile;
        this.tvName = tvName;
        this.tvContent = tvContent;
    }

    public int getIvProfile() {
        return ivProfile;
    }

    public void setIvProfile(int ivProfile) {
        this.ivProfile = ivProfile;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvContent() {
        return tvContent;
    }

    public void setTvContent(String tvContent) {
        this.tvContent = tvContent;
    }
}

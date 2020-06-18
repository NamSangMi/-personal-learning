package com.namsangmi.learning.bean;


import javax.inject.Inject;

public class Bottle {

    private User user;
    private String title;
    private String content;
    private long createTime;

    @Inject
    public Bottle() {
        this.title = "你好。我的中国🇨🇳";
        this.content = "黑云压城城欲摧，甲光向日金鳞开";
        this.createTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "user=" + user +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

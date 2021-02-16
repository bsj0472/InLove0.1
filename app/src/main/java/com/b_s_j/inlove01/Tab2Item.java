package com.b_s_j.inlove01;

public class Tab2Item {
    public String Day;
    public String msg;
    public int img;
    //생성자는 가급적 오버로딩으로 2개 이상 만들것.
    public Tab2Item() {
    }

    public Tab2Item(String day, String msg, int img) {
        this.Day = day;
        this.msg = msg;
        this.img = img;
    }
}

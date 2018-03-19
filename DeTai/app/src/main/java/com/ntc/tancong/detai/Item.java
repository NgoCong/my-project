package com.ntc.tancong.detai;

/**
 * Created by tanco on 3/18/2018.
 */

public class Item {
    String title,content,date;
    String people_name,people_phone;
    int people_img;
    public Item(String title, String content, String date)
    {
        this.title=title;
        this.content=content;
        this.date=date;
    }

    public Item(String people_name, String people_phone, int people_img) {
        this.people_name = people_name;
        this.people_phone = people_phone;
        this.people_img = people_img;
    }

    public String getPeople_name() {
        return people_name;
    }

    public void setPeople_name(String people_name) {
        this.people_name = people_name;
    }

    public String getPeople_phone() {
        return people_phone;
    }

    public void setPeople_phone(String people_phone) {
        this.people_phone = people_phone;
    }

    public int getPeople_img() {
        return people_img;
    }

    public void setPeople_img(int people_img) {
        this.people_img = people_img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
}

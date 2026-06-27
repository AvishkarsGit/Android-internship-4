package com.example.recyclerviewdemo.models;

public class CourseModel {
    String courseTitle, coursePrice, courseImage;

    public CourseModel(String courseImage, String courseTitle, String coursePrice) {
        this.courseImage = courseImage;
        this.courseTitle = courseTitle;
        this.coursePrice = coursePrice;
    }

    public CourseModel() {
        //empty constructor
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }
}

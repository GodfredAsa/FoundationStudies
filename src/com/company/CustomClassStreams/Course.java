package com.company.CustomClassStreams;

public class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }



    public String getCategory() {
        return category;
    }



    public int getReviewScore() {
        return reviewScore;
    }



    public int getNoOfStudents() {
        return noOfStudents;
    }


    public String toString(){
//        System.out.println("-----------------------------------------------------------------------");
        return  name  +
                " | " +  category +
                " | students: " + noOfStudents +
                " | review score: " + reviewScore;
    }


}

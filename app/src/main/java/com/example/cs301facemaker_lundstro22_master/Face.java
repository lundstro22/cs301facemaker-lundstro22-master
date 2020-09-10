package com.example.cs301facemaker_lundstro22_master;

import java.util.Random;

public class Face {
    //declare variables
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;
    private String r= "red";
    private String b= "blue";
    private String g= "green";

    //constructor calls randomize() method
    public Face() {
        this.randomize();
    }

    public void randomize() {
        Random r= new Random();
        //initialize variables
        this.skinColor= r.nextInt();
        this.eyeColor= r.nextInt();
        this.hairColor= r.nextInt();
        this.hairStyle= r.nextInt();
    }
}

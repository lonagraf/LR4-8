package com.example.lr4.entities;

import android.graphics.drawable.Drawable;

public class Employee {
    private String name;
    private String jobPosition;
    private Drawable photoResource;
    public Employee(String name, String jobPosition, Drawable photo)
    {
        this.name = name;
        this.jobPosition = jobPosition;
        this.photoResource = photo;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getJobPosition()
    {
        return this.jobPosition;
    }
    public void setJobPosition(String position)
    {
        this.jobPosition = jobPosition;
    }
    public Drawable getPhotoResource()
    {
        return this.photoResource;
    }
    public void setPhotoResource(Drawable photoResource)
    {
        this.photoResource = photoResource;
    }
}

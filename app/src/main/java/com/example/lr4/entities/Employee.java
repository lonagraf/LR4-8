package com.example.lr4;

public class Employee {
    private String name;
    private String jobPosition;
    private int photoResource;
    public Employee(String name, String jobPosition, int photo)
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
    public int getPhotoResource()
    {
        return this.photoResource;
    }
    public void setPhotoResource(int photoResource)
    {
        this.photoResource = photoResource;
    }
}

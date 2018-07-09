package com.abc.listviewcustomadapter;

import java.util.ArrayList;

public class Student
{

    public Student(String name,String batch, String num, String location)
    {
        this.name   = name;
        this.batch  = batch;
        this.num = num;
        this.location = location;
    }
private  String name,batch,num,location;
    public String getName()
    {
        return  name;

    }
    public void setName(String name)
    {
        this.name = name;

    }
    public void setBatch(String batch)
    {
        this.batch=batch;

    }
    public void setNum(String num)
    {
        this.num = num;

    }
   public void setLocation(String location)
   {
       this.location = location;
   }

}



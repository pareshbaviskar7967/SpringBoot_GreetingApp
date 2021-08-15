package com.example.greeting_app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "greet")
public class Greeting
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String message;

    public Greeting() {}

    public Greeting(String message)
    {
        this.message = message;
    }

    public Greeting(long id, String message)
    {
        this.id = id;
        this.message = message;
    }


    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id = id;
    }

    public String getmessage()
    {
        return message;
    }
    public void setMessage(String name)
    {
        this.message = name;
    }
}

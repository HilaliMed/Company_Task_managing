package com.example.springtaskproject.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;



@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;


    private String Task_name;
    private final Date time_of_start;
    private int time_to_finish;
    private boolean Task_state;

    public Task(Date timeOfStart){
        time_of_start = timeOfStart;
    }


    public Task(String Task_name, int time_to_finish){
        super();
        this.Task_name=Task_name;
        this.time_of_start= new Date();
        this.time_to_finish=time_to_finish;


    }

    public Date getTime_of_start() {
        return time_of_start;
    }


    public int getTime_to_finish() {
        return time_to_finish;
    }

    public void setTime_to_finish(int time_to_finish) {
        this.time_to_finish = time_to_finish;
    }

    public String getTask_name() {
        return Task_name;
    }

    public void setTask_name(String task_name) {
        Task_name = task_name;
    }



    public void display_Task(){
        System.out.println("\n" + Task_name + "     " + time_of_start + "     " + time_to_finish + "     " + Task_state + "\n");

    }


    public boolean isTask_state() {
        return Task_state;
    }

    public void setTask_state(boolean task_state) {
        Task_state = task_state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

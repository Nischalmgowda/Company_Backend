package com.example.company.Company.Inter;

import com.example.company.Company.Entiry.Job;

import java.util.List;

public interface JobInter {
    List<Job> getjob();
    Job getOne(int id);
    boolean Update(int id,Job job);
    void Delete(int id);
}

package com.example.company.Company.Controller;


import com.example.company.Company.Entiry.Job;
import com.example.company.Company.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    JobService service;

    @GetMapping("/")
    public List<Job> getJob() {
        return service.getjob();
    }

    @GetMapping("/get/{id}")
    public Job getOne(@PathVariable int id) {
        return service.getOne(id);
    }

    @PostMapping("/add")
    public Job Add(@RequestBody Job job) {
        return service.Add(job);
    }

    @PutMapping("/update/{id}")
    public boolean Update(@RequestBody Job job, @PathVariable int id) {
        return service.Update(id, job);
    }

    @DeleteMapping("/delete/{id}")
    public void Delete(@PathVariable int id) {
        service.Delete(id);
    }
}

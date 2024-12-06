package com.example.company.Company.Service;
import com.example.company.Company.Entiry.Job;
import com.example.company.Company.Inter.JobInter;
import com.example.company.Company.Repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService implements JobInter {
    @Autowired
    JobRepo repo;

    public List<Job> getjob() {
        return repo.findAll();
    }

    public Job getOne(int id) {
        return repo.findById(id).orElse(null); // Return null if not found
    }

    public Job Add(Job job) {
        return repo.save(job);
    }

    public boolean Update(int id, Job updated) {
        Optional<Job> jobOptional = repo.findById(id);
        if (jobOptional.isPresent()) {
            Job update = jobOptional.get();
            update.setDescription(updated.getDescription());
            update.setMinSalary(updated.getMinSalary());
            update.setMaxSalary(updated.getMaxSalary());
            repo.save(update);
            return true;
        } else {
            return false;
        }
    }

    public void Delete(int id) {
        repo.deleteById(id);
    }
}

package com.example.ECF_4.services;

import com.example.ECF_4.dao.JobOfferRepository;
import com.example.ECF_4.dao.Repository;
import com.example.ECF_4.entities.Application;
import com.example.ECF_4.entities.JobOffer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService implements IService<JobOffer>{

    private final JobOfferRepository jobRepository;

    public JobService(JobOfferRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobOffer> getAll() {
        return List.of();
    }

    @Override
    public JobOffer getById(int id) {
        return jobRepository.findById((long) id).orElse(null);
    }

    @Override
    public JobOffer add(JobOffer jobOffer) {
        return jobRepository.save(jobOffer);
    }



    @Override
    public JobOffer update(JobOffer jobOffer) {
        return jobRepository.save(jobOffer);
    }


    @Override
    public void delete(int id) {
        jobRepository.delete(getById(id));
    }
}

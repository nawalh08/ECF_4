package com.example.ECF_4.services;

import com.example.ECF_4.dao.InterviewRepository;
import com.example.ECF_4.entities.Application;
import com.example.ECF_4.entities.Interview;
import com.example.ECF_4.entities.JobOffer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InterviewService implements IService<Interview>{

    private final InterviewRepository interviewRepository;

    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    @Override
    public List<Interview> getAll() {
        return interviewRepository.findAll();
    }

    @Override
    public Interview getById(int id) {
        return interviewRepository.findById(id).orElse(null);
    }

    @Override
    public Interview add(Interview interview) {
        return interviewRepository.save(interview);
    }



    @Override
    public Interview update(Interview interview) {
        return interviewRepository.save(interview);
    }


    @Override
    public void delete(int id) {
      interviewRepository.delete(interviewRepository.getReferenceById(id));
    }
}

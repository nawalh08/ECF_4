package com.example.ECF_4.dao;

import com.example.ECF_4.entities.Application;
import com.example.ECF_4.entities.Interview;
import com.example.ECF_4.entities.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository {

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {}
    public interface ApplicationRepository extends JpaRepository<Application, Long> {}
    public interface InterviewRepository extends JpaRepository<Interview, Long> {}
}

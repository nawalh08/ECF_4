package com.example.ECF_4.dao;

import com.example.ECF_4.entities.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {}


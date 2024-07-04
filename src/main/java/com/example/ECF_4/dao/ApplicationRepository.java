package com.example.ECF_4.dao;

import com.example.ECF_4.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    void delete(int id);
}

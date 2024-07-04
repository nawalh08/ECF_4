package com.example.ECF_4.services;

import com.example.ECF_4.dao.ApplicationRepository;
import com.example.ECF_4.entities.Application;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationService implements IService<Application> {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }


    @Override
    public List<Application> getAll() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getById(int id) {
        return applicationRepository.findById((long) id).orElse(null);
    }

    @Override
    public Application add(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application update(Application application) {
        return null;
    }

    @Override
    public void delete(int id) {
        applicationRepository.deleteById((long) id);

    }
}

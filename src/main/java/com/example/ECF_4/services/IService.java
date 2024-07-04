package com.example.ECF_4.services;

import com.example.ECF_4.entities.Application;

import java.util.List;

public interface IService <T>{
    public List<T> getAll();
    public T getById(int id);
    public T add(T t);
    public T update(T t);
    public void delete(int id);

}

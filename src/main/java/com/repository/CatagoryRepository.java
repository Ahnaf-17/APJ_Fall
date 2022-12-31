package com.repository;

import com.domain.Admin;
import com.domain.Catagory;

import java.util.List;

public interface CatagoryRepository {

    public List<Catagory> getAll();

    public Catagory create(Catagory catagory);

    public Catagory get(Long id);

    public Catagory update(Catagory catagory);

    public void delete(Long id);
}

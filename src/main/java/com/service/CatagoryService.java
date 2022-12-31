package com.service;

import com.domain.Admin;
import com.domain.Catagory;

import java.util.List;

public interface CatagoryService {
    public Catagory insert(Catagory catagory);

    public Catagory get(Long id);

    public List<Catagory> getAll();

    public Catagory update(Catagory catagory);

    public void delete(Long id);
}

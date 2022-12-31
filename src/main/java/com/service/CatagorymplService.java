package com.service;

import com.domain.Admin;
import com.domain.Catagory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CatagorymplService implements CatagoryService{
    @Transactional
    public Catagory insert(Catagory catagory) {
        return catagoryService.create(catagory);
    }

    @Transactional(readOnly = true)
    public Catagory get(Long id) {
        return catagoryService.get(id);
    }

    @Transactional(readOnly = true)
    public List<Catagory> getAll() {
        return catagoryService.getAll();
    }

    @Transactional
    public Catagory update(Catagory catagory) {
        return catagoryService.update(catagory);
    }

    @Transactional
    public void delete(Long id) {
        catagoryService.delete(id);
    }
}

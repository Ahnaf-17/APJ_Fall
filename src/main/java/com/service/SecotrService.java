package com.service;

import com.domain.Sector;
import com.domain.User;

import java.util.List;

public interface SecotrService {
    public Sector insert(Sector sector );

    public Sector get(Long id);

    public List<Sector> getAll();

    public Sector update(Sector sector);

    public void delete(Long id);

    public Sector getByUsername(String username);
}

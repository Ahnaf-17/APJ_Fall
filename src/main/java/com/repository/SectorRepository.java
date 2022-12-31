package com.repository;

import com.domain.Admin;
import com.domain.Sector;

import java.util.List;

public interface SectorRepository {
    public List<Sector> getAll();

    public Sector create(Sector sector);

    public Sector get(Long id);

    public Sector update(Sector sector);

    public void delete(Long id);
}

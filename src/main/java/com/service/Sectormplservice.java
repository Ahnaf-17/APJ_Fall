package com.service;

import com.domain.Sector;
import com.repository.AdminRepository;
import com.repository.SectorRepository;
import org.springframework.transaction.annotation.Transactional;

public class Sectormplservice implements SecotrService{

    private SectorRepository sectorRepository;

    public Sectormplservice(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }
    @Transactional
    public Sector insert(Sector sector) {
        sector.setBsal(Double.parseDouble(String.valueOf(sector.getBsal())));
        sector.sethRent(Double.parseDouble(String.valueOf(sector.gethRent())));
        sector.setMedical(Double.parseDouble(String.valueOf(sector.getMedical())));
        sector.setConv(Double.parseDouble(String.valueOf(sector.getConv())));
        sector.setBonus(Double.parseDouble(String.valueOf(sector.getBonus())));
        sector.setCategory(sector.getCategory());
        return sectorRepository.create(sector);
    }
}

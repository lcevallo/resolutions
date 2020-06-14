package com.lcevallo.springsecurity.resolutions.service.impl;

import com.lcevallo.springsecurity.resolutions.models.Resolution;
import com.lcevallo.springsecurity.resolutions.repository.ResolutionRepository;
import com.lcevallo.springsecurity.resolutions.service.ResolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResolutionServiceImpl implements ResolutionService {

    @Autowired
    private ResolutionRepository resolutionRepository;

    @Override
    public List<Resolution> getResolutions() {
        return this.resolutionRepository.findAll();
    }

    @Override
    public Resolution make(Integer owner, String text) {
        Resolution resolution = Resolution.builder()
                .owner(owner)
                .completed(false)
                .text(text).build();

        return this.resolutionRepository.save(resolution);
    }

    @Override
    public Optional<Resolution> read(Integer id) {
        return this.resolutionRepository.findById(id);
    }

    @Override
    public Optional<Resolution> revise(Integer id, String text) {
        this.resolutionRepository.revise(id, text);
        return this.read(id);
    }

    @Override
    public Optional<Resolution> complete(Integer id) {
         this.resolutionRepository.complete(id);
         return this.read(id);
    }

    @Override
    public Optional<Resolution> findById(Integer id) {
        return this.resolutionRepository.findById(id);
    }
}

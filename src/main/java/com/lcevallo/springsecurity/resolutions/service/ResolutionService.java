package com.lcevallo.springsecurity.resolutions.service;

import com.lcevallo.springsecurity.resolutions.models.Resolution;

import java.util.List;
import java.util.Optional;

public interface ResolutionService {

    public List<Resolution> getResolutions();
    public Resolution make(Integer owner, String text);
    public Optional<Resolution> read(Integer id);
    public Optional<Resolution> revise(Integer id, String text);
    public Optional<Resolution> complete(Integer id);

    Optional<Resolution> findById(Integer id);
}

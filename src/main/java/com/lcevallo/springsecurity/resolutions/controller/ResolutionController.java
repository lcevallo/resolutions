package com.lcevallo.springsecurity.resolutions.controller;

import com.lcevallo.springsecurity.resolutions.models.Resolution;
import com.lcevallo.springsecurity.resolutions.service.ResolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/resolution")
public class ResolutionController {

    @Autowired
    private ResolutionService resolutionService;

    @GetMapping("/resolutions")
    public Iterable<Resolution> read() {
        return this.resolutionService.getResolutions();
    }

    @GetMapping("/resolution/{id}")
    public Optional<Resolution> read(@PathVariable("id") Integer id) {
        return this.resolutionService.findById(id);
    }

    @PostMapping("/resolution")
    public Resolution make(@RequestBody String text) {
        Integer owner = 1;
        return this.resolutionService.make(owner, text);
    }


    @PutMapping(path="/resolution/{id}/revise")
    @Transactional
    public Optional<Resolution> revise(@PathVariable("id") Integer id, @RequestBody String text) {
       return this.resolutionService.revise(id, text);

    }

    @PutMapping("/resolution/{id}/complete")
    @Transactional
    public Optional<Resolution> complete(@PathVariable("id") Integer id) {
       return this.resolutionService.complete(id);
    }

}

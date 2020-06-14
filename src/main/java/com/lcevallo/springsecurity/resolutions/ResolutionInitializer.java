package com.lcevallo.springsecurity.resolutions;

import com.lcevallo.springsecurity.resolutions.service.ResolutionService;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;


@Component
public class ResolutionInitializer implements SmartInitializingSingleton {

    private final ResolutionService resolutionService;

    public ResolutionInitializer(ResolutionService resolutionService) {
        this.resolutionService = resolutionService;
    }

    @Override
    public void afterSingletonsInstantiated() {
        Integer joshId = 1;
        Integer carolId = 2;

        this.resolutionService.make( joshId,"Read War and Peace");
        this.resolutionService.make(joshId,"Free Solo the Eiffel Tower");
        this.resolutionService.make(joshId, "Hang Christmas Lights");

        this.resolutionService.make(carolId, "Run for President" );
        this.resolutionService.make(carolId,  "Run a Marathon" );
        this.resolutionService.make(carolId,  "Run an Errand" );


    }
}

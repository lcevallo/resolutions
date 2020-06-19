package com.lcevallo.springsecurity.resolutions;

import com.lcevallo.springsecurity.resolutions.models.User;
import com.lcevallo.springsecurity.resolutions.service.ResolutionService;
import com.lcevallo.springsecurity.resolutions.service.UserService;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class ResolutionInitializer implements SmartInitializingSingleton {

    private final ResolutionService resolutionService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public ResolutionInitializer(ResolutionService resolutionService, UserService userService, PasswordEncoder passwordEncoder) {
        this.resolutionService = resolutionService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void afterSingletonsInstantiated() {
        Integer joshId = 1;
        Integer carolId = 2;

        User josh = new User(joshId, "josh", this.passwordEncoder.encode("josh"),true);

        josh.addAuthority("READ");

        User carol = new User(carolId, "carol", this.passwordEncoder.encode("carol"),true);
        carol.addAuthority("READ");
        carol.addAuthority("WRITE");

        this.userService.guardarUsuario(josh);
        this.userService.guardarUsuario(carol);

        this.resolutionService.make( joshId,"Read War and Peace");
        this.resolutionService.make(joshId,"Free Solo the Eiffel Tower");
        this.resolutionService.make(joshId, "Hang Christmas Lights");

        this.resolutionService.make(carolId, "Run for President" );
        this.resolutionService.make(carolId,  "Run a Marathon" );
        this.resolutionService.make(carolId,  "Run an Errand" );




    }
}

package org.seyedk.controller;


import org.seyedk.component.Registration;
import org.seyedk.domain.RegistrationRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

@RequestMapping("/reg")

public class RegistrationController {

    Registration registration;

    @Autowired
    RegistrationController(Registration registration) {
        this.registration = registration;

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    long Register(@RequestBody RegistrationRecord record){
        System.out.println("Registration Request" + record);
        return registration.Register(record);
    }

    @RequestMapping("/get/{id}")
    RegistrationRecord getRecording(@PathVariable long id){
        return registration.getRegistration(id);
    }
}

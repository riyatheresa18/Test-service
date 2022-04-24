package com.microservice.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/internalServiceFallBack")
    public String internalServiceFallBackMethod() {
        return "Internal Hiring Service is taking longer than Expected. " +
                " Please try again later.";
    }

    @GetMapping("/externalServiceFallBack")
    public String externalServiceFallBackMethod() {
        return "External Hiring Service is taking longer than Expected. " +
                " Please try again later.";
    }
}

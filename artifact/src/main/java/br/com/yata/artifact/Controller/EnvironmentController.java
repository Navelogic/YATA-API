package br.com.yata.artifact.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/environment")
public class EnvironmentController {

    @Value("${environment.name}")
    private String environmentName;

    @GetMapping
    public String getEnvironmentName() {
        return "Environment: " + environmentName;
    }
}

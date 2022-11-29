package com.example.finalfas.monitoring.api;


import com.example.finalfas.monitoring.domain.model.entity.Chasis;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Monitoring")
@RestController
@RequestMapping("/api/v1/monitoring")
@CrossOrigin


public class MonitoringController {
    @GetMapping
    public Chasis getMonitoring()
    {
        return new Chasis();
    }
}


package com.spring.meter_converter.controller;

import com.spring.meter_converter.service.IConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/converter")
@CrossOrigin(origins = "*")
public class ConverterController {

    @Autowired
    private IConverterService converterService;

    @GetMapping("/meters/{meters}")
    public Double convertCentimeters (@PathVariable Double meters) {
        return converterService.convertCentimeters(meters);
    }
}

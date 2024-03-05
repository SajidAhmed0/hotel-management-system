package com.hotelmangementsystem.application.controller.pricing;

import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.service.pricing.SeasonSupplementPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seasons/")
public class SeasonSupplementPricingController {

    @Autowired
    private SeasonSupplementPricingService seasonSupplementPricingService;


}

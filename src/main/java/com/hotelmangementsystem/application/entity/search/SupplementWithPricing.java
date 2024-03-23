package com.hotelmangementsystem.application.entity.search;

import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;

public class SupplementWithPricing {

    private Supplement supplement;

    private SeasonSupplementPricing pricing;

    public SupplementWithPricing() {
    }

    public SupplementWithPricing(Supplement supplement, SeasonSupplementPricing pricing) {
        this.supplement = supplement;
        this.pricing = pricing;
    }

    public Supplement getSupplement() {
        return supplement;
    }

    public void setSupplement(Supplement supplement) {
        this.supplement = supplement;
    }

    public SeasonSupplementPricing getPricing() {
        return pricing;
    }

    public void setPricing(SeasonSupplementPricing pricing) {
        this.pricing = pricing;
    }
}

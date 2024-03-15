package com.hotelmangementsystem.application.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SeasonSupplementKey implements Serializable {

    @Column(name = "season_id")
    private Long seasonId;

    @Column(name = "supplementId")
    private Long supplementId;

    @Column(name = "contract_id")
    private Long contractId;

    public SeasonSupplementKey() {
    }

    public SeasonSupplementKey(Long seasonId, Long supplementId, Long contractId) {
        this.seasonId = seasonId;
        this.supplementId = supplementId;
        this.contractId = contractId;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public Long getSupplementId() {
        return supplementId;
    }

    public void setSupplementId(Long supplementId) {
        this.supplementId = supplementId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeasonSupplementKey that = (SeasonSupplementKey) o;
        return Objects.equals(seasonId, that.seasonId) && Objects.equals(supplementId, that.supplementId) && Objects.equals(contractId, that.contractId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonId, supplementId, contractId);
    }
}

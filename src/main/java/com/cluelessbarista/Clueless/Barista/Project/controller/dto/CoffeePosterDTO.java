package com.cluelessbarista.Clueless.Barista.Project.controller.dto;

import jakarta.persistence.Column;

public class CoffeePosterDTO {
    @Column(name = "posted_by")
    private String postedBy;

    public String getPostedBy() {
        return postedBy;
    }
}

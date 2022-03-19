package com.ouch.mongodbpractice.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CoverType {
    HARD_COVER("hard-cover"), SOFT_COVER("soft-cover");

    @JsonValue
    private final String type;

    CoverType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

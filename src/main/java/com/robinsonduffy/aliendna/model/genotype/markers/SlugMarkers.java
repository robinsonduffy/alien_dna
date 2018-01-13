package com.robinsonduffy.aliendna.model.genotype.markers;

public enum SlugMarkers implements MarkersEnum {
    GREEN("G"),
    BLUE("B"),
    EYE_STALKS("E"),
    EYE_STALKS_LENGTH("L"),
    SLIME("S");

    private final String code;

    SlugMarkers(final String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return code;
    }
}

package com.robinsonduffy.aliendna.model.markers;

public enum PlantMarkers implements MarkersEnum {
    PEA_SHAPE("R"),
    PEA_COLOR("Y"),
    POD_SHAPE("I"),
    POD_COLOR("G"),
    FLOWER_COLOR("P"),
    FLOWER_POSITION("A"),
    PLANT_SIZE("T");

    private final String code;

    PlantMarkers(final String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return code;
    }
}

package com.robinsonduffy.aliendna.model.markers;

public enum MonsterMarkers implements MarkersEnum {
    FANGS("A"),
    RUFF("B"),
    MARKINGS("C"),
    MARKINGS_TYPE("D"),
    MARKINGS_COLOR("E"),
    TAIL("F"),
    TAIL_LENGTH("G"),
    TAIL_CURL("H"),
    TAIL_SPIKES("I"),
    HEIGHT("J"),
    WEIGHT("K"),
    ARMS("L"),
    BLUE("M"),
    RED("N"),
    YELLOW("O"),
    WINGS("P"),
    WING_SIZE("Q"),
    BELLY("R"),
    TUFT("S");

    private final String code;

    MonsterMarkers(String code){
        this.code = code;
    }

    @Override
    public String code() {
        return code;
    }
}

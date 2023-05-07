package edu.umb.cs681.hw09;

import java.util.ArrayList;
import java.util.List;

public record Position(double latitude, double longitude, double altitude) {
    List<Double> coordinate() {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(latitude);
        coordinates.add(longitude);
        coordinates.add(altitude);
        return coordinates;
    }

    Position change(double newLat, double newLon, double newAlt) {
        return new Position(newLat, newLon, newAlt);
    }

    boolean higherAltThan(Position anotherPosition) {
        var diff = this.altitude - anotherPosition.altitude;
        if (diff > 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean lowerAltThan(Position anotherPosition) {
        var diff = this.altitude - anotherPosition.altitude;
        if (diff < 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean northOf(Position anotherPosition) {
        var diff = this.latitude  - anotherPosition.latitude ;
        if (diff > 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean southOf(Position anotherPosition) {
        var diff = this.latitude - anotherPosition.latitude;
        if (diff < 0) {
            return true;
        } else {
            return false;
        }
    }

}

package com.company;

import com.company.model.ExperimentalPlane;
import com.company.model.classification.MilitaryType;
import com.company.model.MilitaryPlane;
import com.company.model.PassengerPlane;
import com.company.model.Plane;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Airport {

    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof PassengerPlane)
                .map(plane -> (PassengerPlane) plane)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof MilitaryPlane)
                .map(plane -> (MilitaryPlane) plane)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanes().stream()
                .filter(plane -> plane.getType() == MilitaryType.TRANSPORT)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanes().stream()
                .filter(plane -> plane.getType() == MilitaryType.BOMBER)
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane)
                .collect(Collectors.toList());
    }

    public List<Plane> sortByMaxDistance() {
        return planes.stream()
                .sorted(Comparator.comparing(Plane::getMaxFlightDistance))
                .collect(Collectors.toList());
    }

    public List<Plane> sortByMaxSpeed() {
        return planes.stream()
                .sorted(Comparator.comparing(Plane::getMaxSpeed))
                .collect(Collectors.toList());
    }

    public List<Plane> sortByMaxLoadCapacity() {
        return planes.stream()
                .sorted(Comparator.comparing(Plane::getMaxLoadCapacity))
                .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return getPassengerPlanes().stream()
                .max(Comparator.comparing(PassengerPlane::getPassengersCapacity))
                .orElse(null);
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Airport{");
        stringBuilder.append("planes=").append(planes);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

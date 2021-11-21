package com.company.model;

import com.company.model.classification.MilitaryType;

public class MilitaryPlane extends Plane{

    private final MilitaryType type;

    public MilitaryPlane(
            String model,
            int maxSpeed,
            int maxFlightDistance,
            int maxLoadCapacity,
            MilitaryType type
    ) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
    }

    public MilitaryType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("MilitaryPlane{");
        stringBuilder.append(super.toString());
        stringBuilder.append("type=").append(type);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

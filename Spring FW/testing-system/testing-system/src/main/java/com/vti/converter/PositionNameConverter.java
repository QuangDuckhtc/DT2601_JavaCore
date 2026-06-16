package com.vti.converter;

import com.vti.enumerate.PositionName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<PositionName, String> {
    @Override
    public String convertToDatabaseColumn(PositionName attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public PositionName convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        for (PositionName positionName : PositionName.values()) {
            if (positionName.getValue().equalsIgnoreCase(dbData)) {
                return positionName;
            }
        }

        return null;
    }
}

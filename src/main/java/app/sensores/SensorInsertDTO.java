package app.sensores;

public record SensorInsertDTO(
    String unidade,
    float valor,
    String local
){}
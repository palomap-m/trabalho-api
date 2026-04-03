package app.sensores;

public record SensorDTO(
    long id,
    String unidade,
    float valor,
    String local
){
    public SensorDTO(Sensor dados) {
        this(dados.getId(), dados.getUnidade(), dados.getValor(), dados.getLocal());
    }
}
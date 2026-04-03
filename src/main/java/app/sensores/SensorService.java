package app.sensores;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepo;

    public Iterable<SensorDTO> findAll(){
        return sensorRepo.findAll().stream().map(SensorDTO::new).toList();
    }

    public SensorDTO findOne(long id) {
        Optional<Sensor> resultado = sensorRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Sensor não encontrado"
            );
        }
        return new SensorDTO(resultado.get());
    }

    public List<SensorDTO> findByLocal(String local) {
        return sensorRepo.findByLocal(local).stream().map(SensorDTO::new).toList();
    }

    public SensorDTO insert(SensorInsertDTO dados) {
        Sensor sensor = new Sensor();
        sensor.setUnidade(dados.unidade());
        sensor.setValor(dados.valor());
        sensor.setLocal(dados.local());
        return new SensorDTO(sensorRepo.save(sensor));
    }

    public SensorDTO update(long id, SensorInsertDTO dados) {
        Optional<Sensor> resultado = sensorRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Sensor não encontrado"
            );
        }

        resultado.get().setUnidade(dados.unidade());
        resultado.get().setValor(dados.valor());
        resultado.get().setLocal(dados.local());
        return new SensorDTO(sensorRepo.save(resultado.get()));
    }
    public void delete(long id) {
        if(!sensorRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Sensor não encontrado"
            );
        }
        sensorRepo.deleteById(id);
    }
}
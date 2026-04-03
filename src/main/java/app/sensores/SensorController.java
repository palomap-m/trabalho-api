package app.sensores;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/sensores")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @GetMapping
    public Iterable<SensorDTO> list() {
        return sensorService.findAll();
    }

    @GetMapping("/{id}")
    public SensorDTO getOne(@PathVariable long id) {
        return sensorService.findOne(id);
    }

    @GetMapping("/local/{local}")
    public List<SensorDTO> getByLocal(@PathVariable String local) {
        return sensorService.findByLocal(local);
    }

    @PostMapping
    public SensorDTO insert(@RequestBody SensorInsertDTO novo) {
        return sensorService.insert(novo);
    }

    @PutMapping("/{id}")
    public SensorDTO update(@PathVariable long id, @RequestBody SensorInsertDTO modif){
        return sensorService.update(id, modif);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        sensorService.delete(id);
    }
}
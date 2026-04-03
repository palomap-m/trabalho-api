package app.sensores;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="sensores")
public class Sensor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String unidade;

    @Column(nullable = false)
    private float valor;

    @Column(nullable = false)
    private String local;
}
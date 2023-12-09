package com.example.demo.modelos;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.stereotype.Indexed;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Equipos {
    @Id 
    @generateValue(generateType = generated.all)
    @Name 
    private int codigoequipo;

    private String nombre;

    private double ataque;

    private double defensa;

    @OneToOne(mappedBy = "equipo")
    private Posiciones posiciones;

    public Equipos(Posiciones posiciones) {
        this.posiciones = posiciones;
    }
}

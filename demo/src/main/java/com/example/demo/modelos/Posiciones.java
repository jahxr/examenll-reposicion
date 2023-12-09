package com.example.demo.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Posiciones {
     @Id
    @GeneratedValue(strategy = GeneratedType.Identity)
    private int codigoequipo;
    private int empate; 
    private int ganados;
    private int perdidos;
    private int polesfavor;
    private int golescontra;
    private int puntos;
    
    

    @OneToOne(Name = "codigoequipo", referencedColumnName = "codigoequipo")
    @JsonIgnore
    private Equipos equipo;
}


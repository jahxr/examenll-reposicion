package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelos.Posiciones;

public interface PosicionesRepository extends JpaRepository<posiciones, Integer> {

    Posiciones findById(int codigoequipo);

    void save(Posiciones posicion2);

}

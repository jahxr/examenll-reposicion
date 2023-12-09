package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelos.Equipos;

public interface EquiposRepository extends JpaRepository <Equipos, Integer> {

    void save(Equipos equipo);

    Object findById(int id);

    List<Equipos> findAll();

    void delete(Equipos equipo);
    
}

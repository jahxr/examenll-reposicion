package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelos.Equipos;
import com.example.demo.servicios.impl.EquipoServiceImpl;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    @Autowired
    private EquipoServiceImpl equiposRepository;

    @PostMapping("/crear")
    public Equipos crear(@RequestBody Equipos equipo){
        return this.equiposRepository.crear(equipo);
    }

    @DeleteMapping("/eliminar/{idEquipo}")
    public Boolean delete(@PathVariable int idEquipo){
        return this.equiposRepository.delete(idEquipo);
    }

    @GetMapping("/buscar/{idEquipo}")
    public Equipos buscar(@PathVariable int idEquipo){
        return this.equiposRepository.buscar(idEquipo);
    }

    @GetMapping(value="/simular")
    public Equipos simular() {
        return this.equiposRepository.simular();
    }
    
    @GetMapping(value="/tabla")
    public String tabla() {
        return this.equiposRepository.tabla();
    }
    
}

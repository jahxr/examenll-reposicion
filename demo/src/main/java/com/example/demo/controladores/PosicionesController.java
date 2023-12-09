package com.example.demo.controladores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelos.Equipos;
import com.example.demo.modelos.Posiciones;

@RestController
@RequestMapping("/api/posiciones")
public class PosicionesController {
    @PostMapping("/crear")
    public Equipos crear(@RequestBody Posiciones posiciones){
        return posiciones;
    }
}

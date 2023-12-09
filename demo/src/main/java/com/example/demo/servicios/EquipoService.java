package com.example.demo.servicios;

import com.example.demo.modelos.Equipos;

public interface EquipoService {
    public Equipos crear(Equipos equipo);
    public boolean eliminar(int id);
    public Equipos buscar(int id);
    public boolean simular();
    public String tabla();
    
}

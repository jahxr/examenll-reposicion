package com.example.demo.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Equipos;
import com.example.demo.modelos.Posiciones;
import com.example.demo.modelos.Posiciones;
import com.example.demo.repositorios.EquiposRepository;
import com.example.demo.repositorios.PosicionesRepository;
import com.example.demo.servicios.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {
    @Autowired
    private EquiposRepository equiposRepository;
    @Autowired
    private PosicionesRepository posicionesRepository;

    public Equipos crear(Equipos equipo){
        Posiciones posicion = new Posiciones();
        posicion.setCodigoequipo(equipo.getCodigoequipo());
        this.posicionesRepository.save(posicion);
        return this.equiposRepository.save(equipo);
    }

    @Override
    public boolean eliminar(int id) {
        Equipos equipo = this.equiposRepository.findById(id).get();
        if (equipo != null) {
            this.equiposRepository.delete(equipo);
            return true;
        }
        return false;
    }

    @Override
    public Equipos buscar(int id) {
        return this.equiposRepository.findById(id).get();
    }

    @Override
    public boolean simular() {
        List<Equipos> equipos = this.equiposRepository.findAll();
        for (int index = equipos.size(); index < 6; index++) {
            Equipos equipo = new Equipos();
            posicion.setCodigoequipo(equipo.getCodigoequipo());
            this.posicionesRepository.save(posicion);
            this.equiposRepository.save(equipo);
        }
        for (int i = 0; i < equipos.size(); i=i+2) {
            Equipos equipo1 = equipos.get(i);
            Equipos equipo2 = equipos.get(i+1);
            int goles1 = (Math.random()*10)+1;
            int goles2 = (Math.random()*10)+1;
            if (goles1 > goles2) {
                Posiciones posicion1 = this.posicionesRepository.findById(equipo1.getCodigoequipo());
                Posiciones posicion2 = this.posicionesRepository.findById(equipo1.getCodigoequipo());
                posicion1.setGanados(posicion1.getGanados() + 1);
                posicion1.setGolescontra(posicion1.getGolescontra() + goles2);
                posicion1.setPolesfavor(posicion1.getPolesfavor()+ goles1);
                posicion1.setPuntos(posicion1.getPuntos() + 3);

                posicion2.setPerdidos(posicion2.getPerdidos() + 1);
                posicion2.setGolescontra(posicion2.getGolescontra() + goles1);
                posicion2.setPolesfavor(posicion2.getPolesfavor()+ goles2);

                this.posicionesRepository.save(posicion1);
                this.posicionesRepository.save(posicion2);

                return true;
            }
            if (goles2 > goles1) {
                 Posiciones posicion1 = this.posicionesRepository.findById(equipo2.getCodigoequipo());
                Posiciones posicion2 = this.posicionesRepository.findById(equipo2.getCodigoequipo());
                posicion1.setGanados(posicion1.getGanados() + 1);
                posicion1.setGolescontra(posicion1.getGolescontra() + goles2);
                posicion1.setPolesfavor(posicion1.getPolesfavor()+ goles1);
                posicion1.setPuntos(posicion1.getPuntos() + 3);

                posicion2.setPerdidos(posicion2.getPerdidos() + 1);
                posicion2.setGolescontra(posicion2.getGolescontra() + goles1);
                posicion2.setPolesfavor(posicion2.getPolesfavor()+ goles2);

                this.posicionesRepository.save(posicion1);
                this.posicionesRepository.save(posicion2);
                return true;
            }
            if (goles1==goles2) {
                Posiciones posicion1 = this.posicionesRepository.findById(equipo2.getCodigoequipo());
                Posiciones posicion2 = this.posicionesRepository.findById(equipo2.getCodigoequipo());

                posicion1.setEmpate(posicion1.getEmpate() + 1);
                posicion1.setPuntos(posicion1.getPuntos() + 1);
                posicion2.setEmpate(posicion2.getEmpate() + 1);
                posicion2.setPuntos(posicion2.getPuntos() + 1);

                return true;
            }
        }
        return false;
    }

    @Override
    public String tabla() {
        
    }

    
}

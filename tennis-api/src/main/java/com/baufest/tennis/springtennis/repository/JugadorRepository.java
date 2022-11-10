package com.baufest.tennis.springtennis.repository;

import com.baufest.tennis.springtennis.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Aca va la anotacion Repository para indicar que es un repositorio y pueda ser detectado por el autowired
@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    List<Jugador> findAllByOrderByNombreAsc();

}

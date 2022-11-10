package com.baufest.tennis.springtennis.mapper;

import com.baufest.tennis.springtennis.dto.JugadorDTO;
import com.baufest.tennis.springtennis.model.Jugador;

/**
 * <p>Componente de Mapper</p>
 * Este componente sirve para transformar un objeto de tipo entidad a un objeto de tipo DTO,
 * los atributos deben coincidir en nombre, pero no es necesario que se contenga en el DTO todos
 * los atributos de la entidad, los atributos que no contengan match (mismo nombre) o no existan
 * se instanciaran como null por defecto
 */
public interface JugadorMapper {

    /* Interfaz en donde definimos los metodos que seran
     * obligatorios utilizar en nuestras clases. En este caso
     * JugadorMapperImpl, en su declaracion incluimos:
     * "implements JugadorMapper" */

    JugadorDTO toDTO(Jugador entity);
    Jugador fromDTO(JugadorDTO entity);

}

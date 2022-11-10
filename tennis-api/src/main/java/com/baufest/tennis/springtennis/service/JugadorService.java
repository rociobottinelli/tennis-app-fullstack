package com.baufest.tennis.springtennis.service;

import com.baufest.tennis.springtennis.dto.JugadorDTO;

import java.util.List;

/**
 * <p>Service de Jugador</p>
 * Este componente sera el encargado de aplicar la logica de negocio a los jugadores antes de persistirlos en la base de datos
 * o de devolver dichas entradas desde la base de datos, es necesario que contenga el spring prototype @Service para su funcionamiento
 * ya que es la forma de declarar al momento de la inyeccion de dependencias que se trata de un service
 */
public interface JugadorService {

	/**
	 * <p>
	 *     Obtiene el listado de todos los jugadores
	 * </p>
	 *
	 * @return List<JugadorDto>
	 */
	List<JugadorDTO> listAll();

	/**
	 * <p>
	 *     Obtiene el jugador de id recibido
	 * </p>
	 *
	 * @param id
	 * @return JugadorDto
	 */
	JugadorDTO getById(Long id);

	/**
	 * <p>
	 *     Guarda el jugador recibido. Si el id del jugador recibido ya existe en la
	 *     base se hace throw de una exception "IllegalArgumentException"
	 * </p>
	 * @param jugador
	 * @return JugadorDto
	 */
	JugadorDTO save(JugadorDTO jugador);

	/**
	 * <p>
	 *     Actualiza la información del jugador recibido.
	 *     Busca el id del jugador recibido en la base, si existe actualiza la información,
	 *     caso contrario se hace throw de una exception "NoSuchElementException"
	 * </p>
	 * @param jugador
	 * @return JugadorDto
	 */
	JugadorDTO update(JugadorDTO jugador);

	/**
	 * <p>
	 *     Borra de la base de datos el jugador que tiene el id recibido.
	 *     Si no se encuentra ningun jugador con el id recibido se hace throw de
	 *     una exception "NoSuchElementException"
	 * </p>
	 * @param id
	 */
	void delete(Long id);

}

package com.baufest.tennis.springtennis.mapper;

import com.baufest.tennis.springtennis.dto.JugadorDTO;
import com.baufest.tennis.springtennis.model.Jugador;
import org.springframework.stereotype.Component;

@Component
public class JugadorMapperImpl implements JugadorMapper {

    /* Utilizamos el Mapper para no acceder directamente a la base.
    Lo implementamos en el JugadorServiceImpl a traves del @Autowired
     */

    /* Esta funcion recibe como parametro un Jugador
     * y en base a el parametro recibido genera una nueva instancia
     * de jugador DTO.*/

    @Override
    public JugadorDTO toDTO(Jugador entity) {
        if ( entity == null ) {
            return null;
        }

        JugadorDTO jugadorDTO = new JugadorDTO();

        jugadorDTO.setId( entity.getId() );
        jugadorDTO.setNombre( entity.getNombre() );
        jugadorDTO.setPuntos( entity.getPuntos() );

        return jugadorDTO;
    }

    /* Esta funcion recibe como parametro un JugadorDTO
     * y hacemos un generamos una nueva instancia de Jugador */
    @Override
    public Jugador fromDTO(JugadorDTO entity) {
        if ( entity == null ) {
            return null;
        }

        Jugador jugador = new Jugador();

        jugador.setId( entity.getId() );
        jugador.setNombre( entity.getNombre() );
        jugador.setPuntos( entity.getPuntos() );

        return jugador;
    }
}


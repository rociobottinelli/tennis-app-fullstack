package com.baufest.tennis.springtennis.mapper;

import com.baufest.tennis.springtennis.dto.PartidoDTO;
import com.baufest.tennis.springtennis.model.Partido;
import org.springframework.stereotype.Component;

@Component
public class PartidoMapperImpl implements PartidoMapper{

    @Override
    public PartidoDTO toDTO(Partido entity) {
        if (entity == null){
            return null;
        }
     PartidoDTO partidoDTO = new PartidoDTO();
        partidoDTO.setId(entity.getId());
        partidoDTO.setFechaComienzo(entity.getFechaComienzo());
        partidoDTO.setEstado(entity.getEstado());
        partidoDTO.setJugadorLocal(entity);




        return partidoDTO;
    }

    @Override
    public Partido fromDTO(PartidoDTO entity) {
        return null;
    }
}

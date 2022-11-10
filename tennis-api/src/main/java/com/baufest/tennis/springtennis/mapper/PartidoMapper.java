package com.baufest.tennis.springtennis.mapper;

import com.baufest.tennis.springtennis.dto.PartidoDTO;
import com.baufest.tennis.springtennis.model.Partido;

public interface PartidoMapper {
    PartidoDTO toDTO(Partido entity);
    Partido fromDTO (PartidoDTO entity);
}

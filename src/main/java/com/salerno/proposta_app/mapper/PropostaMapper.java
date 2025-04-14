package com.salerno.proposta_app.mapper;
import com.salerno.proposta_app.dto.PropostaRequestDto;
import com.salerno.proposta_app.entity.Proposta;
import org.mapstruct.Mapper;

@Mapper
public interface PropostaMapper {

    Proposta convertDtoToProposta(PropostaRequestDto propostaRequestDto);
}

package com.salerno.proposta_app.service;
import com.salerno.proposta_app.dto.PropostaRequestDto;
import com.salerno.proposta_app.dto.PropostaResponseDto;
import com.salerno.proposta_app.entity.Proposta;
import com.salerno.proposta_app.mapper.PropostaMapper;
import com.salerno.proposta_app.repository.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PropostaService {

    private PropostaRepository propostaRepository;

    public PropostaResponseDto criar(PropostaRequestDto requestDto) {
       Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);
        propostaRepository.save(proposta);
        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    public List<PropostaResponseDto> obterProposta() {
      return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }
}

package com.salerno.proposta_app.service;
import com.salerno.proposta_app.dto.PropostaRequestDto;
import com.salerno.proposta_app.dto.PropostaResponseDto;
import com.salerno.proposta_app.entity.Proposta;
import com.salerno.proposta_app.mapper.PropostaMapper;
import com.salerno.proposta_app.repository.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PropostaService {

    private PropostaRepository propostaRepository;

    private NotificacaoService notificacaoService;

    private String exchange;

    public PropostaService(PropostaRepository propostaRepository,
                           NotificacaoService notificacaoService,
                           @Value("${rabbitmq.propostapendente.exchange}") String exchange) {
        this.propostaRepository = propostaRepository;
        this.notificacaoService = notificacaoService;
        this.exchange = exchange;
    }

    public PropostaResponseDto criar(PropostaRequestDto requestDto) {
       Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);
        propostaRepository.save(proposta);

        PropostaResponseDto response = PropostaMapper.INSTANCE.convertEntityToDto(proposta);
        notificacaoService.notificar(response, exchange);
        return response;
    }

    public List<PropostaResponseDto> obterProposta() {
      return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }
}

package com.salerno.proposta_app.agendador;
import com.salerno.proposta_app.repository.PropostaRepository;
import com.salerno.proposta_app.service.NotificacaoRabbitService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropostaSemIntegração {

    private PropostaRepository propostaRepository;

    private NotificacaoRabbitService notificacaoRabbitService;

    private String exchange;

    public PropostaSemIntegração(PropostaRepository propostaRepository,
                                 NotificacaoRabbitService notificacaoRabbitService,
                                 @Value("${rabbitmq.propostapendente.exchange}") String exchange) {
        this.propostaRepository = propostaRepository;
        this.notificacaoRabbitService = notificacaoRabbitService;
        this.exchange = exchange;
    }

    public void buscarPropostasSemIntegracao() {
        propostaRepository.findAllByIntegradaIsFalse().forEach(proposta -> {
            try {
                notificacaoRabbitService.notificar(proposta, exchange);
                proposta.setIntegrada(true);
                propostaRepository.save(proposta);
            } catch (RuntimeException ex) {
                System.out.println(ex);
            }
        });
    }
}

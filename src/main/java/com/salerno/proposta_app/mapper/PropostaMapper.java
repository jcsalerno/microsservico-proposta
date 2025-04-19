package com.salerno.proposta_app.mapper;
import com.salerno.proposta_app.dto.PropostaRequestDto;
import com.salerno.proposta_app.dto.PropostaResponseDto;
import com.salerno.proposta_app.entity.Proposta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PropostaMapper {

    PropostaMapper INSTANCE = Mappers.getMapper(PropostaMapper.class);

    @Mapping(target = "usuario.nome", source = "nome")
    @Mapping(target = "usuario.sobrenome", source = "sobrenome")
    @Mapping(target = "usuario.telefone", source = "telefone")
    @Mapping(target = "usuario.cpf", source = "cpf")
    @Mapping(target = "usuario.renda", source = "renda")
    @Mapping(target = "valorSolicitado", source = "valorSolicitado")
    @Mapping(target = "prazoPagamento", source = "prazoPagamento")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aprovada", ignore = true)
    @Mapping(target = "integrada", constant = "true")
    @Mapping(target = "observacao", ignore = true)
    Proposta convertDtoToProposta(PropostaRequestDto propostaRequestDto);

    @Mapping(target = "nome", source = "usuario.nome")
    @Mapping(target = "sobrenome", source = "usuario.sobrenome")
    @Mapping(target = "telefone", source = "usuario.telefone")
    @Mapping(target = "cpf", source = "usuario.cpf")
    @Mapping(target = "renda", source = "usuario.renda")
    @Mapping(target = "prazoPagamento", source = "prazoPagamento")
    @Mapping(target = "valorSolicitadoFmt", expression = "java(formatCurrency(proposta.getValorSolicitado()))")
    PropostaResponseDto convertEntityToDto(Proposta proposta);

    default String formatCurrency(Double value) {
        try {
            return value != null ? NumberFormat.getCurrencyInstance().format(value) : "";
        } catch (IllegalArgumentException e) {
            return "";
        }
    }

    default List<PropostaResponseDto> convertListEntityToListDto(Iterable<Proposta> propostas) {
        List<PropostaResponseDto> result = new ArrayList<>();
        if (propostas != null) {
            for (Proposta proposta : propostas) {
                result.add(convertEntityToDto(proposta));
            }
        }
        return result;
    }
}
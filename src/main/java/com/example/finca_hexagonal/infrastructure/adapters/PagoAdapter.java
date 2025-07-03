package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.domain.ports.out.PagoModelPort;
import com.example.finca_hexagonal.infrastructure.entities.PagoEntity;
import com.example.finca_hexagonal.infrastructure.mappers.PagoModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaPagoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PagoAdapter implements PagoModelPort {

    private final JpaPagoRepository jpaPagoRepository;
    private final PagoModelMappers pagoMapper;

    public PagoAdapter(JpaPagoRepository jpaPagoRepository, PagoModelMappers pagoMapper) {
        this.jpaPagoRepository = jpaPagoRepository;
        this.pagoMapper = pagoMapper;
    }

    @Override
    public Pago save(Pago pago) {
        PagoEntity entity = pagoMapper.toEntity(pago);
        PagoEntity savedEntity = jpaPagoRepository.save(entity);
        return pagoMapper.toModel(savedEntity);
    }

    @Override
    public List<Pago> FindAll() {
        return jpaPagoRepository.findAll().stream()
                .map(pagoMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pago> findBYId(Long pagoId) {
        return jpaPagoRepository.findById(pagoId)
                .map(pagoMapper::toModel);
    }

    @Override
    public Optional<Pago> updateById(Long pagoId, Pago updatePago) {
        return jpaPagoRepository.findById(pagoId)
                .map(entity -> {
                    entity.setFechaPago(updatePago.getFechaPago());
                    entity.setMontoTotal(updatePago.getMonto());
                    // relaciones como reserva o modoDePago si aplica
                    PagoEntity updated = jpaPagoRepository.save(entity);
                    return pagoMapper.toModel(updated);
                });
    }

    @Override
    public Boolean deletedById(Long pagoId) {
        if (jpaPagoRepository.existsById(pagoId)) {
            jpaPagoRepository.deleteById(pagoId);
            return true;
        }
        return false;
    }
}

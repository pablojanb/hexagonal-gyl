package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.api.MercadoPagoApi;
import com.example.finca_hexagonal.application.dto.pago.PagoRequestDTO;
import com.example.finca_hexagonal.application.dto.pago.PagoResponseDTO;
import com.example.finca_hexagonal.application.services.Pago.PagoService;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;
    private final MercadoPagoApi mercadoPagoApi;

    public PagoController(PagoService pagoService, MercadoPagoApi mercadoPagoApi) {
        this.pagoService = pagoService;
        this.mercadoPagoApi = mercadoPagoApi;
    }

    @PostMapping
    public ResponseEntity<PagoResponseDTO> createPago(@RequestBody PagoRequestDTO dto) throws Exception {
        PagoResponseDTO created = pagoService.save(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @PostMapping("/notificacion")
    public ResponseEntity<Void> recibirNotificacionMercadoPago(@RequestBody Map<String, Object> payload,
                                               @RequestHeader Map<String, String> headers) throws MPException, MPApiException {
        Object dataObj = payload.get("data");
        if (dataObj instanceof Map) {
            Map<String, Object> data = (Map<String, Object>) dataObj;
            Object idObj = data.get("id");

            if (idObj != null) {
                Long paymentId = Long.parseLong(idObj.toString());
        mercadoPagoApi.paymentProcess(paymentId);
            }
        }

        return ResponseEntity.ok().build();
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<PagoResponseDTO>> getAllPagos() throws Exception {
        return new ResponseEntity<>(pagoService.getAllPagos(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PagoResponseDTO> getPagoById(@PathVariable Long id) throws Exception {
        return pagoService.getPagoById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<PagoResponseDTO> updatePago(@PathVariable Long id, @RequestBody PagoRequestDTO dto) {
        return pagoService.updatePago(id, dto)
                .map(updated -> new ResponseEntity<>(updated, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        boolean deleted = pagoService.deletePago(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTORequest;
import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTOResponse;
import com.example.finca_hexagonal.application.services.imagenFinca.ImagenFincaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagenes-finca")
public class ImagenFincaController {

    private final ImagenFincaService imagenFincaService;

    public ImagenFincaController(ImagenFincaService imagenFincaService) {
        this.imagenFincaService = imagenFincaService;
    }

    @PostMapping
    public ResponseEntity<ImagenFincaDTOResponse> createImagenFinca(@RequestBody ImagenFincaDTORequest imagenDto){
        return new ResponseEntity<>(imagenFincaService.createImagen(imagenDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAllImagenFinca")
    public ResponseEntity<List<ImagenFincaDTOResponse>> getAll(){
        return new ResponseEntity<>(imagenFincaService.getAllImagenFinca(), HttpStatus.OK);
    }

    @GetMapping("/getImagenFincaById/{imagenFincaId}")
    public ResponseEntity<List<ImagenFincaDTOResponse>> getImagenFincaById(@PathVariable Long imagenFincaId){
        return new ResponseEntity<>(imagenFincaService.getByFincaId(imagenFincaId), HttpStatus.OK);
    }

    @PutMapping("/updateImagenFinca/{imagenFincaId}")
    public ResponseEntity<ImagenFincaDTOResponse> updateImagenFinca(@PathVariable Long imagenFincaId,
                                                                    @RequestBody ImagenFincaDTORequest updateImagenFinca){
        return imagenFincaService.updateById(imagenFincaId, updateImagenFinca)
                .map(imagenFinca -> new ResponseEntity<>(imagenFinca, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteImagenFinca/{imagenFincaId}")
    public ResponseEntity<Void> deleteImagenFinca(@PathVariable Long imagenFincaId){
        if (imagenFincaService.deleteById(imagenFincaId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

package br.edu.ufersa.pw.totalCare.api.controllers;

import br.edu.ufersa.pw.totalCare.api.dtos.MedicoCreateDTO;
import br.edu.ufersa.pw.totalCare.api.dtos.MedicoDTO;
import br.edu.ufersa.pw.totalCare.domain.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {
    @Autowired
    MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listarMedicos() {
        return ResponseEntity.ok(medicoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> criarMedico(@RequestBody MedicoCreateDTO medicoDTO) {
        return ResponseEntity.ok(medicoService.criarMedico(medicoDTO));
    }
}

package br.edu.ufersa.pw.totalCare.api.controllers;

import br.edu.ufersa.pw.totalCare.api.dtos.MedicoCreateDTO;
import br.edu.ufersa.pw.totalCare.api.dtos.MedicoDTO;
import br.edu.ufersa.pw.totalCare.domain.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> obterMedico(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerMedico(@PathVariable Long id) {
        try{
            medicoService.deletarMedico(id);
            return ResponseEntity.status(HttpStatus.OK).body("Médico deletado com sucesso");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar médico");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> atualizarMedico(@PathVariable Long id, @RequestBody MedicoCreateDTO medicoDTO) {
        medicoDTO.setId(id);

        try {
            MedicoDTO medicoAtualizado = medicoService.atualizarMedico(medicoDTO);
            return ResponseEntity.status(HttpStatus.OK).body(medicoAtualizado);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}

package br.edu.ufersa.pw.totalCare.api.controllers;

import br.edu.ufersa.pw.totalCare.api.dtos.ConsultaCreateDTO;
import br.edu.ufersa.pw.totalCare.api.dtos.ConsultaDTO;
import br.edu.ufersa.pw.totalCare.api.dtos.PacienteDTO;
import br.edu.ufersa.pw.totalCare.domain.entities.Consulta;
import br.edu.ufersa.pw.totalCare.domain.entities.Paciente;
import br.edu.ufersa.pw.totalCare.domain.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> listarConsultas() {
        List<ConsultaDTO> consultas = consultaService.buscarTodos();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> buscarConsultaPorId(@PathVariable Long id) {
        ConsultaDTO consulta = consultaService.buscarPorId(id);

        if (consulta == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(consulta);
    }

    @PostMapping
    public ResponseEntity<ConsultaDTO> criarConsulta(@RequestBody ConsultaCreateDTO consultaDTO) {
        return ResponseEntity.ok(consultaService.criarConsulta(consultaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> atualizarConsulta(@RequestBody ConsultaCreateDTO consultaDTO, @PathVariable Long id) {
        try{
            consultaDTO.setId(id);
            ConsultaDTO consultaAtualizada = consultaService.atualizarConsulta(consultaDTO);
            return ResponseEntity.ok(consultaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ConsultaDTO> deletarConsulta(@PathVariable Long id) {
        ConsultaDTO consulta = consultaService.deletarConsulta(id);

        if (consulta == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(consulta);
    }
}


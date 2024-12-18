package br.edu.ufersa.pw.totalCare.api.controllers;

import br.edu.ufersa.pw.totalCare.api.dtos.PacienteDTO;
import br.edu.ufersa.pw.totalCare.domain.entities.Paciente;
import br.edu.ufersa.pw.totalCare.domain.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/")
    public List<PacienteDTO> buscarTodos() {return pacienteService.buscarTodos();}

    @GetMapping("/{id}")
    public PacienteDTO buscarPorId(@PathVariable Long id) {return pacienteService.buscarPorId(id);}

    @PostMapping("/")
    public ResponseEntity<Paciente> criarPaciente (@RequestBody PacienteDTO pacienteDTO){

        try{
            Paciente pacienteCriado = pacienteService.criarPaciente(pacienteDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@RequestBody PacienteDTO pacienteDTO, @PathVariable Long id){

        // ta meio confuso eu sei --th
        try{
            pacienteDTO.setId(id);
            PacienteDTO responseEntity = pacienteService.atualizarPaciente(pacienteDTO);
            Paciente pacienteAtualizado = new Paciente(responseEntity);

            return ResponseEntity.status(HttpStatus.OK).body(pacienteAtualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPaciente(@PathVariable Long id){

        try{
            pacienteService.deletarPaciente(id);
            return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar paciente");
        }
    }
}

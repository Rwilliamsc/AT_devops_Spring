package edu.br.infnet.q02.controller;

import edu.br.infnet.q02.model.Veiculo;
import edu.br.infnet.q02.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {
    private final VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        return ResponseEntity.ok(veiculoService.listarVeiculos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarVeiculoPorId(@PathVariable Long id) {
        Optional<Veiculo> optVeiculo = veiculoService.buscarVeiculoPorId(id);
        if (optVeiculo.isPresent()) {
            return ResponseEntity.ok(optVeiculo.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> salvarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo savedVeiculo = veiculoService.salvarVeiculo(veiculo);
        return new ResponseEntity<>(savedVeiculo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo){
        Veiculo updatedVeiculo = veiculoService.atualizarVeiculo(id, veiculo);
        return ResponseEntity.ok(updatedVeiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable Long id) {
        veiculoService.excluirVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}

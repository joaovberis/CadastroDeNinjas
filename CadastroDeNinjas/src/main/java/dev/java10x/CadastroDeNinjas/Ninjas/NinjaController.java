package dev.java10x.CadastroDeNinjas.Ninjas;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas () {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome());

    }

    //mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas () {
      List<NinjaDTO> ninjas =  ninjaService.listarNinjas();
      return ResponseEntity.ok(ninjas);
    }

    //mostrar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorPorId (@PathVariable Long id) {

        NinjaDTO ninja = ninjaService.listarNinjasID(id);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + " nao existe nos nossos registros");
        }

    }

    // alterar dados dos ninjas (UPDATE)
    @PutMapping ("/alterar/{id}")
    public ResponseEntity<?>  alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {

        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com esse ID não encontrado");
        }

    }

    //deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String>  deletarNinjaPorId (@PathVariable Long id) {
       if (ninjaService.listarNinjasID(id) != null){
           ninjaService.deletarNinjaPorId(id);
           return ResponseEntity.ok("Ninja com ID = " + id + " Foi deletado com sucesso");
       } else
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("O ID não existe");
    }

}

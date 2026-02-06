package dev.java10x.CadastroDeNinjas.Ninjas;

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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    //mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas () {
        return ninjaService.listarNinjas();
    }

    //mostrar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorPorId (@PathVariable Long id) {
        return ninjaService.listarNinjasID(id);
    }

    // alterar dados dos ninjas (UPDATE)
    @PutMapping ("/alterar")
    public String alterarNinjaPorId() {

        return "Alterar Ninja por id";

    }

    //deletar ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId () {

        return "Ninja deletado por id";
    }

}

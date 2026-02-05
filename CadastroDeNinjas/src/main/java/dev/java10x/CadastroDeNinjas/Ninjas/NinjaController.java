package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas () {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    //mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas () {

        return "Ninjas";

    }

    //mostrar ninja por id (READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId () {

        return "NinjasID";

    }

    // alterar dados dos ninjas (UPDATE)
    @PutMapping String alterarNinjaPorId() {

        return "Alterar Ninja por id";

    }

    //deletar ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId () {

        return "Ninja deletado por id";
    }

}

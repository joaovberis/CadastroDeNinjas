package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // GET -- mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissao () {

        return "Missoes Listadas com sucesso";

    }

    // POST -- Mandar uma requisicao para criar uma missao
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao Criada com sucesso";
    }

    // PUT -- Criar uma requisicao para alterar missao
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "missao deletada cm sucesso";
    }

    // DELETE -- Criar uma requisicao para deletar missao
    @DeleteMapping("/deletar")
    public String deletarMissao() {

        return "missao deletada com sucesso";

    }


}

package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET -- mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // POST -- Mandar uma requisicao para criar uma missao
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        return missoesService.criarMissao(missao);
    }

    // PUT -- Criar uma requisicao para alterar missao
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "missao deletada cm sucesso";
    }

    // DELETE -- Criar uma requisicao para deletar missao
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPoId(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }


}

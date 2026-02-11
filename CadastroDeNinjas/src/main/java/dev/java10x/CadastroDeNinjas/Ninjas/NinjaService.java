package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // LISTAR TODOS OS MEUS NINJAS
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // LISTAR TODOS NINJAS POR ID
    public NinjaModel listarNinjasID(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // CRIAR UM NOVO NINJA
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // DELETAR O NINJA - TEM QUE SER UM METODO VOID
    public void deletarNinjaPorId(long id) {
       ninjaRepository.deleteById(id);
    }
}

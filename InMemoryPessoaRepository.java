package necessidades.application;

import necessidades.domain.entity.Pessoa;
import necessidades.domain.repository.PessoaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryPessoaRepository implements PessoaRepository {
    private List<Pessoa> pessoas = new ArrayList<>();

    @Override
    public void salvar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    @Override
    public List<Pessoa> listarTodos() {
        return pessoas;
    }

    @Override
    public List<Pessoa> filtrarPorTipoEGrau(String tipo, String grau) {
        return pessoas.stream()
                .filter(p -> p.getTipoDeficiencia().equalsIgnoreCase(tipo)
                        && p.getGrau().equalsIgnoreCase(grau))
                .collect(Collectors.toList());
    }
}

package necessidades.domain.repository;

import necessidades.domain.entity.Pessoa;
import java.util.List;

public interface PessoaRepository {
    void salvar(Pessoa pessoa);
    List<Pessoa> listarTodos();
    List<Pessoa> filtrarPorTipoEGrau(String tipo, String grau);
}

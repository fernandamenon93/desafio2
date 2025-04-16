package necessidades.main;

import necessidades.application.InMemoryPessoaRepository;
import necessidades.domain.entity.Atendimento;
import necessidades.domain.entity.Pessoa;
import necessidades.domain.repository.PessoaRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PessoaRepository repo = new InMemoryPessoaRepository();

        Pessoa p1 = new Pessoa("Lucas", 30, "Auditiva", "Moderado", "Rua A");
        Pessoa p2 = new Pessoa("Juliana", 27, "Visual", "Leve", "Rua B");

        Atendimento a1 = new Atendimento(LocalDate.now(), "Fisioterapia", "Dra. Ana");
        Atendimento a2 = new Atendimento(LocalDate.now(), "Psicologia", "Dr. João");

        p1.adicionarAtendimento(a1);
        p2.adicionarAtendimento(a2);

        repo.salvar(p1);
        repo.salvar(p2);

        System.out.println("=== Relatório ===");
        for (Pessoa pessoa : repo.listarTodos()) {
            System.out.println(pessoa.getNome());
            for (Atendimento at : pessoa.getAtendimentos()) {
                System.out.println("  -> " + at);
            }
        }

        System.out.println("\n=== Filtro: Visual + Leve ===");
        List<Pessoa> filtradas = repo.filtrarPorTipoEGrau("Visual", "Leve");
        for (Pessoa p : filtradas) {
            System.out.println(p.getNome());
        }
    }
}

package necessidades.test;

import necessidades.domain.entity.Atendimento;
import necessidades.domain.entity.Pessoa;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

    @Test
    public void deveAdicionarAtendimento() {
        Pessoa p = new Pessoa("Maria", 28, "Física", "Severo", "Rua X");
        Atendimento a = new Atendimento(LocalDate.now(), "Terapia", "Dra. Luana");

        p.adicionarAtendimento(a);

        assertEquals(1, p.getAtendimentos().size());
    }
}

package org.iftm.atividadea2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    @Test
    void deveCalcularPagamentoCorreto() {
        Funcionario f = new Funcionario("João", 100, 20.00);
        assertEquals(2000.0, f.calcularPagamento());
    }

    @Test
    void deveAceitarValorHoraMinimoPermitido() {
        Funcionario f = new Funcionario("João", 100, 15.18);
        assertEquals(1518.00, f.calcularPagamento(), 0.01);
    }

    @Test
    void deveLancarErroParaHorasAbaixoDoPermitido() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario("Maria", 10, 20.0);
        });
        assertEquals("Horas devem estar entre 20h e 160h mensais.", e.getMessage());
    }

    @Test
    void deveLancarErroParaValorHoraAcimaDoPermitido() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario("Carlos", 40, 200.0);
        });
        assertEquals("Valor por hora deve estar entre 1% e 10% do salário mínimo.", e.getMessage());
    }

    @Test
    void deveLancarErroParaPagamentoAbaixoDoMinimo() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario("Pedro", 20, 15.18); // 303.6
        });
        assertEquals("Pagamento deve estar entre R$1518,00 e R$10000,00.", e.getMessage());
    }

    @Test
    void deveLancarErroParaPagamentoAcimaDoMaximo() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario("Rico", 160, 80); // 12800
        });
        assertEquals("Pagamento deve estar entre R$1518,00 e R$10000,00.", e.getMessage());
    }
}

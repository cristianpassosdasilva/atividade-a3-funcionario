package org.iftm.atividadea2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTerceirizadoTest {

    @Test
    void deveCalcularPagamentoComBonus() {
        FuncionarioTerceirizado f = new FuncionarioTerceirizado("Terceiro", 100, 20.0, 500);
        assertEquals(2000 + 550, f.calcularPagamento(), 0.01);
    }

    @Test
    void deveLancarErroParaDespesaAcimaDoPermitido() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new FuncionarioTerceirizado("Carlos", 100, 20.0, 2000);
        });
        assertEquals("Despesa adicional deve ser entre 0 e 1000 reais.", e.getMessage());
    }

    @Test
    void deveLancarErroParaPagamentoComBonusAcimaDoTeto() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new FuncionarioTerceirizado("Rico", 160, 60.0, 1000); // base = 9600, bonus = 1100 → total = 10700
        });
        assertEquals("Pagamento com bônus fora dos limites permitidos.", e.getMessage());
    }

    @Test
    void deveAceitarPagamentoMaximoPermitido() {
        FuncionarioTerceirizado f = new FuncionarioTerceirizado("Limite", 160, 50.0, 500); // base = 8000, bonus = 550 = 8550
        assertEquals(8550.0, f.calcularPagamento(), 0.01);
    }
}

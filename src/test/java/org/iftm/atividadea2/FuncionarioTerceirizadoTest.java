package org.iftm.atividadea2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.iftm.atividadea2.FuncionarioTerceirizado;

public class FuncionarioTerceirizadoTest {

    @Test
    void deveCalcularPagamentoComBonus() {
        FuncionarioTerceirizado f = new FuncionarioTerceirizado("Ana", 25, 100, 500);
        assertEquals(2500 + 550, f.calcularPagamento());
    }

    @Test
    void deveLancarErroDespesaInvalida() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new FuncionarioTerceirizado("Ana", 25, 100,  2000);
        });
        assertEquals("Despesa adicional deve ser entre 0 e 1000 reais.", e.getMessage());
    }

    @Test
    void deveLancarErroPagamentoAcimaDoTeto() throws Exception {
        // Inicializa com valores válidos
        FuncionarioTerceirizado f = new FuncionarioTerceirizado("Rico", 40, 151.80, 1000);

        // Usa reflection para forçar um valor ilegal
        java.lang.reflect.Field field = FuncionarioTerceirizado.class.getDeclaredField("despesaAdicional");
        field.setAccessible(true);
        field.set(f, 90000.0); // agora bônus = 99.000 → total = ~105.000

        Exception e = assertThrows(IllegalArgumentException.class, f::calcularPagamento);
        assertEquals("Pagamento com bônus fora dos limites permitidos.", e.getMessage());
    }

}

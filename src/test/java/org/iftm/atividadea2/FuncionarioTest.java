package org.iftm.atividadea2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    @Test
    void deveCalcularPagamentoValido() {
        Funcionario f = new Funcionario("Carlos", 30, 100);
        assertEquals(3000, f.calcularPagamento());
    }

    @Test
    void deveLancarErroHorasMenorQue20() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario("Carlos", 10, 100);
        });
        assertEquals("Horas trabalhadas devem estar entre 20 e 40.", e.getMessage());
    }

    @Test
    void deveLancarErroValorHoraInvalido() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario("Carlos", 30, 20);
        });
        assertEquals("Valor por hora deve estar entre 4% e 10% do salário mínimo.", e.getMessage());
    }
}

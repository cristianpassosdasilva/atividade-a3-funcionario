package org.iftm.atividadea2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora(3);
    }

    @Test
    void testConstrutorComValorPositivo() {
        Calculadora calc = new Calculadora(3);
        assertEquals(3, calc.getMemoria());
    }

    @Test
    void testConstrutorComValorNegativo() {
        Calculadora calc = new Calculadora(-3);
        assertEquals(-3, calc.getMemoria());
    }

    @Test
    void testSomarNumeroPositivo() {
        calculadora.somar(5);
        assertEquals(8, calculadora.getMemoria());
    }

    @Test
    void testSomarNumeroNegativo() {
        calculadora.somar(-2);
        assertEquals(1, calculadora.getMemoria());
    }

    @Test
    void testSubtrairNumeroPositivo() {
        calculadora.subtrair(2);
        assertEquals(1, calculadora.getMemoria());
    }

    @Test
    void testSubtrairNumeroNegativo() {
        calculadora.subtrair(-2);
        assertEquals(5, calculadora.getMemoria());
    }

    @Test
    void testMultiplicarNumeroPositivo() {
        calculadora.multiplicar(2);
        assertEquals(6, calculadora.getMemoria());
    }

    @Test
    void testMultiplicarNumeroNegativo() {
        calculadora.multiplicar(-2);
        assertEquals(-6, calculadora.getMemoria());
    }

    @Test
    void testDividirPorZero() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculadora.dividir(0);
        });
        assertEquals("Divisão por zero!!!", exception.getMessage());
    }

    @Test
    void testDividirPorPositivo() throws Exception {
        calculadora.dividir(3);
        assertEquals(1, calculadora.getMemoria());
    }

    @Test
    void testDividirPorNegativo() throws Exception {
        calculadora.dividir(-3);
        assertEquals(-1, calculadora.getMemoria());
    }

    @Test
    void testExponenciarPor1() throws Exception {
        calculadora.exponenciar(1);
        assertEquals(3, calculadora.getMemoria());
    }

    @Test
    void testExponenciarPor10() throws Exception {
        calculadora.exponenciar(10);
        assertEquals(59049, calculadora.getMemoria());
    }

    @Test
    void testExponenciarPor20() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculadora.exponenciar(20);
        });
        assertEquals("Expoente incorreto, valor máximo é 10.", exception.getMessage());
    }

    @Test
    void testZerarMemoria() {
        calculadora.zerarMemoria();
        assertEquals(0, calculadora.getMemoria());
    }
}

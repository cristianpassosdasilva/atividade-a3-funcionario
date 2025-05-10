package org.iftm.atividadea2;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private double valorHora;

    private static final double SALARIO_MINIMO = 1518.00;

    public Funcionario(String nome, int horasTrabalhadas, double valorHora) {
        validarHoras(horasTrabalhadas);
        validarValorHora(valorHora);

        double pagamento = horasTrabalhadas * valorHora;
        if (pagamento < SALARIO_MINIMO || pagamento > 10000.00) {
            throw new IllegalArgumentException("Pagamento deve estar entre R$1518,00 e R$10000,00.");
        }

        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    protected void validarHoras(int horas) {
        if (horas < 20 || horas > 160) {
            throw new IllegalArgumentException("Horas devem estar entre 20h e 160h mensais.");
        }
    }

    protected void validarValorHora(double valor) {
        if (valor < 15.18 || valor > 151.80) {
            throw new IllegalArgumentException("Valor por hora deve estar entre 1% e 10% do salário mínimo.");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public double calcularPagamento() {
        return horasTrabalhadas * valorHora;
    }
}

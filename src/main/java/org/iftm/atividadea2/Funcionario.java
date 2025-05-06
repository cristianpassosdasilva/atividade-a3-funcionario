package org.iftm.atividadea2;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private double valorHora;

    public static final double SALARIO_MINIMO = 1518.00;
    public static final double TETO_SALARIAL = 100000.00;

    public Funcionario(String nome, int horasTrabalhadas, double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = validaHorasTrabalhadas(horasTrabalhadas);
        this.valorHora = validaValorHora(valorHora);
    }

    private int validaHorasTrabalhadas(int horas) {
        if (horas < 20 || horas > 40) {
            throw new IllegalArgumentException("Horas trabalhadas devem estar entre 20 e 40.");
        }
        return horas;
    }

    private double validaValorHora(double valor) {
        double min = SALARIO_MINIMO * 0.04;
        double max = SALARIO_MINIMO * 0.10;
        if (valor < min || valor > max) {
            throw new IllegalArgumentException("Valor por hora deve estar entre 4% e 10% do salário mínimo.");
        }
        return valor;
    }

    public double calcularPagamento() {
        double pagamento = valorHora * horasTrabalhadas;
        if (pagamento < SALARIO_MINIMO || pagamento > TETO_SALARIAL) {
            throw new IllegalArgumentException("Pagamento fora dos limites permitidos.");
        }
        return pagamento;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = validaHorasTrabalhadas(horasTrabalhadas);
    }

    public void setValorHora(double valorHora) {
        this.valorHora = validaValorHora(valorHora);
    }
}
package org.iftm.atividadea2;

public class FuncionarioTerceirizado extends Funcionario {
    private double despesaAdicional;

    public FuncionarioTerceirizado(String nome, int horasTrabalhadas, double valorHora, double despesaAdicional) {
        super(nome, horasTrabalhadas, valorHora);
        this.despesaAdicional = validaDespesaAdicional(despesaAdicional);
    }

    private double validaDespesaAdicional(double valor) {
        if (valor < 0 || valor > 1000) {
            throw new IllegalArgumentException("Despesa adicional deve ser entre 0 e 1000 reais.");
        }
        return valor;
    }

    @Override
    public double calcularPagamento() {
        double pagamentoBase = super.calcularPagamento();
        double bonus = despesaAdicional * 1.1;
        double total = pagamentoBase + bonus;
        if (total < SALARIO_MINIMO || total > TETO_SALARIAL) {
            throw new IllegalArgumentException("Pagamento com bônus fora dos limites permitidos.");
        }
        return total;
    }

    public void setDespesaAdicional(double despesaAdicional) {
        this.despesaAdicional = validaDespesaAdicional(despesaAdicional);
    }
}
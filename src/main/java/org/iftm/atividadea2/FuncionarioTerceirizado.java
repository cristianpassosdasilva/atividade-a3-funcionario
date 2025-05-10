package org.iftm.atividadea2;

public class FuncionarioTerceirizado extends Funcionario {
    private double despesaAdicional;

    public FuncionarioTerceirizado(String nome, int horasTrabalhadas, double valorHora, double despesaAdicional) {
        super(nome, horasTrabalhadas, valorHora);
        validarDespesa(despesaAdicional);

        double pagamentoBase = super.calcularPagamento();
        double bonus = despesaAdicional * 1.10;
        double totalPagamento = pagamentoBase + bonus;

        if (totalPagamento < 1518.00 || totalPagamento > 10000.00) {
            throw new IllegalArgumentException("Pagamento com bônus fora dos limites permitidos.");
        }

        this.despesaAdicional = despesaAdicional;
    }

    private void validarDespesa(double despesa) {
        if (despesa < 0 || despesa > 1000.00) {
            throw new IllegalArgumentException("Despesa adicional deve ser entre 0 e 1000 reais.");
        }
    }

    public double getDespesaAdicional() {
        return despesaAdicional;
    }

    @Override
    public double calcularPagamento() {
        return super.calcularPagamento() + (despesaAdicional * 1.10);
    }
}

package br.traba.caixaeletronico;

public interface ICaixaEletronico {

	public String pegaValorTotalDisponivel();

	public String sacar(Integer valor);

	public String pegaRelatorioCedulas();

	public String reposicaoCedulas(Integer cedulas, Integer quantidade);

	public String armazenaCotaMinima(Integer minimo);

}

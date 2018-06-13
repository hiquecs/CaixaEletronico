package br.traba.caixaeletronico;

import br.traba.daocaixaeletronico.DAOCaixaEletronico;

public class Caixa {
	DAOCaixaEletronico nota = new DAOCaixaEletronico();

	private Integer cedulas[] = new Integer[6];
	private Integer cotaMinima;
	private Integer valorTotal;
	private String  extrato;

	public Caixa() {

		cedulas[5] = nota.atualizaNota(5);
		cedulas[4] = nota.atualizaNota(4);
		cedulas[3] = nota.atualizaNota(3);
		cedulas[2] = nota.atualizaNota(2);
		cedulas[1] = nota.atualizaNota(1);
		cedulas[0] = nota.atualizaNota(0);

		valorTotal = (cedulas[5] * 100) + (cedulas[4] * 50) + (cedulas[3] * 20) + (cedulas[2] * 10) + (cedulas[1] * 5)
				+ (cedulas[0] * 2);
		cotaMinima = nota.cotaMinima();
	}

	public Integer getCedulas(Integer a) {

		if (a == 5) {
			return cedulas[5];
		} else if (a == 4) {
			return cedulas[4];
		} else if (a == 3) {
			return cedulas[3];
		} else if (a == 2) {
			return cedulas[2];
		} else if (a == 1) {
			return cedulas[1];
		} else {
			return cedulas[0];
		}
	}

	public void setCedulas(Integer a, Integer cedula) {

		if (a == 5) {
			cedulas[5] = cedula;
		} else if (a == 4) {
			cedulas[4] = cedula;
		} else if (a == 3) {
			cedulas[3] = cedula;
		} else if (a == 2) {
			cedulas[2] = cedula;
		} else if (a == 1) {
			cedulas[1] = cedula;
		} else {
			cedulas[0] = cedula;
		}
	}

	public Integer getCotaMinima() {
		return cotaMinima;
	}

	public void setCotaMinima(Integer cotaMinima) {
		this.cotaMinima = cotaMinima;
	}

	public Integer getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getExtrato() {
		return extrato;
	}

	public void setExtrato(String extrato) {
		this.extrato = extrato;
	}
    public String toString() {
		
		return extrato;
	}


}

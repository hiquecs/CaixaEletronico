package br.traba.caixaeletronico;

import br.traba.daocaixaeletronico.DAOCaixaEletronico;

public class CaixaEletronico implements ICaixaEletronico {

	public CaixaEletronico() {

	}

	Caixa caixa = new Caixa();
	DAOCaixaEletronico caixa2 = new DAOCaixaEletronico();

	@Override
	public String pegaValorTotalDisponivel() {
		String valor;
		caixa2.extratoAdd("Valor total Disponivel Consultado");
		valor = "" + ((caixa2.atualizaNota(5)*100) + (caixa2.atualizaNota(4)*50) + (caixa2.atualizaNota(3)*20) + (caixa2.atualizaNota(2)*10)
				+ (caixa2.atualizaNota(1)*5) + (caixa2.atualizaNota(0)*2));
		return valor;
	}

	@Override
	public String sacar(Integer valor) {
		Integer cem, cinquenta, vinte, dez, cinco, dois, resto, cont;
		cem = valor / 100;
		cinquenta = (valor % 100) / 50;
		vinte = ((valor % 100) % 50) / 20;
		dez = (((valor % 100) % 50) % 20) / 10;
		cinco = ((((valor % 100) % 50) % 20) % 10) / 5;
		dois = (((((valor % 100) % 50) % 20) % 10) % 5) / 2;
		resto = (((((valor % 100) % 50) % 20) % 10) % 5) % 2;

		if (caixa.getCedulas(5) < cem) {
			cem = caixa.getCedulas(5);
			caixa.setCedulas(5, 0);
			valor -= cem * 100;
			cinquenta = valor / 50;
			vinte = (valor % 50) / 20;
			dez = ((valor % 50) % 20) / 10;
			cinco = (((valor % 50) % 20) % 10) / 5;
			dois = ((((valor % 50) % 20) % 10) % 5) / 2;
			resto = ((((valor % 50) % 20) % 10) % 5) % 2;
		}

		if (caixa.getCedulas(4) < cinquenta) {
			cinquenta = caixa.getCedulas(4);
			caixa.setCedulas(4, 0);
			valor -= cinquenta * 50;
			vinte = valor / 20;
			dez = (valor % 20) / 10;
			cinco = ((valor % 20) % 10) / 5;
			dois = (((valor % 20) % 10) % 5) / 2;
			resto = (((valor % 20) % 10) % 5) % 2;

		}
		cont = cem + cinquenta + vinte + dez + cinco + dois;
		if (caixa.getCotaMinima() > caixa.getValorTotal()) {
			String a = "\n\n\n\n          Caixa Vazio:\n                 Chame o operador";
			return a;
		} else if (resto == 0 && caixa.getValorTotal() > valor && cont <= 30) {

			caixa2.atualizaNota(5, caixa.getCedulas(5) - cem);
			caixa2.atualizaNota(4, caixa.getCedulas(4) - cinquenta);
			caixa2.atualizaNota(3, caixa.getCedulas(3) - vinte);
			caixa2.atualizaNota(2, caixa.getCedulas(2) - dez);
			caixa2.atualizaNota(1, caixa.getCedulas(1) - cinco);
			caixa2.atualizaNota(0, caixa.getCedulas(0) - dois);
			
			caixa2.extratoAdd("Saque no valor "+valor+" Realizado ");

			String c = "       Saque Realizado com sucesso\n Notas de Cem = " + cem + "\n Notas de Cinquenta = "
					+ cinquenta + "" + "\n Notas de Vinte = " + vinte + "\n Notas de Dez = " + dez
					+ "\n Notas de Cinco = " + cinco + "\n Notas de Dois = " + dois + "\n Valor Total = " + valor;
			return c;
		} else {
			if (cinco >= 1) {
				cinco -= 1;
				dois += 2;
				resto += 1;
				dois = ((dois * 2) + resto) / 2;
				resto = ((dois * 2) + resto) % 2;
			} else if (dez >= 1) {
				dez -= 1;
				cinco += 1;
				dois += 2;
				resto += 1;
				dois = ((dois * 2) + resto) / 2;
				resto = ((dois * 2) + resto) % 2;

			} else if (vinte >= 1) {
				vinte -= 1;
				dez += 1;
				cinco += 1;
				dois += 2;
				resto += 1;
				dois = ((dois * 2) + resto) / 2;
				resto = ((dois * 2) + resto) % 2;

			} else if (cinquenta >= 1) {
				cinquenta -= 1;
				vinte += 2;
				cinco += 1;
				dois += 2;
				resto += 1;
				dois = ((dois * 2) + resto) / 2;
				resto = ((dois * 2) + resto) % 2;

			} else if (cem >= 1) {
				cem -= 1;
				cinquenta += 1;
				vinte += 2;
				cinco += 1;
				dois += 2;
				resto += 1;
				dois = ((dois * 2) + resto) / 2;
				resto = ((dois * 2) + resto) % 2;
			}

		}

		cont = cem + cinquenta + vinte + dez + cinco + dois;
		if (resto == 0 && caixa.getValorTotal() > valor && cont <= 30 && valor != 1 && valor != 3) {

			caixa2.atualizaNota(5, caixa.getCedulas(5) - cem);
			caixa2.atualizaNota(4, caixa.getCedulas(4) - cinquenta);
			caixa2.atualizaNota(3, caixa.getCedulas(3) - vinte);
			caixa2.atualizaNota(2, caixa.getCedulas(2) - dez);
			caixa2.atualizaNota(1, caixa.getCedulas(1) - cinco);
			caixa2.atualizaNota(0, caixa.getCedulas(0) - dois);
			caixa2.extratoAdd("Saque no valor "+valor+" Realizado ");

			String c = "       Saque Realizado com sucesso\n Notas de Cem = " + cem + "\n Notas de Cinquenta = "
					+ cinquenta + "" + "\n Notas de Vinte = " + vinte + "\n Notas de Dez = " + dez
					+ "\n Notas de Cinco = " + cinco + "\n Notas de Dois = " + dois + "\n Valor Total = " + valor;
			return c;
		} else {
			String b = "\n\n\n\nNotas Indisponiveis Para este Saque";
			return b;
		}
	}

	@Override
	public String pegaRelatorioCedulas() {
		String cem, cinquenta, vinte, dez, cinco, dois, relat;

		cem = " Cedula Cem Reais: " + caixa2.atualizaNota(5);
		cinquenta = "\n Cedula Cinquenta Reais: " + caixa2.atualizaNota(4);
		vinte = "\n Cedula Vinte Reais: " + caixa2.atualizaNota(3);
		dez = "\n Cedula Dez Reais: " + caixa2.atualizaNota(2);
		cinco = "\n Cedula Cinco Reais: " + caixa2.atualizaNota(1);
		dois = "\n Cedula Dois Reais: " + caixa2.atualizaNota(0);
		relat = "\n\n" + cem + cinquenta + vinte + dez + cinco + dois;
		caixa2.extratoAdd("Relatorio de notas Consultado ");

		return relat;
	}

	@Override
	public String reposicaoCedulas(Integer cedulas, Integer quantidade) {
		String nota;
		if (cedulas == 100) {
			cedulas = 5;
			nota = "100";
		} else if (cedulas == 50) {
			cedulas = 4;
			nota = "50";
		} else if (cedulas == 20) {
			cedulas = 3;
			nota = "20";
		} else if (cedulas == 10) {
			cedulas = 2;
			nota = "10";
		} else if (cedulas == 5) {
			cedulas = 1;
			nota = "5";
		} else {
			cedulas = 0;
			nota = "2";
		}
		caixa2.atualizaNota(cedulas, quantidade);
		caixa2.extratoAdd("Reposição de notas R$ "+nota+" abastecido com "+quantidade+" Notas");
		String a = "Reposição de cedulas R$ " + nota + "\nFoi Executada Com Sucesso !\n";
		return a;
	}

	@Override
	public String armazenaCotaMinima(Integer minimo) {
		caixa2.cotaMinima(minimo);
		caixa.setCotaMinima(minimo);
		caixa2.extratoAdd("Cota Minima no valor "+minimo+" gravada no sistema ");
		String a = "\n\n\n\n            Cota Minima R$: " + caixa2.cotaMinima()
		+ "\n            Gravada Com Sucesso!!";
		return a;
	}

	public String deposito(Integer quantidade) {
		String a = "\n\n\n\n          Valor impossibilitado\n                 Para deposito";
		String b = "\n\n\n\n     Valor Depositado com Sucesso";
		Integer cem, cinquenta, vinte, dez, cinco, dois, resto;
		cem = quantidade / 100;
		cinquenta = (quantidade % 100) / 50;
		vinte = ((quantidade % 100) % 50) / 20;
		dez = (((quantidade % 100) % 50) % 20) / 10;
		cinco = ((((quantidade % 100) % 50) % 20) % 10) / 5;
		dois = (((((quantidade % 100) % 50) % 20) % 10) % 5) / 2;
		resto = (((((quantidade % 100) % 50) % 20) % 10) % 5) % 2;
		if (resto == 0) {
			caixa2.atualizaNota(5,(caixa.getCedulas(5) + cem));
			caixa2.atualizaNota(4,(caixa.getCedulas(4) + cinquenta));
			caixa2.atualizaNota(3,(caixa.getCedulas(3) + vinte));
			caixa2.atualizaNota(2,(caixa.getCedulas(2) + dez));
			caixa2.atualizaNota(1,(caixa.getCedulas(1) + cinco));
			caixa2.atualizaNota(0,(caixa.getCedulas(0) + dois));
			caixa2.extratoAdd("Deposito no valor "+quantidade+" Realizado ");
			return b;
		} else {
			if (cinco >= 1) {
				cinco -= 1;
				dois += 2;
				resto += 1;
				dois = ((dois * 2) + resto) / 2;
				resto = ((dois * 2) + resto) % 2;
			} else if (dez >= 1) {
				dez -= 1;
				cinco += 1;
				dois += 2;
				resto += 1;
				dois = ((dois * 2) + resto) / 2;
				resto = ((dois * 2) + resto) % 2;

			} else if (vinte >= 1) {
				vinte -= 1;
				dez += 1;
				cinco += 1;
				dois += 2;
				resto += 1;
				dois = ((dois * 2) + resto) / 2;
				resto = ((dois * 2) + resto) % 2;

			} else if (cinquenta >= 1) {
				cinquenta -= 1;
				vinte += 2;
				cinco += 1;
				dois += 2;
				resto += 1;
				dois = ((dois * 2) + resto) / 2;
				resto = ((dois * 2) + resto) % 2;

			} else if (cem >= 1) {
				cem -= 1;
				cinquenta += 1;
				vinte += 2;
				cinco += 1;
				dois += 2;
				resto += 1;
				dois = ((dois * 2) + resto) / 2;
				resto = ((dois * 2) + resto) % 2;
			}
			if (resto == 0) {
				caixa2.atualizaNota(5,(caixa.getCedulas(5) + cem));
				caixa2.atualizaNota(4,(caixa.getCedulas(4) + cinquenta));
				caixa2.atualizaNota(3,(caixa.getCedulas(3) + vinte));
				caixa2.atualizaNota(2,(caixa.getCedulas(2) + dez));
				caixa2.atualizaNota(1,(caixa.getCedulas(1) + cinco));
				caixa2.atualizaNota(0,(caixa.getCedulas(0) + dois));
				caixa2.extratoAdd("Deposito no valor "+quantidade+" Realizado ");
				return b;
			}

		}

		return a;
	}
}

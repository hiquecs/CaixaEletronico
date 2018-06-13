package br.traba.guicaixaeletronico;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.traba.caixaeletronico.Caixa;
import br.traba.caixaeletronico.CaixaEletronico;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUICaixaEletronicoTecnico extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField entrada;
	private JPanel contentPanel = new JPanel();
	CaixaEletronico caixa = new CaixaEletronico();
	Caixa caixa1 = new Caixa();
	GUIReposicaoNotas repo = new GUIReposicaoNotas();

	public GUICaixaEletronicoTecnico() {

		setModal(true);
		setUndecorated(true);
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolKit.getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		getContentPane().setBackground(Color.RED);
		getContentPane().setLayout(null);
		contentPanel = new JPanel();
		contentPanel.setForeground(new Color(0, 0, 128));
		contentPanel.setBackground(new Color(0, 0, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setSize(900, 200);
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JTextArea tela = new JTextArea();
		tela.setEditable(false);
		tela.setFont(new Font("Cambria", Font.BOLD, 25));
		tela.setForeground(new Color(0, 255, 0));
		tela.setBackground(Color.BLACK);
		tela.setBounds(327, 223, 416, 306);
		tela.setText("\n\n                      Bem vindo\n\n" + "                   a area Tecnica\n\n"
				+ "                Escolha o serviço:");
		contentPanel.add(tela);
		JButton relatorioNotas = new JButton("Relatorio De Cedulas");
		relatorioNotas.setForeground(new Color(0, 0, 255));
		relatorioNotas.setBackground(SystemColor.activeCaption);
		relatorioNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tela.setText(caixa.pegaRelatorioCedulas());
			}
		});
		relatorioNotas.setFont(new Font("Cambria", Font.BOLD, 13));
		relatorioNotas.setBounds(158, 223, 159, 136);
		contentPanel.add(relatorioNotas);

		JButton valorDisponivel = new JButton("Valor Total Disponivel");
		valorDisponivel.setForeground(new Color(0, 0, 255));
		valorDisponivel.setBackground(SystemColor.activeCaption);
		valorDisponivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText("\n\n\n\n           Valor Total Disponivel\n            R$: "
						+ caixa.pegaValorTotalDisponivel());
			}
		});
		valorDisponivel.setFont(new Font("Cambria", Font.BOLD, 12));
		valorDisponivel.setBounds(158, 393, 159, 136);
		contentPanel.add(valorDisponivel);

		JButton numero4 = new JButton("4");
		numero4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numero = entrada.getText();
				entrada.setText(numero + "4");
			}
		});
		numero4.setForeground(new Color(0, 0, 255));
		numero4.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero4.setBounds(347, 589, 89, 43);
		contentPanel.add(numero4);

		JButton numero7 = new JButton("7");
		numero7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "7");
			}
		});
		numero7.setForeground(new Color(0, 0, 255));
		numero7.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero7.setBounds(347, 638, 89, 43);
		contentPanel.add(numero7);

		JButton asterisco = new JButton("*");
		asterisco.setForeground(new Color(0, 0, 255));
		asterisco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "*");
			}
		});
		asterisco.setFont(new Font("Tahoma", Font.BOLD, 45));
		asterisco.setBounds(347, 688, 89, 43);
		contentPanel.add(asterisco);

		JButton numero5 = new JButton("5");
		numero5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "5");
			}
		});
		numero5.setForeground(new Color(0, 0, 255));
		numero5.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero5.setBounds(443, 589, 89, 43);
		contentPanel.add(numero5);

		JButton numero9 = new JButton("9");
		numero9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "9");
			}
		});
		numero9.setForeground(new Color(0, 0, 255));
		numero9.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero9.setBounds(541, 638, 89, 43);
		contentPanel.add(numero9);

		JButton numero8 = new JButton("8");
		numero8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "8");
			}
		});
		numero8.setForeground(new Color(0, 0, 255));
		numero8.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero8.setBounds(443, 638, 89, 43);
		contentPanel.add(numero8);

		JButton numero0 = new JButton("0");
		numero0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "0");
			}
		});
		numero0.setForeground(new Color(0, 0, 255));
		numero0.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero0.setBounds(443, 688, 89, 43);
		contentPanel.add(numero0);

		JButton numero6 = new JButton("6");
		numero6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "6");
			}
		});
		numero6.setForeground(new Color(0, 0, 255));
		numero6.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero6.setBounds(541, 589, 89, 43);
		contentPanel.add(numero6);

		JButton sustenido = new JButton("#");
		sustenido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "#");
			}
		});
		sustenido.setForeground(new Color(0, 0, 255));
		sustenido.setFont(new Font("Tahoma", Font.BOLD, 30));
		sustenido.setBounds(541, 688, 89, 43);
		contentPanel.add(sustenido);

		JButton numero1 = new JButton("1");
		numero1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "1");

			}
		});
		numero1.setForeground(new Color(0, 0, 255));
		numero1.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero1.setBounds(347, 540, 89, 43);
		contentPanel.add(numero1);

		JButton numero2 = new JButton("2");
		numero2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "2");
			}
		});
		numero2.setForeground(new Color(0, 0, 255));
		numero2.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero2.setBounds(443, 540, 89, 43);
		contentPanel.add(numero2);

		JButton numero3 = new JButton("3");
		numero3.setForeground(new Color(0, 0, 255));
		numero3.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numero = entrada.getText();
				entrada.setText(numero + "3");
			}
		});
		numero3.setBounds(541, 540, 89, 43);
		contentPanel.add(numero3);
		entrada = new JTextField();
		entrada.setForeground(new Color(0, 255, 0));
		entrada.setBackground(new Color(0, 0, 0));
		entrada.setFont(new Font("Tahoma", Font.PLAIN, 22));
		entrada.setBounds(394, 458, 283, 36);
		contentPanel.add(entrada);
		entrada.setColumns(10);
		entrada.setHorizontalAlignment(JTextField.RIGHT);

		JButton reporCedulas = new JButton("Reposi\u00E7ao de Cedulas");
		reporCedulas.setForeground(new Color(0, 0, 255));
		reporCedulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repo.setVisible(true);
			

			}
		});
		reporCedulas.setFont(new Font("Cambria", Font.BOLD, 12));
		reporCedulas.setBackground(SystemColor.activeCaption);
		reporCedulas.setBounds(753, 223, 159, 136);
		contentPanel.add(reporCedulas);

		JButton btnRelatorioDeCedulas = new JButton("Cota Minima");
		btnRelatorioDeCedulas.setForeground(new Color(0, 0, 255));
		btnRelatorioDeCedulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText("\n\n\n\n    Digite o Valor Para Cota Minima\n " + "              e pressione Enter: ");

			}
		});
		btnRelatorioDeCedulas.setFont(new Font("Cambria", Font.BOLD, 13));
		btnRelatorioDeCedulas.setBackground(SystemColor.activeCaption);
		btnRelatorioDeCedulas.setBounds(753, 393, 159, 136);
		contentPanel.add(btnRelatorioDeCedulas);

		JButton enter = new JButton("Enter");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer b;
				b = Integer.parseInt(entrada.getText());
				tela.setText(caixa.armazenaCotaMinima(b));
				entrada.setText("");
			}
		});
		enter.setForeground(Color.BLUE);
		enter.setFont(new Font("Tahoma", Font.BOLD, 20));
		enter.setBounds(639, 639, 89, 92);
		contentPanel.add(enter);

		JButton corrige = new JButton("corrige");
		corrige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrada.setText("");
			}
		});
		corrige.setForeground(Color.BLUE);
		corrige.setFont(new Font("Tahoma", Font.BOLD, 16));
		corrige.setBounds(640, 540, 89, 92);
		contentPanel.add(corrige);

		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setFont(new Font("Tahoma", Font.BOLD, 20));
		sair.setForeground(new Color(0, 0, 255));
		sair.setBounds(738, 584, 112, 114);
		contentPanel.add(sair);

	}
}

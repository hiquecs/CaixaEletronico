package br.traba.guicaixaeletronico;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import br.traba.caixaeletronico.CaixaEletronico;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class GUICaixaEletronico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField entrada;
	private Integer opcao;
	CaixaEletronico caixa = new CaixaEletronico();
	GUIExtrato extrato = new GUIExtrato();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICaixaEletronico frame = new GUICaixaEletronico();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setLocationRelativeTo(null);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation((tela.width - frame.getSize().width)/2,
					(tela.height - frame.getSize().height)/2);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUICaixaEletronico() {
		setUndecorated(true);
		getContentPane().setBackground(Color.RED);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1494, 1031);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(900, 200);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea tela = new JTextArea();
		tela.setEditable(false);
		tela.setFont(new Font("Cambria", Font.BOLD, 25));
		tela.setForeground(Color.BLACK);
		tela.setBackground(Color.LIGHT_GRAY);
		tela.setBounds(327, 223, 416, 306);
		tela.setText("\r\n\r\n         Bem vindo ao banco 24h\r\n\r\n           Qual o Serviço Desejado\r\n\r\n                Saque ou Deposito");
		contentPane.add(tela);
		JButton saque = new JButton("Saque");
		saque.setBackground(SystemColor.activeCaption);
		saque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcao = 1;
				tela.setText("\n\n\n\n        Digite o valor do Saque:        ");

			}
		});
		saque.setFont(new Font("Cambria", Font.BOLD, 16));
		saque.setBounds(208, 256, 89, 84);
		contentPane.add(saque);

		JButton deposito = new JButton("Deposito");
		deposito.setBackground(SystemColor.activeCaption);
		deposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcao = 2;
				tela.setText("\n\n\n\n        Digite o valor do Deposito:        ");

			}
		});
		deposito.setFont(new Font("Cambria", Font.BOLD, 12));
		deposito.setBounds(208, 412, 89, 84);
		contentPane.add(deposito);

		JButton numero4 = new JButton("4");
		numero4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numero = entrada.getText();
				entrada.setText(numero + "4");
			}
		});
		numero4.setForeground(Color.BLACK);
		numero4.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero4.setBounds(395, 600, 89, 43);
		contentPane.add(numero4);

		JButton numero7 = new JButton("7");
		numero7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "7");
			}
		});
		numero7.setForeground(Color.BLACK);
		numero7.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero7.setBounds(395, 649, 89, 43);
		contentPane.add(numero7);

		JButton asterisco = new JButton("*");
		asterisco.setForeground(Color.BLACK);
		asterisco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "*");
			}
		});
		asterisco.setFont(new Font("Tahoma", Font.BOLD, 45));
		asterisco.setBounds(395, 699, 89, 43);
		contentPane.add(asterisco);

		JButton numero5 = new JButton("5");
		numero5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "5");
			}
		});
		numero5.setForeground(Color.BLACK);
		numero5.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero5.setBounds(491, 600, 89, 43);
		contentPane.add(numero5);

		JButton numero9 = new JButton("9");
		numero9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "9");
			}
		});
		numero9.setForeground(Color.BLACK);
		numero9.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero9.setBounds(589, 649, 89, 43);
		contentPane.add(numero9);

		JButton numero8 = new JButton("8");
		numero8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "8");
			}
		});
		numero8.setForeground(Color.BLACK);
		numero8.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero8.setBounds(491, 649, 89, 43);
		contentPane.add(numero8);

		JButton numero0 = new JButton("0");
		numero0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "0");
			}
		});
		numero0.setForeground(Color.BLACK);
		numero0.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero0.setBounds(491, 699, 89, 43);
		contentPane.add(numero0);

		JButton numero6 = new JButton("6");
		numero6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "6");
			}
		});
		numero6.setForeground(Color.BLACK);
		numero6.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero6.setBounds(589, 600, 89, 43);
		contentPane.add(numero6);

		JButton sustenido = new JButton("#");
		sustenido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "#");
			}
		});
		sustenido.setForeground(Color.BLACK);
		sustenido.setFont(new Font("Tahoma", Font.BOLD, 30));
		sustenido.setBounds(589, 699, 89, 43);
		contentPane.add(sustenido);

		JButton numero1 = new JButton("1");
		numero1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "1");

			}
		});
		numero1.setForeground(Color.BLACK);
		numero1.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero1.setBounds(395, 551, 89, 43);
		contentPane.add(numero1);

		JButton numero2 = new JButton("2");
		numero2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = entrada.getText();
				entrada.setText(numero + "2");
			}
		});
		numero2.setForeground(Color.BLACK);
		numero2.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero2.setBounds(491, 551, 89, 43);
		contentPane.add(numero2);

		JButton numero3 = new JButton("3");
		numero3.setForeground(Color.BLACK);
		numero3.setFont(new Font("Tahoma", Font.BOLD, 22));
		numero3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String numero = entrada.getText();
				entrada.setText(numero + "3");
			}
		});
		numero3.setBounds(589, 551, 89, 43);
		contentPane.add(numero3);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("banco24horas-e1464190414322.png"));
		lblNewLabel_1.setBounds(338, 63, 392, 81);
		contentPane.add(lblNewLabel_1);

		JButton enter = new JButton("");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = entrada.getText();
				if (a.equals("*1234#")) {
					entrada.setText("");
					GUICaixaEletronicoTecnico teste = new GUICaixaEletronicoTecnico();
					teste.setVisible(true);
				}
				Integer funcao;
				funcao = Integer.parseInt(entrada.getText());
				switch (opcao) {
				case 1: {
					tela.setText(new CaixaEletronico().sacar(funcao));
					break;
				}
				case 2: {
					tela.setText(new CaixaEletronico().deposito(funcao));
					break;
				}
				}
				entrada.setText("");
			}
		});
		enter.setBackground(Color.WHITE);
		enter.setIcon(new ImageIcon("Butt.png"));
		enter.setForeground(Color.BLACK);
		enter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enter.setBounds(767, 223, 89, 82);
		contentPane.add(enter);

		JButton sair = new JButton("");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				extrato.setVisible(true);
				dispose();
			}

		});
		sair.setBackground(Color.BLACK);
		sair.setIcon(new ImageIcon("BExit.png"));
		sair.setBounds(767, 445, 89, 84);
		contentPane.add(sair);

		JButton corrigir = new JButton("");
		corrigir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrada.setText("");
			}
		});
		corrigir.setBackground(Color.BLACK);
		corrigir.setIcon(new ImageIcon("BCorrige.png"));
		corrigir.setBounds(767, 333, 89, 84);
		contentPane.add(corrigir);
		entrada = new JTextField();
		entrada.setFont(new Font("Tahoma", Font.PLAIN, 22));
		entrada.setBounds(395, 463, 283, 36);
		contentPane.add(entrada);
		entrada.setColumns(10);
		entrada.setHorizontalAlignment(JTextField.RIGHT);

	}

}
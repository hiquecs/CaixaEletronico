package br.traba.guicaixaeletronico;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.traba.caixaeletronico.CaixaEletronico;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;

public class GUIReposicaoNotas extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CaixaEletronico caixa = new CaixaEletronico();
	private final JPanel contentPanel = new JPanel();

	public GUIReposicaoNotas() {
		setModal(true);
		setUndecorated(true);
		setBounds(327, 223, 416, 306);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setSize(900, 200);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.RIGHT);
		comboBox.addItem(100);
		comboBox.addItem(50);
		comboBox.addItem(20);
		comboBox.addItem(10);
		comboBox.addItem(5);
		comboBox.addItem(2);
		comboBox.setBounds(87, 79, 217, 28);
		comboBox.setRenderer(dlcr);
		contentPanel.add(comboBox);
		contentPanel.setLayout(null);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
		spinner.setBackground(Color.BLACK);
		spinner.setForeground(Color.GREEN);
		spinner.setFont(new Font("Tahoma", Font.BOLD, 18));
		spinner.setBounds(87, 196, 217, 28);
		contentPanel.add(spinner);

		JLabel lblQuantidadeDeCedulas = new JLabel("Quantidade de Cedulas:");
		lblQuantidadeDeCedulas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblQuantidadeDeCedulas.setForeground(Color.GREEN);
		lblQuantidadeDeCedulas.setBounds(76, 157, 261, 28);
		contentPanel.add(lblQuantidadeDeCedulas);

		JButton enter = new JButton("Enter");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer nota, quantidade;
				quantidade = Integer.parseInt(spinner.getValue().toString());
				nota = Integer.parseInt(comboBox.getSelectedItem().toString());
				String a = caixa.reposicaoCedulas(nota, quantidade);
				JOptionPane.showMessageDialog(contentPanel, a, "Reposição de Notas", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		enter.setForeground(Color.BLUE);
		enter.setFont(new Font("Tahoma", Font.BOLD, 13));
		enter.setBounds(87, 253, 89, 42);
		contentPanel.add(enter);

		JButton cancela = new JButton("Cancelar");
		cancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancela.setForeground(Color.BLUE);
		cancela.setFont(new Font("Tahoma", Font.BOLD, 13));
		cancela.setBounds(215, 253, 89, 42);
		contentPanel.add(cancela);

		JLabel lblValorDaCedulas = new JLabel("Valor da Cedulas:");
		lblValorDaCedulas.setForeground(Color.GREEN);
		lblValorDaCedulas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblValorDaCedulas.setBounds(76, 40, 261, 28);
		contentPanel.add(lblValorDaCedulas);

	}
}

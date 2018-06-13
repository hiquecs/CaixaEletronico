package br.traba.guicaixaeletronico;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import br.traba.caixaeletronico.Caixa;
import br.traba.daocaixaeletronico.DAOCaixaEletronico;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GUIExtrato extends JDialog {

	private JPanel contentPane;

	public GUIExtrato() {
		
		setModal(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(327, 100, 382, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	   	
		@SuppressWarnings("rawtypes")
		
		JList areaExtrato = new JList();
		areaExtrato.setValueIsAdjusting(true);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(areaExtrato);
		scroll.setBounds(10, 45, 346, 496);
		
		contentPane.add(scroll);
			
		JButton btnListarAlunos = new JButton("Listar Extrato");		
		btnListarAlunos.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Caixa> lista = new DAOCaixaEletronico().listAll();
				DefaultListModel<Caixa> model = new DefaultListModel<>();
			
				
				for(Caixa a: lista) {
					model.addElement(a);		
					areaExtrato.setModel(model);
				}
				new DAOCaixaEletronico().esvaziaExtrato();
				new DAOCaixaEletronico().extratoAdd("                                       Extrato Bancario");
				new DAOCaixaEletronico().extratoAdd("         -----------------------------------------------------------------------");
				  
			}
		});
		btnListarAlunos.setBounds(10, 11, 121, 23);
		contentPane.add(btnListarAlunos);
	}
}

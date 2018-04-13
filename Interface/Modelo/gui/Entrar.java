package Modelo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Bar;
import Negocio.Categoria;
import Negocio.Cliente;
import Controller.Controle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Entrar extends JFrame {

	private static Controle controller = new Controle("Bar");

	private JPanel contentPane;
	private JTextField cpfField;
	private JTextField nomeField;
	private JTextField idadeField;
	private JTextField generoField;
	private JComboBox<Categoria> comboBox;

	private boolean removerCliente;
	private boolean consultarCliente;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrar frame = new Entrar(controller);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Entrar(Controle controller) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCPF = new JLabel("CPF:");
		JLabel lblNome = new JLabel("Nome:");
		JLabel lblIdade = new JLabel("Idade:");
		JLabel lblGenero = new JLabel("Gênero:");
		JLabel lblCategoria = new JLabel("Categoria:");
		JButton btnSalvar = new JButton("Salvar");
		JButton btnConsultarCliente = new JButton("Consultar Cliente");

		cpfField = new JTextField();
		cpfField.setColumns(10);

		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				lblNome.setVisible(true);
				nomeField.setVisible(true);
				lblIdade.setVisible(true);
				idadeField.setVisible(true);
				generoField.setVisible(true);
				lblGenero.setVisible(true);
				lblCategoria.setVisible(true);
				comboBox.setVisible(true);

				removerCliente = false;
			}
		});

		JButton btnRemoverCliente = new JButton("Remover Cliente");
		btnRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnSalvar.setVisible(true);
				
				nomeField.setVisible(false);
				idadeField.setVisible(false);
				generoField.setVisible(false);
				comboBox.setVisible(false);
				cpfField.setText("");
				lblCPF.setVisible(true);
				
				removerCliente = true;
			}
		});

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrar frame = new Entrar(controller);

				if (removerCliente) {

					//if(cpfField.getText()==controller.)
					
					controller.removeCliente(cpfField.getText());

					System.out.println(controller.numeroClientes());

					JOptionPane.showMessageDialog(frame, "Cliente Excluído com Sucesso!");

				} else {

					String genero = generoField.getText();

					controller.cadastraCliente(nomeField.getText(), cpfField.getText(),
							Integer.parseInt(idadeField.getText()), genero.charAt(0),
							(Categoria) comboBox.getSelectedItem());

					System.out.println(controller.numeroClientes());

					JOptionPane.showMessageDialog(frame, "Cliente Adicionado com Sucesso!");

				}

			}
		});

		nomeField = new JTextField();
		nomeField.setColumns(10);
		idadeField = new JTextField();
		idadeField.setColumns(10);
		generoField = new JTextField();
		generoField.setColumns(10);

		comboBox = new JComboBox(Categoria.values()); //<Categoria>
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<Categoria> comboBox = new JComboBox<>();
				comboBox.setModel(new DefaultComboBoxModel<>(Categoria.values()));
			}
		});

		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeField.setVisible(false);
				idadeField.setVisible(false);
				generoField.setVisible(false);
				comboBox.setVisible(false);
				consultarCliente = true;

				cpfField.setText("");
				lblCPF.setVisible(true);
				
				
				
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Entrar frame = new Entrar(controller);
				
				if(consultarCliente){

					if (controller.cpfExiste(cpfField.getText())==true){
						
						System.out.println("Numero de clientes no bar: " + controller.numeroClientes() + "\nConsulta:"
								+ controller.consultaCliente(cpfField.getText()));

						JOptionPane.showMessageDialog(frame, "Cliente NÃO está no bar!");
						}
					} else {
						System.out.println("Numero de clientes no bar: " + controller.numeroClientes() + "\nConsulta:"
								+ controller.consultaCliente(cpfField.getText()));

						JOptionPane.showMessageDialog(frame, "Cliente ESTÁ no bar!");
					}
			}
		});
		
		JButton btnConsultarGnero = new JButton("Consultar Gênero");
		btnConsultarGnero.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
				lblNome.setVisible(false);
				nomeField.setVisible(false);
				lblIdade.setVisible(false);
				idadeField.setVisible(false);
				cpfField.setVisible(false);
				lblCPF.setVisible(false);
				lblCategoria.setVisible(false);
				generoField.setVisible(false);
				lblGenero.setVisible(false);
				consultarCliente = false;
				
				System.out.println(controller.numeroClientesFemininos());

				
				JOptionPane.showInputDialog("Mulheres:" + controller.numeroClientesFemininos() + "\nHomens:" + controller.numeroClientesMasculinos());
			}
		});
		
		JButton btnConsultarCategoria = new JButton("Consultar Categoria ");
		btnConsultarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNome.setVisible(false);
				nomeField.setVisible(false);
				lblIdade.setVisible(false);
				idadeField.setVisible(false);
				cpfField.setVisible(false);
				lblCPF.setVisible(false);
				lblCategoria.setVisible(false);
				generoField.setVisible(false);
				lblGenero.setVisible(false);
				
				JOptionPane.showInputDialog("Clientes Silver:" + controller.numeroClientesSilver() + "\nClientes Gold:" + controller.numeroClientesGold() + "\nClientes Platinum:" + controller.numeroClientesPlatinum());

				
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCadastrarCliente)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblGenero)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(generoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblIdade)
										.addComponent(lblNome))
									.addGap(8)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(idadeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cpfField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(464))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCategoria)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRemoverCliente)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnConsultarCliente)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnConsultarGnero)
									.addGap(6)
									.addComponent(btnConsultarCategoria))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(0, 0, Short.MAX_VALUE)
									.addComponent(lblCPF)
									.addGap(616))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(340)
							.addComponent(btnSalvar)
							.addGap(18)
							.addComponent(btnConsultar)))
					.addGap(21))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(85)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrarCliente)
						.addComponent(btnRemoverCliente)
						.addComponent(btnConsultarCliente)
						.addComponent(btnConsultarGnero)
						.addComponent(btnConsultarCategoria))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblCPF))
								.addComponent(cpfField))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(idadeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdade))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGenero)
								.addComponent(generoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCategoria)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(69))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnConsultar)
							.addComponent(btnSalvar)))
					.addGap(12))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

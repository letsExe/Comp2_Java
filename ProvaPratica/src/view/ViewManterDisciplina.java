package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Model;
import model.ModelDisciplina;

public class ViewManterDisciplina extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField fieldidDisciplina;
	private JTextField fieldSigla;
	private ModelDisciplina model;
	private JButton btnExcluir;
	private JTextField fieldNome;
	private JTextField fieldCarga_horaria;

	/**
	 * Create the dialog.
	 */
	public ViewManterDisciplina(Controller ctrl) {
		setModal(true);
		setTitle("Manter os dados de uma Disciplina");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewManterDisciplina.class.getResource("/resources/favicon.png")));
		setBounds(100, 100, 423, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelCentral = new JPanel();
			contentPanel.add(panelCentral, BorderLayout.CENTER);
			GridBagLayout gbl_panelCentral = new GridBagLayout();
			gbl_panelCentral.columnWidths = new int[]{82, 0, 0};
			gbl_panelCentral.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_panelCentral.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panelCentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelCentral.setLayout(gbl_panelCentral);
			{
				JLabel lblbid = new JLabel("Identificador:");
				GridBagConstraints gbc_lblbid = new GridBagConstraints();
				gbc_lblbid.anchor = GridBagConstraints.EAST;
				gbc_lblbid.fill = GridBagConstraints.VERTICAL;
				gbc_lblbid.insets = new Insets(0, 0, 5, 5);
				gbc_lblbid.gridx = 0;
				gbc_lblbid.gridy = 0;
				panelCentral.add(lblbid, gbc_lblbid);
			}
			{
				fieldidDisciplina = new JTextField();
				fieldidDisciplina.setBackground(SystemColor.inactiveCaption);
				fieldidDisciplina.setForeground(new Color(191, 205, 219));
				fieldidDisciplina.setEditable(false);
				GridBagConstraints gbc_fieldidDisciplina = new GridBagConstraints();
				gbc_fieldidDisciplina.insets = new Insets(0, 0, 5, 0);
				gbc_fieldidDisciplina.fill = GridBagConstraints.BOTH;
				gbc_fieldidDisciplina.gridx = 1;
				gbc_fieldidDisciplina.gridy = 0;
				panelCentral.add(fieldidDisciplina, gbc_fieldidDisciplina);
				fieldidDisciplina.setColumns(10);
			}
			{
				JLabel lblnome = new JLabel("Nome:");
				GridBagConstraints gbc_lblnome = new GridBagConstraints();
				gbc_lblnome.insets = new Insets(0, 0, 5, 5);
				gbc_lblnome.anchor = GridBagConstraints.EAST;
				gbc_lblnome.fill = GridBagConstraints.VERTICAL;
				gbc_lblnome.gridx = 0;
				gbc_lblnome.gridy = 1;
				panelCentral.add(lblnome, gbc_lblnome);
			}
			{
				fieldNome = new JTextField();
				GridBagConstraints gbc_fieldSigla = new GridBagConstraints();
				gbc_fieldSigla.insets = new Insets(0, 0, 5, 0);
				gbc_fieldSigla.fill = GridBagConstraints.HORIZONTAL;
				gbc_fieldSigla.gridx = 1;
				gbc_fieldSigla.gridy = 1;
				panelCentral.add(fieldNome, gbc_fieldSigla);
				fieldNome.setColumns(10);
			}
			{
				JLabel lblMo = new JLabel("Sigla:");
				GridBagConstraints gbc_lblMo = new GridBagConstraints();
				gbc_lblMo.anchor = GridBagConstraints.EAST;
				gbc_lblMo.insets = new Insets(0, 0, 5, 5);
				gbc_lblMo.gridx = 0;
				gbc_lblMo.gridy = 2;
				panelCentral.add(lblMo, gbc_lblMo);
			}
			{
				fieldSigla = new JTextField();
				fieldSigla.setColumns(10);
				GridBagConstraints gbc_fieldNome = new GridBagConstraints();
				gbc_fieldNome.insets = new Insets(0, 0, 5, 0);
				gbc_fieldNome.fill = GridBagConstraints.HORIZONTAL;
				gbc_fieldNome.gridx = 1;
				gbc_fieldNome.gridy = 2;
				panelCentral.add(fieldSigla, gbc_fieldNome);
			}
			{
				JLabel lblPlaca = new JLabel("Carga Horaria:");
				GridBagConstraints gbc_lblPlaca = new GridBagConstraints();
				gbc_lblPlaca.anchor = GridBagConstraints.EAST;
				gbc_lblPlaca.insets = new Insets(0, 0, 0, 5);
				gbc_lblPlaca.gridx = 0;
				gbc_lblPlaca.gridy = 3;
				panelCentral.add(lblPlaca, gbc_lblPlaca);
			}
			{
				fieldCarga_horaria = new JTextField();
				fieldCarga_horaria.setColumns(10);
				GridBagConstraints gbc_fieldCarga_horaria = new GridBagConstraints();
				gbc_fieldCarga_horaria.fill = GridBagConstraints.HORIZONTAL;
				gbc_fieldCarga_horaria.gridx = 1;
				gbc_fieldCarga_horaria.gridy = 3;
				panelCentral.add(fieldCarga_horaria, gbc_fieldCarga_horaria);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnFechar = new JButton("");
				btnFechar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btnFechar.setIcon(new ImageIcon(ViewManterDisciplina.class.getResource("/resources/botaoFechar.png")));
				panel.add(btnFechar, BorderLayout.EAST);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.WEST);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JButton btnSalvar = new JButton("");
					btnSalvar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							model.setnome(fieldNome.getText());
							model.setsigla(fieldSigla.getText());
							model.setcarga_horaria(fieldCarga_horaria.getText());
							try {
								ctrl.salvar(model);
								setVisible(false);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog (null, "Erro ao salvar!\n" + e1.getMessage());
								e1.printStackTrace();
							}
						}
					});
					btnSalvar.setIcon(new ImageIcon(ViewManterDisciplina.class.getResource("/resources/botaoGravar.png")));
					panel_1.add(btnSalvar, BorderLayout.WEST);
				}
				{
					btnExcluir = new JButton("");//mexi aqui
					btnExcluir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								int r = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este registro?",
										"Confirmação",
										JOptionPane.YES_NO_OPTION);

								if (r==JOptionPane.YES_OPTION) {
									ctrl.excluir(model);
									setVisible(false);
								}
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					btnExcluir.setIcon(new ImageIcon(ViewManterDisciplina.class.getResource("/resources/botaoExcluirTodos.png")));
					panel_1.add(btnExcluir, BorderLayout.SOUTH);
				}
				{
					Component horizontalStrut = Box.createHorizontalStrut(20);
					panel_1.add(horizontalStrut, BorderLayout.CENTER);
				}
			}
		}
	}

	public void mostrar ( Model model ) {
		this.model = (ModelDisciplina)model;
		if (model.getid()==null) {
			fieldidDisciplina.setText("");
			fieldSigla.setText("");
			fieldNome.setText("");
			fieldCarga_horaria.setText("");
			btnExcluir.setEnabled(false);
		} else {
			fieldidDisciplina.setText(this.model.getidDisciplina().toString());
			fieldSigla.setText(this.model.getsigla());
			fieldNome.setText(this.model.getidname());
			fieldCarga_horaria.setText(this.model.getcarga_horaria());
			btnExcluir.setEnabled(true);
		}
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}

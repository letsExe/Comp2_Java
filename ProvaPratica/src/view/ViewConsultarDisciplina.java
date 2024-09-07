package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Model;
import model.ModelDisciplina;
import util.Parameter;
import view.tableModel.TableModelDisciplina;

public class ViewConsultarDisciplina extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private TableModelDisciplina table_model;
	private JTextField fieldidDisciplina;
	private JTextField fieldsigla;
	private JTextField fieldNome;
	private JTextField fieldCarga_horaria;
	private Controller ctrl;

	/**
	 * Create the dialog.
	 */
	public ViewConsultarDisciplina(Controller ctrl) {
		this.ctrl = ctrl;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewConsultarDisciplina.class.getResource("/resources/botaoProcurar.png")));
		setTitle("Consultar Disciplina...");
		setBounds(100, 100, 757, 527);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{49, 526, 84, 0};
			gbl_panel.rowHeights = new int[]{14, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			JLabel lblNewLabel = new JLabel("Identificador:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			panel.add(lblNewLabel, gbc_lblNewLabel);
			
			fieldidDisciplina = new JTextField();
			GridBagConstraints gbc_fieldidDisciplina = new GridBagConstraints();
			gbc_fieldidDisciplina.insets = new Insets(0, 0, 5, 5);
			gbc_fieldidDisciplina.fill = GridBagConstraints.HORIZONTAL;
			gbc_fieldidDisciplina.gridx = 1;
			gbc_fieldidDisciplina.gridy = 0;
			panel.add(fieldidDisciplina, gbc_fieldidDisciplina);
			fieldidDisciplina.setColumns(10);

			JLabel lblNewLabell = new JLabel("Nome:");
			GridBagConstraints gbc_lblNewLabell = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			panel.add(lblNewLabell, gbc_lblNewLabell);

			fieldNome = new JTextField();
			GridBagConstraints gbc_fieldsigla = new GridBagConstraints();
			gbc_fieldsigla.insets = new Insets(0, 0, 5, 0);
			gbc_fieldsigla.fill = GridBagConstraints.HORIZONTAL;
			gbc_fieldsigla.gridx = 1;
			gbc_fieldsigla.gridy = 1;
			panel.add(fieldNome, gbc_fieldsigla);
			fieldNome.setColumns(10);

			JLabel lblModelo = new JLabel("Sigla:");
			GridBagConstraints gbc_lblModelo = new GridBagConstraints();
			gbc_lblModelo.anchor = GridBagConstraints.EAST;
			gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
			gbc_lblModelo.gridx = 0;
			gbc_lblModelo.gridy = 2;
			panel.add(lblModelo, gbc_lblModelo);

			fieldsigla = new JTextField();
			fieldsigla.setColumns(10);
			GridBagConstraints gbc_fieldNome = new GridBagConstraints();
			gbc_fieldNome.insets = new Insets(0, 0, 5, 0);
			gbc_fieldNome.fill = GridBagConstraints.HORIZONTAL;
			gbc_fieldNome.gridx = 1;
			gbc_fieldNome.gridy = 2;
			panel.add(fieldsigla, gbc_fieldNome);

			JLabel lblNewLabel_1_1 = new JLabel("Carga Horaroa:");
			GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
			gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1_1.gridx = 0;
			gbc_lblNewLabel_1_1.gridy = 3;
			panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

			fieldCarga_horaria = new JTextField();
			fieldCarga_horaria.setColumns(10);
			GridBagConstraints gbc_fieldCarga_horaria = new GridBagConstraints();
			gbc_fieldCarga_horaria.fill = GridBagConstraints.HORIZONTAL;
			gbc_fieldCarga_horaria.gridx = 1;
			gbc_fieldCarga_horaria.gridy = 3;
			panel.add(fieldCarga_horaria, gbc_fieldCarga_horaria);
			
			JPanel panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.gridheight = 2;
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 2;
			gbc_panel_1.gridy = 0;
			panel.add(panel_1, gbc_panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JButton btnProcurar = new JButton("");
			btnProcurar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					update();
				}
			});
			btnProcurar.setIcon(new ImageIcon(ViewConsultarDisciplina.class.getResource("/resources/botaoProcurar.png")));
			panel_1.add(btnProcurar);
			
			JButton btnLimpar = new JButton("");
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fieldidDisciplina.setText("");
					fieldNome.setText("");
					table_model.update(new ArrayList<Model>());

				}
			});
			btnLimpar.setIcon(new ImageIcon(ViewConsultarDisciplina.class.getResource("/resources/botaoLimpar.png")));
			panel_1.add(btnLimpar, BorderLayout.EAST);
			
			JLabel lblNewLabel_1 = new JLabel("Nome:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			fieldNome = new JTextField();
			GridBagConstraints gbc_fieldNomee = new GridBagConstraints();
			gbc_fieldNome.insets = new Insets(0, 0, 0, 5);
			gbc_fieldNome.fill = GridBagConstraints.HORIZONTAL;
			gbc_fieldNome.gridx = 1;
			gbc_fieldNome.gridy = 1;
			panel.add(fieldNome, gbc_fieldNome);
			fieldNome.setColumns(10);
		}
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnFechar = new JButton("");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setIcon(new ImageIcon(ViewConsultarDisciplina.class.getResource("/resources/botaoFechar.png")));
		panel.add(btnFechar, BorderLayout.EAST);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.manter(new ModelDisciplina());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		panel.add(btnAdicionar, BorderLayout.WEST);
		btnAdicionar.setIcon(new ImageIcon(ViewConsultarDisciplina.class.getResource("/resources/botaoAdicionar.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		table_model = new TableModelDisciplina();
		table = new JTable(table_model);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					int row = table.getSelectedRow();
					try {
						ctrl.manter (  table_model.getModel(row));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2) {
					int row = table.getSelectedRow();
					try {
						ctrl.manter (  table_model.getModel(row));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		scrollPane.setViewportView(table);	
	}

	public void mostrar () {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void update ( ) {
		try {
			ctrl.consultar(new Parameter ( "idDisciplina", fieldidDisciplina.getText()),
					new Parameter ( "nome", fieldNome.getText()),
					new Parameter ( "sigla", fieldsigla.getText()),
					new Parameter ( "carga_horaria", fieldCarga_horaria.getText()));
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	public void setData ( ArrayList<Model> list ) {
		table_model.setData(list);
	}

}

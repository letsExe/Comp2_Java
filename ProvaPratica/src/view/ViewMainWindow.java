package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import controller.ControllerDisciplina;

public class ViewMainWindow extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewMainWindow dialog = new ViewMainWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewMainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewMainWindow.class.getResource("/resources/favicon.png")));
		setTitle("Sistema de Disciplinas");
		setBounds(100, 100, 747, 491);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		JMenuItem mntmConsultarPessoa = new JMenuItem("Consultar Disiciploina...");
		mntmConsultarPessoa.setIcon(new ImageIcon(ViewMainWindow.class.getResource("/resources/botaoProcurar.png")));
		mntmConsultarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControllerDisciplina();
			}
		});
		mntmConsultarPessoa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		mnSistema.add(mntmConsultarPessoa);
		
		JSeparator separator = new JSeparator();
		mnSistema.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setIcon(new ImageIcon(ViewMainWindow.class.getResource("/resources/botaoFechar.png")));
		mnSistema.add(mntmSair);
	}

}

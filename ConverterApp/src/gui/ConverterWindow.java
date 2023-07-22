package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Canvas;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JComboBox;

public class ConverterWindow extends JFrame {

	private JPanel panelPrincipal;
	private JTextField amountTextField;


	
	
	
	public ConverterWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		starComponents();
		
		setTitle("CHALLENGE CONVERSOR ALURA LATAM/ORACLE"); 
		setResizable(false);
		setLocationRelativeTo(null); // centrar la aplicacion 
		
		
		
		
		
	}



	



	private void starComponents() {
		
		
		
		setBounds(100, 100, 1024, 768);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		
		JPanel panelMenu = new JPanel();
		
		JPanel panelCurrency = new JPanel();
		GroupLayout gl_panelPrincipal = new GroupLayout(panelPrincipal);
		gl_panelPrincipal.setHorizontalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
					.addComponent(panelCurrency, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
					.addGap(125))
		);
		gl_panelPrincipal.setVerticalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(panelMenu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
						.addComponent(panelCurrency, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelCurrency.setLayout(null);
		
		JLabel lblTitleCurrency = new JLabel("CONVERSOR DE MONEDA");
		lblTitleCurrency.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleCurrency.setFont(new Font("SansSerif", Font.PLAIN, 26));
		lblTitleCurrency.setBounds(6, 6, 517, 43);
		panelCurrency.add(lblTitleCurrency);
		
		
		JLabel lblimgCurrency = new JLabel("");
		lblimgCurrency.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblimgCurrency.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgCurrency.setBounds(210, 61, 100, 100);
		panelCurrency.add(lblimgCurrency);
		panelMenu.setLayout(null);
		
		ImageIcon icon = new ImageIcon("/Users/jennymunera/Documents/GitHub/ConverterApp/ConverterApp/img/Currencyicon.png");
		Image img= icon.getImage();
		Image imgScale = img.getScaledInstance(lblimgCurrency.getWidth(), lblimgCurrency.getHeight(),Image.SCALE_SMOOTH );
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		lblimgCurrency.setIcon(scaledIcon);
		
		JLabel lblcantidad = new JLabel("Ingrese la cantidad a convertir");
		lblcantidad.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblcantidad.setEnabled(false);
		lblcantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblcantidad.setBounds(6, 194, 517, 16);
		panelCurrency.add(lblcantidad);
		
		amountTextField = new JTextField();
		amountTextField.setBackground(new Color(238, 238, 238));
		amountTextField.setHorizontalAlignment(SwingConstants.CENTER);
		amountTextField.setBounds(113, 232, 313, 43);
		panelCurrency.add(amountTextField);
		amountTextField.setColumns(10);
		
		JComboBox fromcurrencyComboBox = new JComboBox();
		fromcurrencyComboBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		fromcurrencyComboBox.setBounds(113, 327, 313, 43);
		panelCurrency.add(fromcurrencyComboBox);
		
		JLabel lblcantidad1 = new JLabel("Tipo de Moneda Inicial: ");
		lblcantidad1.setHorizontalAlignment(SwingConstants.CENTER);
		lblcantidad1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblcantidad1.setEnabled(false);
		lblcantidad1.setBounds(6, 299, 517, 16);
		panelCurrency.add(lblcantidad1);
		
		JButton btnexchange = new JButton("");
		btnexchange.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnexchange.setBounds(224, 393, 86, 63);
		panelCurrency.add(btnexchange);
		
		ImageIcon iconexchange = new ImageIcon("/Users/jennymunera/Documents/GitHub/ConverterApp/ConverterApp/img/exchange.png");
		Image imgexchange= iconexchange.getImage();
		Image imgScaleExchange = imgexchange.getScaledInstance(btnexchange.getWidth(), btnexchange.getHeight(),Image.SCALE_SMOOTH );
		ImageIcon scaledIconExchange = new ImageIcon(imgScaleExchange);
		btnexchange.setIcon(scaledIconExchange);
		
		JLabel lblcantidad2 = new JLabel("Tipo de Moneda a convertir:");
		lblcantidad2.setHorizontalAlignment(SwingConstants.CENTER);
		lblcantidad2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblcantidad2.setEnabled(false);
		lblcantidad2.setBounds(6, 468, 517, 16);
		panelCurrency.add(lblcantidad2);
		
		JComboBox toCurrencyComboBox = new JComboBox();
		toCurrencyComboBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		toCurrencyComboBox.setBounds(113, 513, 313, 43);
		panelCurrency.add(toCurrencyComboBox);
		
		JLabel lblResultCurrency = new JLabel("");
		lblResultCurrency.setBounds(6, 593, 517, 100);
		panelCurrency.add(lblResultCurrency);
		
		
		JLabel lblTitle = new JLabel("Converter APP");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(6, 177, 218, 36);
		panelMenu.add(lblTitle);
		
		
		JLabel lblMenu = new JLabel("Menú Principal");
		lblMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(6, 238, 218, 16);
		panelMenu.add(lblMenu);
		
		
		JButton btnCurrency = new JButton("Conversor de Moneda");
		btnCurrency.setBounds(6, 301, 218, 43);
		panelMenu.add(btnCurrency);
		
		
		
		JButton btnUnits = new JButton("Conversor de Unidades");
		btnUnits.setBounds(6, 353, 218, 43);
		panelMenu.add(btnUnits);
		panelPrincipal.setLayout(gl_panelPrincipal);
		
		
		
	}
}

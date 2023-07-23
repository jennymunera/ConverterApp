package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;

import classes.CurrencyApi;
import javax.swing.JTextPane;


public class ConverterWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JTextField amountTextField;
	private JComboBox<String> fromcurrencyComboBox;
	private JComboBox<String> toCurrencyComboBox;
	private CurrencyApi currencyApi;

	public ConverterWindow(CurrencyApi currencyApi) {
		this.currencyApi = currencyApi;

		// configurar JFrame

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CHALLENGE CONVERSOR ALURA LATAM/ORACLE");

		setBounds(100, 100, 1024, 768);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		
		

		JPanel panelMenu = new JPanel();

		JPanel panelCurrency = new JPanel();
		panelCurrency.setVisible(false);
		panelCurrency.setLayout(null);
	    
		JPanel panelUnits = new JPanel();
		panelUnits.setVisible(false);
		panelUnits.setLayout(null);
		
		JPanel panelImage = new JPanel();
		panelImage.setVisible(true);
		panelImage.setLayout(null);
		
		GroupLayout gl_panelPrincipal = new GroupLayout(panelPrincipal);
		gl_panelPrincipal.setHorizontalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(panelImage, GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelUnits, GroupLayout.PREFERRED_SIZE, 773, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panelCurrency, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
					.addGap(125))
		);
		gl_panelPrincipal.setVerticalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(panelMenu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
						.addComponent(panelCurrency, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
						.addComponent(panelUnits, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
						.addComponent(panelImage, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		
		JLabel lblImagenInicio = new JLabel("");
		lblImagenInicio.setBounds(0, 0, 774, 718);
		lblImagenInicio.setHorizontalTextPosition(SwingConstants.CENTER);
		panelImage.add(lblImagenInicio);
		
		ImageIcon iconInicio = new ImageIcon("/Users/jennymunera/Documents/GitHub/ConverterApp/ConverterApp/img/challengeImage.jpg"); 
		Image imgInicio = iconInicio.getImage();
		Image imgScaledInicio = imgInicio.getScaledInstance(lblImagenInicio.getWidth(), lblImagenInicio.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIconInicio = new ImageIcon(imgScaledInicio);
		lblImagenInicio.setIcon(ScaledIconInicio);
		
		
		

		/// componentes del menu principal

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
		
		

		/// componentes del conversor de moneda

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

		ImageIcon icon = new ImageIcon(
				"/Users/jennymunera/Documents/GitHub/ConverterApp/ConverterApp/img/Currencyicon.png");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(lblimgCurrency.getWidth(), lblimgCurrency.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		lblimgCurrency.setIcon(scaledIcon);

		JLabel lblcantidad = new JLabel("Ingrese la cantidad a convertir");
		lblcantidad.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblcantidad.setEnabled(false);
		lblcantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblcantidad.setBounds(6, 173, 517, 20);
		panelCurrency.add(lblcantidad);

		amountTextField = new JTextField();
		amountTextField.setBackground(new Color(238, 238, 238));
		amountTextField.setHorizontalAlignment(SwingConstants.CENTER);
		amountTextField.setBounds(113, 205, 313, 43);
		panelCurrency.add(amountTextField);
		amountTextField.setColumns(10);

		fromcurrencyComboBox = new JComboBox<>(currencyApi.getCurrencyNames());
		fromcurrencyComboBox.setMaximumRowCount(10);
		fromcurrencyComboBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		fromcurrencyComboBox.setBounds(113, 288, 313, 43);
		panelCurrency.add(fromcurrencyComboBox);

		JLabel lblcantidad1 = new JLabel("Tipo de Moneda Inicial: ");
		lblcantidad1.setHorizontalAlignment(SwingConstants.CENTER);
		lblcantidad1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblcantidad1.setEnabled(false);
		lblcantidad1.setBounds(6, 260, 517, 16);
		panelCurrency.add(lblcantidad1);

		JButton invertButton = new JButton("");
		invertButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		invertButton.setBounds(226, 343, 70, 70);
		panelCurrency.add(invertButton);

		ImageIcon iconexchange = new ImageIcon(
				"/Users/jennymunera/Documents/GitHub/ConverterApp/ConverterApp/img/exchange.png");
		Image imgexchange = iconexchange.getImage();
		Image imgScaleExchange = imgexchange.getScaledInstance(invertButton.getWidth(), invertButton.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon scaledIconExchange = new ImageIcon(imgScaleExchange);
		invertButton.setIcon(scaledIconExchange);

		JLabel lblcantidad2 = new JLabel("Tipo de Moneda a convertir:");
		lblcantidad2.setHorizontalAlignment(SwingConstants.CENTER);
		lblcantidad2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblcantidad2.setEnabled(false);
		lblcantidad2.setBounds(6, 425, 517, 16);
		panelCurrency.add(lblcantidad2);

		toCurrencyComboBox = new JComboBox<>(currencyApi.getCurrencyNames());
		toCurrencyComboBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		toCurrencyComboBox.setBounds(113, 460, 313, 43);
		panelCurrency.add(toCurrencyComboBox);

		JButton convertButton = new JButton("Convertir");
		convertButton.setBounds(210, 530, 117, 29);
		panelCurrency.add(convertButton);
		
		JTextPane textResult = new JTextPane();
		textResult.setEditable(false);
		textResult.setBackground(new Color(238, 238, 238));
		textResult.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		textResult.setBounds(6, 593, 517, 111);
		panelCurrency.add(textResult);
		
		
		// Eventos de los botones del menu principal
		
		//evento boton menu convertir moneda
	    btnCurrency.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	panelImage.setVisible(false);
	            panelCurrency.setVisible(true);
	            panelUnits.setVisible(false);
	        }
	    });

	    // evento boton menu convertir unidades
	    btnUnits.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            panelUnits.setVisible(true);
	            panelCurrency.setVisible(false);
	            panelImage.setVisible(false);
	        }
	    });

		// Eventos del conversor de moneda

		// ActionListener para el botón de inversión (invertButton)
		convertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obtiene los datos ingresados por el usuario
				String fromCurrency = getCurrencyCode(fromcurrencyComboBox.getSelectedItem().toString());
				String toCurrency = getCurrencyCode(toCurrencyComboBox.getSelectedItem().toString());
				double amount = Double.parseDouble(amountTextField.getText());

				// Realiza la conversión utilizando el valor de cambio de las monedas
				double fromRate = currencyApi.getExchangeRate(fromCurrency);
				double toRate = currencyApi.getExchangeRate(toCurrency);
				double convertedAmount = (amount / fromRate) * toRate;

				// Redondear convertedAmount a tres decimales
				DecimalFormat df = new DecimalFormat("#.###");
				convertedAmount = Double.parseDouble(df.format(convertedAmount));


				// Muestra el resultado de la conversión 
				// JOptionPane.showMessageDialog(null, amount + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency);
				textResult.setText("La cantidad ingresada: "+amount + "  " + fromCurrency + " corresponde a = " + convertedAmount + " " + toCurrency);
			}

			private String getCurrencyCode(String currency) {
				String[] parts = currency.split(" - ");
				return parts[0].trim();
			}
		});

		// ActionListener para el botón de inversión (invertButton)
		invertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Realiza la inversión de las monedas
				String selectedFromCurrency = fromcurrencyComboBox.getSelectedItem().toString();
				String selectedToCurrency = toCurrencyComboBox.getSelectedItem().toString();

				// Intercambia las monedas seleccionadas
				fromcurrencyComboBox.setSelectedItem(selectedToCurrency);
				toCurrencyComboBox.setSelectedItem(selectedFromCurrency);
			}
		});
		
		
		

	}// fin del constructor
}// fin de la clase

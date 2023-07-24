package gui;

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
import classes.TemperatureConverter;

import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;


public class ConverterWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JTextField amountTextField;
	private JComboBox<String> fromcurrencyComboBox;
	private JComboBox<String> toCurrencyComboBox;
	private CurrencyApi currencyApi;
	private JTextField TextLength;
	private JTextField textTemp;
	private JTextField textWeight;
	private TemperatureConverter temperatureConverter;
	private JComboBox<String>TempUnits1;
	private JComboBox<String>TempUnits2;

	public ConverterWindow(CurrencyApi currencyApi) {
		this.currencyApi = currencyApi;
		
		

		// TODO DESCOMENTAR todo lo relacionado con panelImage y lbllblImagenInicio

///////// configurar JFrame 

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
		
		//JPanel panelImage = new JPanel();
		//panelImage.setVisible(true);  
		//panelImage.setLayout(null);
		
		GroupLayout gl_panelPrincipal = new GroupLayout(panelPrincipal);
		gl_panelPrincipal.setHorizontalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					//.addComponent(panelImage, GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE)
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
						//.addComponent(panelImage, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE))
					).addContainerGap())
		);
		
		
		/*
		JLabel lblImagenInicio = new JLabel("");
		lblImagenInicio.setOpaque(true);
		lblImagenInicio.setFocusTraversalPolicyProvider(true);
		lblImagenInicio.setBounds(0, 0, 774, 718);
		lblImagenInicio.setHorizontalTextPosition(SwingConstants.CENTER);
		//panelImage.add(lblImagenInicio);
		
		ImageIcon iconInicio = new ImageIcon("/Users/jennymunera/Documents/GitHub/ConverterApp/ConverterApp/img/challengeImage.jpg"); 
		Image imgInicio = iconInicio.getImage();
		Image imgScaledInicio = imgInicio.getScaledInstance(lblImagenInicio.getWidth(), lblImagenInicio.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIconInicio = new ImageIcon(imgScaledInicio);
		lblImagenInicio.setIcon(ScaledIconInicio);
		*/
		

////////// componentes del menu principal

		JLabel lblTitle = new JLabel("Converter APP");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(6, 177, 218, 36);
		panelMenu.add(lblTitle);

		JButton lblMenu = new JButton("Menú Principal");
		lblMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
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
		
		

///////// componentes del conversor de moneda

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
		
		JButton btnFinish = new JButton("Finalizar Programa");
		btnFinish.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnFinish.setFont(new Font("SansSerif", Font.ITALIC, 13));
		
		
		btnFinish.setBounds(6, 408, 212, 43);
		panelMenu.add(btnFinish);

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
		
		
////////componentes del conversor de longitud
		JPanel panelLength = new JPanel();
		panelLength.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelLength.setBounds(421, 6, 316, 347);
		panelUnits.add(panelLength);
		panelLength.setLayout(null);
		
		JLabel lblLength = new JLabel("LONGITUD");
		lblLength.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblLength.setBounds(6, 6, 304, 23);
		panelLength.add(lblLength);
		
		TextLength = new JTextField();
		TextLength.setFont(new Font("SansSerif", Font.PLAIN, 13));
		TextLength.setBounds(16, 54, 283, 35);
		panelLength.add(TextLength);
		TextLength.setColumns(10);
		
		JLabel lblLength1 = new JLabel("Ingrese el valor de longitud");
		lblLength1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblLength1.setEnabled(false);
		lblLength1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLength1.setBounds(6, 37, 304, 16);
		panelLength.add(lblLength1);
		
		JLabel lblLength2 = new JLabel("Unidad de longitud inicial");
		lblLength2.setEnabled(false);
		lblLength2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLength2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblLength2.setBounds(6, 94, 304, 23);
		panelLength.add(lblLength2);
		
		JComboBox LengthUnits1 = new JComboBox();
		LengthUnits1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		LengthUnits1.setBounds(16, 120, 283, 27);
		panelLength.add(LengthUnits1);
		
		JButton btnInverLeng = new JButton("");
		btnInverLeng.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnInverLeng.setBounds(137, 146, 40, 40);
		panelLength.add(btnInverLeng);
		ImageIcon iconinvertLeng = new ImageIcon(
				"/Users/jennymunera/Documents/GitHub/ConverterApp/ConverterApp/img/exchange.png");
		Image imginvertleng = iconinvertLeng.getImage();
		Image imgScaleinvertleng = imginvertleng.getScaledInstance(btnInverLeng.getWidth(), btnInverLeng.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon scaledInvertleng = new ImageIcon(imgScaleinvertleng);
		btnInverLeng.setIcon(scaledInvertleng);
		
		JLabel lblLength3 = new JLabel("Unidad de Longitud final");
		lblLength3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblLength3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLength3.setEnabled(false);
		lblLength3.setBounds(6, 187, 304, 16);
		panelLength.add(lblLength3);
		
		JComboBox LengthUnits2 = new JComboBox();
		LengthUnits2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		LengthUnits2.setBounds(6, 213, 283, 27);
		panelLength.add(LengthUnits2);
		
		JTextPane textResutlLength = new JTextPane();
		textResutlLength.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textResutlLength.setBackground(new Color(238, 238, 238));
		textResutlLength.setBounds(6, 280, 304, 50);
		panelLength.add(textResutlLength);
		
		JButton btnConvertLength = new JButton("Convertir");
		btnConvertLength.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnConvertLength.setBounds(103, 241, 117, 29);
		panelLength.add(btnConvertLength);
		
////////componentes conversor de temperatura		
		JPanel panelTemp = new JPanel();
		panelTemp.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTemp.setLayout(null);
		panelTemp.setBounds(47, 6, 316, 347);
		panelUnits.add(panelTemp);
		
		JLabel lblTemp = new JLabel("TEMPERATURA");
		lblTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemp.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblTemp.setBounds(6, 6, 304, 23);
		panelTemp.add(lblTemp);
		
		textTemp = new JTextField();
		textTemp.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textTemp.setColumns(10);
		textTemp.setBounds(16, 54, 283, 35);
		panelTemp.add(textTemp);
		
		JLabel lblTemp1 = new JLabel("Ingrese el valor de temperatura");
		lblTemp1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemp1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblTemp1.setEnabled(false);
		lblTemp1.setBounds(6, 37, 304, 16);
		panelTemp.add(lblTemp1);
		
		JLabel lblTemp2 = new JLabel("Unidad de temperatura inicial");
		lblTemp2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemp2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblTemp2.setEnabled(false);
		lblTemp2.setBounds(6, 94, 304, 23);
		panelTemp.add(lblTemp2);
		
		TempUnits1 = new JComboBox<>();
		TempUnits1.setModel(new DefaultComboBoxModel<String>(new String[] {"ºC - Celsius", "ºF - Fahrenheit ", "ºK - Kelvin"}));
		TempUnits1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		TempUnits1.setBounds(16, 117, 283, 27);
		panelTemp.add(TempUnits1);
		
		JButton btnInvertemp = new JButton("");
		btnInvertemp.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnInvertemp.setBounds(137, 143, 40, 40);
		panelTemp.add(btnInvertemp);
		ImageIcon iconinvertemp = new ImageIcon(
				"/Users/jennymunera/Documents/GitHub/ConverterApp/ConverterApp/img/exchange.png");
		Image imginverttemp = iconinvertemp.getImage();
		Image imgScaleinvertemp = imginverttemp.getScaledInstance(btnInvertemp.getWidth(), btnInvertemp.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon scaledInvertemp = new ImageIcon(imgScaleinvertemp);
		btnInvertemp.setIcon(scaledInvertemp);
		
		JLabel lblTemp3 = new JLabel("Unidad de temperatura final");
		lblTemp3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblTemp3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemp3.setEnabled(false);
		lblTemp3.setBounds(6, 186, 304, 16);
		panelTemp.add(lblTemp3);
		
		TempUnits2 = new JComboBox<>();
		TempUnits2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		TempUnits2.setModel(new DefaultComboBoxModel<String>(new String[] {"ºC - Celsius", "ºF - Fahrenheit ", "ºK - Kelvin"}));
		TempUnits2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		TempUnits2.setBounds(16, 213, 283, 27);
		panelTemp.add(TempUnits2);
		
		JTextPane textResultTemp = new JTextPane();
		textResultTemp.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textResultTemp.setBackground(UIManager.getColor("Button.background"));
		textResultTemp.setBounds(6, 280, 304, 50);
		panelTemp.add(textResultTemp);
		
		JButton btnconverTemp = new JButton("Convertir");
		btnconverTemp.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnconverTemp.setBounds(100, 241, 117, 29);
		panelTemp.add(btnconverTemp);
		
////////componentes conversor de masa
		
		JPanel panelWeight = new JPanel();
		panelWeight.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelWeight.setLayout(null);
		panelWeight.setBounds(47, 371, 316, 347);
		panelUnits.add(panelWeight);
		
		JLabel lblWeight = new JLabel("MASA");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblWeight.setBounds(6, 6, 304, 23);
		panelWeight.add(lblWeight);
		
		textWeight = new JTextField();
		textWeight.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textWeight.setColumns(10);
		textWeight.setBounds(16, 54, 283, 35);
		panelWeight.add(textWeight);
		
		JLabel lblWeight1 = new JLabel("Ingrese el valor");
		lblWeight1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblWeight1.setEnabled(false);
		lblWeight1.setBounds(6, 37, 304, 16);
		panelWeight.add(lblWeight1);
		
		JLabel lblLWeight2 = new JLabel("Unidad de masa inicial");
		lblLWeight2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLWeight2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblLWeight2.setEnabled(false);
		lblLWeight2.setBounds(6, 94, 304, 23);
		panelWeight.add(lblLWeight2);
		
		JComboBox WeightUnits1 = new JComboBox();
		WeightUnits1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		WeightUnits1.setBounds(16, 120, 283, 27);
		panelWeight.add(WeightUnits1);
		
		JButton btnInverWeight = new JButton("");
		btnInverWeight.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnInverWeight.setBounds(137, 146, 40, 40);
		panelWeight.add(btnInverWeight);
		ImageIcon iconinverweight = new ImageIcon(
				"/Users/jennymunera/Documents/GitHub/ConverterApp/ConverterApp/img/exchange.png");
		Image imginvertweight = iconinverweight.getImage();
		Image imgScaleinverweight = imginvertweight.getScaledInstance(btnInverWeight.getWidth(), btnInverWeight.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon scaledInverweight= new ImageIcon(imgScaleinverweight);
		btnInverWeight.setIcon(scaledInverweight);
		
		JLabel lblWeight3 = new JLabel("Unidad de masa final");
		lblWeight3.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblWeight3.setEnabled(false);
		lblWeight3.setBounds(6, 187, 304, 16);
		panelWeight.add(lblWeight3);
		
		JComboBox WeightUnits2 = new JComboBox();
		WeightUnits2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		WeightUnits2.setBounds(6, 213, 283, 27);
		panelWeight.add(WeightUnits2);
		
		JTextPane textResutlWeight = new JTextPane();
		textResutlWeight.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textResutlWeight.setBackground(UIManager.getColor("Button.background"));
		textResutlWeight.setBounds(6, 280, 304, 50);
		panelWeight.add(textResutlWeight);
		
		JButton btnConvertWeight = new JButton("Convertir");
		btnConvertWeight.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnConvertWeight.setBounds(103, 241, 117, 29);
		panelWeight.add(btnConvertWeight);
		
	
			
		
		
/////////Eventos de los paneles y componentes 		

	// Eventos de los botones del menu principal
		 lblMenu.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        //	panelImage.setVisible(true);
		            panelCurrency.setVisible(false);
		            panelUnits.setVisible(false);
		        }
		    });
		
		
		//evento boton menu convertir moneda
	    btnCurrency.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	//panelImage.setVisible(false);
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
	           // panelImage.setVisible(false);
	        }
	    });

///////// Eventos del conversor de moneda

		// ActionListener para el botón de inversión (invertButton)
		convertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obtiene los datos ingresados por el usuario
				String fromCurrency = getCurrencyCode(fromcurrencyComboBox.getSelectedItem().toString());
				String toCurrency = getCurrencyCode(toCurrencyComboBox.getSelectedItem().toString());
				
				
			    double amount = 0.0;
			    
			    try {
		            amount = Double.parseDouble(amountTextField.getText());
		        } catch (NumberFormatException ex) {
		            // Si no se ingresó un número válido, mostrar un mensaje de error
		            JOptionPane.showMessageDialog(null, "Error: Ingrese solo números en el campo de cantidad.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

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
		
///////////Eventos Conversor de temperatura
		
		
		textTemp.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        convertTemperature(temperatureConverter);
		    }
		});

		TempUnits1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        convertTemperature(temperatureConverter);
		    }
		});

		TempUnits2.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        convertTemperature(temperatureConverter);
		    }
		});
		
		//ActionListener para el boton convertir Temperatura
		btnconverTemp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempInput = textTemp.getText();
			    if (tempInput.isEmpty()) {
			    textResultTemp.setText("");
			        return; // No hay nada que convertir si el campo de texto está vacío
			    }

			    double tempValue;
			    try {
			        tempValue = Double.parseDouble(tempInput);
			    } catch (NumberFormatException ex) {
			    	JOptionPane.showMessageDialog(null, "Error: Ingrese solo números en el campo de cantidad.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
			        return;
			    }
				
	                String selectedUnit1 = TempUnits1.getSelectedItem().toString();
	                String selectedUnit2 = TempUnits2.getSelectedItem().toString();
	                
	                if(selectedUnit1.equals(selectedUnit2)){
	                	JOptionPane.showMessageDialog(null,"No se puede convertir a la misma unidad de temperatura, verifica las selecciones","Error de unidades",JOptionPane.ERROR_MESSAGE);
	                }else{

	                double result = 0.0;

	                if (selectedUnit1.equals("ºC - Celsius")) {
	                    if (selectedUnit2.equals("ºF - Fahrenheit ")) {
	                        result = TemperatureConverter.celsiusToFahrenheit(tempValue);
	                    } else if (selectedUnit2.equals("ºK - Kelvin")) {
	                        result = TemperatureConverter.celsiusToKelvin(tempValue);
	                    }
	                } else if (selectedUnit1.equals("ºF - Fahrenheit ")) {
	                    if (selectedUnit2.equals("ºC - Celsius")) {
	                        result = TemperatureConverter.fahrenheitToCelsius(tempValue);
	                    } else if (selectedUnit2.equals("ºK - Kelvin")) {
	                        result = TemperatureConverter.fahrenheitToKelvin(tempValue);
	                    }
	                } else if (selectedUnit1.equals("ºK - Kelvin")) {
	                    if (selectedUnit2.equals("ºC - Celsius")) {
	                        result = TemperatureConverter.kelvinToCelsius(tempValue);
	                    } else if (selectedUnit2.equals("ºF - Fahrenheit ")) {
	                        result = TemperatureConverter.kelvinToFahrenheit(tempValue);
	                    }
	                }

	                textResultTemp.setText("la temperatura ingresada: "+tempValue+" "+selectedUnit1+" es igual a: "+String.valueOf(result)+ " "+selectedUnit2);
	            }
			}
		});
		
		btnInvertemp.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Intercambiar las selecciones de los JComboBox
		        int selectedIndex1 = TempUnits1.getSelectedIndex();
		        int selectedIndex2 = TempUnits2.getSelectedIndex();

		        TempUnits1.setSelectedIndex(selectedIndex2);
		        TempUnits2.setSelectedIndex(selectedIndex1);

		        // Actualizar el resultado con la nueva configuración
		        convertTemperature(temperatureConverter);
		    }
		});
		
//////// Eventos conversor de longitud 
		
		
		
	}// fin del constructor

	public void convertTemperature(TemperatureConverter temperatureConverter) {
		this.temperatureConverter = temperatureConverter;
		
	}
}// fin de la clase

package br.com.curso.dvgenerator.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import br.com.curso.dvgenerator.util.InvalidNumberException;
import br.com.curso.dvgenerator.util.ValidationHelper;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * Classe geradora de DV.
 */
public class DVGeneratorApplication extends javax.swing.JFrame {

    /**
     * Font de tamanho fixo.
     */
    private static final String FONT_COURIER = "Courier";

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 9045952021505245878L;

    /**
     * Label do titulo.
     */
    private JLabel titleLabel;

    /**
     * Compo do digito verificador.
     */
    private JTextField dvTextField;

    /**
     * Botao calcular.
     */
    private JButton calculateButton;

    /**
     * Separador.
     */
    private JSeparator jSeparator1;

    /**
     * Label do mumero + dv.
     */
    private JLabel numeroDvLabel;

    /**
     * Botao sair.
     */
    private JButton exitButton;

    /**
     * Label do digito verificador.
     */
    private JLabel dvLabel;

    /**
     * Campo do mumero + dv.
     */
    private JTextField numberDvTextField;

    /**
     * Label do numero.
     */
    private JLabel numeroLabel;

    /**
     * Campo do numero.
     */
    private JTextField numberTextField;

    /**
     * Painel principal.
     */
    private JPanel mainPanel;

    /**
     * Label do tipo.
     */
    private JLabel typeLabel;

    /**
     * Combo do tipo.
     */
    private JComboBox typeComboBox;

    /**
     * Construtor padrao.
     */
    public DVGeneratorApplication() {
        super();
        initGUI();
    }

    /**
     * Auto-generated main method to display this JFrame.
     * @param args Argumentos da lina de comando
     */
    public static void main(String[] args) {
        // Set Look & Feel
        try {
            String osName = System.getProperty("os.name").toUpperCase();
            if (osName.indexOf("LINUX") >= 0) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            } else if (osName.indexOf("WINDOWS") >= 0) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } else {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
            System.exit(0);
        }

        DVGeneratorApplication inst = new DVGeneratorApplication();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);

    }

    /**
     * Inicializa os componentes de interface.
     */
    private void initGUI() {
        {
            BorderLayout thisLayout = new BorderLayout();
            getContentPane().setLayout(thisLayout);
            this.setTitle("Gerador de DV");
            this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource(
                    "resources/icons/emblem-system-16x16.png")).getImage());
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setResizable(false);
            {
                titleLabel = new JLabel();
                getContentPane().add(titleLabel, BorderLayout.NORTH);
                titleLabel.setText("Gerador de DV");
                titleLabel.setBounds(0, 0, 392, 42);
                titleLabel.setBackground(new java.awt.Color(255, 255, 255));
                titleLabel.setOpaque(true);
                titleLabel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
                titleLabel.setPreferredSize(new java.awt.Dimension(392, 49));
                titleLabel.setFont(new java.awt.Font("Arial", 1, 14));
                titleLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                        "resources/icons/emblem-system-32x32.png")));
            }
            {
                mainPanel = new JPanel();
                getContentPane().add(mainPanel, BorderLayout.CENTER);
                mainPanel.setBounds(63, 140, 161, 63);
                mainPanel.setLayout(null);
                {
                    ComboBoxModel typeComboBoxModel = new DefaultComboBoxModel(new String[] {
                        "Processo", "Inscricao", "CPF", "CNPJ"});
                    typeComboBox = new JComboBox();
                    mainPanel.add(typeComboBox);
                    typeComboBox.setModel(typeComboBoxModel);
                    typeComboBox.setBounds(119, 14, 175, 21);
                }
                {
                    typeLabel = new JLabel();
                    mainPanel.add(typeLabel);
                    typeLabel.setText("Tipo:");
                    typeLabel.setBounds(7, 14, 105, 21);
                    typeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                }
                {
                    numberTextField = new JTextField();
                    mainPanel.add(numberTextField);
                    numberTextField.setBounds(119, 49, 175, 21);
                    numberTextField.setFont(new java.awt.Font(FONT_COURIER, 1, 12));
                }
                {
                    numeroLabel = new JLabel();
                    mainPanel.add(numeroLabel);
                    numeroLabel.setText("Numero:");
                    numeroLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                    numeroLabel.setBounds(7, 49, 105, 21);
                }
                {
                    dvTextField = new JTextField();
                    mainPanel.add(dvTextField);
                    dvTextField.setBounds(119, 85, 175, 21);
                    dvTextField.setFont(new java.awt.Font(FONT_COURIER, 1, 12));
                }
                {
                    numberDvTextField = new JTextField();
                    mainPanel.add(numberDvTextField);
                    numberDvTextField.setBounds(119, 120, 175, 21);
                    numberDvTextField.setFont(new java.awt.Font(FONT_COURIER, 1, 12));
                }
                {
                    dvLabel = new JLabel();
                    mainPanel.add(dvLabel);
                    dvLabel.setText("DV:");
                    dvLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                    dvLabel.setBounds(7, 84, 105, 21);
                }
                {
                    numeroDvLabel = new JLabel();
                    mainPanel.add(numeroDvLabel);
                    numeroDvLabel.setText("Numero + DV:");
                    numeroDvLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                    numeroDvLabel.setBounds(7, 119, 105, 21);
                }
                {
                    jSeparator1 = new JSeparator();
                    mainPanel.add(jSeparator1);
                    jSeparator1.setBounds(0, 154, 329, 7);
                }
                {
                    calculateButton = new JButton();
                    mainPanel.add(calculateButton);
                    calculateButton.setText("Calcular");
                    calculateButton.setBounds(221, 168, 101, 21);
                    calculateButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                            "resources/icons/go-next-16x16.png")));
                    calculateButton.addActionListener(new ActionListener() {
                        @Override
						public void actionPerformed(ActionEvent evt) {
                            calculateButtonActionPerformed(evt);
                        }
                    });
                }
                {
                    exitButton = new JButton();
                    mainPanel.add(exitButton);
                    exitButton.setText("Sair");
                    exitButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                            "resources/icons/system-log-out-16x16.png")));
                    exitButton.setBounds(116, 168, 99, 21);
                    exitButton.addActionListener(new ActionListener() {
                        @Override
						public void actionPerformed(ActionEvent evt) {
                            exitButtonActionPerformed(evt);
                        }
                    });
                }
            }
        }
        this.setSize(335, 272);
    }

    /**
     * Metodo executado ao clicar no botao sair.
     * @param evt Evento
     */
    private void exitButtonActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    /**
     * Metodo executado ao clicar no botao calcular.
     * @param evt Evento
     */
    private void calculateButtonActionPerformed(ActionEvent evt) {
        try {
            String number = numberTextField.getText();
            String numberDV = "";
            if (typeComboBox.getSelectedItem().equals("Processo")) {
                numberDV = ValidationHelper.getNupDV(number);
            } else if (typeComboBox.getSelectedItem().equals("Inscricao")) {
                numberDV = ValidationHelper.getNumeroInscricaoDV(number);
            } else if (typeComboBox.getSelectedItem().equals("CPF")) {
                numberDV = ValidationHelper.getCpfDV(number);
            } else if (typeComboBox.getSelectedItem().equals("CNPJ")) {
                numberDV = ValidationHelper.getCnpjDV(number);
            } else {
                throw new InvalidNumberException("Escolha um tipo de numero!");
            }
            dvTextField.setText(numberDV);
            numberDvTextField.setText(number + numberDV);
        } catch (InvalidNumberException e) {
            dvTextField.setText("");
            numberDvTextField.setText("");
            JOptionPane.showMessageDialog(this, e.getMessage());
            numberTextField.requestFocusInWindow();
        }

    }
}

package ui;

import javax.swing.*;
import model.Password;
import service.PasswordValidator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordUI extends JFrame {

    private JTextField passwordField;
    private JButton validarButton;
    private JLabel resultadoLabel;
    private PasswordValidator validator;

    public PasswordUI() {
        validator = new PasswordValidator();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Validador de Contraseña");
        setSize(400, 200);
        setLocationRelativeTo(null); // Centrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
    }

    private void inicializarComponentes() {

        JPanel panelEntrada = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Ingrese una contraseña: ");
        passwordField = new JTextField(15);
        panelEntrada.add(label);
        panelEntrada.add(passwordField);

        validarButton = new JButton("Validar");
        validarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarContrasena();
            }
        });

        resultadoLabel = new JLabel(" ");
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(panelEntrada, BorderLayout.NORTH);
        add(validarButton, BorderLayout.CENTER);
        add(resultadoLabel, BorderLayout.SOUTH);
    }

    private void validarContrasena() {
        String input = passwordField.getText();
        Password password = new Password(input);

        if (validator.esValida(password)) {
            resultadoLabel.setText("✅ La contraseña es válida.");
            resultadoLabel.setForeground(new Color(0, 128, 0));
        } else {
            resultadoLabel.setText("<html>❌ No cumple los requisitos:<br>"
                    + "- Al menos 8 caracteres.<br>"
                    + "- Al menos un número.</html>");
            resultadoLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PasswordUI ventana = new PasswordUI();
            ventana.setVisible(true);
        });
    }
}


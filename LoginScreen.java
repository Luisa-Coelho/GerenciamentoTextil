package sistematear;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {

    public static void createAndShowLoginScreen() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null); // Layout null para posicionamento absoluto

        // Adicionar ícone têxtil
        ImageIcon icon = new ImageIcon("textile_icon.png");
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBounds(150, 10, icon.getIconWidth(), icon.getIconHeight());
        panel.add(iconLabel);

        // Adicionar mensagem de boas-vindas com fonte maior e centralizada
        JLabel welcomeLabel = new JLabel("Bem-vindo ao Sistema de Gerenciamento Têxtil!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(20, 70, 360, 25);
        panel.add(welcomeLabel);

        // Label e campo de usuário
        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(50, 130, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(130, 130, 200, 25);
        panel.add(userText);

        // Label e campo de senha
        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(50, 160, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(130, 160, 200, 25);
        panel.add(passwordText);

        // Botão de login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 210, 100, 30);
        panel.add(loginButton);

        // Botão de cadastro
        JButton registerButton = new JButton("Cadastre-se aqui");
        registerButton.setBounds(170, 210, 160, 30);
        panel.add(registerButton);

        // Botão de informações
        JButton infoButton = new JButton("Consulte mais informações");
        infoButton.setBounds(50, 250, 280, 30);
        panel.add(infoButton);

        // Aplicar cores diferentes para o campo de login e demais componentes
        userLabel.setForeground(new Color(25, 25, 112)); // Azul escuro
        passwordLabel.setForeground(new Color(25, 25, 112)); // Azul escuro
        welcomeLabel.setForeground(new Color(25, 25, 112)); // Azul escuro

        // ActionListener para o botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = new String(passwordText.getPassword());

                // Implementar verificação de login aqui
                if (authenticate(user, password)) {
                    frame.dispose(); // Fechar a tela de login
                    FactoryManagementScreen.showFactoryManagementScreen();
                } else {
                    JOptionPane.showMessageDialog(panel, "Usuário ou senha inválidos", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ActionListener para o botão de cadastro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação de cadastro aqui
                JOptionPane.showMessageDialog(panel, "Função de cadastro não implementada", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // ActionListener para o botão de informações
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação de consulta de informações aqui
                JOptionPane.showMessageDialog(panel, "Função de consulta de informações não implementada", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    private static boolean authenticate(String user, String password) {
        // Exemplo de autenticação simples (substituir por lógica real)
        return user.equals("admin") && password.equals("password");
    }
}

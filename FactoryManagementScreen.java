package sistematear;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryManagementScreen {

    private static Tear tear;

    public static void showFactoryManagementScreen() {
        JFrame frame = new JFrame("Gerenciamento da Fábrica Têxtil");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Bem-vindo ao Gerenciamento da Fábrica Têxtil!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(10, 1, 5, 5));

        addButton(buttonPanel, "Inserir login e senha do usuário");
        addButton(buttonPanel, "Cadastrar maquinário");
        addButton(buttonPanel, "Alertas e Notificações");
        addButton(buttonPanel, "Alterar e excluir informações de usuário");
        addButton(buttonPanel, "Cadastrar novos usuários");
        addButton(buttonPanel, "Gerar relatório de atividades");
        addButton(buttonPanel, "Status em tempo real do maquinário", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tear == null) {
                    // Substitua os JLabels abaixo com os JLabels que você deseja passar para Tear
                    tear = new Tear(new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel());
                }
            }
        });
        addButton(buttonPanel, "Editar dados do maquinário");
        addButton(buttonPanel, "Hora extra");

        panel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void addButton(JPanel panel, String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        panel.add(button);
    }

    private static void addButton(JPanel panel, String text) {
        addButton(panel, text, null); // Chama o método addButton padrão sem ActionListener
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            showFactoryManagementScreen();
        });
    }
}

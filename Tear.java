package sistematear;

import javax.swing.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tear implements Runnable {

    private final Random aleatorio = new Random();
    private int segundosFuncionando = 0;
    private int minutosFuncionando = 0;
    private int horasFuncionando = 0;
    private int segundosParado = 0;
    private int minutosParado = 0;
    private int horasParado = 0;
    private double eficiencia = 0.0;

    // Componentes visuais que serão atualizados
    private JLabel lblSegundosFuncionando;
    private JLabel lblMinutosFuncionando;
    private JLabel lblHorasFuncionando;
    private JLabel lblSegundosParado;
    private JLabel lblMinutosParado;
    private JLabel lblHorasParado;
    private JLabel lblEficiencia;

    public Tear(JLabel lblSegundosFuncionando, JLabel lblMinutosFuncionando, JLabel lblHorasFuncionando,
                JLabel lblSegundosParado, JLabel lblMinutosParado, JLabel lblHorasParado, JLabel lblEficiencia) {
        this.lblSegundosFuncionando = lblSegundosFuncionando;
        this.lblMinutosFuncionando = lblMinutosFuncionando;
        this.lblHorasFuncionando = lblHorasFuncionando;
        this.lblSegundosParado = lblSegundosParado;
        this.lblMinutosParado = lblMinutosParado;
        this.lblHorasParado = lblHorasParado;
        this.lblEficiencia = lblEficiencia;
        
        // Inicia a thread para execução do monitoramento do maquinário
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            int produzindo = aleatorio.nextInt(12);
            if (produzindo >= 10) {
                atualizarTempoFuncionamento();
            } else {
                atualizarTempoParado();
            }

            try {
                Thread.sleep(1000); // Aguarda 1 segundo antes de atualizar novamente
            } catch (InterruptedException ex) {
                Logger.getLogger(Tear.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void atualizarTempoFuncionamento() {
        if (segundosFuncionando != 59) {
            segundosFuncionando++;
        } else {
            segundosFuncionando = 0;
            if (minutosFuncionando != 59) {
                minutosFuncionando++;
            } else {
                minutosFuncionando = 0;
                horasFuncionando++;
            }
        }
        calcularEficiencia();
        atualizarInterface();
    }

    private void atualizarTempoParado() {
        if (segundosParado != 59) {
            segundosParado++;
        } else {
            segundosParado = 0;
            if (minutosParado != 59) {
                minutosParado++;
            } else {
                minutosParado = 0;
                horasParado++;
            }
        }
        atualizarInterface();
    }

    private void calcularEficiencia() {
        eficiencia = minutosFuncionando / 500.0 + (horasFuncionando * 60) / 500.0;
    }

    private void atualizarInterface() {
        SwingUtilities.invokeLater(() -> {
            // Atualiza os componentes visuais na interface gráfica
            lblSegundosFuncionando.setText(String.valueOf(segundosFuncionando));
            lblMinutosFuncionando.setText(String.valueOf(minutosFuncionando));
            lblHorasFuncionando.setText(String.valueOf(horasFuncionando));
            lblSegundosParado.setText(String.valueOf(segundosParado));
            lblMinutosParado.setText(String.valueOf(minutosParado));
            lblHorasParado.setText(String.valueOf(horasParado));
            lblEficiencia.setText(String.format("%.1f", eficiencia * 100) + "%");
        });
    }
}



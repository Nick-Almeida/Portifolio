import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IMC_Calc {
    private JFrame frame;
    private JTextField campoPeso;
    private JTextField campoAltura;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IMC_Calc window = new IMC_Calc();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public IMC_Calc() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Calculadora de IMC");
        frame.setBounds(300, 250, 310, 190);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 2));

        JLabel marcaPeso = new JLabel("Peso (kg):");
        panel.add(marcaPeso);

        campoPeso = new JTextField();
        panel.add(campoPeso);
        campoPeso.setColumns(10);

        JLabel marcaAltura = new JLabel("Altura (metros):");
        panel.add(marcaAltura);

        campoAltura = new JTextField();
        panel.add(campoAltura);
        campoAltura.setColumns(10);

        JButton Calcular = new JButton("Calcular IMC");
        panel.add(Calcular);

        Calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double Peso = Double.parseDouble(campoPeso.getText());
                    double Altura = Double.parseDouble(campoAltura.getText());

                    double imc = Peso / (Altura * Altura);
                    String avaliacao = "";

                    if (imc < 18.5) {
                        avaliacao = "Abaixo do peso";
                    } else if (imc < 24.9) {
                        avaliacao = "Peso normal";
                    } else if (imc < 29.9) {
                        avaliacao = "Sobrepeso/Obesidade Grau I";
                    } else if (imc < 39.9) {
                        avaliacao = "Obresidade Grau II";
                    } else if (imc > 40) {
                        avaliacao = "Obesidade Grau III";
                    }

                    DecimalFormat df = new DecimalFormat("##.##");
                    String imcString = df.format(imc);

                    JOptionPane.showMessageDialog(frame, "Seu IMC é de " + imcString + " então sua avaliação é " + avaliacao);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Número inválido, por gentileza digite novamente. Lembre-se de usar virgúlas para números quebrados.");
                }
            }
        });
    }
}
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kontrolki extends JFrame {

    private JButton przycisk;
    private JTextField text;
    private int wiek;
    private JCheckBox checkbox1;

    public Kontrolki() {
        super("Weryfikacja wieku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400, 100);

        przycisk = new JButton("Zatwierdź");
        text = new JTextField(" Wprowadź wiek ");
        checkbox1 = new JCheckBox("Akceptuje regulamin");
        text.setSize(300,80);

        przycisk.setEnabled(true);
        checkbox1.setSelected(false);

        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wiek = Integer.parseInt(text.getText());

                if(wiek > 18 && checkbox1.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Rejestracja pomyślna!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wymagany wiek 18+ i akceptacja regulaminu!");
                }
            }
        });

        this.add(text);
        this.add(checkbox1);
        this.add(przycisk);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

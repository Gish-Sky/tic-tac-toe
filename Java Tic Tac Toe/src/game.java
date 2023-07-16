import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class game extends JFrame implements ActionListener {
    JButton gamer[] = new JButton[9];
    boolean xPlayerTurn = true;
    int numsquares = 0;

    public game() {
        super.setSize(800, 800);
        super.setTitle("Tic Tac Toe");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildPanel();
        super.setVisible(true);
    }

    public void buildPanel() {
        GridLayout layout = new GridLayout(3, 3);
        super.setLayout(layout);
        for (int i = 0; i < gamer.length; i += 1) {
            gamer[i] = new JButton();
            gamer[i].addActionListener(this);
            super.add(gamer[i]);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton person = (JButton)e.getSource();
        if (xPlayerTurn) {
            if (person.getText().equals("")) {
                ImageIcon xReplacement = new ImageIcon("javax.jpeg");
                person.setIcon(xReplacement);
                person.setText("X");
                numsquares += 1;
                if (check("X")) {
                    JOptionPane.showMessageDialog(this, "X wins! \n Resetting...");
                    reset();
                }
            }
        }
        else {
            if (person.getText().equals("")) {
                ImageIcon oReplacement = new ImageIcon("javao.jpg");
                person.setText("O");
                person.setIcon(oReplacement);
                numsquares += 1;
            }
            if (check("O")) {
                JOptionPane.showMessageDialog(this, "O wins! \n Resetting...");
                reset();
            }
        }
        if (numsquares == 9) {
            JOptionPane.showMessageDialog(this, "Cat's game \n Resetting...");
            reset();
        }
        xPlayerTurn = !xPlayerTurn;
    }

    public boolean check(String symbol) {
        if (gamer[0].getText().equals(symbol) && gamer[1].getText().equals(symbol) && gamer[2].getText().equals(symbol)) {
            return true;
        }
        if (gamer[3].getText().equals(symbol) && gamer[4].getText().equals(symbol) && gamer[5].getText().equals(symbol)) {
            return true;
        }
        if (gamer[6].getText().equals(symbol) && gamer[7].getText().equals(symbol) && gamer[8].getText().equals(symbol)) {
            return true;
        }
        if (gamer[0].getText().equals(symbol) && gamer[3].getText().equals(symbol) && gamer[6].getText().equals(symbol)) {
            return true;
        }
        if (gamer[1].getText().equals(symbol) && gamer[4].getText().equals(symbol) && gamer[7].getText().equals(symbol)) {
            return true;
        }
        if (gamer[2].getText().equals(symbol) && gamer[5].getText().equals(symbol) && gamer[8].getText().equals(symbol)) {
            return true;
        }
        if (gamer[0].getText().equals(symbol) && gamer[4].getText().equals(symbol) && gamer[8].getText().equals(symbol)) {
            return true;
        }
        if (gamer[2].getText().equals(symbol) && gamer[4].getText().equals(symbol) && gamer[6].getText().equals(symbol)) {
            return true;
        } else {
            return false;
        }
    }
    public void reset() {
        xPlayerTurn=true;
        numsquares=0;
        for (JButton button:gamer) {
            button.setText("");
            ImageIcon weewoo = new ImageIcon("weewoo.jpg");
            button.setIcon(weewoo);
        }
    }
}

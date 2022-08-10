import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class BlackJack implements ActionListener {

    JFrame frame;
    JPanel playerPanel;
    JPanel dealerPanel;
    ArrayList<JLabel> deck;

    JLabel playerScoreLabel;
    int playerScore = 18;
    JLabel dealerScoreLabel;
    int dealerScore = 16;

    JButton hitButton;
    JButton standButton;
    JButton dealButton;

    Random random;

    final int CARD_AMOUNT = 52;

    Color   btnColor = new Color(34,37,45),
            fieldColor = new Color(39,43,51),
            panelColor = new Color(41, 45, 54),
            textColor = new Color(254,254,254),
            redTextColor = new Color(187,87,90),
            clickColor = new Color(48, 49, 54);

    BlackJack() {

        deck = new ArrayList<>(51);
        for(int i=2 ; i<10 ; i++) {
            deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/"+i+"_of_clubs.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        }
        for(int i=2 ; i<10 ; i++) {
            deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/"+i+"_of_spades.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        }
        for(int i=2 ; i<10 ; i++) {
            deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/"+i+"_of_clubs.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        }
        for(int i=2 ; i<10 ; i++) {
            deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/"+i+"_of_clubs.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        }

        frame = new JFrame("BlackJack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(panelColor);

        playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(2,3,8,8));
            // playerPanel.add(deck.get(0));
        playerPanel.setBounds(0,150,400,400);
        playerPanel.setBackground(fieldColor);

        dealerPanel = new JPanel();
        dealerPanel.setLayout(new GridLayout(2,3,8,8));
            // dealerPanel.add(deck.get(5));
        dealerPanel.setBounds(585,150,400,400);
        dealerPanel.setBackground(fieldColor);

        hitButton = new JButton("hit");
        hitButton.addActionListener(this);
        hitButton.setFont(new Font("Arial", Font.BOLD, 30));
        hitButton.setFocusable(false);
        hitButton.setBackground(btnColor);
        hitButton.setForeground(textColor);
        hitButton.setBounds(135,570,130,80);
        hitButton.setBorder(BorderFactory.createEmptyBorder());

        standButton = new JButton("stand");
        standButton.addActionListener(this);
        standButton.setFont(new Font("Arial", Font.BOLD, 30));
        standButton.setFocusable(false);
        standButton.setBackground(btnColor);
        standButton.setForeground(textColor);
        standButton.setBounds(720,570,130,80);
        standButton.setBorder(BorderFactory.createEmptyBorder());

        dealButton = new JButton("deal");
        dealButton.addActionListener(this);
        dealButton.setFont(new Font("Arial", Font.BOLD, 30));
        dealButton.setFocusable(false);
        dealButton.setBackground(btnColor);
        dealButton.setForeground(textColor);
        dealButton.setBounds(425,20,130,80);
        dealButton.setBorder(BorderFactory.createEmptyBorder());

        playerScoreLabel = new JLabel();
        playerScoreLabel.setText(playerScore + "  player");
        playerScoreLabel.setFont(new Font("Arial", Font.BOLD, 70));
        playerScoreLabel.setBounds(25,50,400,60);
        playerScoreLabel.setForeground(textColor);

        dealerScoreLabel = new JLabel();
        dealerScoreLabel.setText("dealer  " + dealerScore);
        dealerScoreLabel.setFont(new Font("Arial", Font.BOLD, 70));
        dealerScoreLabel.setBounds(620,50,400,60);
        dealerScoreLabel.setForeground(textColor);

        frame.add(playerPanel);
        frame.add(dealerPanel);
        frame.add(hitButton);
        frame.add(standButton);
        frame.add(dealButton);
        frame.add(playerScoreLabel);
        frame.add(dealerScoreLabel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

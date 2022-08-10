import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BlackJack implements ActionListener {

    JFrame frame;
    JPanel playerPanel;
    JPanel dealerPanel;
    ArrayList<JLabel> deck;

    JLabel playerScoreLabel;
    int playerScore = 0;
    JLabel dealerScoreLabel;
    int dealerScore = 0;

    JLabel gameOverLabel;

    JButton hitButton;
    JButton standButton;
    JButton dealButton;
    JButton restartButton;

    HashMap<Integer, Integer> cardValues = new HashMap<>();
    ArrayList<Integer> numList = new ArrayList<Integer>(51);

    Color   btnColor = new Color(34,37,45),
            fieldColor = new Color(39,43,51),
            panelColor = new Color(41, 45, 54),
            textColor = new Color(254,254,254),
            redTextColor = new Color(187,87,90),
            clickColor = new Color(48, 49, 54);

    BlackJack() {

        UIManager.put("Button.select", clickColor);

        for(int i=0; i<51;i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);

        cardValues.put(0,2);    cardValues.put(1,3);    cardValues.put(2,4);
        cardValues.put(3,5);    cardValues.put(4,6);    cardValues.put(5,7);
        cardValues.put(6,8);    cardValues.put(7,9);    cardValues.put(8,10);

        cardValues.put(9,2);    cardValues.put(10,3);   cardValues.put(11,4);
        cardValues.put(12,5);   cardValues.put(13,6);   cardValues.put(14,7);
        cardValues.put(15,8);   cardValues.put(16,9);   cardValues.put(17,10);

        cardValues.put(18,2);   cardValues.put(19,3);   cardValues.put(20,4);
        cardValues.put(21,5);   cardValues.put(22,6);   cardValues.put(23,7);
        cardValues.put(24,8);   cardValues.put(25,9);   cardValues.put(26,10);

        cardValues.put(27,2);   cardValues.put(28,3);   cardValues.put(29,4);
        cardValues.put(30,5);   cardValues.put(31,6);   cardValues.put(32,7);
        cardValues.put(33,8);   cardValues.put(34,9);   cardValues.put(35,10);

        cardValues.put(36,11);   cardValues.put(37,11);   cardValues.put(38,11);   cardValues.put(39,11);
        cardValues.put(40,10);   cardValues.put(41,10);   cardValues.put(42,10);   cardValues.put(43,10);
        cardValues.put(44,10);   cardValues.put(45,10);   cardValues.put(46,10);   cardValues.put(47,10);
        cardValues.put(48,10);   cardValues.put(49,10);   cardValues.put(50,10);   cardValues.put(51,10);


        deck = new ArrayList<>(51);

        for(int i=2 ; i<11 ; i++) {
            deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/"+i+"_of_clubs.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        }
        for(int i=2 ; i<11 ; i++) {
            deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/"+i+"_of_spades.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        }
        for(int i=2 ; i<11 ; i++) {
            deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/"+i+"_of_hearts.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        }
        for(int i=2 ; i<11 ; i++) {
            deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/"+i+"_of_diamonds.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        }
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/ace_of_clubs.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/ace_of_diamonds.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/ace_of_hearts.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/ace_of_spades.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/jack_of_clubs.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/jack_of_diamonds.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/jack_of_hearts.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/jack_of_spades.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/king_of_clubs.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/king_of_diamonds.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/king_of_hearts.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/king_of_spades.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/queen_of_clubs.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/queen_of_diamonds.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/queen_of_hearts.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));
        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/queen_of_spades.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));

        deck.add(new JLabel(new ImageIcon (new ImageIcon("src/cards/blankCard.png").getImage().getScaledInstance(130, 200, Image.SCALE_DEFAULT))));

        frame = new JFrame("BlackJack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(panelColor);

        playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(2,3,8,8));
        playerPanel.setBounds(0,150,400,400);
        playerPanel.setBackground(fieldColor);

        dealerPanel = new JPanel();
        dealerPanel.setLayout(new GridLayout(2,3,8,8));
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
        hitButton.setVisible(false);

        standButton = new JButton("stand");
        standButton.addActionListener(this);
        standButton.setFont(new Font("Arial", Font.BOLD, 30));
        standButton.setFocusable(false);
        standButton.setBackground(btnColor);
        standButton.setForeground(textColor);
        standButton.setBounds(720,570,130,80);
        standButton.setBorder(BorderFactory.createEmptyBorder());
        standButton.setVisible(false);

        dealButton = new JButton("deal");
        dealButton.addActionListener(this);
        dealButton.setFont(new Font("Arial", Font.BOLD, 30));
        dealButton.setFocusable(false);
        dealButton.setBackground(btnColor);
        dealButton.setForeground(textColor);
        dealButton.setBounds(425,60,130,80);
        dealButton.setBorder(BorderFactory.createEmptyBorder());

        restartButton = new JButton("restart");
        restartButton.addActionListener(this);
        restartButton.setFont(new Font("Arial", Font.BOLD, 15));
        restartButton.setFocusable(false);
        restartButton.setBackground(btnColor);
        restartButton.setForeground(textColor);
        restartButton.setBounds(459,20,60,30);
        restartButton.setBorder(BorderFactory.createEmptyBorder());

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

        gameOverLabel = new JLabel();
        gameOverLabel.setText("game over");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 70));
        gameOverLabel.setBounds(320,560,400,90);
        gameOverLabel.setForeground(redTextColor);
        gameOverLabel.setVisible(false);

        frame.add(playerPanel);
        frame.add(dealerPanel);
        frame.add(hitButton);
        frame.add(standButton);
        frame.add(dealButton);
        frame.add(restartButton);
        frame.add(playerScoreLabel);
        frame.add(dealerScoreLabel);
        frame.add(gameOverLabel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==dealButton) {
            playerPanel.add(deck.get(numList.get(0)));
            playerPanel.add(deck.get(numList.get(1)));

            playerScore += cardValues.get(numList.get(0));
            playerScore += cardValues.get(numList.get(1));
            playerScoreLabel.setText(playerScore + "  player");
            playerScoreLabel.revalidate();
            playerScoreLabel.repaint();
            playerPanel.revalidate();
            playerPanel.repaint();

            // dealerPanel.add(deck.get(numList.get(2)));
            dealerPanel.add(deck.get(52));
            dealerPanel.add(deck.get(numList.get(3)));

            // dealerScore += cardValues.get(numList.get(2));
            dealerScore += cardValues.get(numList.get(3));
            dealerScoreLabel.setText("dealer  " + dealerScore);
            dealerScoreLabel.revalidate();
            dealerScoreLabel.repaint();
            dealerPanel.revalidate();
            dealerPanel.repaint();

            dealButton.setVisible(false);
            hitButton.setVisible(true);
            standButton.setVisible(true);

            checkBust();
            checkWin();

            frame.revalidate();
            frame.repaint();
        }
        if(e.getSource()==hitButton) {

            if(deck.get(numList.get(4)).getParent() == playerPanel) {
                playerPanel.add(deck.get(numList.get(5)));
                playerScore += cardValues.get(numList.get(5));
            }

            playerPanel.add(deck.get(numList.get(4)));
            playerScore += cardValues.get(numList.get(4));

            playerScoreLabel.setText(playerScore + "  player");

            checkBust();
            checkWin();

            playerScoreLabel.revalidate();
            playerScoreLabel.repaint();
            playerPanel.revalidate();
            playerPanel.repaint();
            frame.revalidate();
            frame.repaint();

        }
        if(e.getSource()==standButton) {
            dealerPanel.remove(deck.get(52));
            if(dealerScore>playerScore) {
                dealerPanel.add(deck.get(numList.get(2)));

            }else {
                if(deck.get(numList.get(50)).getParent() == dealerPanel) {
                    dealerPanel.add(deck.get(numList.get(49)));
                    dealerScore += cardValues.get(numList.get(49));
                    dealerScoreLabel.setText("dealer  " + dealerScore);
                }
                dealerPanel.add(deck.get(numList.get(50)));
                dealerScore += cardValues.get(numList.get(50));
            }

            dealerScoreLabel.setText("dealer  " + dealerScore);

            checkBust();
            checkWin();

            dealerScoreLabel.revalidate();
            dealerScoreLabel.repaint();
            dealerPanel.revalidate();
            dealerPanel.repaint();
            frame.revalidate();
            frame.repaint();
        }
        if(e.getSource()==restartButton) {
            restart();
        }

    }
    public void checkBust() {
        if(playerScore>21) {
            hitButton.setVisible(false);
            standButton.setVisible(false);

            gameOverLabel.setText("you lose");
            gameOverLabel.setVisible(true);
        }
        if(dealerScore>21) {
            hitButton.setVisible(false);
            standButton.setVisible(false);

            gameOverLabel.setText("you win");
            gameOverLabel.setVisible(true);

        }
    }
    public void checkWin() {
        if(playerScore==21) {
            hitButton.setVisible(false);
            standButton.setVisible(false);

            gameOverLabel.setText("you win");
            gameOverLabel.setVisible(true);
        }
        if(dealerScore==21) {
            hitButton.setVisible(false);
            standButton.setVisible(false);

            gameOverLabel.setText("you lose");
            gameOverLabel.setVisible(true);

        }
    }
    public void restart() {
        Collections.shuffle(numList);

        playerScore = 0;
        dealerScore = 0;
        playerScoreLabel.setText(playerScore + "  player");
        dealerScoreLabel.setText("dealer  " + dealerScore);
        dealButton.setVisible(true);
        gameOverLabel.setVisible(false);
        hitButton.setVisible(false);
        standButton.setVisible(false);
        playerPanel.removeAll();
        dealerPanel.removeAll();

        playerScoreLabel.revalidate();
        playerScoreLabel.repaint();
        playerPanel.revalidate();
        playerPanel.repaint();
        dealerScoreLabel.revalidate();
        dealerScoreLabel.repaint();
        dealerPanel.revalidate();
        dealerPanel.repaint();
        frame.revalidate();
        frame.repaint();
    }
}

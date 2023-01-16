package de.hebk.controll.gui;

import de.hebk.controll.Controll;
import de.hebk.gamemode.Gamemode;
import de.hebk.gamemode.ModeSurvive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModesurviveGui extends JFrame implements ActionListener {
    private Gamemode gamemode;
    private Controll ctrl;
    private JButton button4;
    private JButton button3;
    private JButton button2;
    private JButton button1;
    private JPanel panel1;
    private JButton beenden;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private int count = 0;
    private boolean check = false;

    /**
     * Konstruktor
     * @param pControll
     * @param pGamemode
     * @param ptitle
     */
    public ModesurviveGui(Controll pControll, Gamemode pGamemode, String ptitle) {
        super(ptitle);
        ctrl = pControll;
        this.gamemode = pGamemode;
        gamemode.randomQuestion(null);
        generateLabelButtontext();
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        beenden.addActionListener(this);
        beenden.setForeground(Color.white);
        beenden.setBackground(new Color(3,37,126));
        this.add(panel1);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Generiert die Buttons mit den Texten und Back/Foregrounds
     */
    private void generateLabelButtontext() {
        textArea2.setText(gamemode.getCurrentQuestion().getQuestion());
        textArea2.setBackground(new Color(3,37,126));
        textArea2.setForeground(Color.white);
        button1.setBackground(Color.BLUE);
        button2.setBackground(Color.BLUE);
        button3.setBackground(Color.BLUE);
        button4.setBackground(Color.BLUE);
        button1.setForeground(Color.white);
        button2.setForeground(Color.white);
        button3.setForeground(Color.white);
        button4.setForeground(Color.white);
        button1.setText(gamemode.getCurrentQuestion().getAnswers()[0]);
        button2.setText(gamemode.getCurrentQuestion().getAnswers()[1]);
        button3.setText(gamemode.getCurrentQuestion().getAnswers()[2]);
        button4.setText(gamemode.getCurrentQuestion().getAnswers()[3]);
        textArea1.setText("Deine Punktzahl: "+count);
        textArea1.setBackground(new Color(3,37,126));
        textArea1.setForeground(Color.white);
    }

    @Override
    /**
     * Actionlistener
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1 || e.getSource() == button2 || e.getSource() == button3 || e.getSource() == button4) {
            if(gamemode.checkcorrect(((JButton)e.getSource()).getText())) {
                count++;
                ctrl.getGame().getUser()[0].setCount(count);
                textArea1.setText("Deine Punktzahl: "+ count);
                gamemode.randomQuestion(null);
                try {
                    generateLabelButtontext();
                } catch(Exception ie) {
                    textArea1.setText("Du hast alle fragen gelöst!");
                    textArea1.setForeground(Color.green);
                }
            } else {
                textArea1.setText("Das war falsch");
                textArea1.setForeground(Color.RED);
                deletebutton();
            }
        } else if(e.getSource()==beenden) {
            ctrl.showMenu();
            this.setVisible(false);
            ctrl.getLeaderboard().addPosLeaderboard(gamemode);
        }
    }

    /**
     * Sichtbarkeit der Buttons wird verändert
     */
    public void deletebutton() {
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }
}

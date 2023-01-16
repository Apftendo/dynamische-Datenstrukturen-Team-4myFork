package de.hebk.controll.gui;

import de.hebk.controll.Controll;
import de.hebk.gamemode.Gamemode;
import de.hebk.gamemode.ModeNormal;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModenormalGui extends JFrame implements ActionListener{



    private Gamemode gamemode;
    private Controll ctrl;
    private int count = 0;
    private JPanel panel1;
    private JButton antwort1;
    private JButton antwort2;
    private JButton antwort3;
    private JButton antwort4;
    private JPanel geldAnzeige;
    private JPanel antworten;
    private JPanel fragePanel;
    private JButton joker1;
    private JButton joker3;
    private JButton joker2;
    private JPanel joker;
    private JLabel[] moneyarr;
    private JLabel money1;
    private JLabel money2;
    private JLabel money3;
    private JLabel money4;
    private JLabel money5;
    private JLabel money6;
    private JLabel money7;
    private JLabel money8;
    private JLabel money9;
    private JLabel money10;
    private JLabel money11;
    private JLabel money12;
    private JLabel money13;
    private JLabel money14;
    private JLabel money15;
    private JButton end;
    private JTextArea textArea1;

    /**
     * Konstruktor
     * @param pCtrl
     * @param pGamemode
     * @param pTitel
     */
    public ModenormalGui(Controll pCtrl, Gamemode pGamemode, String pTitel) {
        super(pTitel);
        ctrl = pCtrl;
        gamemode = pGamemode;
        gamemode.randomQuestion(null);
        generateLabelButtontext();
        addMoneyarr();
        this.add(panel1);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //Icons für Joker
        Icon joker50 = new ImageIcon("src/main/java/de/hebk/images/icons/img_3.png");
        joker1.setIcon(joker50);
        Icon jokertele = new ImageIcon("src/main/java/de/hebk/images/icons/img_1.png");
        joker2.setIcon(jokertele);
        Icon jokeraudience = new ImageIcon("src/main/java/de/hebk/images/icons/img_2.png");
        joker3.setIcon(jokeraudience);
        antwort1.addActionListener(this);
        antwort2.addActionListener(this);
        antwort3.addActionListener(this);
        antwort4.addActionListener(this);
        end.addActionListener(this);
        joker1.addActionListener(this);
        joker2.addActionListener(this);
        joker3.addActionListener(this);
    }

    /**
     * Actionlistener
     * @param event the event to be processed
     */
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == antwort1 || event.getSource() == antwort2 || event.getSource() == antwort3 || event.getSource() == antwort4){
            if(gamemode.checkcorrect(((JButton) event.getSource()).getText())){
                count++;
                moneycount();
                if(count == 14){
                    deleteAnswerbuttons();
                    textArea1.setText("DU HAST 1.000.000€ GEWONNEN ");
                    textArea1.setForeground(Color.orange);
                }else{
                    gamemode.nextQuestion();
                    generateLabelButtontext();
                }
            }else{
                textArea1.setText("Diese Antwort ist Falsch");
                textArea1.setForeground(Color.RED);
                deleteAnswerbuttons();
            }
        }else if(event.getSource() == end){
            ctrl.showMenu();
            this.setVisible(false);
            ctrl.getLeaderboard().addPosLeaderboard(gamemode);
        }else if(event.getSource() == joker1){
            usefiftyfifty();
            joker1.setVisible(false);
        }else if(event.getSource() == joker2){
            usetelephone();
            joker2.setVisible(false);
        }else if(event.getSource() == joker3){
            useaudiencejoker();
            joker3.setVisible(false);
        }
    }

    /**
     * Packt die money Label in ein array
     * hilft um besser auf die jeweiligen Stellen zuzugreifen
     */
    private void addMoneyarr(){
        moneyarr = new JLabel[15];
        moneyarr[0] = money1;
        moneyarr[1] = money2;
        moneyarr[2] = money3;
        moneyarr[3] = money4;
        moneyarr[4] = money5;
        moneyarr[5] = money6;
        moneyarr[6] = money7;
        moneyarr[7] = money8;
        moneyarr[8] = money9;
        moneyarr[9] = money10;
        moneyarr[10] = money11;
        moneyarr[11] = money12;
        moneyarr[12] = money13;
        moneyarr[13] = money14;
        moneyarr[14] = money15;
        moneyarr[count].setForeground(Color.RED);
    }

    /**
     * verändert die Sichtbarkeit der Antwort Buttons
     */
    private void deleteAnswerbuttons(){
        antwort1.setVisible(false);
        antwort2.setVisible(false);
        antwort3.setVisible(false);
        antwort4.setVisible(false);
    }

    /**
     * Generiert die Texte der Frage und Antwortmöglichkeiten
     */
    private void generateLabelButtontext() {
        gamemode.getCurrentQuestion().randomAnswers();
        antwort1.setVisible(true);
        antwort2.setVisible(true);
        antwort3.setVisible(true);
        antwort4.setVisible(true);
        antwort1.setText(gamemode.getCurrentQuestion().getAnswers()[0]);
        antwort2.setText(gamemode.getCurrentQuestion().getAnswers()[1]);
        antwort3.setText(gamemode.getCurrentQuestion().getAnswers()[2]);
        antwort4.setText(gamemode.getCurrentQuestion().getAnswers()[3]);
        textArea1.setText(gamemode.getCurrentQuestion().getQuestion());
    }

    /**
     * Methode um den 50/50 Joker zu benutzen
     */
    private void usefiftyfifty(){
        ctrl.getGame().getGamemode().useJoker(0);
        gamemode.getCurrentQuestion().randomAnswers();
        antwort1.setText(gamemode.getCurrentQuestion().getAnswers()[0]);
        antwort2.setText(gamemode.getCurrentQuestion().getAnswers()[1]);
        antwort3.setVisible(false);
        antwort4.setVisible(false);
    }

    /**
     * Methode um den Telefonjoker zu benutzen
     */
    private void usetelephone(){
        ctrl.getGame().getGamemode().useJoker(1);
        textArea1.setText(gamemode.getCurrentQuestion().getQuestion());
    }

    /**
     * Methode um den Publikumsjoker zu benutzen
     */
    private void useaudiencejoker(){
        ctrl.getGame().getGamemode().useJoker(2);
        textArea1.setText(gamemode.getCurrentQuestion().getQuestion());
    }

    /**
     * Methode um den jeweiligen Geld Fortschritt zu setzten
     */
    private void moneycount(){
        if(count == 4 || count == 9 || count == 14){
            moneyarr[count].setForeground(new Color(75,82,142));
        }else{
            moneyarr[count].setForeground(Color.RED);
        }
    }
}
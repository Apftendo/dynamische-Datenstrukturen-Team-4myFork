package de.hebk.controll.gui;

import de.hebk.controll.Controll;
import de.hebk.gamemode.Gamemode;
import de.hebk.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModejeopardyGui extends JFrame implements ActionListener {
    private User[] users = new User[2];
    private int point;
    private User currentPlayer;
    private Controll ctrl;
    private Gamemode gamemode;
    private JPanel jeopardy;
    private JLabel topic1;
    private JLabel topic2;
    private JLabel topic3;
    private JLabel topic4;
    private JButton first100;
    private JButton first200;
    private JButton first300;
    private JButton first400;
    private JButton first500;
    private JButton first600;
    private JButton second100;
    private JButton second200;
    private JButton second300;
    private JButton second400;
    private JButton second500;
    private JButton second600;
    private JButton third100;
    private JButton third200;
    private JButton third300;
    private JButton third400;
    private JButton third500;
    private JButton third600;
    private JButton fourth200;
    private JButton fourth300;
    private JButton fourth400;
    private JButton fourth500;
    private JButton fourth600;
    private JButton fourth100;
    private JPanel questions;
    private JTextArea question;
    private JButton answers1;
    private JButton answers3;
    private JButton answers4;
    private JButton answers2;
    private JLabel team1;
    private JLabel team2;
    private JPanel pointteam1;
    private JLabel point2;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel answers;
    private JPanel points;
    private JButton homebutton;
    private JPanel home;
    private JLabel point1;
    private JPanel pointteam2;

    public ModejeopardyGui(Controll pCtrl, Gamemode pGamemode ,String pTitel, String[] pTopics,User user2){
        super(pTitel);
        ctrl = pCtrl;
        gamemode = pGamemode;

        //User
        users[0] = ctrl.getGame().getUser();
        users[1] = user2;
        currentPlayer = users[0];
        team1.setText(users[0].getName());
        team2.setText(users[1].getName());

        this.add(jeopardy);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        generateTopicLabel(pTopics);
        disabletextAnswers();

        first100.addActionListener(this);
        first200.addActionListener(this);
        first300.addActionListener(this);
        first400.addActionListener(this);
        first500.addActionListener(this);
        first600.addActionListener(this);
        second100.addActionListener(this);
        second200.addActionListener(this);
        second300.addActionListener(this);
        second400.addActionListener(this);
        second500.addActionListener(this);
        second600.addActionListener(this);
        third100.addActionListener(this);
        third200.addActionListener(this);
        third300.addActionListener(this);
        third400.addActionListener(this);
        third500.addActionListener(this);
        third600.addActionListener(this);
        fourth100.addActionListener(this);
        fourth200.addActionListener(this);
        fourth300.addActionListener(this);
        fourth400.addActionListener(this);
        fourth500.addActionListener(this);
        fourth600.addActionListener(this);
        answers1.addActionListener(this);
        answers2.addActionListener(this);
        answers3.addActionListener(this);
        answers4.addActionListener(this);
        homebutton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == homebutton){
            ctrl.showMenu();
            this.setVisible(false);
        }
        if(event.getSource() == first100 || event.getSource() == first200){
            generateQuestion(topic1.getText(),1);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }else if(event.getSource() == first300 || event.getSource() == first400){
            generateQuestion(topic1.getText(),2);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }else if(event.getSource() == first500 || event.getSource() == first600){
            generateQuestion(topic1.getText(),3);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }else if(event.getSource() == second100 || event.getSource() == second200){
            generateQuestion(topic2.getText(),1);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }else if(event.getSource() == second300 || event.getSource() == second400){
            generateQuestion(topic2.getText(),2);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }else if(event.getSource() == second500 || event.getSource() == second600){
            generateQuestion(topic2.getText(),3);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }else if(event.getSource() == third100 || event.getSource() == third200){
            generateQuestion(topic3.getText(),1);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }else if( event.getSource() == third300 || event.getSource() == third400){
            generateQuestion(topic3.getText(),2);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }else if(event.getSource() == third500|| event.getSource() == third600){
            generateQuestion(topic3.getText(),3);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }else if(event.getSource() == fourth100 || event.getSource() == fourth200){
            generateQuestion(topic4.getText(),1);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }else if(event.getSource() == fourth300 || event.getSource() == fourth400){
            generateQuestion(topic4.getText(),2);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }else if(event.getSource() == fourth500 || event.getSource() == fourth600) {
            generateQuestion(topic4.getText(), 3);
            ((JButton) event.getSource()).setVisible(false);
            point = Integer.parseInt(((JButton) event.getSource()).getText());
        }
        if(event.getSource() == answers1 || event.getSource() == answers2 || event.getSource() == answers3 || event.getSource() == answers4){
            if(gamemode.checkcorrect(((JButton) event.getSource()).getText())){
                disabletextAnswers();
                question.setText("Diese Antwort ist Richtig!");
                pointCounter(point);
            }else{
                disabletextAnswers();
                question.setText("Diese Antwort ist Falsch!");
                pointCounter(0);
            }
        }
    }



    private void generateTopicLabel(String[] pTopic){
        topic1.setText(pTopic[0]);
        topic2.setText(pTopic[1]);
        topic3.setText(pTopic[2]);
        topic4.setText(pTopic[3]);
    }

    private void generateQuestion(String pTopic,int input){
        gamemode.setLvl(input);
        gamemode.randomQuestion(pTopic);
        gamemode.getCurrentQuestion().randomAnswers();
        question.setVisible(true);
        answers1.setVisible(true);
        answers2.setVisible(true);
        answers3.setVisible(true);
        answers4.setVisible(true);
        question.setText(gamemode.getCurrentQuestion().getQuestion());
        answers1.setText(gamemode.getCurrentQuestion().getAnswers()[0]);
        answers2.setText(gamemode.getCurrentQuestion().getAnswers()[1]);
        answers3.setText(gamemode.getCurrentQuestion().getAnswers()[2]);
        answers4.setText(gamemode.getCurrentQuestion().getAnswers()[3]);
    }

    private void disabletextAnswers(){
        answers1.setVisible(false);
        answers2.setVisible(false);
        answers3.setVisible(false);
        answers4.setVisible(false);
    }

    private void pointCounter(int pPoints){
        if(currentPlayer == users[0]){
            users[0].setPoints(users[0].getPoints() + pPoints);
            point1.setText(String.valueOf(users[0].getPoints())+ " Punkte");
            currentPlayer = users[1];
        }else if(currentPlayer == users[1]){
            users[1].setPoints(users[1].getPoints() + pPoints);
            point2.setText(String.valueOf(users[1].getPoints())+ " Punkte");
            currentPlayer = users[0];
        }
    }
}

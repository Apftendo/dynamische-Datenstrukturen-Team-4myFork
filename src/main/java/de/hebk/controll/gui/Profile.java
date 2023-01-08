package de.hebk.controll.gui;

import de.hebk.controll.Controll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JFrame implements ActionListener {
    private Controll ctrl;
    private JPanel profile;
    private JPanel mid;
    private JLabel usernametext;
    private JLabel pointstext;
    private JLabel username;
    private JLabel points;
    private JButton benutzernamenÄndernButton;

    public Profile(Controll pCtrl, String pTitel){
        super(pTitel);
        ctrl = pCtrl;
        this.add(profile);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        username.setText(ctrl.getGame().getUser().getName());
        points.setText(String.valueOf(ctrl.getGame().getUser().getPoints()));
    }

    public void actionPerformed(ActionEvent event){

    }
}

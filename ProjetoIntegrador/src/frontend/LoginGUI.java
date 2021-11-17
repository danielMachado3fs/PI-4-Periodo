package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {
    private JLabel lbLogin, lbEmail, lbSenha;
    private JTextField tfEmail;
    private JPasswordField pfSenha;
    private JButton btLogin, btCancel;
    private JPanel pEmail, pSenha, pLogin, pButtons;
    private JFrame windowLogin;

    LoginGUI(){
        lbLogin = new JLabel("Login");
        lbEmail = new JLabel("Email");
        lbSenha = new JLabel("Senha");

        tfEmail = new JTextField(30);
        tfEmail.setMaximumSize(new Dimension(30,10));
        pfSenha = new JPasswordField(30);
        pfSenha.setMaximumSize(new Dimension(30,10));

        btLogin = new JButton("Entrar");
        btCancel = new JButton("Cancelar");

        pEmail = new JPanel();
        pEmail.setLayout(new FlowLayout());
        pSenha = new JPanel();
        pSenha.setLayout(new FlowLayout());
        pLogin = new JPanel();
        pLogin.setLayout(new FlowLayout());
        pButtons = new JPanel();
        pButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));

        pLogin.add(lbLogin);
        pEmail.add(lbEmail);    pEmail.add(tfEmail);
        pSenha.add(lbSenha);    pSenha.add(pfSenha);
        pButtons.add(btLogin);  pButtons.add(btCancel);

        eventsLogin eventosLogin = new eventsLogin();

        btLogin.addActionListener(eventosLogin);
        btCancel.addActionListener(eventosLogin);

        windowLogin = new JFrame("Login");
        windowLogin.setLayout(new BorderLayout());
        windowLogin.add(pLogin);
        windowLogin.add(pEmail);
        windowLogin.add(pSenha);
        windowLogin.add(pButtons);
        windowLogin.setSize(400,400);
        windowLogin.setLocationRelativeTo(null);
        windowLogin.setVisible(true);

    }

    private class eventsLogin implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String email, senha;
            if(e.getSource() == btLogin){

            }
        }
    }

    public static void main(String [] args){
        new LoginGUI();
    }
}

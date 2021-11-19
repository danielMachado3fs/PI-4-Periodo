package frontend;

import backend.UpdateBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginGUI {
    private JLabel lbLogin, lbEmail, lbSenha;
    private JTextField tfEmail;
    private JPasswordField pfSenha;
    private JButton btLogin, btCancel;
    private JPanel pEmail, pSenha, pLogin, pButtons, pPanels;
    private JFrame windowLogin;

    LoginGUI(){
        lbLogin = new JLabel("Login");
        lbLogin.setFont(new Font("Trebuchet", Font.BOLD,40));
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
        pPanels = new JPanel();
        pPanels.setLayout(new GridLayout(0,1));

        pLogin.add(lbLogin);
        pEmail.add(lbEmail);    pEmail.add(tfEmail);
        pSenha.add(lbSenha);    pSenha.add(pfSenha);
        pButtons.add(btLogin);  pButtons.add(btCancel);
        pPanels.add(pLogin);
        pPanels.add(pEmail);
        pPanels.add(pSenha);

        eventsLogin eventosLogin = new eventsLogin();

        btLogin.addActionListener(eventosLogin);
        btCancel.addActionListener(eventosLogin);

        windowLogin = new JFrame("Login");
        windowLogin.setSize(500,400);
        windowLogin.setLayout(new BorderLayout());
        windowLogin.add(pPanels, BorderLayout.CENTER);
        windowLogin.add(pButtons, BorderLayout.SOUTH);
        windowLogin.setLocationRelativeTo(null);
        windowLogin.setVisible(true);

    }

    private class eventsLogin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String data, senha, senhabd = null;
            ResultSet dataUser;

            if (e.getSource() == btLogin) {
                data = tfEmail.getText();
                dataUser = UpdateBD.queryUser(data);
                System.out.println(dataUser);

                try {
                    if (!dataUser.next()) {
                        JOptionPane.showMessageDialog(null, "Usuário incorreto");
                    }else {
                        do {
                            senhabd = dataUser.getString("at_senha");
                            System.out.println(senhabd);
                        }while (dataUser.next());
                        senha = pfSenha.getText();

                        if (senha.equals(senhabd)) {
                            UpdateFormVisitor window = new UpdateFormVisitor();
                        } else {
                            JOptionPane.showMessageDialog(null, "Senha incorreta!");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String [] args){
        new LoginGUI();
    }
}

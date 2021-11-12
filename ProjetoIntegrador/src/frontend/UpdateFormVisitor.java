package frontend;

import backend.UpdateBD;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateFormVisitor {

    private JLabel lbName, lbEmail, lbPassword, lbLocalization, lbCpf, lbMensage;
    private JTextField tfName, tfEmail,  tfLocalization, tfCpf;
    private JPasswordField password;
    private JButton update, cancel;
    private JFrame windowUpdateVisitor;
    private JPanel pName, pEmail, pCPF, pLocalization, pPassword, pButtons, pMensage;

    //monta a janela

    UpdateFormVisitor(){
        //instancia os componentes
        //labels

        lbMensage = new JLabel("Atualizar Cadastro");
        lbMensage.setFont(new Font("Trebuchet", Font.BOLD,20));
        lbName = new JLabel("Nome");
        lbEmail = new JLabel("Email");
        lbCpf = new JLabel("CPF");
        lbPassword = new JLabel("Senha");
        lbLocalization = new JLabel("Localização");

        //textFields

        tfName = new JTextField(40);
        tfEmail = new JTextField(40);
        tfCpf = new JTextField(20);
        tfCpf.setEnabled(false);
        tfLocalization = new JTextField(40);
        password = new JPasswordField(30);

        //buttons

        update = new JButton("Atualizar");
        update.setSize(new Dimension(15,10));
        cancel = new JButton("Cancelar");
        cancel.setSize(new Dimension(15,10));

        //configura panels

        Border border = BorderFactory.createEtchedBorder();
        pMensage = new JPanel();
        pMensage.setLayout(new FlowLayout());
        pMensage.setBackground(Color.CYAN);
        pName = new JPanel();
        pName.setBorder(border);
        pName.setLayout(new FlowLayout(FlowLayout.LEFT));
        pEmail = new JPanel();
        pEmail.setBorder(border);
        pEmail.setLayout(new FlowLayout(FlowLayout.LEFT));
        pLocalization = new JPanel();
        pLocalization.setBorder(border);
        pLocalization.setLayout(new FlowLayout(FlowLayout.LEFT));
        pPassword = new JPanel();
        pPassword.setBorder(border);
        pPassword.setLayout(new FlowLayout(FlowLayout.LEFT));
        pCPF = new JPanel();
        pCPF.setBorder(border);
        pCPF.setLayout(new FlowLayout(FlowLayout.LEFT));
        pButtons = new JPanel();
        pButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //configura janela

        windowUpdateVisitor = new JFrame("Atualizar Cadastro");
        windowUpdateVisitor.setSize(600,400);
        windowUpdateVisitor.setLayout(new GridLayout(10,1));
        windowUpdateVisitor.setLocationRelativeTo(null);
        windowUpdateVisitor.setVisible(true);

        //coloca elementos nos paineis

        pMensage.add(lbMensage);
        pCPF.add(lbCpf);    pCPF.add(tfCpf);
        pName.add(lbName);  pName.add(tfName);
        pEmail.add(lbEmail);    pEmail.add(tfEmail);
        pLocalization.add(lbLocalization);  pLocalization.add(tfLocalization);
        pPassword.add(lbPassword);  pPassword.add(password);
        pButtons.add(update);   pButtons.add(cancel);

        //coloca paineis na janela

        windowUpdateVisitor.add(pMensage);
        windowUpdateVisitor.add(pName);
        windowUpdateVisitor.add(pEmail);
        windowUpdateVisitor.add(pCPF);
        windowUpdateVisitor.add(pPassword);
        windowUpdateVisitor.add(pLocalization);
        windowUpdateVisitor.add(pButtons);

        //instacia classe interna de eventos
        EventsVisitor evento = new EventsVisitor();

        //registra eventos do botão
        update.addActionListener(evento);
        cancel.addActionListener(evento);

    }

    private class EventsVisitor implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String cpf = null;
            /*if(e.getSource() == data){
                cpf = tfCpf.getText();
                ResultSet dataUser = UpdateBD.queryUser(cpf);
                try{dataUser.next();
                    tfName.setText(dataUser.getString("at_nome"));
                    tfEmail.setText(dataUser.getString("at_email"));
                    password.setText(dataUser.getString("at_senha"));
                    tfLocalization.setText(dataUser.getString("at_localizacao"));
                }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
                }
            }*/

            if(e.getSource() == update){
                String name = tfName.getText();
                String email = tfEmail.getText();
                String upPassword = password.getText();
                String localization = tfLocalization.getText();
                int confirmation = JOptionPane.showConfirmDialog(null,"Deseja salvar as alterações?");
                if(confirmation == 0){
                    if (name.equals("") || email.equals("") ||  upPassword.equals("") ||  localization.equals("")){
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    }
                    else {
                        String passwordCri = UpdateBD.getSHA256(upPassword);
                        int up = UpdateBD.updateUser(name, email, passwordCri, localization, cpf);
                        if(up == 1){
                            JOptionPane.showMessageDialog(null, "Não foi possivel inserir o usuario");
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
                        }
                    }
                }
            } else if(e.getSource() == cancel){
                windowUpdateVisitor.dispose();
            }
        }
    }

    public static void main(String [] args){
        new UpdateFormVisitor();
    }

}

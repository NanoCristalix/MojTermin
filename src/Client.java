import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Client extends JFrame implements ActionListener {
    JPanel panel;
    JTextField NewMsg;
    JTextArea Chat;
    JButton Send;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket socket;


    public Client() throws IOException {


        panel = new JPanel();
        NewMsg = new JTextField();
        Chat = new JTextArea(23, 43);
        Chat.setLineWrap(true);
        Send = new JButton("Send");
        JScrollPane js = new JScrollPane(Chat);
        js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        panel.setSize(450, 450);
        Chat.setBounds(20, 20, 450, 360);
        Chat.setEditable(false);

        NewMsg.setBounds(20, 400, 340, 30);
        this.getContentPane().add(NewMsg);
        Send.setBounds(375, 400, 95, 30);
        this.getContentPane().add(Send);
        panel.add(js);
        this.getContentPane().add(panel);

        this.setResizable(false);
        setVisible(true);
        this.setTitle("Client");

        Send.addActionListener(this);
        NewMsg.addActionListener(this);

        socket = new Socket("127.0.0.1", 5000);

        while (true) {
            dis = new DataInputStream(socket.getInputStream());
            Chat.append("\nServer: " + dis.readUTF());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            dos = new DataOutputStream(socket.getOutputStream());
            dos.flush();
            dos.writeUTF(NewMsg.getText());


        } catch (IOException ei)

        {
            ei.printStackTrace();
        }
    }



    public static void main(String[] args) throws IOException {
        new Client();

    }
}
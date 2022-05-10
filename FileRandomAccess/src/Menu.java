import java.awt.*;
import javax.swing.*;
import java.io.*;
public class Menu {
    JTextArea txa_output;
    JButton btn_inserisci;
    JButton btn_leggi;
    JTextField txt_nomeCognome;
    JTextField txt_sport;
    JTextField txt_annoNascita;
    JLabel lbl_nomeCognome;
    JLabel lbl_annoNascita;
    JLabel lbl_sport;
    public Menu(){
        JFrame frame_principale = new JFrame("Menu");
        frame_principale.setSize(600,500);
        frame_principale.setLocationRelativeTo(null);
        frame_principale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_inserisci = new JButton("Inserisci");
        btn_leggi = new JButton("Leggi");
        txa_output = new JTextArea(25,25);
        txa_output.setEditable(false);
        txt_nomeCognome = new JTextField(2);
        txt_sport = new JTextField(2);
        txt_annoNascita = new JTextField(2);
        lbl_nomeCognome = new JLabel("Inserire nome e cognome");
        lbl_annoNascita = new JLabel("Inserire Anno di Nascita");
        lbl_sport = new JLabel("Inserire lo sport");

        JScrollPane scr = new JScrollPane(txa_output);

        JPanel pnl_principale = new JPanel();
        JPanel pnl_bottoni = new JPanel();
        JPanel pnl_output = new JPanel();

        pnl_output.setLayout(new BorderLayout());
        pnl_output.add(scr,BorderLayout.CENTER);

        pnl_principale.setLayout(new BorderLayout());
        GridLayout gl = new GridLayout(2,4);
        pnl_bottoni.setLayout(gl);

        pnl_bottoni.add(lbl_nomeCognome);
        pnl_bottoni.add(lbl_sport);
        pnl_bottoni.add(lbl_annoNascita);
        pnl_bottoni.add(btn_inserisci);
        pnl_bottoni.add(txt_nomeCognome);
        pnl_bottoni.add(txt_sport);
        pnl_bottoni.add(txt_annoNascita);
        pnl_bottoni.add(btn_leggi);

        pnl_principale.add(pnl_bottoni,BorderLayout.NORTH);
        pnl_principale.add(pnl_output,BorderLayout.CENTER);

        btn_leggi.addActionListener(new GestoreMenu(this));
        btn_inserisci.addActionListener(new GestoreMenu(this));

        Container container = frame_principale.getContentPane();
        container.add(pnl_principale);
        frame_principale.setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }
}

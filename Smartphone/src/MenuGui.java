import javax.swing.*;
import java.awt.*;

public class MenuGui {
    JButton btn_inserisci;
    JButton btn_leggi;
    JTextField txt_marca;
    JTextField txt_modello;
    JTextField txt_cpu;
    JTextField txt_ram;
    JTextField txt_storage;
    JLabel lbl_smartphone;
    JLabel lbl_marca;
    JLabel lbl_modello;
    JLabel lbl_cpu;
    JLabel lbl_ram;
    JLabel lbl_storage;
    JTextArea txa_file;

    public MenuGui(){
        JFrame frame_principale = new JFrame("Menu");
        frame_principale.setSize(600,500);
        frame_principale.setLocationRelativeTo(null);
        frame_principale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_inserisci = new JButton("Memorizza Smartphone");
        btn_leggi = new JButton("Vedi Smartphone");
        txt_marca = new JTextField(2);
        txt_modello = new JTextField(2);
        txt_cpu = new JTextField(2);
        txt_ram = new JTextField(2);
        txt_storage = new JTextField(2);
        lbl_smartphone = new JLabel("Smartphone");
        lbl_marca = new JLabel("Inserire la Marca");
        lbl_modello = new JLabel("Inserire il modello");
        lbl_cpu = new JLabel("Inserire il Processore(CPU)");
        lbl_ram = new JLabel("Inserire la ram in GB");
        lbl_storage = new JLabel("Inserire la Memoria Interna in GB");
        txa_file = new JTextArea(25,25);

        JScrollPane scr = new JScrollPane(txa_file);

        JPanel pnl_principale = new JPanel();
        JPanel pnl_input = new JPanel();
        JPanel pnl_bottoni = new JPanel();
        JPanel pnl_output = new JPanel();

        pnl_output.setLayout(new BorderLayout());
        pnl_output.add(scr,BorderLayout.CENTER);

        pnl_input.setLayout(new BorderLayout());
        pnl_input.add(lbl_smartphone,BorderLayout.NORTH);

        pnl_principale.setLayout(new BorderLayout());
        GridLayout gl = new GridLayout(2,6);
        pnl_bottoni.setLayout(gl);
        pnl_bottoni.add(lbl_marca);
        pnl_bottoni.add(lbl_modello);
        pnl_bottoni.add(lbl_cpu);
        pnl_bottoni.add(lbl_ram);
        pnl_bottoni.add(lbl_storage);
        pnl_bottoni.add(btn_leggi);
        pnl_bottoni.add(txt_marca);
        pnl_bottoni.add(txt_modello);
        pnl_bottoni.add(txt_cpu);
        pnl_bottoni.add(txt_ram);
        pnl_bottoni.add(txt_storage);
        pnl_bottoni.add(btn_inserisci);

        pnl_input.add(pnl_bottoni,BorderLayout.CENTER);

        pnl_principale.add(pnl_input,BorderLayout.NORTH);
        pnl_principale.add(pnl_output,BorderLayout.CENTER);

        btn_leggi.addActionListener(new GestioneMenuGui(this));
        btn_inserisci.addActionListener(new GestioneMenuGui(this));

        Container container = frame_principale.getContentPane();
        container.add(pnl_principale);
        frame_principale.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuGui();
    }
}

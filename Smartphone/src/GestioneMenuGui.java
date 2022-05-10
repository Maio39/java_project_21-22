import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GestioneMenuGui implements ActionListener {
    MenuGui menu;
    public GestioneMenuGui(MenuGui menu){
        this.menu=menu;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando;
        File file = new File("archivio.dat");
        GestioneFile gs = new GestioneFile(file);
        String marca = menu.txt_marca.getText();
        String modello = menu.txt_modello.getText();
        String cpu = menu.txt_cpu.getText();
        int ram = Integer.parseInt(menu.txt_ram.getText());
        int storage = Integer.parseInt(menu.txt_storage.getText());
        Smartphone tel;
        comando=e.getActionCommand();
        if(comando.equals("Memorizza Smartphone")){
            gs.openFile();
            tel = new Smartphone(marca,modello,cpu,ram,storage);
            gs.write(tel);
            menu.txa_file.append("Dati Inseriti\n\n");
        }
        if(comando.equals("Vedi Smartphone")){
            try{
                gs.openFile();

            }catch(Exception ex){
                ex.printStackTrace();
                for(int i=0;i<gs.numberOfRecords(128);i++){
                    menu.txa_file.append("gs.read()");
                }
            }


        }
    }
}

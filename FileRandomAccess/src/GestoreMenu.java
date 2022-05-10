import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GestoreMenu implements ActionListener{
        Menu menu;
    public GestoreMenu(Menu menu){
        this.menu=menu;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando;
        boolean isFound=true;
        File file = new File("archivioGiocatori.dat");
        GestioneFile gestioneFile = new GestioneFile(file);
        String nomeCognome = menu.txt_nomeCognome.getText();
        int annoNascita = Integer.parseInt(menu.txt_annoNascita.getText());
        String sport = menu.txt_sport.getText();

        comando=e.getActionCommand();
        if(comando.equals("Inserisci")){
            Giocatore giocatore = new Giocatore(nomeCognome,annoNascita,sport);
            if(gestioneFile.openFile()){
                gestioneFile.write(giocatore);
                menu.txa_output.append("Dati Inseriti\n");
                menu.txa_output.append(" Nome Cognome: "+giocatore.getNomeCognome()+"\n");
                menu.txa_output.append(" Sport: "+giocatore.getSport()+"\n");
                menu.txa_output.append("Anno di Nascita"+giocatore.getAnnoNascita()+"\n");
            }else{
                menu.txa_output.append("Il file non e' stato creato\n");
            }
        }
        if(comando.equals("Leggi")){
            menu.txa_output.append("\n"+gestioneFile.read());
        }
    }
}

import java.io.*;
public class Menu {
    private InputStreamReader input = new InputStreamReader(System.in);
    private BufferedReader in = new BufferedReader(input);

    private void mostraMenu(){
        System.out.println();
        System.out.println("1) Aggiungi nominativo");
        System.out.println("2) Elimina nominativo");
        System.out.println("3) Visualizza rubrica");
        System.out.println("4) Cerca nominativo");
        System.out.println("0) Esci");
    }
    public int scelta(){
        int scelta;
        mostraMenu();
        System.out.print("\n-> ");
        try{
            String opzione = in.readLine();
            scelta = Integer.parseInt(opzione);

        }catch(Exception e){
            scelta=0;
        }
        return scelta;
    }
    public String leggiDato(String desc){
        String dato;

        System.out.print(desc);
        try{
            dato = in.readLine();
        }catch(Exception e){
            dato = "";
        }
        return dato;
    }
}

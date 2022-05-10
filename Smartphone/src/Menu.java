import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class Menu {
    public static void main(String[] args) {
        int opt=0;
        String ris="";
        File file = new File("archivio.dat");
        GestioneFile gs = new GestioneFile(file);
        Smartphone tel;
        try{
            do{
                InputStreamReader input = new InputStreamReader(System.in);
                BufferedReader in = new BufferedReader(input);
                System.out.println(" MENU \n\n");
                System.out.println(" 1) Inserire nuovo smartphone");
                System.out.println(" 2) Leggere il file ");
                System.out.println(" 3) Leggere gli smartphone attivi");
                System.out.println(" 4) Inserire gli smartphone attivi su un altro file");
                System.out.println(" 5) Leggere il file di solo smartphone attivi");
                System.out.println(" 0) ESCI \n");
                System.out.println(" Scegli l'opzione desiderata: \n");
                ris = in.readLine();
                opt = Integer.parseInt(ris);
                switch (opt){
                    case 1:
                        gs.openFile();
                        String marca;
                        String modello;
                        String cpu;
                        int ram;
                        int storage;
                        System.out.println("Inserire la marca: \n");
                        marca=in.readLine();
                        System.out.println("Inserire il modello: \n");
                        modello=in.readLine();
                        System.out.println("Inserire la cpu: \n");
                        cpu=in.readLine();
                        System.out.println("Inserire la ram in GB: \n");
                        ris=in.readLine();
                        ram=Integer.parseInt(ris);
                        System.out.println("Inserire la memoria in GB: \n");
                        ris=in.readLine();
                        storage=Integer.parseInt(ris);
                        tel = new Smartphone(marca,modello,cpu,ram,storage);
                        gs.write(tel);
                        break;
                    case 2:
                        gs.openFile();
                        gs.read();
                        break;
                    case 3:
                        gs.openFile();
                        gs.readActive();
                        break;
                    case 4:
                        gs.openFile();
                        gs.openFileActive();
                        gs.writeOnlyActive();
                        break;
                    case 5:
                        gs.openFileActive();
                        gs.readFileActive();
                        break;
                }
            }while(opt!=0);
        }catch(Exception e){
            System.out.println(e);
        }


    }
}

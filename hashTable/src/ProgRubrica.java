import java.util.*;
public class ProgRubrica {
    public static void main(String[] args) {
        Hashtable rubrica = new Hashtable();
        String chiave, numTel;
        int scelta;
        Menu menu = new Menu();

        do{
            scelta = menu.scelta();
            switch(scelta){
                case 1:
                    chiave = menu.leggiDato("Email:");
                    numTel = menu.leggiDato("Numero di Telefono:");
                    rubrica.put(chiave,numTel);
                    break;
                case 2:
                    chiave = menu.leggiDato("Email:");
                    rubrica.remove(chiave);
                    break;
                case 3:
                    Iterator i = rubrica.keySet().iterator();
                    while(i.hasNext()){
                        chiave = (String) i.next();
                        numTel = (String) rubrica.get(chiave);
                        System.out.println(chiave+" tel. "+numTel);
                    }
                    break;
                case 4:
                    chiave = menu.leggiDato("Email:");
                    if(rubrica.contains(chiave)){
                        numTel = (String) rubrica.get(chiave);
                        System.out.println("Telefono: "+ numTel);
                    }else{
                        System.out.println("Nominativo Inesistente.");
                    }
                    break;
            }
        }while(scelta != 0);
    }
}

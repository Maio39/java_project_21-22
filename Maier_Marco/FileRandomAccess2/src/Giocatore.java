public class Giocatore {
    private String nomeCognome;
    private int annoNascita;
    private String sport;
    Giocatore(String nomeCognome,int annoNascita, String sport){
        this.nomeCognome=nomeCognome;
        this.annoNascita=annoNascita;
        this.sport=sport;
    }

    public String getNomeCognome(){
        String res;
        res=this.nomeCognome;
        return res;
    }
    public String getSport(){
        String res;
        res=this.sport;
        return res;
    }
    public int getAnnoNascita(){
        int res;
        res=this.annoNascita;
        return res;
    }
    public void setNomeCognome(String nomeCognome2){
        this.nomeCognome=nomeCognome2;
    }
    public void setSport(String sport2){
        this.sport=sport2;
    }
    public void setAnnoNascita(int annoNascita2){
        this.annoNascita=annoNascita2;
    }

    String toStringa(){
        String res;
        res="Nome Cognome: "+nomeCognome+"\n"+"Sport: "+sport+"\n"+"Anno di Nascita: "+annoNascita;
        return res;
    }

}

public class Smartphone {
    private String marca;
    private String modello;
    private String cpu;
    private int ram;
    private int storage;
    private boolean isActive=true;
    final static int MAX_LENGHT = 20;
    final static int NUMBER_RECORDS = 3*MAX_LENGHT*2+8+1;

    public Smartphone(String marca, String modello, String cpu, int ram, int storage){
        this.marca=marca;
        this.modello=modello;
        this.cpu=cpu;
        this.ram=ram;
        this.storage=storage;
    }
    boolean getActive(){ return isActive; }
    String getMarca(){
        return marca;
    }
    String getModello(){
        return modello;
    }
    String getCpu(){
        return cpu;
    }
    int getRam(){
        return ram;
    }
    int getStorage(){
        return storage;
    }

    public void setActive(boolean isActive){
        this.isActive=isActive;
    }
    String toStringa(){
        String res;
        res= marca+modello+ "CPU: "+cpu+"RAM: "+ram+"Memoria: "+storage+"\n";
        return res;
    }
}

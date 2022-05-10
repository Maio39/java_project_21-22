import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class GestioneFile {
    private RandomAccessFile randomAccessFile;
    private RandomAccessFile randomAccessFile2;
    File file;
    public GestioneFile(File file){
        this.file=file;
    }
    public boolean openFile(){
        boolean isFound;
        try{
            randomAccessFile = new RandomAccessFile(file, "rw");
            isFound=true;
        }catch(FileNotFoundException exc){
            exc.printStackTrace();
            isFound=false;
        }
        return isFound;
    }
    public boolean openFileActive(){
        boolean isFound;
        File fileActive = new File("smartphoneActive.dat");
        try{
            randomAccessFile2 = new RandomAccessFile(fileActive, "rw");
            isFound=true;
        }catch(FileNotFoundException exc){
            exc.printStackTrace();
            isFound=false;
        }
        return isFound;
    }


    public long numberOfRecords(long recordSize){
        long lenght=1;
        long res=0;
        try{
            lenght = randomAccessFile.length();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        res=lenght/recordSize;

        return res;
    }
    public void writeString(String str, int len){
        try{
            randomAccessFile.writeChars(str);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        for(int i=len;i<Smartphone.MAX_LENGHT;i++){
            try{
                randomAccessFile.writeChar('\0');
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public void writeStringFileActive(String str, int len){
        try{
            randomAccessFile2.writeChars(str);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        for(int i=len;i<Smartphone.MAX_LENGHT;i++){
            try{
                randomAccessFile2.writeChar('\0');
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public String readString(int maxLenght){
        String res="";
        char c = ' ';
        try{
            for (int j = 0; j < maxLenght; j++) {
                c = randomAccessFile.readChar();
                if(c!='\0'){
                    res+=c;
                }
            }
            return res;
        }catch(IOException e){
            e.printStackTrace();
        }
        return res;
    }

    public String readStringFileActive(int maxLenght){
        String res="";
        char c = ' ';
        try{
            for (int j = 0; j < maxLenght; j++) {
                c = randomAccessFile2.readChar();
                if(c!='\0'){
                    res+=c;
                }
            }
            return res;
        }catch(IOException e){
            e.printStackTrace();
        }
        return res;
    }

    public void write(Smartphone smartphone){
        try{
            randomAccessFile.skipBytes((int)(Smartphone.NUMBER_RECORDS*numberOfRecords(Smartphone.NUMBER_RECORDS)));
            writeString(smartphone.getMarca(),smartphone.getMarca().length());
            writeString(smartphone.getModello(),smartphone.getModello().length());
            writeString(smartphone.getCpu(),smartphone.getCpu().length());
            randomAccessFile.writeInt(smartphone.getRam());
            randomAccessFile.writeInt(smartphone.getStorage());
            randomAccessFile.writeBoolean(smartphone.getActive());

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void read() {
        String marca=" ";
        String modello= " ";
        String cpu= " ";
        String ram=" ";
        String storage=" ";
        String active=" ";
        String res;
        try{
            randomAccessFile.seek(0);
            for(int i=0;i<numberOfRecords(Smartphone.NUMBER_RECORDS);i++){
                marca=readString(Smartphone.MAX_LENGHT);
                modello=readString(Smartphone.MAX_LENGHT);
                cpu=readString(Smartphone.MAX_LENGHT);
                ram = ""+randomAccessFile.readInt();
                storage = ""+randomAccessFile.readInt();
                active = ""+randomAccessFile.readBoolean();
                res= marca+" "+modello+" "+cpu+" "+ram+" "+storage+" "+active;
                System.out.println(res);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readFileActive() {
        String marca=" ";
        String modello= " ";
        String cpu= " ";
        String ram=" ";
        String storage=" ";
        String active=" ";
        String res;
        try{
            randomAccessFile.seek(0);
            for(int i=0;i<numberOfRecords(Smartphone.NUMBER_RECORDS);i++){
                marca=readStringFileActive(Smartphone.MAX_LENGHT);
                modello=readStringFileActive(Smartphone.MAX_LENGHT);
                cpu=readStringFileActive(Smartphone.MAX_LENGHT);
                ram = ""+randomAccessFile2.readInt();
                storage = ""+randomAccessFile2.readInt();
                active = ""+randomAccessFile2.readBoolean();
                res= marca+" "+modello+" "+cpu+" "+ram+" "+storage+" "+active;
                System.out.println(res);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeOnlyActive() {
        String marca=" ";
        String modello= " ";
        String cpu= " ";
        String ramS=" ";
        String storageS=" ";
        String active=" ";
        boolean isActive;
        int ram;
        int storage;
        try{
            randomAccessFile.seek(0);
            for(int i=0;i<numberOfRecords(Smartphone.NUMBER_RECORDS);i++){
                marca=readString(Smartphone.MAX_LENGHT);
                modello=readString(Smartphone.MAX_LENGHT);
                cpu=readString(Smartphone.MAX_LENGHT);
                ramS = ""+randomAccessFile.readInt();
                storageS = ""+randomAccessFile.readInt();
                active = ""+randomAccessFile.readBoolean();

                ram=Integer.parseInt(ramS);
                storage=Integer.parseInt(storageS);
                isActive=Boolean.parseBoolean(active);
                if(isActive){
                    randomAccessFile2.skipBytes((int)(Smartphone.NUMBER_RECORDS*numberOfRecords(Smartphone.NUMBER_RECORDS)));
                    writeStringFileActive(marca,marca.length());
                    writeStringFileActive(modello,modello.length());
                    writeStringFileActive(cpu,cpu.length());
                    randomAccessFile2.writeInt(ram);
                    randomAccessFile2.writeInt(storage);
                    randomAccessFile2.writeBoolean(isActive);
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readActive() {
        String marca=" ";
        String modello= " ";
        String cpu= " ";
        String ram=" ";
        String storage=" ";
        String active=" ";
        boolean isActive;
        String res;
        try{
            randomAccessFile.seek(0);
            for(int i=0;i<numberOfRecords(Smartphone.NUMBER_RECORDS);i++){
                marca=readString(Smartphone.MAX_LENGHT);
                modello=readString(Smartphone.MAX_LENGHT);
                cpu=readString(Smartphone.MAX_LENGHT);
                ram = ""+randomAccessFile.readInt();
                storage = ""+randomAccessFile.readInt();
                active = ""+randomAccessFile.readBoolean();

                isActive=Boolean.parseBoolean(active);
                if(isActive){
                    res= marca+" "+modello+" "+cpu+" "+ram+" "+storage;
                    System.out.println(res);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
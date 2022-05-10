import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class GestioneFile {
    private RandomAccessFile randomAccessFile;
    File file;
    final int MAX_LENGHT = 20;
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
        for(int i=len;i<MAX_LENGHT;i++){
            try{
                randomAccessFile.writeChar('\0');
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public boolean write(Giocatore giocatore){
        boolean res;
        try{
            randomAccessFile.skipBytes((int)(84*numberOfRecords(84)));
            writeString(giocatore.getNomeCognome(),giocatore.getNomeCognome().length());
            writeString(giocatore.getSport(),giocatore.getSport().length());
            randomAccessFile.writeInt(giocatore.getAnnoNascita());

            res=true;
        }catch(IOException ex){
            res=false;
            ex.printStackTrace();
        }
        return res;
    }
    public String read() {
        String nomeCognome=" ";
        String sport= " ";
        String anno= " ";
        String res;
        try{
            randomAccessFile.seek(0);
            for(int i=0;i<numberOfRecords(84);i++){
                for(int j=0;j<MAX_LENGHT;j++){
                    nomeCognome += randomAccessFile.readChar();
                }
                for(int k=0;k<MAX_LENGHT;k++){
                    sport += randomAccessFile.readChar();
                }
                anno = ""+randomAccessFile.readInt();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        res= nomeCognome+" "+sport+" "+anno;
        return res;
    }


}

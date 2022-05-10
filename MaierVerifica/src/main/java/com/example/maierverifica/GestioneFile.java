package com.example.maierverifica;
import java.util.*;
import java.io.*;
class GestioneFile{
    String nomeFile;
    GestioneFile(){
        this.nomeFile="/Users/marcomaier/documenti/Java_project/MaierVerifica/login.txt";
    }
    void inputFile(String firstName, String lastName, String email, String password){
        boolean modScrittura = true;
        try{
            FileWriter fw = new FileWriter(nomeFile,modScrittura);
            PrintWriter fOut = new PrintWriter(fw);
            fOut.println(firstName);
            fOut.println(lastName);
            fOut.println(email);
            fOut.println(password);
            fOut.flush();
            fOut.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

}

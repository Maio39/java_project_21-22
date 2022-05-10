package com.example.testverifica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SalvaCampi {
    String nomeFile;

    public SalvaCampi(String nomeFile){
        this.nomeFile=nomeFile;
    }

    public void salvaCampi(String firstName, String lastName, String email, String password){
        try{
            FileWriter fw = new FileWriter(nomeFile,true);
            PrintWriter fOut = new PrintWriter(fw);
            fOut.println("\n");
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

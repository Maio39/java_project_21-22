/*
    nome:   Marco Maier
    Classe: 4E
    Data:   18/11/2020
    Oggetto: Realizzare una classe che rappresenta una data e abbia i seguenti metodi:
                - confrontare due date
                - distanza in giorni tra due date 
                - verificare se l'anno è bisestile
                - giorno della settimana
                - nome del mese (opzionale in più lingue)
*/

//import java.sql.Date;
//import java.util.*;
class Data {
    private int giorno;
    private int mese;
    private int anno;

    Data(int giorno, int mese, int anno){
        this.giorno=giorno;
        this.mese=mese;
        this.anno=anno;
    }
    Data(){
        this.giorno=0;
        this.mese=0;
        this.anno=0;
    }
    int bisestile(int anno){
        if(anno>1584){
            if(anno%400==0){
                if(anno%4==0){
                    if(anno%100!=0){
                        return 1;
                    }else{
                        return 0;
                    }
                }else{
                    return 0;
                }
            }else{
                return 0;
            }
        }else{
            return 0;
        }    
    }
    public int getDays(){
        return this.giorno;
    }
    public int getMonths(){
        return this.mese;
    }
    public int getYears(){
        return this.anno;
    }
    public boolean setDays(int giorni){
        if(getMonths()==1 || getMonths()==3 || getMonths()==5 || getMonths()==7 || getMonths()==8 || getMonths()==10 || getMonths()==12){
            if(giorni>31){
                return false;
            }else{
                this.giorno=giorni;
                return true;
            }
        }
        if(getMonths()==4 || getMonths()==6 || getMonths()==9 || getMonths()==11){
            if(giorni>30){
                return false;
            }else{
                this.giorno=giorni;
                return true;
            }
        }
        if(getMonths()==2){
            if(bisestile(getYears())==1){
                if(giorni>29){
                    return false;
                }else{
                    this.giorno=giorni;
                    return true;
                }
            }else{
                if(giorni>28){
                    return false;
                }else{
                    this.giorno=giorni;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean setMonths(int mesi){
        if(mesi>12){
            return false;
        }else{
            this.mese=mesi;
            return true;
        }
    }
    public boolean setYears(int anni){
        if(anni<=0){
            return false;
        }else{
            this.anno=anni;
            return true;
        }
    }

    String toStringa(){
        String res;
        res="\nData: "+giorno+"/"+mese+"/"+anno;
        return res;
    }

    int confrontoDate(Data d2){
        if(this.anno>d2.getYears()){
            return 1;
        }
        if(this.anno<d2.getYears()){
            return 2;
        }
        if(this.anno==d2.getYears()){
            if(mese>d2.getMonths()){
                return 1;
            }
            if(this.mese<d2.getMonths()){
                return 2;
            }
            if(this.mese==d2.getMonths()){
                if(giorno>d2.getDays()){
                    return 1;
                }
                if(this.giorno<d2.getDays()){
                    return 2;
                }
                if(this.giorno==d2.getDays()){
                    return 3;
                }
            }
        }
        return 0;
    }
    int DistanzaInGiorni(Data d2){
        int a,m;
        int gg=0;
        int ris;
        int i=1;
        if(this.confrontoDate(d2)==1){
            a=d2.getYears();
            do{
                ris=bisestile(a);
                if(ris==1){
                    gg = gg + 366;
                }else{
                    gg = gg + 365;
                }
            }while(a<this.anno);
        }
        if(this.confrontoDate(d2)==2){
            a=this.anno;
            do{
                ris=bisestile(a);
                if(ris==1){
                    gg = gg + 366;
                }else{
                    gg = gg + 365;
                }
            }while(a<d2.getYears());
        }
        if(this.confrontoDate(d2)==3){
            return 0;
        }
        do{
            m=d2.getMonths();
            if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12){
                gg = gg + 31;
            }
            if(i==4 || i==6 || i==9 || i==11){
                gg = gg + 30;
            }
            if(i==2){
                if(bisestile(d2.getYears())==1){
                    gg = gg + 29;
                }else{
                    gg = gg + 28;
                }
            }
            i++;
        }while(i!=m);
            
        do{
            m=this.mese;
            if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12){
                gg = gg + 31;
            }
            if(i==4 || i==6 || i==9 || i==11){
                gg = gg + 30;
            }
            if(i==2){
                if(bisestile(this.getYears())==1){
                    gg = gg + 29;
                }else{
                    gg = gg + 28;
                }
            }
            i++;
        }while(i!=m);
        m=d2.getMonths();
        if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12){
            gg = gg + (31-m);
        }
        if(i==4 || i==6 || i==9 || i==11){
            gg = gg + (30-m);
        }
        if(i==2){
            if(bisestile(this.getYears())==1){
               gg = gg + (29-m);
            }else{
                gg = gg + (28-m);
            }
        }
        gg = gg + this.giorno;
        return gg;
    }
    String nomeMese(){
        String res;
        if(this.mese==1){
            res="Gennaio or January";
            return res;
        }
        if(this.mese==2){
            res="Febbraio or February";
            return res;
        }
        if(this.mese==3){
            res="Marzo or March";
            return res;
        }
        if(this.mese==4){
            res="Aprile or April";
            return res;
        }
        if(this.mese==5){
            res="Maggio or May";
            return res;
        }
        if(this.mese==6){
            res="Giugno or June";
            return res;
        }
        if(this.mese==7){
            res="Luglio or July";
            return res;
        }
        if(this.mese==8){
            res="Agosto or August";
            return res;
        }
        if(this.mese==9){
            res="Settembre or September";
            return res;
        }
        if(this.mese==10){
            res="Ottobre or October";
            return res;
        }
        if(this.mese==11){
            res="Novembre or November";
            return res;
        }
        if(this.mese==12){
            res="Dicembre or December";
            return res;
        }
        res="Errore";
        return res;
    }

}

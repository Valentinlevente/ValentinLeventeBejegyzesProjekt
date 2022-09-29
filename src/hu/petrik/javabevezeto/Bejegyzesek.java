package hu.petrik.javabevezeto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bejegyzesek {
    private List<Bejegyzes> bejegyzesek;

    public Bejegyzesek(Bejegyzes[] bejegyzesTomb){
        this.bejegyzesek = new ArrayList<>();
        this.bejegyzesek.addAll(Arrays.asList(bejegyzesTomb));
    }

    public Bejegyzesek(String fajlNev)throws IOException {
        this.bejegyzesek = new ArrayList<>();
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while(sor != null && !sor.equals("")){
            String[] adatok = sor.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(adatok[0], adatok[1]);
            this.bejegyzesek.add(bejegyzes);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }

    public List<Bejegyzes> getBejegyzesek(){
        return bejegyzesek;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Bejegyzes b: this.bejegyzesek){
            sb.append(b.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
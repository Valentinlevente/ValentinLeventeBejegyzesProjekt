package hu.petrik.javabevezeto;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        //-----2/a-------
        Bejegyzes b1 = new Bejegyzes("Valentin Levente","Lorem ipsum");
        Bejegyzes b2 = new Bejegyzes("Valentinusz Maximus","Szeretem a dolgozatokat");

        Bejegyzesek bejegyzesList = new Bejegyzesek(new Bejegyzes[]{b1,b2});

        //--------2/b---------
        System.out.println("Bejegyzések száma:");
        int amount = 0;
        try{
            amount = sc.nextInt();
            if (amount < 0){
                System.out.println("Pozitív számot adj meg");
            }
        }catch (Exception e){
            System.err.println("Egész számot adj meg!");
        }
        sc.nextLine();
        for (int i = 0; i < amount;i++){
            System.out.println("Nev:");
            String nev = sc.nextLine();
            System.out.println("Tartalom:");
            String tartalom = sc.nextLine();
            Bejegyzes b3 = new Bejegyzes(nev,tartalom);
            bejegyzesList.getBejegyzesek().add(b3);
        }

        //------2/c----------
        Bejegyzesek bejegyzesekLista1 = null;
        try{
            bejegyzesekLista1 = new Bejegyzesek("bejegyzesek.csv");
            bejegyzesList.getBejegyzesek().addAll(bejegyzesekLista1.getBejegyzesek());
        }catch (IOException e){
            System.err.println("Ismeretlen hiba történt a fájl beolvasás folyamán");
        }

        //-------2/d------
        for (int i = 0; i < bejegyzesList.getBejegyzesek().size()*20 ;i++){
            int random = rnd.nextInt(bejegyzesList.getBejegyzesek().size());
            bejegyzesList.getBejegyzesek().get(random-1).like();
        }

        //----------2/e-------
        System.out.println("2. szöveg tartalma:");
        String tartalom = sc.nextLine();
        bejegyzesList.getBejegyzesek().get(1).setTartalom(tartalom);

        //----------2/f----------
        System.out.println(bejegyzesList);

        //---------3/a----------
        int max = 0;
        for (int i = 0; i < bejegyzesList.getBejegyzesek().size(); i++){
            if(bejegyzesList.getBejegyzesek().get(i).getLikeok() > max){
                max = bejegyzesList.getBejegyzesek().get(i).getLikeok();
            }
        }
        System.out.println(max);

        //-------3/b-------
        if(max > 35){
            System.out.println("Van 35-nél nagyobb szám");
        }else{
            System.out.println("Nincs 35-nél nagyobb szám");
        }

        //-------3/c-----
        int counter = 0;
        for (int i = 0; i < bejegyzesList.getBejegyzesek().size(); i++){
            if(bejegyzesList.getBejegyzesek().get(i).getLikeok() < 15){
                counter++;
            }
        }

        //----------3/d-------
        bejegyzesList.getBejegyzesek().sort(Comparator.comparing(Bejegyzes::getLikeok));
        System.out.println(bejegyzesList);


    }
}

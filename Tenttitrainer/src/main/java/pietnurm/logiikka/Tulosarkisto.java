/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author pieta
 */
public class Tulosarkisto {
    
    
    public int kategorianPisteet(String kategorianNimi) throws FileNotFoundException {
        int pisteet = 0;
        File pistetiedosto = new File("pisteet_" + kategorianNimi + ".txt");
        if (pistetiedosto.exists()) {
            Scanner pisteskanneri = new Scanner(pistetiedosto);
            while (pisteskanneri.hasNextLine()) {
                int kysymysarvostelu = Integer.parseInt(pisteskanneri.nextLine());
                pisteet = pisteet + kysymysarvostelu;
            }
        }
        return pisteet;
    }
    public int kysymystenMaara(String kategorianNimi) throws FileNotFoundException {
        int kysymystenMaara = 0;
        File pistetiedosto = new File("pisteet_" + kategorianNimi + ".txt");
        if (pistetiedosto.exists()) {
            Scanner kysymysskanneri = new Scanner(pistetiedosto);
            while (kysymysskanneri.hasNextLine()) {
                String line = (kysymysskanneri.nextLine());
                kysymystenMaara++;
            }
        }
        return kysymystenMaara;
    } 
    public double kategorianKeskiarvo(String kategorianNimi) throws FileNotFoundException {
        int kategorianPisteet = kategorianPisteet(kategorianNimi);
        int kysymystenMaara = kysymystenMaara(kategorianNimi);
        double keskiarvo = (double) kategorianPisteet / kysymystenMaara;
        return keskiarvo;
    }
    public double kokonaiskeskiarvo() throws FileNotFoundException {
        int kokonaispisteet = 0;
        int kysymystenKokonaismaara = 0;
        Scanner kategoriaskanneri = new Scanner(new File("kategorialista.txt"));
        while (kategoriaskanneri.hasNextLine()) {
            String kategorianNimi = kategoriaskanneri.nextLine();
            kokonaispisteet = kokonaispisteet + kategorianPisteet(kategorianNimi);
            kysymystenKokonaismaara = kysymystenKokonaismaara + kysymystenMaara(kategorianNimi);
        }
        double kokonaiskeskiarvo = (double) kokonaispisteet / kysymystenKokonaismaara;
        return kokonaiskeskiarvo;
    }
}

package objectorientedprogramming;

import objectorientedprogramming2.KontoBankowe;

public class OOP 
{
    public static void main(String[] args) {
        
        Punkt p;
        p = new Punkt();
        
        p.setX(5);
        p.setY(20);
        
        System.out.println("p.x = " + p.getX());
        System.out.println("p.y = " + p.getY());
        
        Punkt r = new Punkt(10, 15);
        System.out.println(r.getX());
        System.out.println(r.getY());
        
        Punkt s = new Punkt(11, "Polprosta");
        System.out.println("Atrybut 'x' obiektu 's' ma wartosc = " + s.getX());
        System.out.println("Atrybut 'z' obiektu 's' to ciag znakow: " + s.z);
       
        Test pierwszyObiekt = new Test();
        int wynik = pierwszyObiekt.dodaj(10,20);
        System.out.println("Wynik: " + wynik);
        pierwszyObiekt.wypiszGodnosc("Konrad", "Zolynski");
                
        Test drugiObiekt = new Test();
        drugiObiekt.wypiszGodnosc("Beata", "Kozidrak");
        
        double wynikDzielenia = pierwszyObiekt.dzielenie(101, 20);
        System.out.println(wynikDzielenia);
        double wynikDzielenia2 = pierwszyObiekt.dzielenie(101, 20.55);
        System.out.println(wynikDzielenia2);
        
        double wynikDodawania = Matematyka.dodaj(10, 12.73);
        System.out.println("Wynik dodawania: " + wynikDodawania);
        System.out.println("Liczba PI wynosi " + Matematyka.PI);
        
        Klient pierwszyKlient = new Klient("Konrad");
        Klient drugiKlient = new Klient("Arkadiusz");
        Klient trzeciKlient = new Klient("Bolo");
        Klient czwartyKlient= new Klient("Michal");
        
        System.out.println("ID pierwszego klienta o imieniu " + pierwszyKlient.imie + " to " + pierwszyKlient.id);
        System.out.println("ID drugiego klienta o imieniu " + drugiKlient.imie + " to " + drugiKlient.id);
        System.out.println("ID trzeciego klienta o imieniu " + trzeciKlient.imie + " to " + trzeciKlient.id);
        System.out.println("ID czwartego klienta o imieniu " + czwartyKlient.imie + " to " + czwartyKlient.id);
        
        KontoBankowe oszczednosciowe = new KontoBankowe();
        System.out.println("Saldo konta to: " + oszczednosciowe.getSaldo());
        if (oszczednosciowe.wyplac(154))
        {
            System.out.println("Pomyslnie wyplacono gotowke");
        }
        else
            System.out.println("Nie masz wystarczajacych srodkow aby zrealizowac wyplate");
        System.out.println("Saldo konta to: " + oszczednosciowe.getSaldo());
        oszczednosciowe.wplac(4000);
        System.out.println("Saldo konta to: " + oszczednosciowe.getSaldo());
        
        // Część druga z wykorzystaniem superklasy Object
        
        Punkt z = new Punkt(4,10);
        System.out.println(z.getClass());
        Object a = new Punkt(50,20);
        ((Punkt)a).getX();
        
        if(p.equals(a))
            System.out.println("Przypadkiem koordynaty punktów są sobie równe");
        
        ((Punkt)a).setX(5);
        
        if(p.equals(a))
            System.out.println("Przypadkiem koordynaty punktów są sobie równe");
        System.out.println(p);
        
        Object[] tablicaPunktow = new Punkt[5];
        tablicaPunktow[0] = new Punkt(2, 12);
        tablicaPunktow[1] = new Punkt(21, 12);
        tablicaPunktow[2] = new Punkt(91, 1);
        tablicaPunktow[4] = new Punkt(1, 1);
        
        for(Object licznik: tablicaPunktow)
        {
            System.out.println(licznik);
        }
    }
}
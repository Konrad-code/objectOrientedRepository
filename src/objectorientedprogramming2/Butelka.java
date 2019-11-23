package objectorientedprogramming2;

public class Butelka {
    
    private double ileLitrow;
    private double pojemnosc;
    
    Butelka(double numerek)                             // Konstruktor pseudolosowego przydzielania zawartości i pojemności butelki w uzależnieniu od jej numeru.
    {
        double posredniLitraz = (int)(numerek % 4);
        this.pojemnosc = (posredniLitraz + 1) / 2;
        double posredniaZawartosc = (int)(numerek % 5);
        if(posredniaZawartosc > pojemnosc)
            this.ileLitrow = pojemnosc;
        else    
            this.ileLitrow = posredniaZawartosc;
    }
    
    double getLitraz()                                  // Metoda dostępu do pojemności butelki.
    {
        return pojemnosc;
    }
    
    double getIleLitrow()                               // Metoda dostępu do zawartości butelki.
    {
        return ileLitrow;
    }
    
    boolean wlej(double ilosc)                          // Metoda wlewająca
    {
        if(ileLitrow == pojemnosc)                      // Przypadek 1. gdy butelka jest już pełna.
        {
            System.out.println("Butelka jest pełna. Nie możesz dolać już więcej.");
            return false;
        }
        else if(ileLitrow + ilosc > pojemnosc)          // Przypadek 2. gdy chcemy wlać więcej niż pozwala jej pojemność.
        {
            System.out.println("Nalałeś do butelki do pełna.");
            this.ileLitrow = pojemnosc;
            return true;
        }
        else                                            // Przypadek 3. gdy chcemy dolać mniej lub do maksimum jej pojemności.
        {
            this.ileLitrow += ilosc;
            return true;
        }
    }
    
    double wylej(double ilosc)                           // Metoda wylewająca.
    {
        if(ilosc <= ileLitrow)                           // Pierwszy przypadek zwracający sumę kontrolną.
        {
            this.ileLitrow -= ilosc;
            return 69;
        }
        else                                             // Drugi przypadek zwracający zawartość, którą możemy operować (wylać) np. w celu przelania do innej butelki.
            return ileLitrow;
    }
    
    void przelej(double ilosc, Butelka gdziePrzelac)    // Metoda przelewająca.
    {
        if(this.ileLitrow == 0)
            System.out.println("Z pustego to i Salomon nie przeleje.");
        else if(this.wylej(ilosc) == 69)
        {
            double potencjalnyNadmiar = 0;              // Zmienna służąca do zapisania ilości wody, której nie możemy przelać do drugiej butelki z racji na osiągnięcie jej pojemności i którą wlewamy z powrotem do pierwszej butelki.
            if(gdziePrzelac.getIleLitrow() + ilosc > gdziePrzelac.getLitraz())
                potencjalnyNadmiar = gdziePrzelac.getIleLitrow() + ilosc - gdziePrzelac.getLitraz();    // Zapisujemy wartość do zmiennej zanim wywołanie metod "wlej"/"wylej" w warunku spowoduje zmianę pierwotnych atrybutów instancji.
            if(gdziePrzelac.wlej(ilosc))                // Sprawdzenie tego warunku spowoduje, że wykona się metoda "wlej", a jeśli drugi lub trzeci warunek jej będzie spełniony i zwróci wartość true, to dodatkowo wlana zostanie woda przechowywana w zmiennej "potencjalnyNadmiar". Dla trzeciego warunku będzie to 0, gdy nie próbujemy wlać więcej niż przewiduje pojemność drugiej butelki.
                this.wlej(potencjalnyNadmiar);
            else
                this.wlej(ilosc);                       // Wlanie wody z powrotem do pierwszej butelki jeśli nie zostanie spełniony żaden z powyższych warunków metody "przelej", aby uzupełnić uprzednie wylanie z niej wody poprzez wywołanie w warunku funkcji "wylej".
        }
        else
        {
            System.out.println("Chciałeś przelać z butelki więcej niż w niej było, więc przelaliśmy jej całą zawartość.");
            this.przelej(this.wylej(ilosc), gdziePrzelac);     // Przypadek gdzie wywołujemy rekurencyjnie metodę "wylej" po czym operujemy na wartości zwróconej przez jej drugi przypadek, która jest przekazana jako argument do wywołania funkcji "przelej". 
        }
    }
    
    public static void main(String[] args){
        Butelka[] butelka = new Butelka[50];
        
        for(int iterator = 0; iterator < 50; iterator++)
        {
            butelka[iterator] = new Butelka(iterator);
            // System.out.println("Nr " + iterator + " Pojemność: " + butelka[iterator].getLitraz() + " Zawartosc butelki: " + butelka[iterator].getIleLitrow() + " litrow");    // Wyświetlanie numeracji, pojemności i zawartości butelek.
        } 
        
        /*
        butelka[49].przelej(10, butelka[20]);   // Przykładowa operacja przelania
        System.out.println(butelka[49].getIleLitrow());
        System.out.println(butelka[20].getIleLitrow());
        */
        
        butelka[24].wylej(0.5);   // Przykładowe operacje metody "wlej" i "wylej" przygotowujące dodatkowe testowe instancje w zakresie potrzebnych atrybutów.
        butelka[3].wylej(1);  
        butelka[45].wlej(1);
        butelka[14].wylej(0.5);    
        butelka[31].wylej(1);     
        butelka[15].wlej(1);
        butelka[19].wylej(0.5);
        butelka[22].wylej(1);
        
        /*
        System.out.println("Butelka 24: " + butelka[24].getIleLitrow());    // Wyświetlanie czy na pewno atrybuty instancji zostały zmodyfikowane w poprawny sposób.
        System.out.println("Butelka 3: " + butelka[3].getIleLitrow());
        System.out.println("Butelka 45: " + butelka[45].getIleLitrow());
        System.out.println("Butelka 14: " + butelka[14].getIleLitrow());      
        System.out.println("Butelka 31: " + butelka[31].getIleLitrow());    
        System.out.println("Butelka 15: " + butelka[15].getIleLitrow());
        System.out.println("Butelka 19: " + butelka[19].getIleLitrow());
        System.out.println("Butelka 22: " + butelka[22].getIleLitrow());
        */
        
        butelka[5].przelej(1, butelka[11]);     // Blok testów poprawności działania metody przelewającej.
        // System.out.println("    Z pustego...");
        butelka[24].przelej(1, butelka[10]);
        // System.out.println("    Z pustego...");
        butelka[4].przelej(1, butelka[26]);
        // System.out.println("    Za duzo do przelania wzgledem 1 i 2, ale 2 zmiesci po uwzglednieniu ze w 1 nie ma żądanej objetosci.");
        butelka[6].przelej(1, butelka[42]);
        // System.out.println("    Drugi pełny.");
        butelka[37].przelej(1, butelka[47]);
        // System.out.println("    Drugi pełny.");
        butelka[33].przelej(1, butelka[3]);
        // System.out.println("    W porzadku.");
        butelka[36].przelej(1, butelka[35]);
        // System.out.println("    Za duzo wzgledem 1.");
        butelka[45].przelej(1, butelka[29]);
        // System.out.println("    Drugi pełny.");     
        butelka[44].przelej(1, butelka[14]);
        // System.out.println("    Za duzo wzgledem 1.");
        butelka[31].przelej(0, butelka[15]);
        // System.out.println("    Proba przelania 0 z pustego.");
        butelka[41].przelej(1, butelka[19]);
        // System.out.println("    Za duzo do przelania wzgledem 1 i 2, ale 2 zmiesci po uwzglednieniu ze w 1 nie ma żądanej objetosci.");
        butelka[18].przelej(2, butelka[22]);    
        // System.out.println("    Za duzo do przelania wzgledem 1 i 2.");
        System.out.println("Butelka nr 5: " + butelka[5].getIleLitrow() + " Butelka nr 11: " + butelka[11].getIleLitrow());
        System.out.println("Butelka nr 24: " + butelka[24].getIleLitrow() + " Butelka nr 10: " + butelka[10].getIleLitrow());
        System.out.println("Butelka nr 4: " + butelka[4].getIleLitrow() + " Butelka nr 26: " + butelka[26].getIleLitrow());
        System.out.println("Butelka nr 6: " + butelka[6].getIleLitrow() + " Butelka nr 42: " + butelka[42].getIleLitrow());
        System.out.println("Butelka nr 37: " + butelka[37].getIleLitrow() + " Butelka nr 47: " + butelka[47].getIleLitrow());
        System.out.println("Butelka nr 33: " + butelka[33].getIleLitrow() + " Butelka nr 3: " + butelka[3].getIleLitrow());
        System.out.println("Butelka nr 36: " + butelka[36].getIleLitrow() + " Butelka nr 35: " + butelka[35].getIleLitrow());
        System.out.println("Butelka nr 45: " + butelka[45].getIleLitrow() + " Butelka nr 29: " + butelka[29].getIleLitrow());
        System.out.println("Butelka nr 44: " + butelka[44].getIleLitrow() + " Butelka nr 14: " + butelka[14].getIleLitrow());
        System.out.println("Butelka nr 31: " + butelka[31].getIleLitrow() + " Butelka nr 15: " + butelka[15].getIleLitrow());
        System.out.println("Butelka nr 41: " + butelka[41].getIleLitrow() + " Butelka nr 19: " + butelka[19].getIleLitrow());
        System.out.println("Butelka nr 18: " + butelka[18].getIleLitrow() + " Butelka nr 22: " + butelka[22].getIleLitrow());
    }
}

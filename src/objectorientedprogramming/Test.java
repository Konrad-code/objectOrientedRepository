package objectorientedprogramming;

public class Test 
{
    void wypiszGodnosc(String imie, String nazwisko)
    {
        System.out.println("Imie: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println();
    }
    
    int dodaj(int a, int b)
    {
        return a + b;
    }
    double dodaj(double a, double b)
    {
        return a + b;
    }
    
    double dzielenie (double dzielna, double dzielnik)
    {
        if (dzielnik == 0)
            return 0;
        
        System.out.println("Wynik dzielenia: ");
        return dzielna / dzielnik;
    }
}

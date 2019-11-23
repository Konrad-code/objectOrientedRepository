package objectorientedprogramming;

public class Klient
{
    Klient(String imie)
    {
        this.imie = imie;
        nastepnyId++;
        id = nastepnyId; 
    }
    
    String imie;
    int id = 0;
    static int nastepnyId = 0;
}

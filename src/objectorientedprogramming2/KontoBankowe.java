package objectorientedprogramming2;

public class KontoBankowe
{
    public KontoBankowe()
    {
        saldo = 1000;
    }
    
    private int saldo;
    
    public int getSaldo()
    {
        return saldo;
    }
    
    private boolean setSaldo(int saldo)
    {
        /*
        OPERATION CONDITIONS
        */
        this.saldo = saldo;
        
        return true;
    }
    
    public boolean wyplac(int kwota)
    {
        if (saldo < kwota)
            return false;
        else
            setSaldo(saldo - kwota);
        
        return true;
    }
    
    public boolean wplac(int kwota)
    {
        setSaldo(saldo + kwota);
        return true;
    }
}

package objectorientedprogramming;

public class Punkt extends Object
{
    private int x;
    private int y;
    String z;
    
    Punkt()
    {
        System.out.println("Wywołano konstruktor domyślny");
        x = 20;
        y = 20;
    }
    Punkt(int pierwszyKoordynat, int drugiKoordynat)
    {
        this.x = pierwszyKoordynat;
        this.y = drugiKoordynat;
    }
    Punkt(int x, String z)
    {
        this.x = x;
        this.z = z;
    }
    
    int getX()
    {
        return x;
    }
    
    int getY()
    {
        return y;
    }
    
    void setX(int x)
    {
        this.x = x;
    }
    
    void setY(int y)
    {
        this.y = y;
    }
    
    public boolean equals(Object obj) 
        {
            if(obj.getClass() != this.getClass())
                return false;
            if(obj == null)
                return false;
            if(obj == this)
                return true;
                        
            Punkt przyslany = (Punkt) obj;
            return this.getX() == przyslany.getX() && this.getY() == przyslany.getY();
        }       
    
    @Override
    public String toString() 
    {
        return getX() + ", " + getY();
    }
}
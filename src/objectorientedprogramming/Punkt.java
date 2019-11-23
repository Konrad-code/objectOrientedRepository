package objectorientedprogramming;

public class Punkt
{
    Punkt()
    {
        System.out.println("Wywołano konstruktor domyślny");
        x = 20;
        y = 20;
    }
    Punkt(int pierwszy, int drugi)
    {
        x = pierwszy;
        y = drugi;
    }
    Punkt(int x, String z)
    {
        this.x = x;
        this.z = z;
    }
    int x;
    int y;
    String z;
}
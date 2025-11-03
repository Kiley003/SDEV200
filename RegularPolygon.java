
/** Excerise 9.9  */

public class Exercise09_09 {
  public static void main(String[] args) {
    private int n; 
    private double side; 
    private double x; 
    private double y;
  }
}

class RegularPolygon {
        n = 3;
        side = 1;
        x = 0; 
        y = 0;
}

RegularPolygon(int n, double side)
    {
        this.n = n;
        this.side = side;
        x = 0;
        y = 0;
    }

    RegularPolygon(int n, double side, double x, double y)
    {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public void setN(int then)
    {
        n = then;
    }

    public int getN()
    {
        return n;
    }

    public void setSide(double theside)
    {
        side = theside;
    }

    public double getSide()
    {
        return side;
    }

    public void setX(int thex)
    {
        x = thex;
    }

    public double getX()
    {
        return x;
    }

    public void setY(int they)
    {
        y = they;
    }

    public double getY()
    {
        return y;
    }

    public double getPerimeter()
    {
        return n * side;
    }
    public double getArea()
    {
        return (n * side) * 5;
    }}

package com.company;
import lombok.Setter;
import lombok.Getter;
public class Quadrangle {
    /**
     * Конструктор на 8 координат
     */
    public Quadrangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }

    @Setter
    @Getter
    private int x1, y1, x2, y2, x3, y3, x4, y4;
    /**
     * Нахождение сторон четыреугольника
     */
    int length1() { return(int) Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)); }

    int length2() { return(int) Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2)); }

    int length3() {
        return(int) Math.sqrt(Math.pow((x4 - x3), 2) + Math.pow((y4 - y3), 2));
    }

    int length4() { return(int) Math.sqrt(Math.pow((x1 - x4), 2) + Math.pow((y1 - y4), 2));}
    /**
     * Нахождение диагоналей четыреугольника
     */
    double diagonal1() {
        return Math.sqrt(Math.pow((x4 - x2), 2) + Math.pow((y4 - y2), 2));
    }

    double diagonal2() {
        return Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
    }
    /**
     * Нахождение периметра четыреугольника
     */
    double perimeter() {
        return length1() + length2() + length3() + length4();
    }
    /**
     * Нахождение площади четыреугольника
     */
    double area() {
        //return Math.sqrt((perimeter()/2 - length1())*(perimeter()/2 - length2())*(perimeter()/2 - length3())*(perimeter()/2 - length4()));
        double half_perimeter = perimeter() / 2;
        return Math.sqrt((half_perimeter - length1()) * (half_perimeter - length2()) * (half_perimeter - length3()) * (half_perimeter - length4()));
    }

    /**
     * Вывод результатов на экран
     */
    @Override
    public String toString() {
        return "Сторона четырехугольника А = " + length1() +
                "; Сторона четырехугольника B = " + length2()+
                "; Сторона четырехугольника C = " + length3() +
                "; Сторона четырехугольника D = " + length4() +
                "; Диагональ четырехугольника d1 = " + String.format("%4.2f", diagonal1()) +
                "; Диагональ четырехугольника d2= " + String.format("%4.2f", diagonal2()) +
                "; Периметр четырехугольника = " + String.format("%4.2f",perimeter()) +
                "; Площадь четыреугольника = " + String.format("%4.2f",area());
    }

}

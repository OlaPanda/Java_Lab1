package com.company;
 public class Square extends Quadrangle{
    public Square(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
        checkSquare(length1(), length2(), length3(), length4());
    }

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
     /**
      * Проверка фигуры является ли она квадратом
      */
     public void check(double length1 ,double length2,double length3,double length4) {
         if(length1()==length2()&&(length1()==length3())&&(length1()==length4())&&(length2()==length3())&&(length2()==length4())&&(length3()==length4())) {
             System.out.println("Фигура является квадратом!");
         }
     }
    private void checkSquare(double length1 ,double length2,double length3,double length4 ) {
        if ((length1() != length2()) | (length2() != length3()) | (length3() != length4())) {
            throw new IllegalArgumentException("Фигура не являеться квадратом, проверьте правильность вводимых данных !");
        }

    }
}

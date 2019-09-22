package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите кол-во четырёхугольников: ");
        int quantity = scanner.nextInt();
        /**
         * @param quantity кол-во четырехугольников
         */
        double [] arr1 = new double[quantity];
        for (int i = 0; i < quantity; i++) {
            int x1, y1, x2, y2, x3, y3, x4, y4;
            System.out.println("Введите x1: ");
            x1 = scanner.nextInt();
            System.out.println("Введите y1: ");
            y1 = scanner.nextInt();
            System.out.println("Введите x2: ");
            x2 = scanner.nextInt();
            System.out.println("Введите y2: ");
            y2 = scanner.nextInt();
            System.out.println("Введите x3: ");
            x3 = scanner.nextInt();
            System.out.println("Введите y3: ");
            y3 = scanner.nextInt();
            System.out.println("Введите x4: ");
            x4 = scanner.nextInt();
            System.out.println("Введите y4: ");
            y4 = scanner.nextInt();

            Quadrangle quadrangle = new Quadrangle(x1, y1, x2, y2, x3, y3, x4, y4);
            arr1[i] = quadrangle.area();
            System.out.println(quadrangle.toString());
        }
/**
 * Нахождения максимальной и минимальной площпди четырехугольников
 */
           double max=arr1[0];
        for (double d:arr1){
            if (max< d){
                max=d;

            }
        }
        System.out.println("Найбольшая площадьчетырехугольника :" + String.format("%4.2f",max));

        double min = arr1[0];
        for (double p : arr1){
            if (min > p){
                min = p;
            }
        }
        System.out.println("Найменьшая площадьчетырехугольника :" + String.format("%4.2f",min));

        System.out.println("Введите кол-во квадратов: ");
        quantity = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            int x1, y1, x2, y2, x3, y3, x4, y4;
            System.out.println("Введите x1: ");
            x1 = scanner.nextInt();
            System.out.println("Введите y1: ");
            y1 = scanner.nextInt();
            System.out.println("Введите x2: ");
            x2 = scanner.nextInt();
            System.out.println("Введите y2: ");
            y2 = scanner.nextInt();
            System.out.println("Введите x3: ");
            x3 = scanner.nextInt();
            System.out.println("Введите y3: ");
            y3 = scanner.nextInt();
            System.out.println("Введите x4: ");
            x4 = scanner.nextInt();
            System.out.println("Введите y4: ");
            y4 = scanner.nextInt();
            Square square = new Square(x1, y1, x2, y2, x3, y3, x4, y4);
            arrayList.add(square.length1());
            /**
             * Нахождения одинаковых квадратов и их номеров
             */
            if(square.length1()==square.length2()&&(square.length1()==square.length3())&&(square.length1()==square.length4())&&(square.length2()==square.length3())&&(square.length2()==square.length4())&&(square.length3()==square.length4()))
            System.out.println(square.toString());
        }
        ArrayList<Integer> index = new ArrayList<>();
        System.out.println(arrayList);
        for (int k = 0; k < arrayList.size(); k++){
            for (int p = k+1; p < arrayList.size(); p++){
                if(arrayList.get(k) == arrayList.get(p)){
                        index.add(arrayList.indexOf(arrayList.get(k)));
                        System.out.println(index);
                }
            }
        }

    }
}

package classes;
import java.util.Scanner;
public class Main {
    public static Universiteis universiteis;

    public static void main(final String[] args) {
        universiteis = new Universiteis(10);

        universiteis.add(new University("ТАУ", "023456" ,"ИКС","АТ-171",77,33,45 ), 1);
        universiteis.add(new University( "Java","00123","ИКС" ,"Ат-173","Кирилов О.Л.","Сперанский В.А.",20,12,90), 2);
        universiteis.add(new University("Matlab", "765347","ИКС","АВ-171",90,60,90), 3);
        universiteis.add(new University("Компьютерно-интегрированные системы", "111111", "ИКС","АС-183","Арешкин Д.О.","Шапорин О.Ф." ,120,45,90), 4);
        universiteis.add(new University("Физика","6754456","ИБИИТ","ОР-162", 70,120,45), 5);
        universiteis.add(new University("Физика атмосферы", "097655", "ИЭКСУ","ПП-144","Розумовский Р.О. ","Анисимов О.А.", 88,33,66), 6);
        universiteis.add(new University("Дискретная математика ", "00124", "ИКС","АВ-152","Поплавский А.С.","Краснова Е.Р." , 87,66,34),7);
        universiteis.add(new University("Физкультура","001122","ИИМ","СФ-181",67,34,56), 8);
        universiteis.add(new University("Компьютерные технологии в автоматизации та управлении", "009877", "ИКС","АТ-172","Морозова А.А.","Кисель А.Г.", 23,46,88), 9);
        universiteis.add(new University("Теория систем та системний анализ","011987","ИКС","АМ-166",91,92,93), 10);

        Menu();
    }
    /**
     * Создания меню
     */
    public static void Menu(){
        int menuU = 0;
        Scanner scanner = new Scanner(System.in);
        while(menuU==0){
            System.out.println("Выберите нужный пункт: " +
                    "\n1) Сведенья о дисциплине по преподавательским кадрам" +
                    "\n2) Сведенья о преподавателях кафедры и их общей нагрузке" +
                    "\n3)  Удаление записей по курсу либо спецкурсу " +
                    "\n4) Сведенья о предметах, в которых суммарное кол-во часов, отводимых под практические и лабораторные занятия меньше лекционных часов." +
                    "\n5) Список всех курсов" +
                    "\n6) Выход" +
                    "\nВведите цифру нужного пункта и нажмите Enter: ");
            boolean isCorrectly = false;
            String str="";
            while (!isCorrectly) {
                str = scanner.next();
                if (str.equals("1")||str.equals("2")||str.equals("3")||str.equals("4")||str.equals("5")) {
                    isCorrectly = true;
                }
                else {
                    System.out.println("Введите корректное значение: ");
                }
            }
            menuU = Integer.parseInt(str);
            switch (menuU){
                case 1: universiteis.getDataByCourse(); break;
                case 2: universiteis.getDataByClock(); break;
                case 3: universiteis.remove(); break;
                case 4:universiteis.getDataBySubject(); break;
                case 5:universiteis.print();break;
                case 6: System.exit(0); break;
                default: menuU=0;
            }

        }
    }
}


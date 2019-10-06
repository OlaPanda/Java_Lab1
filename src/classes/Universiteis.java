package classes;

import java.util.Scanner;

public class Universiteis {
    Scanner scanner = new Scanner(System.in);

    private University[] list;

    public Universiteis(){
        University[] university = new University[0];
    }

    public Universiteis(final int length){
        this.list = new University[length];
    }

    public void add(final University university, final int position) {
        this.list[position-1] = university;
    }

    String course;
    String clock;
    /**
     Выдачу сведений об учебных дисциплинах
     */
    public void print(){
        for (University university : this.list) {
            System.out.println("\nКурс: " + university.course + "\nШифр курса: " + university.cipher + "\n Ваш факультет:"+ university.faculty+"\nКурс либо группа: " + university.group +"\nЧасы практические: " + university.hoursForPractice +"\nЧасы лекционные: " + university.hoursForLecture+"\nЧасы лабораторные: " + university.hoursForLabs+ "\nФ.И.О. Преподователя: " + university.teacher +"\nФ.И.О. ассистента: " + university.assistant +'\n');
        }
        backToMenu();
    }
    /**
    Выдачу сведений об учебных дисциплинах, не обеспеченных преподавательскими кадрами
     */
    public void getDataByCourse(){
        System.out.println("Введите нужную дисциплину: ");
        course = scanner.next();
        for(int i = 0;i < this.list.length; i++){
            if(course.equals(this.list[i].course)){
                System.out.println("\nКурс: "+this.list[i].course + "\nШифр курса: " + this.list[i].cipher + "\nВаш факультет: " + this.list[i].faculty  + "\nКурс либо группа: " + this.list[i].group + "\nЧасы лекционные: " + this.list[i].hoursForLecture+"\nЧасы практические: " + this.list[i].hoursForPractice+"\nЧасы лабораторные: " + this.list[i].hoursForLabs+"\nФ.И.О. Преподователя: " + this.list[i].teacher +"\n Ф.И.О. ассистента: " + this.list[i].assistant +'\n');
                break;
            }
            else if(i == this.list.length-1){
                System.out.println("Курс не найден не найден!");
            }
        }
        backToMenu();
    }
    /**
     *Выдачу сведений о преподавателях кафедры и их общей нагрузке
     */
    public void getDataByClock(){
        for (University university : this.list) {
            if (university.teacher != null && university.assistant != null) {
                System.out.println("\nКурс " + university.course + "\nФ.И.О. преподователя: " + university.teacher + "\nФ.И.О. ассистента: " + university.assistant  + "\nЧасы практические: " + university.hoursForPractice +"\nЧасы лекционные: " + university.hoursForLecture+"\nЧасы лабораторные: " + university.hoursForLabs +'\n');
            }
        }
        backToMenu();
    }
    /**
     *Удаление записей с заданным названием общего курса / спецкурса
     */
    public void remove(){
        boolean isFounded = false;
        System.out.println("Введите курс: ");
        course = scanner.next();
        for (int i = 0; i < this.list.length;i++){
            if (this.list[i].course.contains(course)){
                this.list[i].course = null;
                this.list[i].cipher=null;
                this.list[i].faculty=null;
                this.list[i].group=null;
                this.list[i].teacher=null;
                this.list[i].assistant=null;
                this.list[i].hoursForPractice=0;
                this.list[i].hoursForLabs=0;
                this.list[i].hoursForLecture=0;
                System.out.println("Удаление выполнено успешно");
                break;
            }
            if (i == this.list.length&&!isFounded)
                System.out.println("Такого курса не существует!");
        }
        backToMenu();
    }
    /**
     *Выдачу сведений о предметах, в которых суммарное кол-во часов, отводимых под практические и лабораторные занятия меньше лекционных часов.
     */
public void getDataBySubject(){
    for (University university : this.list) {
        if (university.hoursForPractice + university.hoursForLabs < university.hoursForLecture) {
            System.out.println("\nКурс " + university.course + "\nФ.И.О. преподователя: " + university.teacher + "\nФ.И.О. ассистента: " + university.assistant  + "\nЧасы практические: " + university.hoursForPractice +"\nЧасы лекционные: " + university.hoursForLecture+"\nЧасы лабораторные: " + university.hoursForLabs +'\n');
        }
    }
    backToMenu();
}
    /**
     * Возращения в меню
     */
    public void backToMenu(){
        int result = -1;
        while (result<0||result>1) {
            System.out.println("Вернуться в меню? (1 - да, 0 - нет)");
            result = Integer.parseInt(scanner.next());
            if (result == 1) {
                Main.Menu();
            }
        }
    }

}

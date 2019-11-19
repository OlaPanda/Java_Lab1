import java.util.Scanner;
import java.util.ArrayList;
public class Universiteis {Scanner scanner = new Scanner(System.in);

    public ArrayList<University> list;
    boolean isCorrectly = false;
    public Universiteis(){
        this.list = new ArrayList<>();
    }

    public Universiteis( int length){
        this.list = new ArrayList<>(length);
    }

    public void add(final University university,  int position) {
        list.add(university);
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
    }
    /**
     Выдачу сведений об учебных дисциплинах, не обеспеченных преподавательскими кадрами
     */
    public void getDataByCourse(){
        System.out.println("Введите нужную дисциплину: ");
        course = scanner.next();
        int counter = 0;
        for(University university : list){
            if(course.equals(university.course)){
                System.out.println("\nКурс: "+university.course + "\nШифр курса: " + university.cipher + "\nВаш факультет: " + university.faculty  + "\nКурс либо группа: " + university.group + "\nЧасы лекционные: " + university.hoursForLecture+"\nЧасы практические: " + university.hoursForPractice+"\nЧасы лабораторные: " + university.hoursForLabs+"\nФ.И.О. Преподователя: " + university.teacher +"\n Ф.И.О. ассистента: " + university.assistant +'\n');
                break;
            }
            else if(counter == list.size()-1){
                System.out.println("Курс не найден не найден!");
            }
        }
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
    }
    /**
     *Удаление записей с заданным названием общего курса / спецкурса
     */
    public void remove(){
        boolean isFounded = false;
        System.out.println("Введите курс: ");
        course = scanner.next();
        int counter = 0;
        for (University university: list){
            if (university.course.contains(course)){
                university.course = null;
                university.cipher=null;
                university.faculty=null;
                university.group=null;
                university.teacher=null;
                university.assistant=null;
                university.hoursForPractice=0;
                university.hoursForLabs=0;
                university.hoursForLecture=0;
                System.out.println("Удаление выполнено успешно");
                break;
            }
            if (counter == list.size()&&!isFounded)
                System.out.println("Такого курса не существует!");
        }
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
    }
    /**
     * Возращения в меню

    public void backToMenu(){
        int result = -1;
        while (result<0||result>1) {
            System.out.println("Вернуться в меню? (1 - да, 0 - нет)");
            result = Integer.parseInt(scanner.next());
            if (result == 1) {
                Main.Menu();
            }
     }
        }*/
    }


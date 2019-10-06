package classes;

public class University {
    String course;
    String cipher;
    String faculty;
    String group;
    String teacher;
    String assistant;
    int hoursForPractice;
    int hoursForLecture;
    int hoursForLabs;

    public University(){
    }
    /**
     * Конструктор
     */
    public University(String course, String cipher, String faculty, String group, String assistant, String teacher, int hoursForPractice, int hoursForLecture, int hoursForLabs ) {
        this.course = course;
        this.cipher = cipher;
        this.faculty = faculty;
        this.group = group;
        this.assistant = assistant;
        this.teacher = teacher;
        this.hoursForLabs=hoursForLabs;
        this.hoursForLecture=hoursForLecture;
        this.hoursForPractice=hoursForPractice;

    }
    /**
     * Конструктор с пустыми значениями
     */
    public University( String course, final String cipher, final String faculty, String group, int hoursForPractice, int hoursForLecture, int hoursForLabs ){
        this.course = course;
        this.cipher = cipher;
        this.faculty = faculty;
        this.group = group;
        this.assistant =null;
        this.teacher =null ;
        this.hoursForLabs=hoursForLabs;
        this.hoursForLecture=hoursForLecture;
        this.hoursForPractice=hoursForPractice;

    }
}

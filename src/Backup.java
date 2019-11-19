import java.io.*;

public class Backup extends Thread {

    private static File file;
    private static Universiteis universiteis;

    public Backup(String pathname, Universiteis universiteis){
        file = new File(pathname);
        Backup.universiteis = universiteis;
    }

    @Override
    public void run(){
        Backup();
    }

    private static void Backup() {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                oos = new ObjectOutputStream(fileOutputStream);
                oos.writeObject(universiteis.list);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
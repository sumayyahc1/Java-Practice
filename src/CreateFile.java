import java.io.File;

public class CreateFile {
    public static void main(String[] args) {
        // create a file object
        File file = new File("newFile.txt");
        try {
            // trying to create new file
            if (file.createNewFile()) {
                System.out.println("The new file is created.");
            }
            else {
                System.out.println("The file already exists.");
            }
            // prints absolute path
            System.out.println(file.getAbsolutePath());
            
            // check if file is readable and writable
            System.out.println("Is writable: "+ file.canWrite());
            System.out.println("Is readable: "+ file.canRead());
        }
        catch(Exception e) {
            e.getStackTrace();
        }      
    }
}


import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    double GPA;

    public Student(int id, String name, double GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', GPA=" + GPA + "}";
    }
}

public class StudentSerialization {

    public static void main(String[] args) {
        Student student = new Student(1, "John Doe", 3.8);
        
       
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            out.writeObject(student);
            System.out.println("Student object serialized and saved to file.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: I/O exception. " + e.getMessage());
        }
        
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student deserializedStudent = (Student) in.readObject();
            System.out.println("Student object deserialized: " + deserializedStudent);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: I/O exception. " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found. " + e.getMessage());
        }
    }
}

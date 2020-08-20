package az.ingress.student.exceptionns;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException() {
        super("No student with requested id found in the system");
    }
}

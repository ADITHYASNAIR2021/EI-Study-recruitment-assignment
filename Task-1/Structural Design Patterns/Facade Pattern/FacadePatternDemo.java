// Complex subsystem classes
class Subsystem1 {
    public void operation1() {
        System.out.println("Subsystem1: operation1");
    }
}

class Subsystem2 {
    public void operation2() {
        System.out.println("Subsystem2: operation2");
    }
}

// Facade class that simplifies the subsystem usage
class Facade {
    private Subsystem1 subsystem1;
    private Subsystem2 subsystem2;

    public Facade() {
        subsystem1 = new Subsystem1();
        subsystem2 = new Subsystem2();
    }

    public void simpleOperation() {
        subsystem1.operation1();
        subsystem2.operation2();
    }
}

// Client code
public class FacadePatternDemo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.simpleOperation(); // Simplified interface to perform complex operations
    }
}

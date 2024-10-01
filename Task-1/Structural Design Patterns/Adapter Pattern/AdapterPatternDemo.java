// Target interface that clients use
interface Target {
    void request();
}

// Adaptee class that has an incompatible interface
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee's specificRequest is called");
    }
}

// Adapter class that adapts the Adaptee to the Target interface
class Adapter implements Target {
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// Client code - This contains the main method you need to run
public class AdapterPatternDemo {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee); // Using the adapter
        target.request(); // This will internally call adaptee's specificRequest
    }
}

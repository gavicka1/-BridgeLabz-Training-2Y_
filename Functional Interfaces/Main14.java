class Model implements Cloneable {
    int id = 10;
    public Object clone() throws CloneNotSupportedException { return super.clone(); }
}

public class Main14 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Model m1 = new Model();
        Model m2 = (Model) m1.clone();
        System.out.println("Cloned model id: " + m2.id);
    }
}

public class Main {
    public static void main(String []args) {
        Bilheteria b = new Bilheteria();
        Distribuidor d = new Distribuidor(b);
        Comprador c1 = new Comprador(b, "Comprador A");
        Comprador c2 = new Comprador(b, "Comprador B");

        d.start();
        c1.start();
        c2.start();
    }
}

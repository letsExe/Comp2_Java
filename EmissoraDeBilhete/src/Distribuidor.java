public class Distribuidor extends Thread{
    private Bilheteria b;

    public Distribuidor(Bilheteria b){
        super("Distribuidor");
        this.b = b;
    }

    public void run(){
        for(int i = 1; i <= 20; i++)
        {
            try{
                Thread.sleep((int)(Math.random()*3000));
            }
            catch(InterruptedException e){
                System.out.println("\n" + e.toString());
            }
            b.setBilhete(i);
        }
        System.out.println("\n"+getName() + "Terminei");
    }
}

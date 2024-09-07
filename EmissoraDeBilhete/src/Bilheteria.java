import java.util.Vector;

public class Bilheteria {
    private Vector conjBilhetes = new Vector();

    public synchronized int getBilhete(){
        if(conjBilhetes.size() == 0){
            System.out.println(Thread.currentThread().getName()+" Nao ha bilhetes");
            return -1;
        }
        else {
            System.out.println(Thread.currentThread().getName() + " Bilhete comprado numero:" + ((Bilhete)conjBilhetes.get(0)).getNum());
            Bilhete b = (Bilhete)conjBilhetes.remove(0);
            return b.getNum();
        }
    }
    public synchronized void setBilhete(int valor) {
        System.out.println(Thread.currentThread().getName()+" Bilhete emitido num: " + valor);
        conjBilhetes.add(new Bilhete(valor));
    }

}


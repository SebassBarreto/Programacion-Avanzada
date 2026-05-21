public class Banco implements Runnable {
    private Cuenta c = new Cuenta();

    public static void main(String[] args) {
        Banco ps = new Banco();
        Thread t1 = new Thread(ps, "Cristian");
        Thread t2 = new Thread(ps, "Angie");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            hacerRetiro(100000.0);
            if (c.getSaldo() < 0) {
                System.out.println("La cuenta está sobregirada");
            }
        }
    }
    private void hacerRetiro(Double cant) {
        if (c.getSaldo() >= cant) {
            System.out.println(Thread.currentThread().getName() + " va a retirar");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            c.retirar(cant);
            System.out.println(Thread.currentThread().getName() + " ha retirado");
        } else {
            System.out.println(Thread.currentThread().getName() + " no ha podido retirar por falta de saldo");
        }
    }
}

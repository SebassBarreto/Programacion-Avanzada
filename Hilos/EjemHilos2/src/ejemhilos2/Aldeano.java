package ejemhilos2;

public class Aldeano extends Thread {
    private String nombre;
    public Aldeano(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void run() {
        for (int a = 1; a <= 5; a++) {
            System.out.println(nombre + " come " + a + " platos de ramen");
        }
        System.out.printf("%s termino\n", nombre);
    }
}

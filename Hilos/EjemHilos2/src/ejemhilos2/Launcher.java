/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemhilos2;
public class Launcher {

    public static void main(String[] args) {
        String[] nombres = { "Sakura", "Naruto","Hinata","Kiba","Shino","Neji","Tenten","Rock Lee", "Choji", "Ino"};
        for (String nomb : nombres) {
            Aldeano e = new Aldeano(nomb);
            Thread t = new Thread(e);
            t.start();
        }
    }
}

class Cuenta {
    private double saldo = 500000;
    
    public Double getSaldo() {
        return saldo;
    }

    public void retirar(Double cantidad) {
        saldo -= cantidad;
    }
}

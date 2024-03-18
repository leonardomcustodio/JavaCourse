package br.com.leocustodio.composition;

public enum OrderStatus {
    PENDING_PAYMENT(0),
    PROCESSING(1),
    SHIPPED(2),
    DELIVERED(3);

    final private int valor;

    OrderStatus(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}

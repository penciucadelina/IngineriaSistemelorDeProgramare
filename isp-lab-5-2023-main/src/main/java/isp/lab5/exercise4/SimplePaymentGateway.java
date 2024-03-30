package isp.lab5.exercise4;

public class SimplePaymentGateway implements PaymentGateway {
    public boolean processPayment(double amount) {
        // procesarea plății
        double totalPrice = 50.0; // Pretul biletului

        if (amount >= totalPrice) {
            System.out.println("Plata în valoare de 50 lei a fost procesată cu succes.");
            return true;
        } else {
            System.out.println("Sold insuficient.");
            return false;
        }
    }
}
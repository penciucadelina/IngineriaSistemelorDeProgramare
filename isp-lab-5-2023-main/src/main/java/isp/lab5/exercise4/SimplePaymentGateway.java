package isp.lab5.exercise4;

public class SimplePaymentGateway implements PaymentGateway {
    public boolean processPayment(double amount) {
        // procesarea plații
        double totalPrice = 50.0; // pretul biletului

        if (amount >= totalPrice) {
            System.out.println("Plata in valoare de 50 lei a fost procesata cu succes.");
            return true;
        } else {
            System.out.println("Sold insuficient.");
            return false;
        }
    }
}
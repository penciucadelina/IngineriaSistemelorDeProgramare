package isp.lab7.safehome;

public class TenantNotFoundException extends Exception {
    TenantNotFoundException(String message) {
        super(message);
    }
}

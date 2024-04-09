package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DoorLockController implements ControllerInterface {
    private final static int MAX_ATTEMPTS = 3;
    private final static String MASTER_KEY_PIN = "master";

    private Map<String, AccessKey> validAccess = new HashMap<>();
    private DoorStatus doorStatus = DoorStatus.CLOSED;
    private int failedAttempts = 0;
    private List<AccessLog> accessLogs = new ArrayList<>();


    @Override
    public DoorStatus enterPin(String pin) throws InvalidPinException, TooManyAttemptsException {
        if (doorStatus == DoorStatus.LOCKED) {
            throw new TooManyAttemptsException("Door is locked. Use master key to unlock.");
        }

        if (pin.equals(MASTER_KEY_PIN)) {
            doorStatus = DoorStatus.OPEN;
            failedAttempts = 0;
            logAccess("Master key used", doorStatus);
            return doorStatus;
        }

        AccessKey accessKey = validAccess.get(pin);
        if (accessKey == null) {
            failedAttempts++;
            if (failedAttempts >= MAX_ATTEMPTS) {
                doorStatus = DoorStatus.LOCKED;
                logAccess("Max attempts reached. Door locked.", doorStatus);
                throw new TooManyAttemptsException("Max attempts reached. Door locked.");
            }
            throw new InvalidPinException("Invalid PIN.");
        }

        doorStatus = (doorStatus == DoorStatus.OPEN) ? DoorStatus.CLOSED : DoorStatus.OPEN;
        failedAttempts = 0;
        logAccess("PIN entered successfully", doorStatus);
        return doorStatus;
    }

    @Override
    public void addTenant(String pin, String tenantName) throws TenantAlreadyExistsException {
        for (String name : validAccess.keySet()) {
            if (validAccess.get(name).getPin().equals(pin)) {
                throw new TenantAlreadyExistsException("Tenant already exists.");
            }
        }
        validAccess.put(tenantName, new AccessKey(pin));
    }

    @Override
    public void removeTenant(String name) throws TenantNotFoundException {
        if (!validAccess.containsKey(name)) {
            throw new TenantNotFoundException("Tenant not found.");
        }
        validAccess.remove(name);
    }

    @Override
    public List<AccessLog> getAccessLogs() {
        return accessLogs;
    }

    private void logAccess(String operation, DoorStatus doorStatus) {
        AccessLog accessLog = new AccessLog(LocalDateTime.now(), operation, doorStatus);
        accessLogs.add(accessLog);
    }


   /* private  Tenant findTenantByAccessKey(AccessKey accessKey)
    {
        for (Map.Entry<Tenant, AccessKey> kv: validAccess.entrySet()){
            if(kv.getValue().equals(accessKey))
                return kv.getKey();
        }
        return null;
    }

      //find key by value in a map
     return validAccess.entrySet().stream()
        .filter(kv -> kv.getValue().equals(accessKey))
        .findFirst()
        .map(kv -> kv.getKey())
        .orElse(null);

    */
}
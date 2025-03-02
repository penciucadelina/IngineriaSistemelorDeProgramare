package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OnlineStore {
    private List<Product> products=new ArrayList<>();
    private Map<String, ActiveSession> sessions=new HashMap();

    void addSession(String username){
        sessions.put(username, new ActiveSession(username));
    }
    public OnlineStore() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }
}

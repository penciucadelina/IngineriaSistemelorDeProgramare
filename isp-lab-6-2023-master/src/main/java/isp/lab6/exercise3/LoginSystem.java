package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

class LoginSystem {
    private Set<User> users=new HashSet<>();
    private Map<String, ActiveSession> sessions=new HashMap<>();
    private OnlineStore store;

    public LoginSystem(OnlineStore store) {
        this.users = new HashSet<>();
        this.sessions = new HashMap<>();
        this.store = store;
    }

    public void register(String username, String password) {
        users.add(new User(username, password));
    }

    public boolean login(String username, String password) {
        User user=null;
        for (User u:users)
            if(u!=null && u.getPassword()!=null && u.getUsername()!=null && u.getPassword().equals(username)) {
                user = u;
                break;
            }
        if(user!=null)
        {
            store.addSession(username);
            return true;
        }
        else
        return false;

    }

    public boolean logout(String username) {

        return true;
    }

    public void addSession(String username) {
        sessions.put(username, new ActiveSession(username));
    }

    public void removeSession(String username) {
        sessions.remove(username);
    }

    public Map<String, ActiveSession> getSessions() {
        return sessions;
    }
}
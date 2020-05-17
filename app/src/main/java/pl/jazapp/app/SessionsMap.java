//package pl.jazapp.app;
//
//
//import javax.enterprise.context.ApplicationScoped;
//import java.util.concurrent.ConcurrentHashMap;
//
//@ApplicationScoped
//public class SessionsMap {
//    private final Map<String, Session> sessions = new ConcurrentHashMap<>();
//
//    public Session getSession(String sessionId) {
//        if (!sessions.containsKey(sessionId)) {
//            sessions.put(sessionId, new Session());
//        }
//        return sessions.get(sessionId);
//    }
//
//    public static class Session {
//
//        private Long counter = 0L;
//
//        public Long getCounter() {
//            return counter++;
//        }
//    }
//}
package configs;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    public Map<String, String> defaultHeaders() {
        Map<String, String> defaultHeadersObjMap = new HashMap<String, String>();
        defaultHeadersObjMap.put("Content-Type", "application/json");

        return defaultHeadersObjMap;
    }

    public Map<String, String> jokerPostHeaders(){
        Map<String, String> jokerHeaderMap = new HashMap<>();
        jokerHeaderMap.put("Connection", "keep-alive");
        jokerHeaderMap.put("Accept-Encoding", "gzip, deflate, br");
        jokerHeaderMap.put("Content-Type", "application/json");

        return jokerHeaderMap;
    }

    public Map<String, String> tokenHeaders() {
        Map<String, String> tokenheadersMap = new HashMap<String, String>();
        //!!! Required headers for token (i.e. client_id, grant_type, code,... etc
        //tokenheadersMap.put("code", "598305932840");

        return tokenheadersMap;
    }
}

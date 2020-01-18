package ley.untis;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import ley.untis.data.AuthParams;
import ley.untis.data.AuthResponse;
import ley.untis.exception.APIRequestException;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UntisClient {

    JsonRpcHttpClient client;
    public AuthResponse auth;
    Map<String , String> header;

    public UntisClient(String username, String password, String url, String school, String appname) throws APIRequestException{
        try {
            client = new JsonRpcHttpClient(new URL(url + "?school=" + school));

            auth = client.invoke("authenticate", new AuthParams(username, password, appname), AuthResponse.class);
            header = new HashMap<>();
            header.put("cookie", "JSESSIONID=" + auth.sessionId);
            client.setHeaders(header);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }

    }

    public UntisClient(String username, String password, String url, String school) throws APIRequestException{
        this(username, password, url, school, "JavaUntis");
    }

    public void logout() throws APIRequestException {
        try {
            client.invoke("logout", new Object[0], Object.class);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }
    }


}

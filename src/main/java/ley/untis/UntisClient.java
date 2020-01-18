package ley.untis;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import ley.untis.data.*;
import ley.untis.exception.APIRequestException;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UntisClient {

    JsonRpcHttpClient client;
    public AuthResponse auth;
    Map<String , String> header;

    /**
     * Creates an UntisClient and starts a session.
     * @param username The username of the user
     * @param password The password of the user
     * @param url The URL of the server including jsonrpc.do
     * @param school The name of the school
     * @param appname The name of your app
     * @throws APIRequestException
     */
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

    /**
     * Creates an UntisClient and starts a session.
     * @param username The username of the user
     * @param password The password of the user
     * @param url The URL of the server including jsonrpc.do
     * @param school The name of the school
     * @throws APIRequestException
     */
    public UntisClient(String username, String password, String url, String school) throws APIRequestException{
        this(username, password, url, school, "JavaUntis");
    }

    /**
     * End the session.
     * Use to logout from the server. Only do this, if you don't longer need this Object!
     * @throws APIRequestException
     */
    public void logout() throws APIRequestException {
        try {
            client.invoke("logout", new Object[0], Object.class);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }
    }

    /**
     * Get list of subjects
     * @return an ArrayList of subjects
     * @throws APIRequestException
     */
    public SubjectResponse getSubjects() throws APIRequestException {
        try {
            return client.invoke("getSubjects", new Object[0], SubjectResponse.class);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }
    }

    /**
     * Get list of teachers
     * @return an ArrayList of teachers
     * @throws APIRequestException
     */
    public TeacherResponse getTeachers() throws APIRequestException {
        try {
            return client.invoke("getTeachers", new Object[0], TeacherResponse.class);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }
    }

    /**
     * Get list of Klassen (base class) for schoolyear
     * @param schoolyearId Id of the schoolyear
     * @return an ArrayList of Klassen
     * @throws APIRequestException
     */
    public KlasseResponse getKlassen(String schoolyearId) throws APIRequestException {
        try {
            return client.invoke("getKlassen", new KlasseParams(schoolyearId), KlasseResponse.class);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }
    }

    /**
     * Get list of Klassen (base class) for current schoolyear
     * @return an ArrayList of Klassen
     * @throws APIRequestException
     */
    public KlasseResponse getKlassen() throws APIRequestException {
        try {
            return client.invoke("getKlassen", new Object[0], KlasseResponse.class);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }
    }

    /**
     * Get list of students
     * @return an ArrayList of students
     * @throws APIRequestException
     */
    public StudentResponse getStudents() throws APIRequestException {
        try {
            return client.invoke("getStudents", new Object[0], StudentResponse.class);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }
    }

    /**
     * Get list of rooms
     * @return an ArrayList of rooms
     * @throws APIRequestException
     */
    public RoomResponse getRooms() throws APIRequestException {
        try {
            return client.invoke("getRooms", new Object[0], RoomResponse.class);
        } catch (Throwable e)
        {
            throw new APIRequestException(e);
        }
    }


}

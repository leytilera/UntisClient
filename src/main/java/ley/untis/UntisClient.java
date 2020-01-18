package ley.untis;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import ley.untis.data.*;
import ley.untis.exception.APIRequestException;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UntisClient {

    //Fields
    JsonRpcHttpClient client;
    public AuthResponse auth;
    Map<String , String> header;

    //Static Methods
    public static String getURLBySchoolname(String schoolname) throws APIRequestException {
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("https://mobile.webuntis.com/ms/schoolquery2"));
            SchoolParams[] params = new SchoolParams[1];
            params[0] = new SchoolParams(schoolname);
            SchoolResponse res = client.invoke("searchSchool", params, SchoolResponse.class);
            return "https://" + res.schools[0].server + "/WebUntis/jsonrpc.do?school=" + res.schools[0].loginName;
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }
    }

    /**
     * Creates an UntisClient and starts a session
     * @param username The username of the user
     * @param password The password of the user
     * @param school The name of the school
     * @param appname The name of your app
     * @return An UntisClient object
     * @throws APIRequestException
     */
    public static UntisClient constructBySchool(String username, String password, String school, String appname) throws APIRequestException {
        return new UntisClient(username, password, getURLBySchoolname(school), appname);
    }

    /**
     * Creates an UntisClient and starts a session
     * @param username The username of the user
     * @param password The password of the user
     * @param url The url of the school
     * @param appname The name of your app
     * @return An UntisClient object
     * @throws APIRequestException
     */
    public static UntisClient constructByURL(String username, String password, String url, String appname) throws APIRequestException {
        return new UntisClient(username, password, url, appname);
    }

    //Constructors
    UntisClient(String username, String password, String url, String appname) throws APIRequestException{
        try {
            client = new JsonRpcHttpClient(new URL(url));

            auth = client.invoke("authenticate", new AuthParams(username, password, appname), AuthResponse.class);
            header = new HashMap<>();
            header.put("cookie", "JSESSIONID=" + auth.sessionId);
            client.setHeaders(header);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }

    }

    //Methods
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

    /**
     * Get list of departments
     * @return an ArrayList of departments
     * @throws APIRequestException
     */
    public DepartmentResponse getDepartments() throws APIRequestException {
        try {
            return client.invoke("getDepartments", new Object[0], DepartmentResponse.class);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }
    }

    /**
     * Get list of holidays
     * @return an ArrayList of holidays
     * @throws APIRequestException
     */
    public HolidayResponse getHolidays() throws APIRequestException {
        try {
            return client.invoke("getHolidays", new Object[0], HolidayResponse.class);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }
    }

    public TimegridResponse getTimegridUnits() throws APIRequestException {
        try {
            return client.invoke("getTimegridUnits", new Object[0], TimegridResponse.class);
        } catch (Throwable e) {
            throw new APIRequestException(e);
        }
    }


}

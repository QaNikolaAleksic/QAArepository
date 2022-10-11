package constants;

public class ApiEndpoints {

    //private
    public static final String USERS = "my/crocodiles/";
    public static String SINGLE_USER(Integer id) { return USERS + id; }

    //public
    public static final String PUBLIC = "public/crocodiles/";

    //authentication
    public static final String LOGIN = "auth/token/login/";
}

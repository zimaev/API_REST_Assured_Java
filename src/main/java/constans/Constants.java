package constans;

import static constans.Constants.Servers.SWAPI_URL;
import static constans.Constants.Path.SWAPI_PATH;

public class Constants {

    //настройки для тестируемого сервиса
    public static class RunVariable{
         public static String server = SWAPI_URL;
         public static String path = SWAPI_PATH;
    }

    //настройка адресов сервера
    public static class Servers{
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String GOOGLE_PLACES_URL;
    }

    public static class Path{
        public static String SWAPI_PATH = "api/";
        public static String GOOGLE_PLACES_PATH;
    }

    public static class Actions{
        public static String GET_PEOPLE = "people/";

    }
}

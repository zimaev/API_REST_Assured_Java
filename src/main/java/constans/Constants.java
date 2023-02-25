package constans;

import static constans.Constants.Servers.JSON_PLACEHOLDER_URL;

public class Constants {

    //настройки для тестируемого сервиса
    public static class RunVariable{
         public static String server = JSON_PLACEHOLDER_URL;
         public static String path = "";
    }

    //настройка адресов сервера
    public static class Servers{
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String JSON_PLACEHOLDER_URL = "https://jsonplaceholder.typicode.com/";
        public static String GOOGLE_PLACES_URL;
    }

    //настройка путей
    public static class Path{
        public static String SWAPI_PATH = "api/";
        public static String GOOGLE_PLACES_PATH;
    }

    //Эндпоинты
    public static class Actions{

        //SWAPI
        public static String GET_PEOPLE = "people/";

        //JSON_PLACEHOLDER
        public static String GET_COMMENTS = "comments/";
        public static String PUT_POST = "/posts/1";
        public static String DELETE_POST = "/posts/1";

    }
}

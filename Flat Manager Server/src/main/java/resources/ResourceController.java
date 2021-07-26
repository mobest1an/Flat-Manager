package resources;

import java.util.ResourceBundle;

public class ResourceController {

    public static ResourceBundle getResourceByName(String resourceName) {
        if (resourceName != null) {
            if (resourceName.equals("resources.Resources_ru")) {
                return ResourceBundle.getBundle("resources.Resources_ru");
            }
            if (resourceName.equals("resources.Resources_pt")) {
                return ResourceBundle.getBundle("resources.Resources_pt");
            }
            if (resourceName.equals("resources.Resources_sq")) {
                return ResourceBundle.getBundle("resources.Resources_sq");
            }
            if (resourceName.equals("resources.Resources_en")) {
                return ResourceBundle.getBundle("resources.Resources_en");
            }
        }
        return ResourceBundle.getBundle("Resources.Resources_ru");
    }

//    public static Locale getLocaleByResourceName(String resourceName) {
//        if (resourceName != null) {
//            if (resourceName.equals("Resources.Resources_ru")) {
//                return new Locale("ru", "Ru");
//            }
//            if (resourceName.equals("Resources.Resources_pt")) {
//                return new Locale("pt", "PT");
//            }
//            if (resourceName.equals("Resources.Resources_sq")) {
//                return new Locale("sq", "AL");
//            }
//            if (resourceName.equals("Resources.Resources_en")) {
//                return new Locale("en", "CA");
//            }
//        }
//        return new Locale("ru", "Ru");
//    }
}

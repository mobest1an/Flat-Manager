package resources;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceController {

    private ResourceBundle mainResourceBundle;
    private ResourceBundle[] resourceBundles;
    private int selectedLanguage;

    public ResourceController(ResourceBundle mainResourceBundle, ResourceBundle[] resourceBundles) {
        this.mainResourceBundle = mainResourceBundle;
        this.resourceBundles = resourceBundles;
    }

    public ResourceBundle getMainResourceBundle() {
        return mainResourceBundle;
    }

    public int getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setMainResourceBundleByIndex(int index) {
        this.selectedLanguage = index;
        mainResourceBundle = resourceBundles[selectedLanguage];
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

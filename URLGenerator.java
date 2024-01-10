
public class URLGenerator {
    private String companyName;
    private String generatedURL;
    private static final String ID = "23176903"; 

    public URLGenerator(String companyName) {
        this.companyName = companyName.toLowerCase().replaceAll("[^a-z\\s]", ""); 
        // remove non-alphabetic characters except spaces
    }

    public void computeURL() {
        String protocol = "https://";
        String modifiedCompanyName = companyName.replaceAll("Inc.|Ltd.|LLC.", "").trim().replaceAll("\\s+", "-");
        if (modifiedCompanyName.length() > 30) { // Length limit check
            modifiedCompanyName = modifiedCompanyName.substring(0, 30);
        }
        String domain = countVowels(companyName) % 2 == 0 ? ".com" : ".ie";
        String path = "view.php"; 

        generatedURL = protocol + modifiedCompanyName + domain + "/" + path + "?id=" + ID;
    }

    private int countVowels(String input) {
        int vowelCount = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                vowelCount++;
            }
        }
        return vowelCount;
    }

    public String getGeneratedURL() {
        return generatedURL;
    }

    public static boolean isValidURL(String url) {
        url = url.toLowerCase();
        return url.startsWith("https://");
    }
}


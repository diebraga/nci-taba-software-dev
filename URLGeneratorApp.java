import java.util.Scanner;

public class URLGeneratorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of company names you want to generate URLs for:");
        int numberOfCompanies = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numberOfCompanies; i++) {
            System.out.println("Enter company name:");
            String companyName = scanner.nextLine();

            URLGenerator generator = new URLGenerator(companyName);
            generator.computeURL();
            String generatedURL = generator.getGeneratedURL();

            System.out.println("Generated URL: " + generatedURL);
            System.out.println("Is the URL valid? " + URLGenerator.isValidURL(generatedURL));
        }

        scanner.close();
    }
}

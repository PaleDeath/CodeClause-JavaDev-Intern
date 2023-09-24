import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeConversionByCountry {
    // Constant for date and time format
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Constant for example time zones
    public static final String EXAMPLE_TIME_ZONES = "(e.g. Asia/Kolkata, Asia/Tashkent, Asia/Kuwait)";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variables to store the user input
        String localZoneIdStr = "";
        String countryZoneIdStr = "";

        // Variables to store the zone ids
        ZoneId localZoneId = null;
        ZoneId countryZoneId = null;

        // Flag to indicate whether the user wants to continue or not
        boolean continueProgram = true;

        while (continueProgram) {
            try {
                // Taking user input for local time zone
                System.out.print("Enter your local time zone " + EXAMPLE_TIME_ZONES + ": ");
                localZoneIdStr = sc.nextLine();

                // Checking if the user wants to exit
                if (localZoneIdStr.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you for using this program. Goodbye!");
                    return;
                }

                // Converting the input string to a zone id object
                localZoneId = ZoneId.of(localZoneIdStr);

                // Taking user input for country time zone
                System.out.print("Enter the country time zone " + EXAMPLE_TIME_ZONES + ": ");
                countryZoneIdStr = sc.nextLine();

                // Checking if the user wants to exit
                if (countryZoneIdStr.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you for using this program. Goodbye!");
                    return;
                }

                // Converting the input string to a zone id object
                countryZoneId = ZoneId.of(countryZoneIdStr);

                // Convert local time to country time
                LocalDateTime localDateTime = LocalDateTime.now(localZoneId);
                LocalDateTime countryDateTime = localDateTime.atZone(localZoneId).withZoneSameInstant(countryZoneId).toLocalDateTime();

                // Formating Date and time
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
                String localTime = formatter.format(localDateTime);
                String countryTime = formatter.format(countryDateTime);

                // Showing output
                System.out.println("Local time (" + localZoneId + "): " + localTime);
                System.out.println("Country time (" + countryZoneId + "): " + countryTime);

                // Ask the user if they want to continue using the program
                System.out.print("Do you want to continue using this program? (yes/no): ");
                String continueResponse = sc.nextLine();

                if (continueResponse.equalsIgnoreCase("no")) {
                    continueProgram = false;
                    System.out.println("Thank you for using this program. Goodbye!");
                    return;
                }
            } catch (Exception e) {
                // Displaying a friendly error message and asking the user to try again
                System.out.println("Invalid input. Please enter a valid time zone or type 'exit' to quit.");
            }
        }
    }
}

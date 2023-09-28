import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class TimeConversionByCountry {
    // Constant for date, day, and time format
    public static final String DATE_DAY_TIME_FORMAT = "yyyy-MM-dd EEE HH:mm:ss";

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
                LocalDateTime countryDateTime = localDateTime.atZone(localZoneId)
                        .withZoneSameInstant(countryZoneId)
                        .toLocalDateTime();

                // Show menu for customization
                System.out.println("Options:");
                System.out.println("1. Change time format");
                System.out.println("2. Show date and day of the week");
                System.out.println("3. Continue without customization");
                System.out.print("Enter your choice: ");
                int optionChoice = Integer.parseInt(sc.nextLine());

                switch (optionChoice) {
                    case 1:
                        System.out.print("Enter the time format (e.g. 'yyyy-MM-dd HH:mm:ss' format): ");
                        String timeFormat = sc.nextLine();
                        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(timeFormat);
                        String localCustomTime = customFormatter.format(localDateTime);
                        String countryCustomTime = customFormatter.format(countryDateTime);
                        System.out.println("Local time (" + localZoneId + "): " + localCustomTime);
                        System.out.println("Country time (" + countryZoneId + "): " + countryCustomTime);
                        break;
                    case 2:
                        DateTimeFormatter dateDayFormatter = DateTimeFormatter.ofPattern(DATE_DAY_TIME_FORMAT);
                        String localDateDayTime = dateDayFormatter.format(localDateTime);
                        String countryDateDayTime = dateDayFormatter.format(countryDateTime);
                        System.out.println("Local time (" + localZoneId + "): " + localDateDayTime);
                        System.out.println("Country time (" + countryZoneId + "): " + countryDateDayTime);
                        break;
                    case 3:
                        // Display default date and time format
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_DAY_TIME_FORMAT);
                        String localTime = formatter.format(localDateTime);
                        String countryTime = formatter.format(countryDateTime);
                        System.out.println("Local time (" + localZoneId + "): " + localTime);
                        System.out.println("Country time (" + countryZoneId + "): " + countryTime);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }

                // Ask the user if they want to continue using the program
                System.out.print("Do you want to continue using this program? (yes/no): ");
                String continueResponse = sc.nextLine();

                if (continueResponse.equalsIgnoreCase("no")) {
                    continueProgram = false;
                    System.out.println("Thank you for using this program. Goodbye!");
                }
            } catch (Exception e) {
                // Displaying a friendly error message and asking the user to try again
                System.out.println("Invalid input. Please enter a valid time zone or type 'exit' to quit.");
            }
        }
    }
}

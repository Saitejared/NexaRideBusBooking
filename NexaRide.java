import java.util.*;

class Person {
    private String name;
    private String address;
    private String email;
    private String password;
    private String mobileNo;

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getMobileNo() { return mobileNo; }
}

class Passenger {
    private String name;
    private int age;
    private String address;
    private String mobileNo;
    private String emailId;
    private String aadhaarNo;  

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setAddress(String address) { this.address = address; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }
    public void setEmailId(String emailId) { this.emailId = emailId; }
    public void setAadhaarNo(String aadhaarNo) { this.aadhaarNo = aadhaarNo; }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAddress() { return address; }
    public String getMobileNo() { return mobileNo; }
    public String getEmailId() { return emailId; }
    public String getAadhaarNo() { return aadhaarNo; }
}

public class NexaRide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person user = new Person();
        ArrayList<Passenger> passengers = new ArrayList<>();

        System.out.println("Welcome to Nexa Ride !");
        System.out.println("Please Login/Signup for Nexa Ride Services");
        System.out.print("Do you have an account in Nexa Ride (yes/no): ");
        String input = sc.next();

        if (input.equalsIgnoreCase("yes")) {
            System.out.println("Login to Nexa Ride using USERID and PASSWORD !");
            System.out.print("USERNAME : ");
            String userId = sc.next();
            System.out.print("PASSWORD : ");
            String password = sc.next();
            System.out.println("Login successful");
        } else {
            sc.nextLine(); 
            System.out.println("Sign up and create your account");
            System.out.print("Name : ");
            String name = sc.nextLine();
            System.out.print("Address : ");
            String address = sc.nextLine();
            String email;
            while (true) {
                System.out.print("Email Id : ");
                email = sc.nextLine();
                if (email.contains("@")) break;
                else System.out.println("Invalid email. Please include '@' in your email.");
            }
            System.out.print("Password : ");
            String password = sc.nextLine();
            String mobileNo;
            while (true) {
                System.out.print("Mobile No : ");
                mobileNo = sc.nextLine();
                if (mobileNo.length() == 10 && mobileNo.matches("\\d+")) break;
                else System.out.println("Enter a valid 10-digit Mobile Number!");
            }
            user.setName(name);
            user.setAddress(address);
            user.setEmail(email);
            user.setPassword(password);
            user.setMobileNo(mobileNo);
            System.out.println("Sign up successful");
            System.out.println("Username : " + email);
            System.out.println("Password : " + password);
        }

        System.out.println("\nWelcome to Nexa Ride Services");
        System.out.println("1. One Way Booking");
        System.out.println("2. Two Way Booking");
        System.out.println("3. Tourism Packages");
        System.out.println("Bus Types: AC / Non-AC / AC-Sleeper");

        sc.nextLine();

        String busType;
        while (true) {
            System.out.print("Type of Bus : ");
            busType = sc.nextLine().trim().toLowerCase();
            if (busType.equals("ac") || busType.equals("non-ac") || busType.equals("ac-sleeper")) {
                break;
            } else {
                System.out.println("Invalid bus type! Please enter AC, Non-AC, or AC-Sleeper.");
            }
        }

        String bookingType;
        while (true) {
            System.out.print("Type of Booking (one way / two way / tourism): ");
            bookingType = sc.nextLine().trim().toLowerCase();
            if (bookingType.equals("one way") || bookingType.equals("two way") || bookingType.equals("tourism")) {
                break;
            } else {
                System.out.println("Invalid booking type. Please enter 'one way', 'two way', or 'tourism'.");
            }
        }

        int numPersons;
        while (true) {
            System.out.print("Number of Persons: ");
            try {
                numPersons = Integer.parseInt(sc.nextLine());
                if (numPersons > 0) break;
                else System.out.println("Number of persons must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }

        int price = 0;
        int totalPrice = 0;
        String from = "", to = "", date = "", returnFrom = "", returnTo = "", returnDate = "", place = "";
        int days = 0;

        switch (bookingType) {
            case "one way":
                System.out.print("From: ");
                from = sc.nextLine();
                System.out.print("To: ");
                to = sc.nextLine();
                System.out.print("Enter Date (dd/mm/yyyy): ");
                date = sc.nextLine();

                if (busType.equals("ac")) price = 1200;
                else if (busType.equals("non-ac")) price = 750;
                else if (busType.equals("ac-sleeper")) price = 1850;

                totalPrice = price * numPersons;
                System.out.println("One Way Booking Confirmed from " + from + " to " + to + " on " + date);
                break;

            case "two way":
                System.out.print("From: ");
                from = sc.nextLine();
                System.out.print("To: ");
                to = sc.nextLine();
                System.out.print("Departure Date (dd/mm/yyyy): ");
                date = sc.nextLine();
                System.out.print("Return From: ");
                returnFrom = sc.nextLine();
                System.out.print("Return To: ");
                returnTo = sc.nextLine();
                System.out.print("Return Date (dd/mm/yyyy): ");
                returnDate = sc.nextLine();

                if (busType.equals("ac")) price = 1050;
                else if (busType.equals("non-ac")) price = 700;
                else if (busType.equals("ac-sleeper")) price = 1650;

                totalPrice = price * 2 * numPersons;
                System.out.println("Two Way Booking Confirmed.");
                break;

            case "tourism":
                System.out.print("Place: ");
                place = sc.nextLine();
                System.out.print("Date (dd/mm/yyyy): ");
                date = sc.nextLine();
                while (true) {
                    System.out.print("Number of Days: ");
                    try {
                        days = Integer.parseInt(sc.nextLine());
                        if (days > 0) break;
                        else System.out.println("Number of days must be greater than zero.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Please enter a valid integer.");
                    }
                }

                price = 1100 * days;
                totalPrice = price * numPersons;
                System.out.println("Tourism Package Confirmed for " + place + " starting " + date);
                break;

            default:
                System.out.println("Invalid booking type.");
                sc.close();
                return;
        }

        for (int i = 1; i <= numPersons; i++) {
            System.out.println("\nEnter details for Passenger " + i + ":");
            Passenger p = new Passenger();

            System.out.print("Name: ");
            p.setName(sc.nextLine());

            while (true) {
                System.out.print("Age: ");
                String ageInput = sc.nextLine();
                try {
                    int age = Integer.parseInt(ageInput);
                    if (age > 0) {
                        p.setAge(age);
                        break;
                    } else {
                        System.out.println("Age must be positive.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid age.");
                }
            }

            System.out.print("Address: ");
            p.setAddress(sc.nextLine());

            String mobileNo;
            while (true) {
                System.out.print("Mobile No: ");
                mobileNo = sc.nextLine();
                if (mobileNo.length() == 10 && mobileNo.matches("\\d+")) {
                    p.setMobileNo(mobileNo);
                    break;
                } else {
                    System.out.println("Enter a valid 10-digit Mobile Number!");
                }
            }

            String email;
            while (true) {
                System.out.print("Email Id: ");
                email = sc.nextLine();
                if (email.contains("@")) {
                    p.setEmailId(email);
                    break;
                } else {
                    System.out.println("Invalid email. Please include '@' in your email.");
                }
            }

            System.out.print("Aadhaar No (12 digits): ");
            while (true) {
                String aadhaar = sc.nextLine();
                if (aadhaar.matches("\\d{12}")) {
                    p.setAadhaarNo(aadhaar);
                    break;
                } else {
                    System.out.println("Invalid Aadhaar Number. Must be exactly 12 digits.");
                }
            }

            passengers.add(p);
        }

        System.out.println("\nPay and confirm your tickets");
        System.out.println("Available payment modes: UPI | Netbanking | Debit/Credit cards");
        System.out.print("Choose payment mode: ");
        String pay = sc.nextLine();

        System.out.println("Amount: ₹" + totalPrice);
        System.out.print("Confirm payment (enter 'done'): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("done")) {
            System.out.println("Payment processed successfully via " + pay + ".");
        } else {
            System.out.println("Payment failed or cancelled.");
            sc.close();
            return;
        }

        System.out.println("\nYour Bus Tickets");
        System.out.println("-----------------------------------------------------------");
        System.out.println("                        Nexa Ride                          ");
        System.out.println("-----------------------------------------------------------");
        for (Passenger p : passengers) {
            System.out.println("Name       : " + p.getName());
            System.out.println("Age        : " + p.getAge());
            System.out.println("Aadhaar No : " + p.getAadhaarNo());
            if (bookingType.equals("tourism")) {
                System.out.println("Tour       : " + place + " starting on " + date);
            } else {
                System.out.println("From       : " + from + "    To: " + to);
                System.out.println("Date       : " + date);
                if (bookingType.equals("two way")) {
                    System.out.println("Return     : " + returnFrom + " to " + returnTo + " on " + returnDate);
                }
            }
            System.out.println("Bus Type   : " + busType.toUpperCase());
            System.out.println("-----------------------------------------------------------");
        }

        System.out.println("Thank you for booking with Nexa Ride!");
    }
}

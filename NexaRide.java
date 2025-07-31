import java.util.*;

class Person {
    private String name;
    private String address;
    private String email;
    private String password;
    private String mobile_no;

    public void setname(String name) { 
        this.name = name; 
    }
    public void setaddress(String address) { 
        this.address = address; 
    }
    public void setemail(String email) { 
        this.email = email; 
    }
    public void setpassword(String password) { 
        this.password = password; 
    }
    public void setmobile_no(String mobile_no) { 
        this.mobile_no = mobile_no; 
    }

    public String getname() { 
        return name; 
    }
    public String getaddress() { 
        return address; 
    }
    public String getemail() { 
        return email; 
    }
    public String getpassword() { 
        return password; 
    }
    public String getmobile_no() { 
        return mobile_no; 
    }
}

class Passenger {
    private String Name;
    private int Age;
    private String Address;
    private String Mobile_No;
    private String Email_Id;
    private Double Aadhaar_No;

    public void setName(String Name) { 
        this.Name = Name; 
    }
    public void setAge(int Age) { 
        this.Age = Age; 
    }
    public void setAddress(String Address) { 
        this.Address = Address;
     }
    public void setMobile_No(String Mobile_No) {
         this.Mobile_No = Mobile_No; 
        }
    public void setEmail_Id(String Email_Id) { 
        this.Email_Id = Email_Id; 
    }
    public void setAadhaar_No(Double Aadhaar_No) { 
        this.Aadhaar_No = Aadhaar_No; 
    }

    public String getName() { 
        return Name; 
    }
    public int getAge() { 
        return Age; 
    }
    public String getAddress() { 
        return Address; 
    }
    public String getMobile_No() { 
        return Mobile_No; 
    }
    public String getEmail_Id() { 
        return Email_Id; 
    }
    public Double getAadhaar_No() { 
        return Aadhaar_No;
     }
}

public class NexaRide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person data = new Person();
        ArrayList<Passenger> passengers = new ArrayList<>();

        System.out.println("Welcome to Nexa Ride !");
        System.out.println("Please Login/Signup for Nexa Ride Services");
        System.out.print("Do you have an account in Nexa Ride (yes/no): ");
        String input = sc.next();

        if (input.equalsIgnoreCase("yes")) {
            System.out.println("Login to Nexa Ride using USERID and PASSWORD !");
            System.out.print("USERNAME : ");
            String Userid = sc.next();
            System.out.print("PASSWORD : ");
            String Password = sc.next();
            System.out.println("Login successful");
        } else {
            sc.nextLine(); // clear buffer
            System.out.println("Sign up and create your account");
            System.out.print("Name : ");
            String name = sc.nextLine();
            System.out.print("ADDRESS : ");
            String address = sc.nextLine();
            String email;
            while (true) {
                System.out.print("Email Id : ");
                email = sc.nextLine();
                if (email.contains("@")) break;
                else System.out.println("Invalid email. Please include '@' in your email.");
            }
            System.out.print("PASSWORD : ");
            String password = sc.nextLine();
            String mobile_no;
            while (true) {
                System.out.print("Mobile_no : ");
                mobile_no = sc.nextLine();
                if (mobile_no.length() == 10) break;
                else System.out.println("Enter valid Mobile Number!");
            }
            data.setname(name);
            data.setaddress(address);
            data.setemail(email);
            data.setpassword(password);
            data.setmobile_no(mobile_no);
            System.out.println("Sign up successful");
            System.out.println("Username : " + email);
            System.out.println("Password : " + password);
        }

        System.out.println("\nWelcome to Nexa Ride Services");
        System.out.println("1. One Way Booking");
        System.out.println("2. Two Way Booking");
        System.out.println("3. Tourism Packages");
        System.out.println("AC/NON-AC/AC-Sleeper");

        sc.nextLine(); 
        System.out.print("Type of Bus : ");
        String Bus = sc.nextLine();

        System.out.print("Type of Booking : ");
        String Booking = sc.nextLine().toLowerCase();

        int numPersons = 0;
        System.out.print("\nNumber of Persons: ");
        try {
            numPersons = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid number. Exiting.");
            return;
        }

        int totalPrice = 0;
        int price = 0;
        String from = "", to = "", date = "", returnFrom = "", returnTo = "", returnDate = "", place = "";
        int days = 0;

        switch (Booking) {
            case "one way":
                System.out.print("From: ");
                from = sc.nextLine();
                System.out.print("To: ");
                to = sc.nextLine();
                System.out.print("Enter Date: ");
                date = sc.nextLine();

                price = Bus.equalsIgnoreCase("AC") ? 1200 :
                        Bus.equalsIgnoreCase("Non-AC") ? 750 :
                        Bus.equalsIgnoreCase("AC-Sleeper") ? 1850 : 0;

                totalPrice = price * numPersons;
                System.out.println("One Way Booking Confirmed from " + from + " to " + to + " on " + date);
                break;

            case "two way":
                System.out.print("From: ");
                from = sc.nextLine();
                System.out.print("To: ");
                to = sc.nextLine();
                System.out.print("Departure Date: ");
                date = sc.nextLine();
                System.out.print("Return From: ");
                returnFrom = sc.nextLine();
                System.out.print("Return To: ");
                returnTo = sc.nextLine();
                System.out.print("Return Date: ");
                returnDate = sc.nextLine();

                price = Bus.equalsIgnoreCase("AC") ? 1050 :
                        Bus.equalsIgnoreCase("Non-AC") ? 700 :
                        Bus.equalsIgnoreCase("AC-Sleeper") ? 1650 : 0;

                totalPrice = price * 2 * numPersons;
                System.out.println("Two Way Booking Confirmed.");
                break;

            case "tourism":
                System.out.print("Place: ");
                place = sc.nextLine();
                System.out.print("Date: ");
                date = sc.nextLine();
                System.out.print("Number of Days: ");
                days = sc.nextInt();
                sc.nextLine();

                price = 1100 * days;
                totalPrice = price * numPersons;
                System.out.println("Tourism Package Confirmed for " + place + " starting " + date);
                break;

            default:
                System.out.println("Invalid booking type.");
                return;
        }

        // Passenger details
        for (int i = 1; i <= numPersons; i++) {
            System.out.println("\nEnter details for Passenger " + i + ":");
            Passenger p = new Passenger();

            System.out.print("Name: ");
            p.setName(sc.nextLine());

            System.out.print("Age: ");
            p.setAge(sc.nextInt());
            sc.nextLine();

            System.out.print("Address: ");
            p.setAddress(sc.nextLine());

            System.out.print("Mobile No: ");
            p.setMobile_No(sc.nextLine());

            System.out.print("Email Id: ");
            p.setEmail_Id(sc.nextLine());

            System.out.print("Aadhaar No: ");
            p.setAadhaar_No(sc.nextDouble());
            sc.nextLine();

            passengers.add(p);
        }

        // Payment
        System.out.println("\nPay and confirm your tickets");
        System.out.println("UPI\nNetbanking\nDebit/Credit cards");
        System.out.print("Choose payment mode : ");
        String pay = sc.nextLine();

        System.out.println("Amount: ₹" + totalPrice);
        System.out.print("Confirm payment (enter 'done'): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("done")) {
            System.out.println("Payment processed successfully via " + pay + ".");
        } else {
            System.out.println("Payment failed or cancelled.");
            return;
        }

        // Final ticket
        System.out.println("\nYour Bus Tickets");
        System.out.println("-----------------------------------------------------------");
        System.out.println("                     Nexa Ride                             ");
        System.out.println("-----------------------------------------------------------");
        for (Passenger p : passengers) {
            System.out.println("Name       : " + p.getName());
            System.out.println("Age        : " + p.getAge());
            System.out.println("Aadhaar No : " + p.getAadhaar_No());
            if (Booking.equals("tourism")) {
                System.out.println("Tour       : " + place + " starting on " + date);
            } else {
                System.out.println("From       : " + from + "  To: " + to);
                System.out.println("Date       : " + date);
                if (Booking.equals("two way")) {
                    System.out.println("Return     : " + returnFrom + " to " + returnTo + " on " + returnDate);
                }
            }
            System.out.println("Bus Type   : " + Bus);
            System.out.println("-----------------------------------------------------------");
        }

        System.out.println("Thank you for booking with Nexa Ride!");
    }
}

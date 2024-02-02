import java.util.Scanner;

public class Main {
    static int rows;
    static int cols;
    static char[] lable = new char[26];

    private static void setupHall(String[][] hall, char[] lable) {
        System.out.println("-+".repeat(35));

        for (int i = 0; i < hall.length; ++i) {
            for (int j = 0; j < hall[i].length; ++j) {
                if (hall[i][j] == null) {
                    System.out.print("|" + lable[i] + "-" + (j + 1) + "::AV|   ");
                } else {
                    System.out.print("|" + lable[i] + "-" + (j + 1) + "::" + hall[i][j] + "|   ");
                }
            }

            System.out.println();
        }
        System.out.println("-+".repeat(35));
    }
    // booking
    public static void bookingSeat(String [][]hall,char row, int seatNumber){
        int rowBooking = row - 'A';
        // Validate row and seatNumber
        if (row >= 'A' && row <= 'C' && seatNumber >= 1 && seatNumber <= hall[0].length) {
            // Check if the seat is available
            if (hall[rowBooking][seatNumber - 1] != null && hall[rowBooking][seatNumber - 1].equals("AV")) {
                // Book the seat
                hall[rowBooking][seatNumber - 1] = "BO";
                System.out.println("Seat " + row + "-" + seatNumber + " booked successfully!");
            } else {
                System.out.println("Seat " + row + "-" + seatNumber + " is already booked or invalid.");
            }
        } else {
            System.out.println("Invalid row or seat number.");
        }
    }
    private static char getConfirmation(String message) {
        Scanner scanner = new Scanner(System.in);
        char confirmation;

        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() == 1 && (input.equals("Y") || input.equals("N"))) {
                confirmation = input.charAt(0);
                break;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }

        return confirmation;
    }

    static void showHall(String[][] arr, char[] alpabet) {
        System.out.println("+".repeat(35));

        for(int i = 0; i < arr.length; ++i) {
            for(int j = 0; j < arr[i].length; ++j) {
                if (arr[i][j] == null) {
                    System.out.print("|" + alpabet[i] + "-" + (j + 1) + "::AV|   ");
                } else {
                    System.out.print("|" + alpabet[i] + "-" + (j + 1) + "::" + arr[i][j] + "|   ");
                }
            }

            System.out.println();
        }

        System.out.println("+".repeat(35));
    }
    static void history(String[] bookingHistory, int n) {
        for(int i = 0; i < n; ++i) {
            if (bookingHistory[i] == null) {
                System.out.println("<<< all array is reboot >>>>");
            } else {
                System.out.println("# User : " + (i + 1));
                System.out.println(bookingHistory[i]);
            }
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String option;

        System.out.print("Input row : ");
        rows = input.nextInt();
        System.out.print("Input column: ");
        cols = input.nextInt();
        String[][] hallsetup = new String[rows][cols];
        //Setup hall

        int index = 0;
        for (char a = 'A'; a <= 'Z'; ++a) {
            lable[index] = a;
            ++index;
        }
        setupHall(hallsetup, lable);
        // end Setup
        do {
            System.out.println("Welcome to CSTAD Hall ");
            System.out.println("<A> Booking ");
            System.out.println("<B> Hall");
            System.out.println("<C> Showtime");
            System.out.println("<D> Reboot Showtime");
            System.out.println("<E> History");
            System.out.println("<F> Exit");
            System.out.print("Select your option: ");
            option = input.next();
            switch (option) {
                case "a", "A": {
                    String timeshow;
                    System.out.println("-+".repeat(35));
                    System.out.println("""
                            ============== Booking ===========""");
                    System.out.println("# Daily show time of hall ");
                    System.out.println("# A) Morning (10:00 - 12:30 PM)");
                    System.out.println("# B) Afternoon (03:00 - 05:30 PM)");
                    System.out.println("# C) Night (07:00 - 09:30 PM)");
                    System.out.println("+".repeat(35));

                    System.out.print("Please select show time (A|B|C): ");
                    timeshow = input.next();
                    switch (timeshow) {
                        case "a", "A": {
                            String[][] hallMorning = new String[rows][cols];
                            if (timeshow.equalsIgnoreCase("A")) {
                                System.out.println("+".repeat(15) + " Morning (10:00 - 12:30 PM)" + "+".repeat(15));

                                // Additional booking logic for the Morning shift
                                System.out.print("Enter the row (A|B|C): ");
                                char row = input.next().charAt(0);
                                System.out.print("Enter the seat number: ");
                                int seatNumber = input.nextInt();
                                input.nextLine();
                                String comfirm=input.nextLine();
                                getConfirmation(comfirm);
                                ///called method
                                bookingSeat(hallMorning, row, seatNumber);

                            }
                            break;
                        }
                            case "b", "B": {
                                String[][] hallMorning = new String[rows][cols];
                                if (timeshow.equalsIgnoreCase("B")) {
                                    System.out.println("+".repeat(15)+" After (01:30 - 05:30 PM)"+"+".repeat(15));

                                    System.out.print("Enter the row (A|B|C): ");
                                    char row = input.next().charAt(0);
                                    System.out.print("Enter the seat number: ");
                                    int seatNumber = input.nextInt();
                                    input.nextLine();
                                    String comfirm=input.nextLine();
                                    getConfirmation(comfirm);
                                    ///called method
                                    bookingSeat(hallMorning,row,seatNumber);

                                }break;
                        }
                        case "c", "C": {
                            String[][] hallMorning = new String[rows][cols];
                            if (timeshow.equalsIgnoreCase("C")) {
                                System.out.println("+".repeat(15)+" Night (07:00 - 09:30 PM)"+"+".repeat(15));

                                System.out.print("Enter the row (A|B|C): ");
                                char row = input.next().charAt(0);
                                System.out.print("Enter the seat number: ");
                                int seatNumber = input.nextInt();
                                input.nextLine();
                                String comfirm=input.nextLine();
                                getConfirmation(comfirm);
                                ///called method
                                bookingSeat(hallMorning,row,seatNumber);

                            }break;
                        }

                    }break;

                }
                case"b","B":{
                    System.out.println("+".repeat(35));
                    for (int i=0; i<3;i++){
                        showHall(hallsetup,lable);
                    }
                    System.out.println("+".repeat(35));
                }break;
                case"c","C":{
                    System.out.println("+".repeat(35));
                    System.out.println("========= Booking ===========");
                    System.out.println("# Daily show time of hall ");
                    System.out.println("# A) Morning (10:00 - 12:30 PM)");
                    System.out.println("# B) Afternoon (03:00 - 05:30 PM)");
                    System.out.println("# C) Night (07:00 - 09:30 PM)");
                    System.out.println("+".repeat(35));

                }continue;
                case"d","D":{
                    boolean b =true;
                    System.out.println("+".repeat(35));
                    input.nextLine();
                    String comfirm=input.nextLine();
                    getConfirmation(comfirm);
                    for (int i=0;i<hallsetup.length;i++){
                        for(int j=0;j<hallsetup[i].length;j++){
                             b = hallsetup[i][j] .equals(null) ;
                            System.out.println("Reboot success!!");
                        }
                    }

                    System.out.println("+".repeat(35));
                }break;
                case"e","E":{
                    int n=0;

                    System.out.println("+".repeat(35));
                        history(hallsetup[rows-1],n);
                    System.out.println("+".repeat(35));
                }break;
            }

        } while (option.equals("f"));
    }
}
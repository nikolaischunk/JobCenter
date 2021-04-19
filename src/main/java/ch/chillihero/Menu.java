package ch.chillihero;

import java.util.Scanner;

public class Menu {


    Scanner scan = new Scanner(System.in);
    JobCenter jobCenter = new JobCenter();
    boolean isLoggedin = false;


    public void start() {
        jobCenter.generateDummyJobs();
        jobCenter.generateDummyPersons();
        menuProcesss();
    }

    public void menuProcesss() {
        boolean repeat = true;
        boolean repeatMenu = false;

        while (repeat) {
            System.out.println("Please Login!");
            System.out.println("Email: ");
            String inputEmail = scan.nextLine();
            if (inputEmail.equalsIgnoreCase("exit")) {
                repeat = false;
                return;
            }
            System.out.println("Password: ");
            String inputPassword = scan.nextLine();

            if (jobCenter.isLoginValid(inputEmail, inputPassword)) {
                jobCenter.setLoggedInPerson(inputEmail);
                isLoggedin = true;
                repeatMenu = true;

                while (repeatMenu) {
                    mainmenu();
                }
            } else {
                System.out.println("Wrong Email or Password");
            }
        }
    }

    public void logout() {
        jobCenter.setLoggedInPerson(null);
        isLoggedin = false;
        menuProcesss();
    }

    public void mainmenu() {
        if (!isLoggedin) {
            return;
        }
//Menu to choose what to do next
        System.out.println("What do you want to do?\n" +
                "1: Create new Job\n" +
                "2: Show All Jobs\n" +
                "3: Show All Avaible Jobs\n" +
                "4: Show All In Progress Jobs\n" +
                "5: Show All Done Jobs\n" +
                "6: Show All My InProgress Jobs\n" +
                "7: Accept Job\n" +
                "8: Finish Job\n" +
                "9: Logout\n");
        String choice = scan.nextLine();

        switch (choice) {
            case "1":
                jobCenter.createJob();
                break;
            case "2":
                jobCenter.listALlJobs();
                break;
            case "3":
                jobCenter.listAvaibleJobs();
                break;
            case "4":
                jobCenter.listInProgressJobs();
                break;
            case "5":
                jobCenter.listFinishedJobs();
                break;
            case "6":
                jobCenter.listMyInProgress();
                break;
            case "7":
                jobCenter.acceptJob();
                break;
            case "8":
                jobCenter.finshJob();
                break;
            case "9":
                System.out.println("Logged Out Successfully");
                logout();
                break;
            default:
                System.out.println("Not A Valid Choice, try again!\n");
                break;
        }
    }
}




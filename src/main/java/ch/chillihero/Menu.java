package ch.chillihero;

import java.util.Scanner;

public class Menu {

    public String loggedInUser = "0";
    Scanner scan = new Scanner(System.in);
    JobCenter jobCenter = new JobCenter();


    public void start() {
        jobCenter.generateDummyJobs();
        jobCenter.generateDummyPersons();
        login();

    }


    public void login() {
        boolean repeatLoginProcess = true;
        while (repeatLoginProcess) {
            System.out.println("Please Login!");
            System.out.println("Email: ");
            String inputEmail = scan.nextLine();
            System.out.println("Password: ");
            String inputPassword = scan.nextLine();

            if (jobCenter.isLoginValid(inputEmail, inputPassword)) {
                loggedInUser = jobCenter.returnLoggedInUser(inputEmail);
                UserMenu();
                repeatLoginProcess = false;
            } else {
                System.out.println("Login not valid, try again");
            }
        }
    }

    public void logout() {

    }

    public void UserMenu() {
        boolean repeatJobMenu = true;
        do {
            System.out.println("What do you want to do?\n" +
                    "1: Create new Job\n" +
                    "2: Show All Jobs\n" +
                    "3: Show All Avaible Jobs\n" +
                    "4: Show All In Progress Jobs\n" +
                    "5: Show All Done Jobs\n");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    jobCenter.createJob();
                    break;
                case 2:
                    jobCenter.listALlJobs();
                    break;
                case 3:
                    jobCenter.listAvaibleJobs();
                    break;
                case 4:
                    jobCenter.listInProgressJobs();
                    break;
                case 5:
                    jobCenter.listFinishedJobs();
                    break;
                default:
                    System.out.println("Not A Valid Coice, try again!\n");
            }
        } while (repeatJobMenu);
    }
}



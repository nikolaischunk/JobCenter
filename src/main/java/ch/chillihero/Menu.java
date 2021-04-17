package ch.chillihero;

import java.util.Scanner;

public class Menu {

    public String loggedInUser = "0";
    Scanner scan = new Scanner(System.in);
    JobCenter jobCenter = new JobCenter();
    boolean repeatLoginProcess = true;

    public void start() {
        jobCenter.generateDummyJobs();
        jobCenter.generateDummyPersons();


        } else {


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


    public void login() {

    }

    public void logout() {

    }

}

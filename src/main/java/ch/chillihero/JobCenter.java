package ch.chillihero;

import ch.chillihero.util.AutoIncrement;
import ch.chillihero.util.convertPerson;
import ch.chillihero.util.convertStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class JobCenter {
    //List for all Jobs
    public List<Job> allJobs = new ArrayList<>();
    //List for all Person
    public List<Person> allPersons = new ArrayList<>();
    JobFactory jobFactory = new JobFactory();
    Scanner scan = new Scanner(System.in);
    //LoggedIn User to work with Attributes
    private Person loggedInUser = null;

    //Create a Menu for Creating a new Job
    public void createJob() {
        String jobChoice = "";
        boolean repeat = true;
        do {
            System.out.println("What kind of Job do you want to Create?\n" +
                    "1: Housework\n" +
                    "2: Babysitting\n" +
                    "3: Gardenwork\n" +
                    "4: Cleaning\n");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    jobChoice = "housework";
                    repeat = false;
                    break;
                case 2:
                    jobChoice = "babysitting";
                    repeat = false;
                    break;
                case 3:
                    jobChoice = "gardenwork";
                    repeat = false;
                    break;
                case 4:
                    jobChoice = "cleaning";
                    repeat = false;
                    break;
                default:
                    System.out.println("Not a valid Choice, try again");
                    break;
            }

        } while (repeat);
        Job job = jobFactory.createJob(jobChoice);
        System.out.println("====== Create new " + job.getTitle() + " Job ======\n");
        System.out.println("Write a short Description of the Job");
        String description = scan.nextLine();
        System.out.println("How long takes the Job (in hours)");
        int duration = scan.nextInt();
        scan.nextLine();
        System.out.println("Whats the Adress of the Job?");
        String location = scan.nextLine();
        System.out.println("What is the salary per Hour?");
        int salaryPerHour = scan.nextInt();
        scan.nextLine();

        //Set all Fields
        job.setId(AutoIncrement.generate());
        job.setDescription(description);
        job.setDuration(duration);
        job.setLocation(location);
        job.setSalary(salaryPerHour);
        job.setCreator(loggedInUser);
        allJobs.add(job);
        System.out.println("Created new Job with the ID: " + job.getId() + "\n");
    }

    public void acceptJob() {
        //Method to accept an Open Job
        System.out.println("====== Accept Job ======");
        System.out.println("Whats the ID of the Job you want to accept?");
        String jobID = scan.nextLine();

        Job choosenJob = returnJobFromId(jobID);
        if (!isJobTaken(jobID)) {
            choosenJob.setWorker(loggedInUser);
            choosenJob.setStatus(1);
        } else {
            System.out.println("Job is already taken");
        }
    }

    public void finshJob() {
        //Method to finish an accepted Job
        System.out.println("====== Finish Job ======");
        System.out.println("Whats the ID of the Job you want to finish?");
        String jobID = scan.nextLine();

        Job choosenJob = returnJobFromId(jobID);
        if (choosenJob.getStatus() == 0) {
            System.out.println("This job is not taken yet");
            return;
        }
        if (choosenJob.getWorker() != loggedInUser) {
            System.out.println("This is not your Job!");
            return;
        } else {
            choosenJob.setWorker(loggedInUser);
            choosenJob.setStatus(2);
        }
    }

    public void listALlJobs() {
        if (!allJobs.isEmpty()) {
            for (Job job : allJobs) {
                System.out.println("ID: " + job.getId() + "\n" +
                        "Title: " + job.getTitle() + "\n" +
                        "Description: " + job.getDescription() + "\n" +
                        "Location: " + job.getLocation() + "\n" +
                        "Duration: " + job.getDuration() + "\n" +
                        "Salary per Hour: " + job.getSalary() + "\n" +
                        "Status: " + convertStatus.convert(job.getStatus()) + "\n" +
                        "Creator: " + convertPerson.convert(job.getCreator()) + "\n" +
                        "Worker: " + convertPerson.convert(job.getWorker()) + "\n");
            }
        } else {
            System.out.println("No Jobs Found");
        }
    }

    public boolean isJobTaken(String jobID) {
        Job choosenJob = returnJobFromId(jobID);
        return choosenJob.getWorker() != null;
    }

    public Job returnJobFromId(String Id) {
        if (!allJobs.isEmpty()) {
            for (Job job : allJobs) {
                if (job.getId().equals(Id)) {
                    return job;
                }
            }
        } else {
            System.out.println("No Jobs Found");
        }
        return null;
    }

    public void listAvaibleJobs() {
        listJobs(0);
    }

    public void listInProgressJobs() {
        listJobs(1);
    }

    public void listFinishedJobs() {
        listJobs(2);
    }

    private void listJobs(int status) {
        //generic method to get all Jobs with a specific Status
        if (!allJobs.isEmpty()) {
            for (Job job : allJobs) {
                if (job.getStatus() == status) {
                    System.out.println("ID: " + job.getId() + "\n" +
                            "Title: " + job.getTitle() + "\n" +
                            "Description: " + job.getDescription() + "\n" +
                            "Location: " + job.getLocation() + "\n" +
                            "Duration: " + job.getDuration() + "\n" +
                            "Salary per Hour: " + job.getSalary() + "\n" +
                            "Status: " + convertStatus.convert(job.getStatus()) + "\n" +
                            "Creator: " + convertPerson.convert(job.getCreator()) + "\n" +
                            "Worker: " + convertPerson.convert(job.getWorker()) + "\n");
                }
            }
            new Menu().mainmenu();
        } else {
            System.out.println("No Jobs Found");
        }
    }

    public void listMyInProgress() {
        CompletableFuture.runAsync(() -> {
            if (!allJobs.isEmpty()) {
                for (Job job : allJobs) {
                    if (job.getStatus() == 1 && job.getWorker().equals(loggedInUser)) {
                        System.out.println("ID: " + job.getId() + "\n" +
                                "Title: " + job.getTitle() + "\n" +
                                "Description: " + job.getDescription() + "\n" +
                                "Location: " + job.getLocation() + "\n" +
                                "Duration: " + job.getDuration() + "\n" +
                                "Salary per Hour: " + job.getSalary() + "\n" +
                                "Status: " + convertStatus.convert(job.getStatus()) + "\n" +
                                "Creator: " + convertPerson.convert(job.getCreator()) + "\n" +
                                "Worker: " + convertPerson.convert(job.getWorker()) + "\n");
                    }
                }

                new Menu().mainmenu();
            } else {
                System.out.println("No Jobs in Progress.");
            }
        });
    }


    public void setLoggedInPerson(String email) {
        for (Person person : allPersons) {
            if (email == null) {
                this.loggedInUser = null;
                break;
            }
            if (person.getEmail().equals(email)) {
                this.loggedInUser = person;
            }
        }
    }

    public boolean isLoginValid(String email, String password) {
        for (Person person : allPersons) {
            if (person.getEmail().equals(email)) {
                if (person.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Generate Dummies to test our System
    public void generateDummyJobs() {
        Job job1 = jobFactory.createJob("babysitting");
        Job job2 = jobFactory.createJob("gardenwork");
        Job job3 = jobFactory.createJob("housework");
        Person person = new Person();
        person.setFirstname("Back");
        person.setLastname("Fisch");

        job1.setId("1000");
        job1.setDescription("A great Babysitt Job, searching M/W min. 16y old");
        job1.setDuration(4);
        job1.setLocation("My Adress 19b");
        job1.setSalary(10);
        job1.setCreator(person);

        job2.setId("999");
        job2.setDescription("A great Gardenwork Job, searching M/W min. 12y old");
        job2.setDuration(8);
        job2.setLocation("A nice location in  19b");
        job2.setSalary(33);
        job2.setStatus(1);
        job2.setWorker(person);

        job3.setId("998");
        job3.setDescription("A great Housework Job, searching M/W min. 18y old");
        job3.setDuration(2);
        job3.setLocation("Another Adress anywhere 19b");
        job3.setSalary(15);
        job2.setCreator(person);

        allJobs.add(job1);
        allJobs.add(job2);
        allJobs.add(job3);

    }

    public void generateDummyPersons() {
        Person person1 = new Person();
        person1.setId("1");
        person1.setFirstname("Nikolai");
        person1.setLastname("Schunk");
        person1.setAge(17);
        person1.setEmail("nikolai.schunk@gmail.com");
        person1.setPassword("abc123");

        Person person2 = new Person();
        person2.setId("2");
        person2.setFirstname("Peter");
        person2.setLastname("Pan");
        person2.setAge(20);
        person2.setEmail("peter.pan@gmail.com");
        person2.setPassword("paeterpan");

        Person person3 = new Person();
        person3.setId("3");
        person3.setFirstname("Hanna");
        person3.setLastname("Fate");
        person3.setAge(14);
        person3.setEmail("hanna.fate@gmail.com");
        person3.setPassword("keepthefate");

        allPersons.add(person1);
        allPersons.add(person2);
        allPersons.add(person3);
    }

}

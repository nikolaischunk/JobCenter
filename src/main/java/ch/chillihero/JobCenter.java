package ch.chillihero;

import ch.chillihero.util.AutoIncrement;
import ch.chillihero.util.convertStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JobCenter {

    public List<Job> allJobs = new ArrayList<>();
    public List<Person> allPersons = new ArrayList<>();
    JobFactory jobFactory = new JobFactory();
    Scanner scan = new Scanner(System.in);
    public String loggedInUser = "0";

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

        job.setId(AutoIncrement.generate());
        job.setDescription(description);
        job.setDuration(duration);
        job.setLocation(location);
        job.setSalary(salaryPerHour);

        allJobs.add(job);
    }

    public void acceptJob() {

    }

    public void finshJob() {

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
                        "Status: " + convertStatus.convert(job.getStatus()) + "\n");
            }
        } else {
            System.out.println("No Jobs Found\n");
        }
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
        if (!allJobs.isEmpty()) {
            for (Job job : allJobs) {
                if (job.getStatus() == status) {
                    System.out.println("ID: " + job.getId() + "\n" +
                            "Title: " + job.getTitle() + "\n" +
                            "Description: " + job.getDescription() + "\n" +
                            "Location: " + job.getLocation() + "\n" +
                            "Duration: " + job.getDuration() + "\n" +
                            "Salary per Hour: " + job.getSalary() + "\n" +
                            "Status: " + convertStatus.convert(job.getStatus()) + "\n");
                } else {
                    System.out.println("No Jobs Found\n");
                }
            }
        } else {
            System.out.println("No Jobs Found\n");
        }
    }

    public void loginProcess (){
        boolean repeatLoginProcess = true;

        if (loggedInUser == "0") {
            while (repeatLoginProcess) {
                System.out.println("Please Login!\n" +
                        "Email: ");
                String inputEmail = scan.nextLine();
                System.out.println("Password: ");
                String inputPassword = scan.nextLine();

                for (Person person : jobCenter.allPersons) {
                    if (person.getEmail() == inputEmail) {
                        if (person.getPassword() == inputPassword) {
                            loggedInUser = person.getId();
                            repeatLoginProcess = false;
                        }
                    }
                }
            }
    }

    public void generateDummyJobs() {
        Job job1 = jobFactory.createJob("babysitting");
        Job job2 = jobFactory.createJob("gardenwork");
        Job job3 = jobFactory.createJob("housework");

        job1.setId("1000");
        job1.setDescription("A great Babysitt Job, searching M/W min. 16y old");
        job1.setDuration(4);
        job1.setLocation("My Adress 19b");
        job1.setSalary(10);

        job2.setId("999");
        job2.setDescription("A great Gardenwork Job, searching M/W min. 12y old");
        job2.setDuration(8);
        job2.setLocation("A nice location in  19b");
        job2.setSalary(33);
        job2.setStatus(2);

        job3.setId("998");
        job3.setDescription("A great Housework Job, searching M/W min. 18y old");
        job3.setDuration(2);
        job3.setLocation("Another Adress anywhere 19b");
        job3.setSalary(15);

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
        person1.setId("2");
        person1.setFirstname("Peter");
        person1.setLastname("Pan");
        person1.setAge(20);
        person1.setEmail("peter.pan@gmail.com");
        person1.setPassword("paeterpan");

        Person person3 = new Person();
        person1.setId("3");
        person1.setFirstname("Hanna");
        person1.setLastname("Fate");
        person1.setAge(14);
        person1.setEmail("hanna.fate@gmail.com");
        person1.setPassword("keepthefate");

        allPersons.add(person1);
        allPersons.add(person2);
        allPersons.add(person3);
    }

}

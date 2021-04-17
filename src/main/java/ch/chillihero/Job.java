package ch.chillihero;

abstract public class Job {

    //no interface, spoke with teacher about that, he agreed!
    private String id;
    private String title;
    private String description;
    private int duration; //in hours
    private String location;
    private int status = 0;
    private int salaryPerHour;
    private Person creator = null;
    private Person worker = null;


    //GETTER & SETTER
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSalary() {
        return salaryPerHour;
    }

    public void setSalary(int salary) {
        this.salaryPerHour = salary;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public Person getWorker() {
        return worker;
    }

    public void setWorker(Person worker) {
        this.worker = worker;
    }
}

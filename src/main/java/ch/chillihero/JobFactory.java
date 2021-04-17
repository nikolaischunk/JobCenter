package ch.chillihero;

public class JobFactory {

    public Job createJob(String type) {
        Job job = null;

        if (type.equalsIgnoreCase("housework")) {
            job = new Housework();
        } else if (type.equalsIgnoreCase("babysitting")) {
            job = new Babysitting();
        } else if (type.equalsIgnoreCase("gardenwork")) {
            job = new Gardenwork();
        } else if (type.equalsIgnoreCase("cleaning")) {
            job = new Cleaning();
        }
        return job;
    }

}

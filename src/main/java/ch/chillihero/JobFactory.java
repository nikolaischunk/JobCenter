package ch.chillihero;

public class JobFactory {

    public Job createJob(String type) {
        Job job = null;

        if (type.equals("housework")) {
            job = new Housework();
        } else if (type.equals("babysitting")) {
            job = new Babysitting();
        } else if (type.equals("gardenwork")) {
            job = new Gardenwork();
        } else if (type.equals("cleaning")) {
            job = new Cleaning();
        }
        return job;
    }

}

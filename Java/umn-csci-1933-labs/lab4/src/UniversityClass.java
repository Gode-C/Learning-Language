
public class UniversityClass {

    private String department;
    private String courseNumber;
    private String courseName;
    private int maxEnrollment;
    private int currentEnrollment;
    private Student classRoster[];
    private String[] waitlist = new String[6];
    private int waitlistnum = 0;
    private  String[] currentStudents= new String[7];


    public UniversityClass(String department, String courseNumber,
                                  String courseName, int maxEnrollment) {

        this.department = department;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.maxEnrollment = maxEnrollment;
        this.currentEnrollment = 0;
        classRoster = new Student[maxEnrollment];


    }
    public String toString(){
        String name = "";
        String waitlists = "";
        for (String n : currentStudents) {
            if(n != null)
            name = name +n+ "\n";}
        for (String n: waitlist){
            if(n!= null)
                waitlists = waitlists+n+"   ";}
        if (waitlistnum > 0) {
            return (courseName + " " + currentEnrollment + " " + maxEnrollment + "\nCurrent enrolled students.\n" +
                    name +
                    "Students on waitlist:\n"+
                    waitlists);}
        else{
            return (courseName + " " + currentEnrollment + " " + maxEnrollment + "\nCurrent enrolled students.\n" +
                    name);}}

//     Writing unit tests for addStudent would be intuitive!
//     Could also use exceptions
    public void addStudent (String name) throws ClassFullException {

         if (currentEnrollment < maxEnrollment) {
            classRoster[currentEnrollment] = new Student(name);
            currentEnrollment++;
            System.out.format("Added %s to the class.\n", name);
             currentStudents[currentEnrollment] = name;
        }
        else{
            throw new ClassFullException();
        }
    }
    public  void addStudentToWaitlist(String name){
        if (waitlistnum < 4) {

            waitlist[waitlistnum] = name;
            waitlistnum++;
            System.out.println("Added student "+name+" to the wait list");
        }
        else{

            System.out.println("Sorry, the class and the waitlist are full. "+name+" cannot be added.");
        }


    }

    public static void main (String[] args) {
        UniversityClass cs1933 = new UniversityClass("cs&e",
                "1933",
                "Data Structures and Abstraction",
                6);

        String[] names = {"Fred", "Cui", "Amir", "Ofebia", "Dianne", "Kevin", "Sarah", "Thomas", "Cliff",
                "Jonathan", "Elizabeth", "Gerrit", "Scooter", "StudentA"};

        for (String n: names) {

            try {cs1933.addStudent(n);}

            catch (ClassFullException e){
                cs1933.addStudentToWaitlist(n);
            }

        }

        System.out.println(cs1933);

    }

}

public class Patient{
    private String firstName, lastName, vaccineType, vaccineLocation, vaccineDate;
    private int ID;
    
    public Patient(int id, String lname, String fname, String vaccType, String vaccDate, String vaccLocation){
        this.ID = id;
        this.firstName = fname;
        this.lastName = lname;
        this.vaccineType = vaccType;
        this.vaccineDate = vaccDate;
        this.vaccineLocation = vaccLocation;
    }

    public int getID(){
        return ID;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getVaccineType(){
        return vaccineType;
    }

    public String getVaccineLocation(){
        return vaccineLocation;
    }

    public String getVaccineDate(){
        return vaccineDate;
    }

    public String toString(){
        return ""+ID+","+lastName+","+firstName+","+vaccineType+","+vaccineDate+","+vaccineLocation;
    }
}
package persons;

import java.util.ArrayList;

public abstract class Person {
    private int id;
    private String name;
    private String password;
    private String email;
    private int phone;
    private int status;
    private ArrayList<Holiday> holidays;
    private ArrayList<Holiday> requestsHolidays;
    private String attendance;
    private String leave;

    public Person() {

    }

    public Person(int id, String name, String password, String email, int phone, int status, ArrayList<Holiday> holidays, ArrayList<Holiday> requestsHolidays) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.holidays = holidays;
        this.requestsHolidays = requestsHolidays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(ArrayList<Holiday> holidays) {
        this.holidays = holidays;
    }

    public ArrayList<Holiday> getRequestsHolidays() {
        return requestsHolidays;
    }

    public void setRequestsHolidays(ArrayList<Holiday> requestsHolidays) {
        this.requestsHolidays = requestsHolidays;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getLeave() {
        return leave;
    }

    public void setLeave(String leave) {
        this.leave = leave;
    }

    public boolean isNumber(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public abstract void add(ArrayList<Person> persons);

    public abstract void update(ArrayList<Person> persons);

    public abstract void delete(ArrayList<Person> persons);

    public abstract void searchAbout(ArrayList<Person> persons);

    public abstract void reportAbout(ArrayList<Person> persons);

    public abstract void reportAboutAll(ArrayList<Person> persons);

    public void holiday(ArrayList<Person> mangers, ArrayList<Person> employees) {

    }

    public abstract void deactivateAndActivate(ArrayList<Person> persons);


    @Override
    public String toString() {
        return "id: " + id + " || Name: " + name + " || Email: " + email + " || Phone: " + phone + " || Status: " + status + " || Check in: " + attendance + " || Check out: " + leave;
    }

    public String printtofile() {
        return id + " " + name + " " + password + " " + email + " " + phone + " " + status + " " + attendance + " " + leave;
    }

    public String printholidaytofile() {
        String format = null;
        for (Holiday h : holidays) {
            format = id + " " + h.printtofile();

        }
        return format;
    }

}

package persons;

public class Holiday {
    private String name;
    private String reason;
    private String details;
    private String date;

    public Holiday() {
    }

    public Holiday(String name, String reason, String details, String date) {
        this.name = name;
        this.reason = reason;
        this.details = details;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return "Name: " + name + " || Reason: " + reason +" || Details: " + details+ " || Date: " + date;
    }
    public String printtofile() {
        return  name + " " +reason + " " + details + " " + date;
    }
}

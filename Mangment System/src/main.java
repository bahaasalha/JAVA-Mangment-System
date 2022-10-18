import persons.Employee;
import persons.Holiday;
import persons.Manger;
import persons.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    static int id = 120200;//id for admin
    static String username = "Bahaa Salha";//username for admin
    static String password = "123";//password for admin
    public static Scanner input = new Scanner(System.in);//Scanner for user to enter data

    public static ArrayList<Person> mangers = new ArrayList<>();//array for mangers
    public static ArrayList<Person> employees = new ArrayList<>();//array for employees


    public static void main(String[] args) {
        readFromFile();
        do {
            System.out.println(">>>>>>>>> Login Screen <<<<<<<<<\n" +
                    "1- Login as Admin\n" +
                    "2- Login as Manger\n" +
                    "3- Login as Employee\n" +
                    "4- about System\n" +
                    "5- Exit\n");

            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        adminIsLogin();
                        break;
                    case 2:
                        mangerIsLogin();
                        break;
                    case 3:
                        employeeIsLogin();
                        break;
                    case 4:
                        aboutSystem();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Enter right choice please !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Your selection can only be an integer!");
                input.nextLine();
            }
        } while (true);

    }


    public static void adminIsLogin() {
        System.out.println(">>>>>>>>> Welcome <<<<<<<<<");
        System.out.print("Enter id:");
        int idSc = input.nextInt();
        System.out.print("Enter Password:");
        String passwordSC = input.next();
        if (id == idSc && password.equals(passwordSC)) {


            boolean isTrue = true;
            while (isTrue) {
                readFromFile();
                Manger manger = new Manger();
                System.out.println(">>>>>>>>> Admin <<<<<<<<<\n" +
                        "1- Add Manger\n" +
                        "2- Update Manger\n" +
                        "3- Delete Manger\n" +
                        "4- Search about Manger\n" +
                        "5- Report about Manger\n" +
                        "6- Report about All  Manger\n" +
                        "7- Holiday requests\n" +
                        "8- Deactivate & Activate Manger\n" +
                        "9- Get Manger count and Employee count\n" +
                        "10- Exit\n");
                try {
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            manger.add(mangers);
                            writetofile();
                            readFromFile();
                            break;
                        case 2:
                            manger.update(mangers);
                            writetofile();
                            readFromFile();
                            break;
                        case 3:
                            manger.delete(mangers);
                            writetofile();
                            readFromFile();
                            break;
                        case 4:
                            manger.searchAbout(mangers);
                            break;
                        case 5:
                            manger.reportAbout(mangers);
                            break;
                        case 6:
                            manger.reportAboutAll(mangers);
                            break;
                        case 7:
                            manger.holiday(mangers, employees);
                            break;
                        case 8:
                            manger.deactivateAndActivate(mangers);
                            writetofile();
                            readFromFile();
                            break;
                        case 9:
                            System.out.println("- Manger Count:" + mangers.size() + "\n" +
                                    "- Employee Count:");
                            break;
                        case 10:
                            isTrue = false;
                            break;
                        default:
                            System.out.println("Enter right choice please !");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Your selection can only be an integer!");
                    input.nextLine();
                }
            }
        }


    }

    public static void mangerIsLogin() {
        boolean isTrue = true;
        Person me = new Employee();
        System.out.println(">>>>>>>>> Welcome <<<<<<<<<");
        System.out.print("Enter id:");
        int idSc = input.nextInt();
        System.out.print("Enter Password:");
        String passwordSC = input.next();
        for (Person e : mangers) {
            if (id == e.getId() && password.equals(e.getPassword())) {
                me = e;
                break;
            }
        }


        while (isTrue) {
            readFromFile();
            Employee employee = new Employee();
            System.out.println(">>>>>>>>> Admin <<<<<<<<<\n" +
                    "1- Add Employee\n" +
                    "2- Update Employee\n" +
                    "3- Delete Employee\n" +
                    "4- Search about Employee\n" +
                    "5- Report about Employee\n" +
                    "6- Report about All  Employee\n" +
                    "7- Deactivate & Activate Employee\n" +
                    "8- Promote an Employee to Manger \n" +
                    "9- Attendance \n" +
                    "10- Holiday \n" +
                    "11- Exit\n");
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        employee.add(employees);
                        writetofile();
                        readFromFile();
                        break;
                    case 2:
                        employee.update(employees);
                        writetofile();
                        readFromFile();
                        break;
                    case 3:
                        employee.delete(employees);
                        writetofile();
                        readFromFile();
                        break;
                    case 4:
                        employee.searchAbout(employees);
                        break;
                    case 5:
                        employee.reportAbout(employees);
                        break;
                    case 6:
                        employee.reportAboutAll(employees);
                        break;
                    case 7:
                        employee.deactivateAndActivate(employees);
                        writetofile();
                        readFromFile();
                        break;
                    case 8:
                        employee.PromoteanemployeetoManager(mangers, employees);
                        writetofile();
                        readFromFile();
                        break;
                    case 9:
                        employee.attendance(me, id);
                        break;

                    case 10:
                        employee.Holiday(me);
                        break;
                    case 11:
                        isTrue = false;
                        break;
                    default:
                        System.out.println("Enter right choice please !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Your selection can only be an integer!");
                input.nextLine();
            }

        }
    }

    public static void employeeIsLogin() {
        boolean isTrue = true;
        Person me = new Employee();
        System.out.println(">>>>>>>>> Welcome <<<<<<<<<");
        System.out.print("Enter id:");
        int idSc = input.nextInt();
        System.out.print("Enter Password:");
        String passwordSC = input.next();
        for (Person e : mangers) {
            if (id == e.getId() && password.equals(e.getPassword())) {
                me = e;
                break;
            }
        }


        while (isTrue) {
            Employee employee = new Employee();
            System.out.println(">>>>>>>>> Employee <<<<<<<<<\n" +
                    "1- Change Password\n" +
                    "2- Attendance \n" +
                    "3- Holiday \n" +
                    "4- Exit\n");
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        employee.ChangePassword(me);
                        break;
                    case 2:
                        employee.attendance(me, id);
                        break;

                    case 3:
                        employee.Holiday(me);
                        break;
                    case 4:
                        isTrue = false;
                        break;
                    default:
                        System.out.println("Enter right choice please !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Your selection can only be an integer!");
                input.nextLine();
            }

        }
    }

    public static void writetofile() {
        try {
            FileWriter mangerss = new FileWriter("manger.txt");
            PrintWriter pw = new PrintWriter(mangerss);
            FileWriter employeess = new FileWriter("employees.txt");
            PrintWriter em = new PrintWriter(employeess);
            FileWriter holiday = new FileWriter("holiday.txt");
            PrintWriter ho = new PrintWriter(holiday);
            for (Person m : mangers) {
                pw.println(m.printtofile());
                if (m.getHolidays()!=null){
                    for (Holiday h : m.getHolidays()) {
                        ho.println(m.printholidaytofile());
                    }
                }
            }
            for (Person e : employees) {
                em.println(e.printtofile());
                if (e.getHolidays()!=null){
                for (Holiday h : e.getHolidays()) {
                    ho.println(e.printholidaytofile());
                }
                }
            }
            mangerss.close();
            pw.close();
            employeess.close();
            em.close();
            holiday.close();
            ho.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void readFromFile() {
        ArrayList<Person> magersss = new ArrayList<>();
        ArrayList<Person> employeesss = new ArrayList<>();

        try {
            File mangerssFile = new File("manger.txt");
            Scanner mangerss = new Scanner(mangerssFile);
            File employeesFile = new File("employees.txt");
            Scanner employeess = new Scanner(employeesFile);
            File holidayFile = new File("holiday.txt");
            Scanner holidays = new Scanner(holidayFile);

            while (mangerss.hasNextLine()) {
                String[] manger;
                manger = mangerss.nextLine().split(" ");
                int id = Integer.parseInt(manger[0]);
                String name = manger[1];
                String password = manger[2];
                String email = manger[3];
                int phone = Integer.parseInt(manger[4]);
                int status = Integer.parseInt(manger[5]);
                ArrayList<Holiday> holidaysArray = null;
                while (holidays.hasNextLine()) {
                    holidaysArray = new ArrayList<>();
                    String[] holiday;
                    holiday = holidays.nextLine().split(" ");
                    String nameholiday = holiday[0];
                    if (name.equalsIgnoreCase(nameholiday)) {
                        String reason = holiday[1];
                        String details = holiday[2];
                        String date = holiday[3];
                        holidaysArray.add(new Holiday(nameholiday, reason, details, date));
                    }
                }
                magersss.add(new Manger(id, name, password, email, phone, status, holidaysArray, null));
            }
            while (employeess.hasNextLine()) {
                String[] employee;
                employee = mangerss.nextLine().split(" ");
                int id = Integer.parseInt(employee[0]);
                String name = employee[1];
                String password = employee[2];
                String email = employee[3];
                int phone = Integer.parseInt(employee[4]);
                int status = Integer.parseInt(employee[5]);
                int typeOfEmployees = Integer.parseInt(employee[6]);

                ArrayList<Holiday> holidaysArray = null;
                while (holidays.hasNextLine()) {
                    holidaysArray = new ArrayList<>();
                    String[] holiday;
                    holiday = holidays.nextLine().split(" ");
                    String nameholiday = holiday[0];
                    if (name.equalsIgnoreCase(nameholiday)) {
                        String reason = holiday[1];
                        String details = holiday[2];
                        String date = holiday[3];
                        holidaysArray.add(new Holiday(nameholiday, reason, details, date));
                    }
                }
                employeesss.add(new Employee(id, name, password, email, phone, status, holidaysArray, null, typeOfEmployees));
            }


            mangers = magersss;
            employees = employeesss;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static void aboutSystem() {
        System.out.println(">>>>> System information <<<<<\n" +
                "> Company Management System" +
                "> Developed by Bahaa Salha" +
                "> @2022-2023");
    }


}

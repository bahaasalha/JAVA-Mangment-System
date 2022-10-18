package persons;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee extends Person {
    private int typeOfEmployees;

    public Employee() {

    }

    public Employee(int id, String name, String password, String email, int phone, int status, ArrayList<Holiday> holidays, ArrayList<Holiday> requestsHolidays, int typeOfEmployees) {
        super(id, name, password, email, phone, status, holidays, requestsHolidays);
        this.typeOfEmployees = typeOfEmployees;
    }

    public int getTypeOfEmployees() {
        return typeOfEmployees;
    }

    public void setTypeOfEmployees(int typeOfEmployees) {
        this.typeOfEmployees = typeOfEmployees;
    }


    @Override
    public void add(ArrayList<Person> persons) {
        System.out.println(">>>>>>>>> Add Employee <<<<<<<<<");
        System.out.println("Enter id : ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Enter name : ");
        String name = new Scanner(System.in).next();
        System.out.println("Enter password : ");
        String password = new Scanner(System.in).next();
        System.out.println("Enter email : ");
        String email = new Scanner(System.in).next();
        System.out.println("Enter phone number : ");
        int phone = new Scanner(System.in).nextInt();
        System.out.println("type Of Employees (1) <Full-time> or (2) <part-time> ");
        int typeOfEmployees = new Scanner(System.in).nextInt();
        System.out.println("Enter status : ");
        int status = new Scanner(System.in).nextInt();
        System.out.println("The manger has been successfully added.");
        persons.add(new Employee(id, name, password, email, phone, status, null, null, typeOfEmployees));
    }

    @Override
    public void update(ArrayList<Person> persons) {
        boolean success = false;
        System.out.println(">>>>>>>>> Update Employee <<<<<<<<<");
        System.out.println("Enter id : ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("new password : ");
        String password = new Scanner(System.in).next();

        for (Person e : persons) {
            if (e.getId() == id) {
                e.setPassword(password);
                success = true;
            }
        }
        if (success) {
            System.out.println("The Employee data was successfully update.");
        } else {
            System.out.println("This Employee was not exists or id not right");
        }
    }
    public void ChangePassword(Person persons) {
        boolean success = false;
        System.out.println(">>>>>>>>> Change Password <<<<<<<<<");
        System.out.println("Enter new password : ");
        String password = new Scanner(System.in).next();


        persons.setPassword(password);
                success = true;

    }

    @Override
    public void delete(ArrayList<Person> persons) {
        boolean success = false;
        System.out.println(">>>>>>>>> Delete Employee <<<<<<<<<");
        System.out.println("Enter id : ");
        int id = new Scanner(System.in).nextInt();

        for (Person e : persons) {
            if (e.getId() == id) {
                persons.remove(e);
                success = true;
            }
        }
        if (success) {
            System.out.println("The Employee has been successfully deleted.");
        } else {
            System.out.println("This Employee was not exists or id not right");
        }
    }

    @Override
    public void searchAbout(ArrayList<Person> persons) {
        boolean success = false;
        System.out.println(">>>>>>>>> Search About Employee <<<<<<<<<");
        System.out.println("Enter id : ");
        int id = new Scanner(System.in).nextInt();

        for (Person e : persons) {
            if (e.getId() == id) {
                System.out.println("Name: " + e.getName() + " || Status: " + e.getStatus());
                success = true;
            }
        }
        if (success == false) {
            System.out.println("This Employee was not exists or id not right");
        }
    }

    @Override
    public void reportAbout(ArrayList<Person> persons) {
        boolean success = false;
        System.out.println(">>>>>>>>> Report about Employee <<<<<<<<<");
        System.out.println("Enter id or name : ");
        String input = new Scanner(System.in).next();
        if (isNumber(input)) {
            int id = Integer.parseInt(input);
            for (Person e : persons) {
                if (e.getId() == id) {
                    System.out.println(e.toString());
                    success = true;
                }
            }
        } else {
            for (Person e : persons) {
                if (e.getName().equals(input)) {
                    System.out.println(e.toString());
                    success = true;
                }
            }
        }
        if (success == false) {
            System.out.println("This Employee was not exists or id/name not right");
        }
    }

    @Override
    public void reportAboutAll(ArrayList<Person> persons) {
        System.out.println(">>>>>>>>> Report about All Employee <<<<<<<<<");
        for (Person m : persons) {
            System.out.println(m.toString());
        }
    }


    @Override
    public void deactivateAndActivate(ArrayList<Person> persons) {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println(">>>>>>>>>  Deactivate & Activate Manager: <<<<<<<<<\n"
                    + "1- Activate.\n"
                    + "2- Deactivate.\n"
                    + "3- Exit.\n"
            );
            int input = new Scanner(System.in).nextInt();
            try {
                switch (input) {
                    case 1:
                        activateORDeactivate(persons, 1);
                        break;
                    case 2:
                        activateORDeactivate(persons, 0);
                        break;
                    case 3:
                        isTrue = false;
                        break;
                    default:
                        System.out.println("Enter right choice please !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Your selection can only be an integer!");

            }
        }
    }


    public void PromoteanemployeetoManager(ArrayList<Person> mangers, ArrayList<Person> employees) {
        boolean success = false;
        System.out.println(">>>>> Promote an employee to Manager <<<<<");
        System.out.println("Enter id : ");
        int id = new Scanner(System.in).nextInt();
        for (Person e : employees) {
            if (e.getId() == id) {
                Manger manger = new Manger(e.getId(), e.getName(), e.getPassword(), e.getEmail(), e.getPhone(), e.getStatus(), e.getHolidays(), e.getRequestsHolidays());

                employees.remove(e);
                mangers.add(manger);
                success = true;
            }
        }


        if (success == false) {
            System.out.println("This Employee was not exists or id not right");
        }
    }


    public void activateORDeactivate(ArrayList<Person> persons, int status) {
        boolean success = false;
        if (status == 1) {
            System.out.println(">>>>>>>>> Activate Employee <<<<<<<<<");

        } else {
            System.out.println(">>>>>>>>> Deactivate Employee <<<<<<<<<");

        }
        System.out.println("Enter id : ");
        int id = new Scanner(System.in).nextInt();

        for (Person m : persons) {
            if (m.getId() == id) {
                m.setStatus(status);
                success = true;
            }
        }
        if (success == false) {
            System.out.println("This manger was not exists or id not right");
        }
    }

    public void attendance(Person person, int id) {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println(">>>>>>>>>  Deactivate & Activate Manager: <<<<<<<<<\n"
                    + "1- Time of attendance.\n"
                    + "2- Time of leave.\n"
                    + "3- Exit.\n"
            );
            int input = new Scanner(System.in).nextInt();
            try {
                switch (input) {
                    case 1:
                        System.out.println(">>>>>>>>> Time of attendance <<<<<<<<<\n" +
                                "Enter the time");
                        String attendance = new Scanner(System.in).next();
                        person.setAttendance(attendance);
                        break;
                    case 2:
                        System.out.println(">>>>>>>>> Time of Leave <<<<<<<<<\n" +
                                "Enter the Leave");
                        String Leave = new Scanner(System.in).next();
                        person.setLeave(Leave);
                        break;
                    case 3:
                        isTrue = false;
                        break;
                    default:
                        System.out.println("Enter right choice please !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Your selection can only be an integer!");

            }
        }
    }

    public void Holiday(Person employee){
        boolean isTrue = true;
        while (isTrue) {
            System.out.println(">>>>>>>>> Holiday <<<<<<<<<\n"
                    + "1- My Holiday.\n"
                    + "2- Crate Holiday.\n"
                    + "3- Exit.\n"
            );
            int input = new Scanner(System.in).nextInt();
            try {
                switch (input) {
                    case 1:
                        System.out.println(">>>>>>>>> My Holiday <<<<<<<<<\n" );
                        for (Holiday holiday : employee.getHolidays()) {
                            System.out.println("Id: " + employee.getId() + " || " + holiday.toString());
                        }
                        break;
                    case 2:
                        System.out.println(">>>>>>>>> Crate Holiday <<<<<<<<<\n");
                        System.out.println("Enter name : ");
                        String name = new Scanner(System.in).next();
                        System.out.println("Enter Reason : ");
                        String Reason = new Scanner(System.in).next();
                        System.out.println("Enter Details : ");
                        String details = new Scanner(System.in).next();
                        System.out.println("Enter Date : ");
                        String date = new Scanner(System.in).next();
                        employee.getRequestsHolidays().add(new Holiday(name ,Reason,details,date));
                        break;
                    case 3:
                        isTrue = false;
                        break;
                    default:
                        System.out.println("Enter right choice please !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Your selection can only be an integer!");

            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public String printtofile() {
        return super.printtofile()+" "+typeOfEmployees;
    }
}

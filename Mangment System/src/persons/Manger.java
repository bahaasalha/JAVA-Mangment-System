package persons;

import java.util.*;

public class Manger extends Person {


    public Manger() {
    }

    public Manger(int id, String name, String password, String email, int phone, int status, ArrayList<Holiday> holidays, ArrayList<Holiday> requestsHolidays) {
        super(id, name, password, email, phone, status, holidays, requestsHolidays);
    }

    @Override
    public void add(ArrayList<Person> persons) {
        System.out.println(">>>>>>>>> Add Manger <<<<<<<<<");
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
        System.out.println("Enter status : ");
        int status = new Scanner(System.in).nextInt();
        System.out.println("The manger has been successfully added.");
        persons.add(new Manger(id, name, password, email, phone, status, null, null));
    }


    @Override
    public void update(ArrayList<Person> persons) {
        boolean success = false;
        System.out.println(">>>>>>>>> Update Manager <<<<<<<<<");
        System.out.println("Enter id : ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("new password : ");
        String password = new Scanner(System.in).next();

        for (Person m : persons) {
            if (m.getId() == id) {
                m.setPassword(password);
                success = true;
            }
        }
        if (success) {
            System.out.println("The manger's data was successfully update.");
        } else {
            System.out.println("This manger was not exists or id not right");
        }

    }

    @Override
    public void delete(ArrayList<Person> persons) {
        boolean success = false;
        System.out.println(">>>>>>>>> Delete Manager <<<<<<<<<");
        System.out.println("Enter id : ");
        int id = new Scanner(System.in).nextInt();

        for (Person m : persons) {
            if (m.getId() == id) {
                persons.remove(m);
                success = true;
            }
        }
        if (success) {
            System.out.println("The manger has been successfully deleted.");
        } else {
            System.out.println("This manger was not exists or id not right");
        }

    }

    @Override
    public void searchAbout(ArrayList<Person> persons) {
        boolean success = false;
        System.out.println(">>>>>>>>> Search About Manger <<<<<<<<<");
        System.out.println("Enter id : ");
        int id = new Scanner(System.in).nextInt();

        for (Person m : persons) {
            if (m.getId() == id) {
                System.out.println("Name: " + m.getName() + " || Status: " + m.getStatus());
                success = true;
            }
        }
        if (success == false) {
            System.out.println("This manger was not exists or id not right");
        }
    }

    @Override
    public void reportAbout(ArrayList<Person> persons) {
        boolean success = false;
        System.out.println(">>>>>>>>> Report about Manger <<<<<<<<<");
        System.out.println("Enter id or name : ");
        String input = new Scanner(System.in).next();
        if (isNumber(input)) {
            int id = Integer.parseInt(input);
            for (Person m : persons) {
                if (m.getId() == id) {
                    System.out.println(m.toString());
                    success = true;
                }
            }
        } else {
            for (Person m : persons) {
                if (m.getName().equals(input)) {
                    System.out.println(m.toString());
                    success = true;
                }
            }
        }
        if (success == false) {
            System.out.println("This manger was not exists or id/name not right");
        }
    }

    @Override
    public void reportAboutAll(ArrayList<Person> persons) {

        System.out.println(">>>>>>>>> Report about All Manger <<<<<<<<<");
        for (Person m : persons) {
            System.out.println(m.toString());
        }
    }

    @Override
    public void holiday(ArrayList<Person> mangers, ArrayList<Person> employees) {
        boolean success = false;
        boolean success1 = false;
        System.out.println(">>>>>>>>> Holiday requests <<<<<<<<<\n"
                + "1- View Holiday requests.\n"
                + "2- Accept the holiday. "
                + "3- Rejected the holiday. "
        );
        int input = new Scanner(System.in).nextInt();
        try {
            switch (input) {
                case 1:
                    System.out.println(">>>>>>>>> View Holiday requests <<<<<<<<<");
                    for (Person manger : mangers) {
                        for (Holiday holiday : manger.getHolidays()) {
                            System.out.println("Id: " + manger.getId() + " || " + holiday.toString());
                        }
                    }
                    for (Person employee : employees) {
                        for (Holiday holiday : employee.getHolidays()) {
                            System.out.println("Id: " + employee.getId() + " || " + holiday.toString());
                        }
                    }
                    break;
                case 2:
                    System.out.println(">>>>>>>>> Accept the Holiday  <<<<<<<<<");
                    System.out.println("Enter id : ");
                    int id = new Scanner(System.in).nextInt();

                    for (Person m : mangers) {
                        if (m.getId() == id) {
                            while (!m.getRequestsHolidays().isEmpty()) {
                                m.getHolidays().add(m.getRequestsHolidays().remove(0));

                                success = true;
                                success1 = true;
                            }
                        }
                    }
                    if (success != true) {
                        for (Person e : employees) {
                            if (e.getId() == id) {
                                while (!e.getRequestsHolidays().isEmpty()) {
                                    e.getHolidays().add(e.getRequestsHolidays().remove(0));

                                    success1 = true;
                                }
                            }
                        }
                    }

                    if (success1 == true) {
                        System.out.println("Approved successfully.");
                    } else {
                        System.out.println("This manger was not exists or id not right");

                    }

                    break;
                case 3:
                    System.out.println(">>>>>>>>> Rejected the Holiday <<<<<<<<<");
                    System.out.println("Enter id : ");
                    int id1 = new Scanner(System.in).nextInt();

                    for (Person m : mangers) {
                        if (m.getId() == id1) {
                            while (!m.getRequestsHolidays().isEmpty()) {
                                m.getRequestsHolidays().remove(0);

                                success = true;
                                success1 = true;
                            }
                        }
                    }
                    if (success != true) {
                        for (Person e : employees) {
                            if (e.getId() == id1) {
                                while (!e.getRequestsHolidays().isEmpty()) {
                                    e.getRequestsHolidays().remove(0);

                                    success1 = true;
                                }
                            }
                        }
                    }

                    if (success1 == true) {
                        System.out.println("Approved successfully.");
                    } else {
                        System.out.println("This manger was not exists or id not right");

                    }
                    break;

                default:
                    System.out.println("Enter right choice please !");
            }
        } catch (InputMismatchException e) {
            System.out.println("Your selection can only be an integer!");

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


    public void activateORDeactivate(ArrayList<Person> persons, int status) {
        boolean success = false;
        if (status == 1) {
            System.out.println(">>>>>>>>> Activate Manager <<<<<<<<<");

        }else {
            System.out.println(">>>>>>>>> Deactivate Manager <<<<<<<<<");

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



    @Override
    public String toString() {
        return super.toString();
    }


}

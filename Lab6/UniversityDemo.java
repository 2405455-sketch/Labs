class University {
    String universityName;
    String location;

    University(String name, String loc) {
        universityName = name;
        location = loc;
    }

    class Department {
        String deptName;
        String hodName;

        Department(String dept, String hod) {
            deptName = dept;
            hodName = hod;
        }

        void display() {
            System.out.println("University: " + universityName);
            System.out.println("Location: " + location);
            System.out.println("Department: " + deptName);
            System.out.println("HOD: " + hodName);
        }
    }

    void createDepartment() {
        Department d = new Department("CSE", "Dr. Sharma");
        d.display();
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        University u = new University("KIIT", "Bhubaneswar");
        u.createDepartment();
    }
}



class Person{

    String name;
    String nic;
    int age;

    Person(String name, String nic, int age){
        this.name = name;
        this.nic = nic;
        this.age = age;
    }
}

class Student extends Person{

    double gpa1;
    double gpa2;
    double gpa3;
    double gpa4;
    double finalGpa;

    Student(String name, String nic, int age, double gpa1, double gpa2, double gpa3, double gpa4){
        super(name, nic, age);
        this.gpa1 = gpa1;
        this.gpa2 = gpa2;
        this.gpa3 = gpa3;
        this.gpa4 = gpa4;
    }

    public double calculateFinalGpa(){
        double totalOfTheGpa = gpa1 + gpa2 + gpa3 + gpa4;
        return totalOfTheGpa/4;
    }

    public void getFinalResult(){
        if(calculateFinalGpa() >= 3.7){
            System.out.println("First Class");
        }else if(calculateFinalGpa() >= 3.3){
            System.out.println("Second Class");
        }else if(calculateFinalGpa() >= 3.0){
            System.out.println("Third Class");
        }else {
            System.out.println("Pass.");
        }
    }
}

abstract class StaffMember extends Person{

    final double COLA = 7800.00;
    double basicSalary;
    double lonInstallment;

    StaffMember(String name, String nic, int age,double basicSalary, double lonInstallment){
        super(name, nic, age);
        this.basicSalary = basicSalary;
        this.lonInstallment = lonInstallment;
    }

    abstract double getSalary();

}

class AcademicStaff extends StaffMember{

    final double ACADEMIC_ALLOWANCE = 25.00;

    AcademicStaff(String name, String nic, int age, double basicSalary, double lonInstallment){
        super(name, nic, age, basicSalary, lonInstallment);
    }

    public double getSalary(){
        double salary = (basicSalary + COLA + (basicSalary/100)*ACADEMIC_ALLOWANCE)-lonInstallment;
        return salary;
    }
}

class NonAcademicStaff extends StaffMember{

    double overTimeHours;
    double overTimePayment;

    NonAcademicStaff(String name,String nic, int age, double basicSalary, double lonInstallment, double overTimeHours){
        super(name, nic, age, basicSalary, lonInstallment);
        this.overTimeHours = overTimeHours;
    }

    public double overTimeAmount(){
        double overTimePayment = (basicSalary/(20*8))*overTimeHours;
        return overTimePayment;
    }


    public double getSalary() {
        this.overTimePayment = overTimeAmount();
        return (basicSalary + COLA + overTimePayment) - lonInstallment;
    }

}




public class Main {
    public static void main(String[] args) {
        /*
        Student student = new Student("Yashen Fernando","200209403870",22,3.9,3.9,3.8,3.7);

        double gpa = student.calculateFinalGpa();
        System.out.println("Final GPA : "+gpa);

        student.getFinalResult();

        */

        AcademicStaff academicStaff = new AcademicStaff("Mr.Perera","7054388V",46,150000,20000);
        double salary = academicStaff.getSalary();
        System.out.println("Salary (LKR) "+salary);
        
        NonAcademicStaff nonAcademicStaff = new NonAcademicStaff("Mr.silva", "682244337V", 50, 75000,6000,10);
        double salary1 = nonAcademicStaff.getSalary();
        System.out.println("Salary (LKR) "+salary1);


    }
}
package Lab3Ex;

import  java.util.Scanner;

class Pet {
    public String name = "Unknown";
    public int age;

    public Pet(){};

    public Pet(Pet other){
        this.name = other.name;
        this.age = other.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }   
}

public class ExPet {
    public static void main(String[] args) {
        Pet myPet = new Pet();
        myPet.setName("Fido");
        myPet.setAge(3);

        Pet petCopy = new Pet(myPet);
        System.out.println("My pet is called " + myPet.name + " and is " + myPet.age + " years old.");
        System.out.println("My pet copy is called " + petCopy.name + " and is " + petCopy.age + " years old.");

        System.out.println("Original Pet Hashcode: " + myPet.hashCode());
        System.out.println("Copy Pet Hashcode: " + petCopy.hashCode());

        Pet Pet2 = new Pet();
        Pet2.setName("Rex");
        Pet2.setAge(5);
        System.out.println("Your pet is called " + Pet2.name + " and is " + Pet2.age + " years old.");

        Pet Pet3 = new Pet();
        Pet3.setName("Spot");
        Pet3.setAge(2);
        System.out.println("My pet is called " + Pet3.name + " and is " + Pet3.age + " years old.");

        Pet Pet4 = new Pet();
        System.out.println("Your pet is called " + Pet4.name + " and is " + Pet4.age + " years old.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of your pet: ");
        String petName = scanner.nextLine();
        System.out.println("Enter the age of your pet: ");
        int petAge = scanner.nextInt();

        Pet newPet = new Pet();
        newPet.name = petName;
        newPet.age = petAge;
        System.out.println("Your pet is called " + newPet.name + " and is " + newPet.age + " years old.");
        
        scanner.close();
    }
}
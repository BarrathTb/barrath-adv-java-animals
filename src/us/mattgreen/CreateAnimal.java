package us.mattgreen;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateAnimal implements Talkable, AnimalCreator {

    public void addNewAnimal(ArrayList<Talkable> zoo) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Create an Animal! Please choose from the list below to create a new animal");
        System.out.println("1. Cat\n2. Dog\n3. Teacher");

        // Try-catch block to handle invalid input
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                int selection = Integer.parseInt(sc.nextLine());

                // Call method based on user's selection
                switch (selection) {
                    case 1 -> zoo.add(createCat(sc));
                    case 2 -> zoo.add(createDog(sc));
                    case 3 -> zoo.add(createTeacher(sc));
                    default -> System.out.println("Invalid selection. Please try again.");
                }

                invalidInput = false;
            } catch (NumberFormatException e) {
                System.out.println("Please select a Number from the list:");
            }
        }
    }

    private Cat createCat(Scanner input) {
        System.out.println("What is the cat's name? ");
        String catName = input.nextLine();

        // Loop to validate input for number of mice killed
        boolean invalidInput = true;
        int mousesKilled = 0;

        while (invalidInput) {
            System.out.println("How many mice has this cat killed? ");
            try {
                mousesKilled = Integer.parseInt(input.nextLine());
                invalidInput = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number for mice killed by cat");
            }
        }

        return new Cat(mousesKilled, catName);
    }

    private Dog createDog(Scanner input) {
        System.out.println("What is the dog's name? ");
        String dogName = input.nextLine();

        // Loop to validate input for whether dog is friendly or not
        boolean invalidInput = true;
        int friendlySelection = 0;

        while (invalidInput) {
            System.out.println("Is the dog friendly?\nEnter 1 for yes or 2 for no ");

            try {
                friendlySelection = Integer.parseInt(input.nextLine());

                // check if user input is either 1 or 2
                if (friendlySelection == 1 || friendlySelection == 2) {
                    invalidInput = false;
                } else {
                    System.out.println("Please enter either 1 or 2 to select");    // invalid input
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number to select");    // invalid input
            }
        }

        boolean isFriendly = (friendlySelection == 1);
        return new Dog(isFriendly, dogName);
    }

    private Teacher createTeacher(Scanner input) {
        System.out.println("What is this teacher's name?");
        String personName = input.nextLine();

        // Loop to validate input for teacher's age
        boolean invalidInput = true;
        int age = 0;

        while (invalidInput) {
            System.out.println("What is this teacher's age?");
            try {
                age = Integer.parseInt(input.nextLine());  // read age input
                invalidInput = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number for teacher's age: ");
            }
        }

        return new Teacher(age, personName);
    }

    @Override
    public String talk() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Talkable createAnimal(Scanner input) {

        ArrayList<Talkable> animals = new ArrayList<>();
        addNewAnimal(animals);
        return animals.get(animals.size() - 1);
    }
}
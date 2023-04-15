package us.mattgreen;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private final static FileOutput outFile = new FileOutput("animals.txt");
    private final static FileInput inFile = new FileInput("animals.txt");

    public static void main(String[] args) {
        ArrayList<Talkable> zoo = new ArrayList<>();


        AnimalCreator animalCreator = new CreateAnimal();

        // Add new animals using createAnimal() method
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Press Enter if you would like to add an animal to the Zoo!, or 'exit' to quit: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            Talkable newAnimal = animalCreator.createAnimal(scanner);
            if (newAnimal != null) {
                zoo.add(newAnimal);
            }
        }

        for (Talkable thing : zoo) {
            printOut(thing);
        }
        outFile.fileClose();
        inFile.fileRead();
        inFile.fileClose();

        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    public static void printOut(Talkable p) {
        System.out.println(p.getName() + " says=" + p.talk());
        outFile.fileWrite(p.getName() + " | " + p.talk());
    }
}
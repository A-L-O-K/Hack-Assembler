import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Filter { // main extends filter so it can access all the functions in filter class

    private static ArrayList<String> lines = new ArrayList<String>(); // ArrayList with all lines as each element

    public static void main(String[] args) {

        // making class object of all required classes...

        A_Instruction ain = new A_Instruction();
        C_Instruction cin = new C_Instruction();

        // -------------------- Storing each line in an ArrayList
        try {
            File myObj = new File("Editor.asm"); // creating file object
            Scanner myReader = new Scanner(myObj); // creating reader object

            while (myReader.hasNextLine()) { // loop to get all data in the file

                String data = myReader.nextLine();
                lines.add(data);
            }

            myReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        // -------------------- Filtering unwanted things in the lines with Filter class

        lines = Unifier(lines);

        // --------------------- ArrayList lines have all the filtered code lines

        //
        //
        //

        // --------------------- classifying into instructions

        String finalBinaryOut = "";

        for (String e : lines) {

            if (e.charAt(0) == '@') { // if the instruction starts with '@', it is an a-instruction
                finalBinaryOut += ain.classifier(e) + "\n";

            }

            else if (e.charAt(0) == '(') { // if the instruction starts with '(', it is deceleration of a label
                ain.labelAdder(e, lines.indexOf(e));

            }

            else { // if the doesn't start with any of the above, it is a c-instruction
                finalBinaryOut += cin.Converter(e) + "\n";

            }
        }

        // ---------------------------- writing the binary output to a text file

        try {
            File file = new File("BinaryOut.hack");
            FileOutputStream fileWriter = new FileOutputStream(file);

            PrintWriter writer = new PrintWriter(fileWriter);

            writer.println(finalBinaryOut);
            writer.close();

            System.out.println("Process Completed !");
        }

        catch (FileNotFoundException e) {
            System.out.println("File Not Found !");
        }

    }

}

import java.util.ArrayList;
import java.util.HashMap;

class A_Instruction { // a line is sent here from Main if it is an A Instruction

    private ArrayList<String> Variables = new ArrayList<String>();
    // private ArrayList<String> Labels = new ArrayList<String>();
    private HashMap<String, Integer> Labels = new HashMap<String, Integer>();

    private HashMap<String, String> symbols = new HashMap<String, String>();

    protected A_Instruction() {

        for (int i = 0; i <= 15; i++) {
            symbols.put("R" + i, ifNum(i));
        }
        symbols.put("SCREEN", ifNum(16384));
        symbols.put("KBD", ifNum(24576));
        symbols.put("SP", ifNum(0));
        symbols.put("LCL", ifNum(1));
        symbols.put("ARG", ifNum(2));
        symbols.put("THIS", ifNum(3));
        symbols.put("THAT", ifNum(4));

        // System.out.println(symbols);
    }

    protected String classifier(String data) { // removes the '@' symbol and classify the instruction to below
                                               // categories

        data = data.substring(1); // removing '@' symbol
        String binary = ""; // String where the final binary is added and returned

        try { // try part for numbers
            binary = ifNum(Integer.parseInt(data)); // binary contains 16 bit binary of any number
        }

        catch (NumberFormatException e) { // catch part for variables and labels

            if (symbols.containsKey(data)) {
                binary = symbols.get(data);
            }

            else if (Labels.containsKey(data)) {
                binary = ifNum(Labels.get(data));
            }

            else {
                binary = ifVar(data);

            }

        }

        return binary; // returns the finial binary of corresponding A Instruction

    }

    protected void labelAdder(String data, int index) { // adding all labels in the ArrayList Labels

        data = data.substring(1, data.length() - 1);
        Labels.put(data, index);
    }

    private String ifNum(int data) { // if instruction is a number, this method is invoked

        String bin = Integer.toBinaryString(data);

        while (bin.length() < 16) // loop to convert binary to 16 bit
            bin = "0" + bin;

        return bin;
    }

    private String ifVar(String data) { // if instruction is a variable, this method is invoked

        if (!Variables.contains(data)) { // adding unique values to variable ArrayList
            Variables.add(data);
        }

        int decimalIndex = 16 + Variables.indexOf(data); // assigns value of first variable as 16 and
                                                         // continues...
        return ifNum(decimalIndex); // converting it to binary
    }

}

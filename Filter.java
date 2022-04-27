import java.util.ArrayList;

public class Filter {

    public static ArrayList<String> Unifier(ArrayList<String> arr) { // Classify the data to below categories

        ArrayList<String> filteredLines = new ArrayList<String>();

        int lengthArr = arr.size();

        for (int i = 0; i < lengthArr; i++) { // gets the lines in editor

            String whiteSpaceResult = whiteSpace(arr.get(i));

            if (whiteSpaceResult.length() > 0) {
                filteredLines.add(whiteSpaceResult); // add all the filtered line to the array
            }
        }

        return filteredLines; // returns the filtered list
    }

    protected static String whiteSpace(String data) { // removes white space and comments

        data = data.replaceAll("\\s", ""); // removes white spaces every where

        // removing comments
        if ((data.length() == 0) || (data.charAt(1) == '/')) { // if empty line or full line comment
            data = "";
        }

        else { // for comments which is along with asm code

            String[] comments = data.split("//");
            data = comments[0]; // first element will be the code and others will be comments
        }

        return data; // returning the filtered line
    }
}

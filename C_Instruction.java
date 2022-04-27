import java.util.HashMap;

class C_Instruction { // a line is sent here from Main if it is an C Instruction

    // HashMaps for all C-Instructions
    private HashMap<String, String> comp = new HashMap<String, String>();
    private HashMap<String, String> dest = new HashMap<String, String>();
    private HashMap<String, String> jmp = new HashMap<String, String>();

    protected C_Instruction() { // Constructor

        // binary of comp (a+comp)
        comp.put("0", "0101010");
        comp.put("1", "0111111");
        comp.put("-1", "0111010");
        comp.put("D", "0001100");
        comp.put("A", "0110000");
        comp.put("M", "1110000");
        comp.put("!D", "0001101");
        comp.put("!A", "0110001");
        comp.put("!M", "1110001");
        comp.put("-D", "0001111");
        comp.put("-A", "0110011");
        comp.put("-M", "1110011");
        comp.put("D+1", "0011111");
        comp.put("A+1", "0110111");
        comp.put("M+1", "1110111");
        comp.put("D-1", "0001110");
        comp.put("A-1", "0110010");
        comp.put("M-1", "1110010");
        comp.put("D+A", "0000010");
        comp.put("A+D", "0000010");
        comp.put("D+M", "1000010");
        comp.put("M+D", "1000010");
        comp.put("D-A", "0010011");
        comp.put("D-M", "1010011");
        comp.put("A-D", "0000111");
        comp.put("M-D", "1000111");
        comp.put("D&A", "0000000");
        comp.put("A&D", "0000000");
        comp.put("D&M", "1000000");
        comp.put("M&D", "1000000");
        comp.put("D|A", "0010101");
        comp.put("A|D", "0010101");
        comp.put("D|M", "1010101");
        comp.put("M|D", "1010101");

        // binary of dest (dest)
        dest.put("null", "000");
        dest.put("M", "001");
        dest.put("D", "010");
        dest.put("MD", "011");
        dest.put("A", "100");
        dest.put("AM", "101");
        dest.put("AD", "110");
        dest.put("AMD", "111");

        // binary of jmp (jmp)
        jmp.put("null", "000");
        jmp.put("JGT", "001");
        jmp.put("JEQ", "010");
        jmp.put("JGE", "011");
        jmp.put("JLT", "100");
        jmp.put("JNE", "101");
        jmp.put("JLE", "110");
        jmp.put("JMP", "111");

    }

    protected String Converter(String data) {

        C_Instruction cin = new C_Instruction();

        String COMP, DEST, JMP;

        String[] lis = data.split(";");

        if (lis.length == 1)
            JMP = cin.jmp.get("null");

        else {
            COMP = cin.comp.get(lis[0]);
            JMP = cin.jmp.get(lis[1]);

            // System.out.println(COMP);
        }

        String[] lis2 = lis[0].split("=");

        if (lis2.length == 1) {

            COMP = cin.comp.get(lis2[0]);
            DEST = cin.dest.get("null");
            // System.out.println(COMP);
        }

        else {
            DEST = cin.dest.get(lis2[0]);
            COMP = cin.comp.get(lis2[1]);
            // System.out.println(COMP);
        }

        return ("111" + COMP + DEST + JMP);

    }

}

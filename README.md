# Hack-Assembler
Hack assembler is a program that converts hack assembly code to hack binary code


********************************************************************************

This program has,
	
	* 4 .java files(and their .class files)
	* 1 .asm file
	* 1 .hack file


To convert an assembly code to binary code,
	
	* Write the assembly code in Editor.asm file
	* Run the Main.java file
	* The binary code (hack binary) is saved to BinaryOut.hack file


*******************************  About the Code  *******************************

* Main.java
	* The files Editor.asm & BinaryOut.asm are opened in this class
	* It inherits the filtering method from filter.java
	* The lines from Editor.asm are saved into ArrayList and filtered using the filter class
	* If a line is A-Instruction, it is passed to A_Instruction.java
	* If a line is C-Instruction, it is passed to C_Instruction.java
	* The ouput binary is returned to this class and is stored in BinaryOut.asm

* Filter.java
	* Filters the ArrayList passes into it by removing whitespaces and comments
	* Returns the filtered ArrayList to Main.java

* A_Instruction.java
	* Finds the curresponding binary value of A-instruction passes to it
	* Returns the binary to Main.java

* C_Instruction.java
	* Finds the curresponding binary value of C-instruction passes to it
	* Returns the binary to Main.java


*********************************************************************************

- Alok


	

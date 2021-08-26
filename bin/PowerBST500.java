import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;

public class PowerBST500 {

    public static void main(String[] args) throws IOException {
        //Get scanner
        Scanner input = new Scanner(new File("cleaned_data(sorted).csv"));
        input.nextLine();
        input.useDelimiter(",");

        //Implement Inserts File FileWriter
        BufferedWriter insertsWriter = new BufferedWriter(new FileWriter("insertBSTCounts500.txt"));

        String date = "";
        String global ="";
        String voltage = "";

        //Set root node in tree
        BinaryNode root = new BinaryNode();
        BinarySearchTree tree = new BinarySearchTree();
        date = input.next();
        global = input.next();
        input.next();
        voltage =input.next();
        tree.insert(date, global, voltage);
        input.nextLine();

        //Add data to tree
        BinaryNode current = new BinaryNode();
        while(input.hasNextLine()) {
          date = input.next();
          global = input.next();
          input.next();
          voltage = input.next();
          tree.insert(date, global, voltage);
          input.nextLine();
        }
        insertsWriter.write(tree.insertCount+"\n");

        try {
            if (args.length == 1) {
                tree.printDateTime(args[0]);
                System.out.println("The operation count was "+(tree.insertCount+tree.count)+". The find Operation count was: "+tree.count+". And the insert operation count was: "+tree.insertCount);
                tree.count = 0;
            }else {
                tree.printAllDateTimes();
                System.out.println("The number of operations used was: " + tree.count);
                tree.count = 0;
            }
        }catch (ArrayIndexOutOfBoundsException e) {

        }
        input.close();
        insertsWriter.close();
        }
}

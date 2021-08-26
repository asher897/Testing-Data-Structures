import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;

public class PowerBSTApp {

    public static void main(String[] args) throws IOException {
        //Get scanner
        Scanner input = new Scanner(new File("cleaned_data.csv"));
        input.nextLine();
        input.useDelimiter(",");

        //Implement Inserts File FileWriter
        BufferedWriter insertsWriter = new BufferedWriter(new FileWriter("insertBSTCounts.txt"));

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
        insertsWriter.write(tree.insertCount+"\n");

        //Add data to tree
        BinaryNode current = new BinaryNode();
        while(input.hasNextLine()) {
          date = input.next();
          global = input.next();
          input.next();
          voltage = input.next();
          tree.insert(date, global, voltage);
          insertsWriter.write(tree.insertCount+"\n");
          input.nextLine();
        }

        try {
          if(args.length == 1) {
              if(args[0].contains(".txt")) {
                  Scanner read = new Scanner (new File(args[0]));
                  String txtDate = "";
                  while(read.hasNextLine()) {
                      txtDate = read.nextLine();
                      System.out.println(txtDate);
                      tree.printDateTime(txtDate);
                      System.out.println("The operation count was "+(tree.insertCount+tree.count)+". The find Operation count was: "+tree.count+". And the insert operation count was: "+tree.insertCount);
                      tree.count = 0;
                  }
              }else {
                  tree.printDateTime(args[0]);
                  System.out.println("The operation count was "+(tree.insertCount+tree.count)+". The find Operation count was: "+tree.count+". And the insert operation count was: "+tree.insertCount);
                  tree.count = 0;
              }
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

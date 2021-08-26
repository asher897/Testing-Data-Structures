import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class PowerAVL500 {

    public static void main(String[] args) throws IOException {
        //Determine scanner
        Scanner input = new Scanner(new File("cleaned_data(sorted).csv"));
        input.nextLine();
        input.useDelimiter(";");

        //Setup File FileWriter
        BufferedWriter insertsWriter = new BufferedWriter(new FileWriter("insertAVLCounts500.txt"));

        String date = "";
        String global ="";
        String voltage = "";

        //Implement AVL tree
        BinaryNode root = new BinaryNode();
        AVLTree tree = new AVLTree();
        date = input.next();
        //System.out.println(date);
        global = input.next();
        input.next();
        voltage =input.next();
        tree.insert(date, global, voltage);
        input.nextLine();

        //Extract necessary data for AVL Tree
        BinaryNode current = new BinaryNode();
        while(input.hasNextLine()) {
          date = input.next();
          global = input.next();
          input.next();
          voltage = input.next();
          tree.insertNode(date, global, voltage);
          input.nextLine();
        }

        insertsWriter.write(tree.insertCount+"\n");

        //Test printing date time methods
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
                tree.printAllDateTimes();}
            }catch (ArrayIndexOutOfBoundsException e) {}
        input.close();
        insertsWriter.close();
        }
    }

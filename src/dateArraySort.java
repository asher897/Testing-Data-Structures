import java.util.Scanner;
import java.io.*;

public class dateArraySort{

  public static void main(String[] args) throws FileNotFoundException{
  Scanner files = new Scanner(new File("cleaned_data(sorted).csv"));
  files.nextLine();
  files.useDelimiter(";");
  String[] data = new String[500];
  int i = 0;
  while(files.hasNextLine()){
    data[i] = files.next();
    files.nextLine();
    i++;
  }
  files.close();

  for(int j = 0; j <= data.length -1; j++){
    System.out.println(data[j]);
  }
  }
}

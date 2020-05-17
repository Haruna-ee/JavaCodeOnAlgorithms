import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class AlgorithmsHome02 {

  public static void main(String[] args) throws IOException {

    Scanner te = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(
      new FileReader("C:\\Users\\gabri\\OneDrive\\Desktop\\Kotoka.txt")
    );

    String line;
    do {
      line = reader.readLine();
      if (line != null) {
        System.out.println("Do you wish to know the various temperatures ? (y/n)");
        String reply = te.nextLine();
        if (reply.equalsIgnoreCase("y") || reply.equalsIgnoreCase("yes")) {
          System.out.println("location: " + getLocationName(line));

          int[] temperatures = getTemperatureArray(line);
          for (int i = 0; i < temperatures.length; i++) {
            System.out.println(temperatures[i]);
          }

          System.out.println(
              "The average temperature at this location is " + getAvgTemperature(temperatures)
          );
          System.out.println(
              "The warmest temperature at this location is " + getWarmestTemperature(temperatures)
          );
          System.out.println(
              "The coldest temperature at this location is " + getColdestTemperature(temperatures)
          );
          System.out.println(
              "The average temperature excluding two extremes is " + getAvgTemperatureExclExtremes(temperatures)
          );
        } else {
          System.out.println("Alright");
          break;
        }
      }

    } while (line != null);
  }

  public static int[] getTemperatureArray(String line) {
    int[] temperatures = new int[7];
    String[] strArr = line.split(" ");

    int incrementor = 0;
    for(int i=0; i<strArr.length; i++){
      try {
        int temp = Integer.parseInt(strArr[i]);
        temperatures[incrementor] = temp;
        incrementor++;
      } catch (NumberFormatException exception){
        continue;
      }
    }

    return temperatures;
  }

  public static String getLocationName(String line) {
    String location = "";
    String[] strArr = line.split(" ");

    for(int i=0; i<strArr.length; i++){
      try {
        int temp = Integer.parseInt(strArr[i]);
      } catch (NumberFormatException exception){
        location = location + strArr[i] + " ";
      }
    }

    return location.trim();
  }

  public static double getAvgTemperature(int[] temperatures) {
    double avg = 0;
    double sum = 0;
    double me = 0;
    for (int i = 0; i < temperatures.length; i++) {
      sum += temperatures[i];
      me++;
    }

    avg = (sum / me);

    return avg;
  }

  public static int getWarmestTemperature(int[] temperatures) {
    int max = temperatures[0];
    for (int i = 1; i < temperatures.length; i++) {
      if (temperatures[i] > max) {
        max = temperatures[i];
      }
    }

    return max;
  }

  public static int getColdestTemperature(int[] temperatures) {
    int min = temperatures[0];
    for (int i = 1; i < temperatures.length; i++) {
      if (min > temperatures[i]) {
        min = temperatures[i];
      }
    }

    return min;
  }

  public static double getAvgTemperatureExclExtremes(int[] temperatures) {
    double avg = 0;
    double sum = 0;
    double me = 0;

    for (int i = 0; i < temperatures.length; i++) {
      if ((temperatures[i] != getWarmestTemperature(temperatures))
          && (temperatures[i] != getColdestTemperature(temperatures))) {
        sum += temperatures[i];
        me++;
      }
    }

    avg = (sum / me);
    
    return avg;
  }
}
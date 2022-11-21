import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

class Inventory {
  String name;
  String num;
  int value;

  Inventory(String name, String num, int value) {
    this.name = name;
    this.num = num;
    this.value = value;
  }

  public String toString() {
    return name + ", " + num + ", " + value;
  }

  public String getnum() {
    return this.num;
  }

  public void setname(String name) {
    this.name = name;
  }

  public void setvalue(int value) {
    this.value = value;
  }

}

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Inventory> Total = new ArrayList<Inventory>();

    int choice;
    while (true) {

      System.out.println("Press 1 to add an item. ");
      System.out.println("Press 2 to delete an item. ");
      System.out.println("Press 3 to update an item. ");
      System.out.println("Press 4 to show all the item. ");
      System.out.println("Press 5 to quit the program. ");

      choice = scanner.nextInt();

      switch (choice) {

        case 1:
          System.out.println("Enter the name: ");
          scanner.nextLine();
          String name = scanner.nextLine();
          System.out.println("Enter the serial number: ");
          String num = scanner.next();
          System.out.println("Enter the value in dollars (whole number): ");
          int value = scanner.nextInt();
          Inventory inv = new Inventory(name, num, value);
          Total.add(inv);
          // done

          break;

        case 2:
          System.out.println("Enter the serial number of the item to delete: ");
          String num1 = scanner.next();
          Iterator itr = Total.iterator();
          while (itr.hasNext()) {
            Inventory x = (Inventory) itr.next();
            if (x.getnum().contains(num1)) {
              itr.remove();
            }
          }
          // done
          
          break;

        case 3:
          System.out.println("Enter the serial number of the item to change: ");
          String num2 = scanner.next();
          System.out.println("Enter the new name: ");
          scanner.nextLine();
          String name1 = scanner.nextLine();
          System.out.println("Enter the new value in dollars (whole number): ");
          int value1 = scanner.nextInt();
          for (Inventory anything : Total) {
            if (num2.equals(anything.getnum())) {
              anything.setname(name1);
              anything.setvalue(value1);
            }
          }
          // done

          break;

        case 4:
          for (int i = 0; i < Total.size(); i++) {
            System.out.println(Total.get(i));
          }
          // done
          break;

        case 5:
          System.exit(0);
          break; // done

        default:
          System.out.println("Please slelect the options 1 through 5. ");
      }
    }
  }
}

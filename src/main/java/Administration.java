import java.util.Scanner;

public class Administration {
    public static void main(String[] args) {
        StudentPresentation studentPresentation = new StudentPresentation();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            studentPresentation.showMenu();
            System.out.println("Enter choice : ");
            int choice = scanner.nextInt();
            studentPresentation.performMenu(choice);

        }
    }
}

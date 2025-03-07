public class StackCalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackCalculator calc = new StackCalculator();
        calc.displayWelcomeMessage();
        calc.displayCommands();
        
        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "push":
                    if (parts.length > 1) {
                        try {
                            double value = Double.parseDouble(parts[1]);
                            calc.push(value);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format.");
                        }
                    } else {
                        System.out.println("Please provide a number to push.");
                    }
                    break;
                case "add":
                case "sub":
                case "mult":
                case "div":
                    calc.performOperation(command);
                    break;
                case "clear":
                    calc.clearStack();
                    break;
                case "list":
                    calc.listStack();
                    break;
                case "quit":
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}

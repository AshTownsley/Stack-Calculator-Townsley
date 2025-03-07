import java.util.Scanner;
import java.util.Stack;

class StackCalculator {
    private Stack<Double> calculator;
    private String command;

    public StackCalculator() {
        calculator = new Stack<>();
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Stack Calculator!");
    }

    public void displayCommands() {
        System.out.println("Commands:");
        System.out.println("push n - Push number n onto the stack");
        System.out.println("add - Pop two values, add them, push the result");
        System.out.println("sub - Pop two values, subtract, push the result");
        System.out.println("mult - Pop two values, multiply, push the result");
        System.out.println("div - Pop two values, divide, push the result");
        System.out.println("clear - Clear the stack");
        System.out.println("list - List stack contents");
        System.out.println("quit - Exit the application");
    }

    public void push(double value) {
        calculator.push(value);
    }

    public double pop() {
        if (!calculator.isEmpty()) {
            return calculator.pop();
        } else {
            System.out.println("Stack is empty.");
            return 0;
        }
    }

    public int size() {
        return calculator.size();
    }

    public void listStack() {
        System.out.println("Stack contents: " + calculator);
    }

    public void clearStack() {
        calculator.clear();
        System.out.println("Stack cleared.");
    }

    public void performOperation(String operation) {
        if (calculator.size() < 2) {
            System.out.println("Not enough values in stack to perform operation.");
            return;
        }
        double b = pop();
        double a = pop();
        double result = 0;
        switch (operation) {
            case "add":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "mult":
                result = a * b;
                break;
            case "div":
                if (b == 0) {
                    System.out.println("Cannot divide by zero.");
                    push(a);
                    push(b);
                    return;
                }
                result = a / b;
                break;
            default:
                System.out.println("Invalid operation.");
                return;
        }
        push(result);
        System.out.println("Result: " + result);
    }
}

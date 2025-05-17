import java.util.Scanner;

public class AIChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("🤖 ChatBot: Hello! I'm your assistant. Ask me anything or type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            input = scanner.nextLine().toLowerCase();

            if (input.contains("hi") || input.contains("hello")) {
                System.out.println("🤖 ChatBot: Hello there! How can I help you?");
            } else if (input.contains("how are you")) {
                System.out.println("🤖 ChatBot: I'm just code, but I'm doing great! What about you?");
            } else if (input.contains("your name")) {
                System.out.println("🤖 ChatBot: I’m ChatGPT-Bot, built with Java!");
            } else if (input.contains("bye")) {
                System.out.println("🤖 ChatBot: Goodbye! Have a great day.");
                break;
            } else {
                System.out.println("🤖 ChatBot: Hmm... I didn't understand that. Can you rephrase?");
            }
        }

        scanner.close();
    }
}

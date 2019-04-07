package builder.builder;

import java.util.Set;

public class Email {
    private final String      title;
    private final Set<String> to;
    private final Set<String> cc;
    private final Set<String> bcc;
    private final String      message;

    public static EmailBuilder build() {
        return new EmailBuilder();
    }

    public Email(String title, Set<String> to, Set<String> cc, Set<String> bcc, String message) {
        this.title = title;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.message = message;
    }

    public void send() {
        System.out.println("+=================================================+");
        System.out.println("Title: '" + title + "'");
        System.out.println("To:     " + to);
        System.out.println("Cc:     " + cc);
        System.out.println("Bcc:    " + bcc);
        System.out.println("+-------------------------------------------------+");
        System.out.println(message);
        System.out.println("===================================================");
    }
}

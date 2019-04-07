package builder.builder;

import java.util.HashSet;
import java.util.Set;

public class EmailBuilder {
    private final Set<String> to  = new HashSet<>();
    private final Set<String> cc  = new HashSet<>();
    private final Set<String> bcc = new HashSet<>();
    private       String      title;
    private       String      greeting;
    private       String      mainText;
    private       String      closing;

    public EmailBuilder sendTo(String recipient) {
        to.add(recipient);
        return this;
    }

    public EmailBuilder withCc(String recipient) {
        cc.add(recipient);
        return this;
    }

    public EmailBuilder withBcc(String recipient) {
        bcc.add(recipient);
        return this;
    }

    public EmailBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public EmailBuilder setHeader(String greeting) {
        this.greeting = greeting;
        return this;
    }

    public EmailBuilder setMainText(String mainText) {
        this.mainText = mainText;
        return this;
    }

    public EmailBuilder setFooter(String closing) {
        this.closing = closing;
        return this;
    }

    public Email build() {
        String message = greeting + "\n" + mainText + "\n" + closing;
        return new Email(title, to, cc, bcc, message);
    }
}
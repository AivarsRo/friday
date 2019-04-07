package builder.builder;

import java.util.HashSet;
import java.util.Set;

public class SimpleEmailBuilder implements EmailBuilder {
    private final Set<String> to  = new HashSet<>();
    private final Set<String> cc  = new HashSet<>();
    private final Set<String> bcc = new HashSet<>();
    private       String      title;
    private       String      header;
    private       String      mainText;
    private       String      footer;

    @Override
    public SimpleEmailBuilder sendTo(String recipient) {
        to.add(recipient);
        return this;
    }

    @Override
    public SimpleEmailBuilder withCc(String recipient) {
        cc.add(recipient);
        return this;
    }

    @Override
    public SimpleEmailBuilder withBcc(String recipient) {
        bcc.add(recipient);
        return this;
    }

    @Override
    public SimpleEmailBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public SimpleEmailBuilder setHeader(String greeting) {
        this.header = greeting;
        return this;
    }

    @Override
    public SimpleEmailBuilder setMainText(String mainText) {
        this.mainText = mainText;
        return this;
    }

    @Override
    public SimpleEmailBuilder setFooter(String closing) {
        this.footer = closing;
        return this;
    }

    @Override
    public Email build() {
        String message = header + "\n" + mainText + "\n" + footer;
        return new Email(title, to, cc, bcc, message);
    }
}
package builder.builder;

public interface EmailBuilder {
    EmailBuilder sendTo(String recipient);

    EmailBuilder withCc(String recipient);

    EmailBuilder withBcc(String recipient);

    EmailBuilder setTitle(String title);

    EmailBuilder setHeader(String greeting);

    EmailBuilder setMainText(String mainText);

    EmailBuilder setFooter(String closing);

    Email build();
}

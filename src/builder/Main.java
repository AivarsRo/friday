package builder;

import builder.builder.Email;

public class Main {

    public static void main(String[] args) {
        Email email = Email.build()
                           .setTitle("Builder pattern demo")
                           .sendTo("john@Doe.com")
                           .withCc("johnny.english@007.com")
                           .withBcc("hidden.recepient@gmail.com")
                           .withBcc("hidden.one.more@yahoo.com")
                           .setMainText("Check the builder pattern")
                           .setHeader("Hi John!")
                           .setFooter("Regards")
                           .build();

        email.send();
    }
}

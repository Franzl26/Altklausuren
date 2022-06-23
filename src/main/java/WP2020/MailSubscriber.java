package WP2020;

import java.util.Objects;
import java.util.regex.Pattern;

public class MailSubscriber implements Subscribable<Mail>, Comparable<MailSubscriber> {
    private static final Pattern namePattern = Pattern.compile("[a-zA-Z][a-z]{2,19}");
    private static final Pattern eMailPattern = Pattern.compile("[a-zA-Z0-9]{3,10}@[a-zA-Z0-9]{3,15}[.][a-zA-Z0-9]{2,5}");

    private String name;
    final String eMail;

    public MailSubscriber(String name, String eMail) {
        /*if (name == null || !namePattern.matcher(name).matches())
            throw new IllegalArgumentException("Name not valid");
        if (eMail == null || !eMailPattern.matcher(eMail).matches())
            throw new IllegalArgumentException("email not valid");*/
        this.name = name;
        this.eMail = eMail;
    }

    public boolean setName(String name) {
        if (name == null || !namePattern.matcher(name).matches()) return false;
        else {
            this.name = name;
            return true;
        }
    }

    @Override
    public void send(Mail mail) {

    }

    @Override
    public String toString() {
        return "name = " + name + ", eMail = " + eMail;
    }

    public static class Builder {
        private String name = null;
        private String mail = null;

        public Builder setName(String n) {
            if (n == null || !namePattern.matcher(n).matches())
                throw new IllegalArgumentException("Name not valid");
            name = n;
            return this;
        }

        public Builder setEmail(String n) {
            if (n == null || !eMailPattern.matcher(n).matches())
                throw new IllegalArgumentException("email not valid");
            mail = n;
            return this;
        }

        public MailSubscriber create() {
            if (name == null || mail == null) throw new IllegalArgumentException("not all parameters set");
            return new MailSubscriber(name, mail);
        }
    }

    public boolean equals(Object o) {
        return this.eMail.equals(((MailSubscriber)o).eMail);
    }

    public int hashCode() {
        return Objects.hash(eMail);
    }

    public int compareTo(MailSubscriber o) {
        return this.eMail.compareTo(o.eMail);
    }
}

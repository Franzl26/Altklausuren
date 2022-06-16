package WP2020;

public class Mail {
    private static long uniqueIdCounter = 0;
    public final long id = uniqueIdCounter++;

    public final String subject;
    public final String text;
    public final String sender;

    private Mail(String subject, String text, String sender) {
        this.subject = subject;
        this.text = text;
        this.sender = sender;
    }

    public static Mail of(String subject, String text, String sender) {
        if (subject == null || subject.length() < 1 || subject.length() > 42) return null;
        if (text == null || text.length() < 1 || text.length() > 1024) return null;
        if (sender == null || sender.length() < 1 || sender.length() > 32) return null;
        return new Mail(subject, text, sender);
    }
}

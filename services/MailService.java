package services;

import models.EBook;


public class MailService {


    public void sendEmail(EBook ebook) {
        if (ebook == null) {
            System.out.println("Quantum book store: Cannot send null EBook via email.");
            return;
        }
        
        System.out.println("Quantum book store: Sending digital book via email...");
        System.out.println("Quantum book store: Email Details:");
        System.out.println("  - To: customer@email.com");
        System.out.println("  - Subject: Your Digital Book Purchase - " + ebook.getTitle());
        System.out.println("  - Book: " + ebook.getTitle() + " by " + ebook.getAuthor());
        System.out.println("  - Format: " + ebook.getFileFormat());
        System.out.println("  - File Size: " + generateMockFileSize(ebook.getFileFormat()));
        System.out.println("Quantum book store: Digital book successfully delivered via email!");
    }


    private String generateMockFileSize(String format) {
        switch (format.toUpperCase()) {
            case "PDF":
                return "2.5 MB";
            case "EPUB":
                return "1.2 MB";
            case "MOBI":
                return "1.8 MB";
            case "TXT":
                return "0.3 MB";
            default:
                return "1.5 MB";
        }
    }


    public void sendNotification(String to, String subject, String message) {
        System.out.println("Quantum book store: Sending email notification...");
        System.out.println("  - To: " + to);
        System.out.println("  - Subject: " + subject);
        System.out.println("  - Message: " + message);
        System.out.println("Quantum book store: Email notification sent successfully!");
    }
}

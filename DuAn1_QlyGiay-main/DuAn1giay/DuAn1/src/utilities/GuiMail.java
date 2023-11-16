
package utilities;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class GuiMail {

    public class EmailSender {

        private final static String emailGui = "tkao30t11@gmail.com";
        private final static String matKhau = "thuc2002";

        public  void guiMail(String emailNhan,
                String tieuDe, String noiDung)
                throws AddressException, MessagingException {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
            prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailGui, matKhau);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailGui));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(emailNhan));

            // Tiêu đề
            message.setSubject(tieuDe);

            // Nội dung
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(noiDung, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        }
    }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) throws MessagingException {
            // TODO code application logic here
           // EmailSender.guiMail("thanhldph22749@fpt.edu.vn", "thanh2002", "Thang Thuc an cut!!!");
        }
}

    

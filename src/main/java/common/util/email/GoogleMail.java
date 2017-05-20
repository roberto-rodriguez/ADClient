package common.util.email;

import com.sun.mail.smtp.SMTPTransport;
import common.display.ReportItem;
import common.persistence.domain.Factura;
import common.persistence.domain.FacturaItem;
import java.security.Security;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author doraemon
 */
public class GoogleMail {

    public static GoogleMail INSTANCE;

    public static GoogleMail get() {
        if (INSTANCE == null) {
            INSTANCE = new GoogleMail();
        }
        return INSTANCE;
    }

    public static void main(String[] args) throws MessagingException {
        System.out.println("Sending email...");
        Factura factura = new Factura();

        FacturaItem item = new FacturaItem();
        item.setProduct("Product");
        item.setQuantity(5);
        item.setSales(10D);
        item.setCommission(2D);
        item.setNet2pay(1D);
        item.setFreeDollar(3D);
        List<FacturaItem> items = new ArrayList<>();
        items.add(item);

        factura.setItems(items);

//        sendReportEmail("robertoSoftwareEngineer@gmail.com", factura);
        sendReportEmail("gtitorobe@gmail.com", factura);

        System.out.println("Email sent");
    }

    public static void sendReportEmail(String destinatario, Factura factura) throws MessagingException { 
        String body = buildEmail(factura);
        SendEmail("Alo Diga. Reporte de Facturas", destinatario, body);
        System.out.println("Email sent to: " + destinatario);
    }

    private static String buildEmail(Factura factura) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div style=\"width=100%;\">");
        sb.append("<br>");
        sb.append("<b style=\"width=100%;text-align:center;\">Alo Diga</b>");
        sb.append("<br>");
        sb.append("<br>"); 
 
        sb.append("<br>");
        sb.append("<p ><b>Date:</b> " + factura.getFecha() + "</p>");
        sb.append("<p ><b>No:</b>" + factura.getNumber() + "</p>");
         sb.append("<br>");
         
        sb.append("<table border=\"1\" cellspacing=\"0\" cellpadding=\"2\">");
        
        sb.append("<tr><td colspan=\"3\"></td><td colspan=\"3\" style=\"text-align:center;font-weight:bold;background-color:#e0e2e4;\">Invoice Period</td></tr>");
        sb.append("<tr><td colspan=\"3\"></td><td colspan=\"1\" style=\"text-align:center;font-weight:bold;background-color:#e0e2e4;\">From</td><td colspan=\"1\" style=\"text-align:center;font-weight:bold;background-color:#e0e2e4;\"> </td><td colspan=\"1\" style=\"text-align:center;font-weight:bold;background-color:#e0e2e4;\">To</td></tr>");
        sb.append("<tr><td colspan=\"3\"></td><td colspan=\"1\" style=\"text-align:center;\">" + factura.getStartDateStr()+ "</td><td colspan=\"1\" > </td><td colspan=\"1\" style=\"text-align:center; \">" + factura.getEndDateStr()+ "</td></tr>");
        sb.append("<tr  style=\"height:20px;\"><td colspan=\"6\"</td></tr>"); 
         
        sb.append("<tr style=\"font-weight:bold; background-color:#e0e2e4\"><td colspan=\"3\" style=\"text-align:left;\">Retail Store</td><td colspan=\"3\" style=\"text-align:center;\">Summary</td></tr>");
        sb.append("<tr><td colspan=\"3\" style=\"text-align:left;\">" + factura.getStore().getName() + "</td><td colspan=\"2\"  style=\"text-align:left;\">Total to Pay</td><td style=\"text-align:right;\">69.16</td></tr>");
        sb.append("<tr><td colspan=\"3\" style=\"text-align:left;\">" + factura.getStore().getAddress() + "</td><td colspan=\"2\"  style=\"text-align:left;\">Total Paid (Credit Card)</td><td style=\"text-align:right;\">(189.6)</td></tr>");
        sb.append("<tr ><td colspan=\"3\" style=\"text-align:left;\">Store ID: " + factura.getStore().getLoginId() + "</td><td colspan=\"2\"  style=\"text-align:left;\">Discount</td><td style=\"text-align:right;\">11.64</td></tr>");         
        sb.append("<tr  style=\"height:25px;\"><td colspan=\"6\"</td></tr>");         

        sb.append("<tr style=\"font-weight:bold; background-color:#e0e2e4\"><td>Product</td><td>Quantity</td><td>Sales</td><td>Discount</td><td>Net to Pay</td><td>Promotion</td></tr>");

        List<FacturaItem> items = factura.getItems();

        for (FacturaItem item : items) {
            sb.append("<tr>  <td>" + item.getProduct() + "</td><td>" + item.getQuantity() + "</td><td>" + item.getSales() + "</td><td>" + item.getCommission() + "</td><td>" + item.getNet2payStr() + "</td><td>" + item.getFreeDollar() + "</td></tr>");
        }

        sb.append("<tr style=\"font-weight:bold; background-color:#e0e2e4\">  <td>Total</td><td>" + factura.getQuantity() + "</td><td>" + factura.getSales() + "</td><td>" + factura.getCommission() + "</td><td>" + factura.getNet2pay() + "</td><td>" + factura.getSalesPromotion() + "</td></tr>");
        sb.append("<tr >  <td>Purchase Balance</td><td>" + factura.getQuantityPurchaseBalance() + "</td><td> </td><td> </td><td>" + factura.getPurchaseBalance() + "</td><td> </td></tr>");
        
        sb.append("</table>");
        sb.append("</div>");
        return sb.toString();
    }

    public static void SendEmail(String title, String destinatario, String body) throws AddressException, MessagingException {
//        Send("alodiga.reportes@gmail.com", "Alodiga1", "derick_brol@hotmail.com", new String[]{""}, title, body);
//        Send("alodiga.reportes@gmail.com", "Alodiga1", "robertosoftwareengineer@gmail.com", new String[]{""}, title, body);
        Send("alodiga.reportes@gmail.com", "Alodiga1", destinatario, new String[]{ }, title, body);
    }

    /**
     * Send email using GMail SMTP server.
     *
     * @param username GMail username
     * @param password GMail password
     * @param recipientEmail TO recipient
     * @param ccEmail CC recipient. Can be empty if there is no CC recipient
     * @param title title of the message
     * @param message message to be sent
     * @throws AddressException if the email address parse failed
     * @throws MessagingException if the connection is dead or not in the
     * connected state or if the message is not a MimeMessage
     */
    public static void Send(final String username, final String password, String recipientEmail, String[] ccEmail, String title, String message) throws AddressException, MessagingException {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

        /*
         If set to false, the QUIT command is sent and the connection is immediately closed. If set 
         to true (the default), causes the transport to wait for the response to the QUIT command.

         ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
         http://forum.java.sun.com/thread.jspa?threadID=5205249
         smtpsend.java - demo program from javamail
         */
        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        // -- Create a new message --
        final MimeMessage msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(username));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

        for (int i = 0; i < ccEmail.length; i++) {
            msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail[i], false));
        }

        msg.setSubject(title);
        msg.setContent(message, "text/html");
//        msg.setText(message, "utf-8");
        msg.setSentDate(new Date());

        SMTPTransport t = (SMTPTransport) session.getTransport("smtps");

        t.connect("smtp.gmail.com", username, password);
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
    }

}

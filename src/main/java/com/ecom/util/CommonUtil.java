package com.ecom.util;

import java.io.UnsupportedEncodingException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ecom.model.ProductOrder;
import com.ecom.model.UserDtls;
import com.ecom.service.UserService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Common utility class for handling email-related functionalities.
 * Project: Kashmir's Specialties Handicrafts & Merchandise Retails (KSHMR)
 * Developed by Sahil and Maheshwari.
 */
@Component
public class CommonUtil {

    @Autowired
    private JavaMailSender mailSender; // Mail sender for sending emails

    @Autowired
    private UserService userService; // Service for user-related operations

    /**
     * Sends a password reset email to the recipient.
     *
     * @param url the link to reset the password
     * @param reciepentEmail the email address of the recipient
     * @return true if the email was sent successfully
     * @throws UnsupportedEncodingException if the encoding is unsupported
     * @throws MessagingException if there is an error in sending the email
     */
    public Boolean sendMail(String url, String reciepentEmail) throws UnsupportedEncodingException, MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        // Set sender and recipient details
        helper.setFrom("daspabitra55@gmail.com", "Shopping Cart");
        helper.setTo(reciepentEmail);

        // Email content for password reset
        String content = "<p>Hello,</p>" + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>" + "<p><a href=\"" + url
                + "\">Change my password</a></p>";
        helper.setSubject("Password Reset");
        helper.setText(content, true); // Set the email body
        mailSender.send(message); // Send the email
        return true;
    }

    /**
     * Generates the base URL for the application.
     *
     * @param request the HTTP request
     * @return the generated URL
     */
    public static String generateUrl(HttpServletRequest request) {

        // Returns the base URL (e.g., http://localhost:8080)
        String siteUrl = request.getRequestURL().toString();
        return siteUrl.replace(request.getServletPath(), "");
    }

    String msg = null; // Message variable to store the email content

    /**
     * Sends an email regarding the product order status.
     *
     * @param order the ProductOrder object containing order details
     * @param status the status of the order
     * @return true if the email was sent successfully
     * @throws Exception if there is an error in sending the email
     */
    public Boolean sendMailForProductOrder(ProductOrder order, String status) throws Exception {

        // Email content template for product order status
        msg = "<p>Hello [[name]],</p>"
                + "<p>Thank you for your order <b>[[orderStatus]]</b>.</p>"
                + "<p><b>Product Details:</b></p>"
                + "<p>Name : [[productName]]</p>"
                + "<p>Category : [[category]]</p>"
                + "<p>Quantity : [[quantity]]</p>"
                + "<p>Price : [[price]]</p>"
                + "<p>Payment Type : [[paymentType]]</p>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        // Set sender and recipient details
        helper.setFrom("daspabitra55@gmail.com", "Shopping Cart");
        helper.setTo(order.getOrderAddress().getEmail());

        // Replace placeholders with actual order details
        msg = msg.replace("[[name]]", order.getOrderAddress().getFirstName());
        msg = msg.replace("[[orderStatus]]", status);
        msg = msg.replace("[[productName]]", order.getProduct().getTitle());
        msg = msg.replace("[[category]]", order.getProduct().getCategory());
        msg = msg.replace("[[quantity]]", order.getQuantity().toString());
        msg = msg.replace("[[price]]", order.getPrice().toString());
        msg = msg.replace("[[paymentType]]", order.getPaymentType());

        helper.setSubject("Product Order Status");
        helper.setText(msg, true); // Set the email body
        mailSender.send(message); // Send the email
        return true;
    }

    /**
     * Retrieves the details of the currently logged-in user.
     *
     * @param p the Principal object representing the logged-in user
     * @return UserDtls object containing user details
     */
    public UserDtls getLoggedInUserDetails(Principal p) {
        String email = p.getName(); // Get the email from Principal
        UserDtls userDtls = userService.getUserByEmail(email); // Retrieve user details from the service
        return userDtls;
    }
}

package C0921G1_sprint_1.controller.special_ticket_confirmation;



import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.service.member_management.MemberService;
import C0921G1_sprint_1.service.special_ticket_confirmation.PaymentService;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.validation.Valid;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@RestController
@CrossOrigin(origins = "*")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    // cái này xóa đi
    @GetMapping("/pay")
    public ResponseEntity<List<Transaction>> listResponseEntity(){
        List<Transaction> transactions = paymentService.getAllTransaction();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    //còn 2 3 đối tượng con đang đợi bên phía a đạt gửi qua cùng lúc save xuống data là được !!!
    // thêm mới lịch sử xong redirect về trang lịch sử
    @PostMapping(value = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addTracsaction(@Valid @RequestBody Transaction transaction , BindingResult bindingResult){

        try {
            if (bindingResult.hasFieldErrors()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                qrCode(transaction);
                sendEmail(transaction);
            }
        } catch (MessagingException | WriterException | IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(paymentService.saveTransaction(transaction) , HttpStatus.OK);
    }



        // chức năng send mail
    private void sendEmail(Transaction transaction) throws MessagingException {
        String to = "doantai100983hu@gmail.com";
        String from = "doantai100983hu@gmail.com";
        final String username = "doantai100983hu@gmail.com";
        final String password = "tai100900huong";
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        Message message = new MimeMessage(session);
        //địa chỉ mail được gửi
        message.setFrom(new InternetAddress(from));
        // địa chỉ mail được gửi
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
        // tiêu đề thư
        message.setSubject("[C0921G1Cinema-Thông báo] Xác nhận thanh toán thành công");
        MimeMultipart multipart = new MimeMultipart("related");
        // phần này gửi html đi
        BodyPart messageBodyPart = new MimeBodyPart();


        String htmlText=
                "<div style=\"color: #031327\">\n" +
                        "    <div style=\"background: url(https://thumbs.dreamstime.com/b/abstract-background-white-film-strip-frame-cinema-festival-poster-flyer-template-your-design-movie-time-139262949.jpg);\n" +
                        "width: 720px ;height: 480px\">\n" +
                        "        <br>\n" +
                        "        <h2 style=\"text-align: center;\">Kính chào quý khách <strong style=\"color: darkblue\">"+ transaction.getMember().getName()+ "</strong></h2>\n" +
                        "        <p><strong>Cảm ơn quý khách đã đặt vé xem phim: </strong>" + "<strong style=\"color: darkblue\">" + transaction.getShowTime().getFilm().getName() + "</strong>" +"</p>\n" +
                        "        <p><strong>NGÀY CHIẾU: </strong>"+ transaction.getShowTime().getDate() + "<p>\n" +
                        "        <p><strong>XUẤT CHIẾU: </strong>"+  transaction.getShowTime().getName() + "<p>\n" +
                        "        <p><strong>SỐ GHẾ: </strong>"+ "đang đợi dữ liệu bên đạt" + "<p>\n" +
                        "        <p><strong>TỔNG TIỀN: </strong>"+ "100.000.000" + " VND"+ " </p>\n" +
                        "        <p><strong>Cảm ơn quý khách đã đặt vé xem phim tại <span style=\"color: darkblue\">C0921G1-CINEMA</span></strong></p>\n" +
                        "        <p><strong> CHÚC QUÝ KHÁCH MỘT BUỔI XEM PHIM VUI VẺ </strong></p>\n" +
                        "        <p><strong style=\"color: red\">LƯU Ý: KHI ĐI NHỚ ĐEM THEO MÃ QR ĐẾN QUẦY THU NGÂN ĐỂ XÁC NHẬN ĐẶT VÉ.</strong></p>\n" +
                        "    <img src=\"cid:image\">\n" +
                        "    </div>\n" +

                        "</div>"
                ;

        messageBodyPart.setContent(htmlText, "text/html;charset=UTF-8");
        // thêm vào body
        multipart.addBodyPart(messageBodyPart);
      //phần này dùng để gửi hình ảnh
        messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource("src/main/resources/qr.png");
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID", "<image>");
        //thêm mới hình ảnh
        multipart.addBodyPart(messageBodyPart);
       //gép mọi thứ lại với nhau
        message.setContent(multipart);
        // gửi mail
        Transport.send(message);
        System.out.println("Sent message successfully....");
    }


        // chuyển đối qrcode thành hình ảnh
    private void qrCode(Transaction transaction) throws WriterException, IOException {
        String data = transaction.getCode() + "" + transaction.getId() + " "
                + "Email Người đặt vé" +transaction.getMember().getEmail() + "Tên Người Đặt Vé" + transaction.getMember().getName();
        String path = "src/main/resources/qr.png";
        BitMatrix matrix;
        matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 150, 150);
        MatrixToImageWriter.writeToPath(matrix, "png", Paths.get(path));
    }
}


package sem6.tsk1.SendMessages;

public class SendEmailMessage implements ISendMessage {

    @Override
    public void sendMessage(String typeMessage, String message) {
        if (typeMessage.equals("email")) {
            //email
            //use Java.Mail.SenderAPI
            System.out.println("Send email");
        }
    }
}

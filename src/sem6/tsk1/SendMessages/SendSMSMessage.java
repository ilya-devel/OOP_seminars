package sem6.tsk1.SendMessages;

public class SendSMSMessage implements ISendMessage {

    @Override
    public void sendMessage(String typeMessage, String message) {
        if(typeMessage.equals("SMS")) {
            System.out.println("Send SMS message");
        }
    }
}

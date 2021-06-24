package LLD;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Result {
    private static Map<Integer, Client> registeredClient = new HashMap<>();
    // clients should be concurrent hashMap<client id,val->
    // This method is called on "register-client" input.
    public static void registerClient(int clientId, int windowSize) {
        // Implement this
        Client client = new Client(windowSize, clientId);
        registeredClient.put(clientId, client);
    }
    // This method is called on "new-message" input.  Use the provided
    // Solution.sendMessage() method to send a message to the client.  The
    // `more` argument to sendMessage should be false when called from this
    // method.
    public static void newMessage(int clientId, int msgId, int msgAge) {
        if (registeredClient.get(clientId) != null) {
            Client client = registeredClient.get(clientId);
            client.getMessages().add(new Message(msgId, msgAge));
            sendQueuedMessagesFromClient(client);
        }
    }

    private static void sendQueuedMessagesFromClient(Client client) {
        int clientId = client.getClientId();

        Set<Message> messages = client.getMessages();
        int windowSize = client.getWindowSize();
        Iterator<Message> msgItr = messages.iterator();
        while (windowSize > 0 || msgItr.hasNext()) {
            --windowSize;
             Message message = msgItr.next();
             Solution.sendMessage(clientId, message.getMsgId(), message.msgAge, false);
             msgItr.remove();
        }

        client.setWindowSize(windowSize);
        client.setMessages(messages);
        registeredClient.put(clientId, client);
    }

    // This method is called on "adjust-window" input.  Use the provided
    // Solution.sendMessage() method to send a message to the client.  If
    // multiple messages have to be sent due to message window adjustment, the
    // `more` argument to sendMessage() should be false for the last message
    // (and true for all others).
    public static void adjustWindow(int clientId, int windowSize) {
        // Implement this
        if (registeredClient.get(clientId) != null) {
            Client client = registeredClient.get(clientId);
            client.setWindowSize(windowSize);
            sendQueuedMessagesFromClient(client);
        }
    }

    static class Client {
        private int windowSize;
        private int clientId;

        Set<Message> messages = new TreeSet<>(new MessageComparator());
        public Client(int windowSize, int clientId) {
            this.windowSize = windowSize;
            this.clientId = clientId;
        }

        public int getWindowSize() {
            return windowSize;
        }

        public void setWindowSize(int windowSize) {
            this.windowSize = windowSize;
        }

        public Set<Message> getMessages() {
            return messages;
        }

        public void setMessages(Set<Message> messages) {
            this.messages = messages;
        }

        public int getClientId() {
            return clientId;
        }

        public void setClientId(int clientId) {
            this.clientId = clientId;
        }
    }
    static class MessageComparator implements Comparator<Message> {

        @Override
        public int compare(Message message2, Message message) {
            int compare = Integer.compare(message.getMsgId(), message2.getMsgId());
            if (compare == 0) {
                return Integer.compare(message.getMsgAge(), message2.getMsgAge());
            }
            return compare;
        }
    }

    static class Message{
        private int msgId;
        private int msgAge;

        public int getMsgId() {
            return msgId;
        }

        public void setMsgId(int msgId) {
            this.msgId = msgId;
        }

        public int getMsgAge() {
            return msgAge;
        }

        public void setMsgAge(int msgAge) {
            this.msgAge = msgAge;
        }

        public Message(int msgId, int msgAge) {
            this.msgAge = msgAge;
            this.msgId = msgId;
        }
    }
}
public class Solution {
    // Actions
    public static final String REGISTER_CLIENT = "register-client";
    public static final String NEW_MSG = "new-message";
    public static final String ADJUST_WINDOW = "adjust-window";
    public static final String EXIT = "exit";
    public static final int MAX_MSG_PER_CLIENT = 100;
    private static BufferedWriter bufferedWriter;
    // This method is used to send a message to a client.
    // params:
    //  clientId - client identifier
    //  msgId - message identifier
    //  msgAge - message Age
    //  more - true if more messages are to be sent to the client as part of
    //         processing the current command.
    public static void sendMessage(int clientId, int msgId, int msgAge, boolean more) {
        try {
            bufferedWriter.write("(" + clientId + ", " + msgId + ", " + msgAge + ")" + (more?" ":"\n"));
        }
        catch (IOException e ) {
            System.out.println(e.toString());
        }
    }
    public static void main(String[] args) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        try (Scanner scanner = new Scanner(System.in)) {
            Scanner s = scanner.useDelimiter("\\s+");
            boolean exit = false;
            while (!exit) {
                String cmd = s.next();
                if(!cmd.isEmpty()){
                    switch (cmd) {
                        case REGISTER_CLIENT:
                            Result.registerClient(s.nextInt(), s.nextInt());
                            break;
                        case NEW_MSG:
                            Result.newMessage(s.nextInt(), s.nextInt(), s.nextInt());
                            break;
                        case ADJUST_WINDOW:
                            Result.adjustWindow(s.nextInt(), s.nextInt());
                            break;
                        case EXIT:
                            exit = true;
                            break;
                        default:
                            System.out.println("Unknown input " + cmd);
                            break;
                    }
                }
            }
        } finally {
            bufferedWriter.close();
        }
    }
}

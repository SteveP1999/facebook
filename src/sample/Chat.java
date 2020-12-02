package sample;

import java.io.*;

public class Chat {
    public AllMessages ReadMessages() {
        File f = new File("chatstream.ser");
        if (f.exists()) {
            try {
                AllMessages u;
                FileInputStream fileIn = new FileInputStream("chatstream.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                u = (AllMessages) in.readObject();
                in.close();
                fileIn.close();
                return u;
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }
        }
        return new AllMessages();
    }

    public void SaveMessages(AllMessages users) {
        try {
            FileOutputStream fileOut = new FileOutputStream("chatstream.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

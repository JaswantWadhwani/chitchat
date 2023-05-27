package chitchat.services;

import chitchat.event.PublicEvent;
import chitchat.models.MessageReceivingModel;
import chitchat.models.UserAccountModel;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private static Service instance;
    private Socket client;
    private static final int PORT_NUMBER = 9999;
    private String IP;
    private UserAccountModel user;

    public UserAccountModel getUser() {
        return user;
    }

    public void setUser(UserAccountModel user) {
        this.user = user;
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private Service() {
    }

    public void startServer() {
        try {
            try (final DatagramSocket datagramSocket = new DatagramSocket()) {
                datagramSocket.connect(InetAddress.getByName("8.8.8.8"), 12345);
                IP = datagramSocket.getLocalAddress().getHostAddress();
            } catch (Exception e) {
                e.printStackTrace();
            }

            client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    //  list user
                    List<UserAccountModel> users = new ArrayList<>();
                    for (Object o : os) {
                        UserAccountModel u = new UserAccountModel(o);
                        if (u.getUserId() != user.getUserId()) {
                            users.add(u);
                        }
                    }
                    PublicEvent.getInstance().getEventLeftMenu().newUser(users);
                }
            });
            client.on("user_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    int userId = (Integer) os[0];
                    boolean status = (Boolean) os[1];

                    if (status) {
//                        connect
                        PublicEvent.getInstance().getEventLeftMenu().connectUser(userId);
                    } else {
//                        disconnect
                        PublicEvent.getInstance().getEventLeftMenu().disconnectUser(userId);
                    }
                }
            }
            );
            client.on("receive_ms", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    MessageReceivingModel message = new MessageReceivingModel(os[0]);
                    PublicEvent.getInstance().getEventChat().receiveMessage(message);
                }

            });

            client.open();
        } catch (URISyntaxException ex) {
            error(ex);
        }
    }

    public Socket getClient() {
        return client;
    }

    public void error(Exception ex) {
        System.err.println(ex);
    }
}

package _NetworkChat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    String nick;
    String userID;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if(str.startsWith("/auth")) {
                            String[] tokens = str.split(" ");
                            String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2],this);

                            if(newNick != null) {
                                sendMsg("/authok");
                                Server.logger.info("Авторизован клиент с ником: " + newNick);
                                nick = newNick;
                                server.subscribe(this);
                                sendMsg(AuthService.getChatHistory());
                                sendMsg("История чата окончена.");
                                break;
                            } else {
                                sendMsg("Неверный логин/пароль");
                            }
                        }
                    }
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            out.writeUTF("/serverclosed");
                            break;
                        } else if (str.startsWith("/changenick")){
                            String[] tokens = str.split(" ");
                            try{
                                AuthService.changeClientNick(tokens[1], this) ;
                                sendMsg("Успешно сменили NickName на " + tokens[1]);
                                Server.logger.info("Авторизован клиент с ником: " + tokens[1]);
                            } catch(SQLException e){
                                e.printStackTrace();
                            }
                        }
                        server.broadcastMsg(nick + " " + str);
                        AuthService.saveHistory(nick + " " + str);
                        System.out.println("Client: " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

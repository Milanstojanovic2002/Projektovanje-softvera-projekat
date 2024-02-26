/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import domain.Admin;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import logic.Controller;
import thread.ClientThread;

public class Server extends Thread {

    private Controller controller;
    private List<ClientThread> clients;
    private ServerSocket serverSocket;
    private boolean kraj = false;

    public Server() {
        this.controller = new Controller();
        clients = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(9000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (!kraj) {
            try {
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected!");
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
                clients.add(clientThread);
            } catch (IOException ex) {
                //ex.printStackTrace();
            }
        }
    }

    

    public boolean notLogin(Admin admin) {
        for (ClientThread client : clients) {
            if (admin.equals(client.getAdmin())) {
                return false;
            }
        }
        return true;
    }

    public void stopServer() {
        try {
            for (ClientThread clientThread : clients) {
                clientThread.setKraj(true);
            }
            serverSocket.close();
            System.out.println("Server je zaustavljen");
            kraj = true;
//            Controller.getInstance().setPrijavljeniKorisnici(new ArrayList<>());
//            ss.close();
//            kraj = true;
        } catch (IOException ex) {
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    

    
}

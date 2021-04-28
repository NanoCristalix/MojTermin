import java.lang.Runnable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.*;

class ClientHandler implements Runnable {
    public Socket clientSocket;
    public DataInputStream dis;
    public DataOutputStream dos;
    static ArrayList < String > doktori = new ArrayList < String > ();
    static ArrayList < String > doktor1 = new ArrayList < String > ();
    static ArrayList < String > doktor2 = new ArrayList < String > ();
    static ArrayList < String > doktor3 = new ArrayList < String > ();
    private static final int PORT_NUMBER = 5000;
    private static ServerSocket serverSocket;
    private static Thread thread;
    private static ClientHandler clientHandler;
    protected void finalize() throws IOException {
        serverSocket.close();
    }
    boolean termin;
    ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        termin = false;
    }

    public void run() {
        try {
            dis = new DataInputStream(clientSocket.getInputStream());
            dos = new DataOutputStream(clientSocket.getOutputStream());
            String poraka = "";

            if (clientSocket.isConnected()) {

                System.out.println("Noviot client e konektiran");
                dos.writeUTF("Dobredojdovte vo moj termin");
                dos.writeUTF("Izberete doktor so reden broj t.e 1=Dr.Nenad..");
                System.out.println("Izbiranje na doktor...");
                for (int i = 0; i < doktori.size(); i++) {

                    dos.writeUTF(doktori.get(i));

                }
            }
            boolean terminB = false;
            String Odgovor;
            while (true) {
                Odgovor = dis.readUTF();

                try {
                    int odgovor1 = Integer.parseInt(Odgovor) - 1;
                    if (odgovor1 < 3)
                        System.out.println("Izbiranje na termin...");
                    else {
                        dos.writeUTF("Ne postoi toj izbor");
                    }
                    if (odgovor1 == 0) {
                        dos.writeUTF("Terminite za " + doktori.get(odgovor1) + " se : ");
                        if (doktor1.isEmpty()) {
                            dos.writeUTF("Terminite se popolneti");
                            clientSocket.close();
                            System.out.println("Isklucuvanje na klientot");
                            break;


                        } else {


                            for (int i = 0; i < doktor1.size(); i++) {
                                dos.writeUTF(doktor1.get(i));
                            }

                            dos.writeUTF("Dali sakate da zakazete termin kaj " + doktori.get(odgovor1) + "?");
                            while (true) {
                                String zakazi = dis.readUTF();
                                if (zakazi.equals("da") || zakazi.equals("Da")) {
                                    System.out.println("Zakazuvanje na termin....");
                                    dos.writeUTF("Koj termin ke go izberete");
                                    String termin = dis.readUTF();

                                    for (int i = 0; i < doktor1.size(); i++) {
                                        if (doktor1.get(i).contains(termin)) {
                                            terminB = true;
                                            doktor1.remove(i);

                                        }
                                    }

                                    if (terminB == true) {
                                        terminB = false;
                                        dos.writeUTF("Terminot e zakazan");
                                        System.out.println("Terminot e zakazan");
                                    } else {
                                        dos.writeUTF("Terminot ne postoi");
                                    }

                                    break;

                                } else {
                                    System.out.println("Gresna komanda");
                                    dos.writeUTF("Gresna komanda vnesi Da ili da");
                                }
                            }
                        }
                    }


                    if (odgovor1 == 1) {
                        dos.writeUTF("Terminite za " + doktori.get(odgovor1) + " se : ");
                        if (doktor2.isEmpty()) {
                            dos.writeUTF("Terminite se popolneti");
                            clientSocket.close();
                            System.out.println("Isklucuvanje na klientot");
                            break;


                        } else {


                            for (int i = 0; i < doktor2.size(); i++) {
                                dos.writeUTF(doktor2.get(i));
                            }

                            dos.writeUTF("Dali sakate da zakazete termin kaj " + doktori.get(odgovor1) + "?");
                            while (true) {
                                String zakazi = dis.readUTF();
                                if (zakazi.equals("da") || zakazi.equals("Da")) {
                                    System.out.println("Zakazuvanje na termin....");
                                    dos.writeUTF("Koj termin ke go izberete");
                                    String termin = dis.readUTF();

                                    for (int i = 0; i < doktor2.size(); i++) {
                                        if (doktor2.get(i).contains(termin)) {
                                            terminB = true;
                                            doktor2.remove(i);

                                        }
                                    }

                                    if (terminB == true) {
                                        terminB = false;
                                        dos.writeUTF("Terminot e zakazan");
                                        System.out.println("Terminot e zakazan");
                                    } else {
                                        dos.writeUTF("Terminot ne postoi");
                                    }

                                    break;

                                } else {
                                    System.out.println("Gresna komanda");
                                    dos.writeUTF("Gresna komanda vnesi Da ili da");
                                }
                            }
                        }
                    }

                    if (odgovor1 == 2) {
                        dos.writeUTF("Terminite za " + doktori.get(odgovor1) + " se : ");
                        if (doktor3.isEmpty()) {
                            dos.writeUTF("Terminite se popolneti");
                            clientSocket.close();
                            System.out.println("Isklucuvanje na klientot");
                            break;


                        } else {


                            for (int i = 0; i < doktor3.size(); i++) {
                                dos.writeUTF(doktor3.get(i));
                            }

                            dos.writeUTF("Dali sakate da zakazete termin kaj " + doktori.get(odgovor1) + "?");
                            while (true) {
                                String zakazi = dis.readUTF();
                                if (zakazi.equals("da") || zakazi.equals("Da")) {
                                    System.out.println("Zakazuvanje na termin....");
                                    dos.writeUTF("Koj termin ke go izberete");
                                    String termin = dis.readUTF();

                                    for (int i = 0; i < doktor3.size(); i++) {
                                        if (doktor3.get(i).contains(termin)) {
                                            terminB = true;
                                            doktor3.remove(i);

                                        }
                                    }

                                    if (terminB == true) {
                                        terminB = false;
                                        dos.writeUTF("Terminot e zakazan");
                                        System.out.println("Terminot e zakazan");
                                    } else {
                                        dos.writeUTF("Terminot ne postoi");
                                    }

                                    break;

                                } else {
                                    System.out.println("Gresna komanda");
                                    dos.writeUTF("Gresna komanda vnesi Da ili da");
                                }
                            }
                        }
                    }




                } catch (Exception e) {
                    System.out.println("Greska izbor");
                    dos.writeUTF("Greska izbor vlez obidi se povtorno.");
                }
            } //

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Klientot e diskonektiran");

        }

    }

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(PORT_NUMBER);
        int klient = 0;
        System.out.println("Server is UP....");

        doktori.add("Dr.Nenad");
        doktori.add("Dr.Martin");
        doktori.add("Dr.Dragan");
        doktor1.add("31/01/2020");
        doktor2.add("1/01/2020");
        doktor3.add("2.02.2020");


        while (true) {
            clientHandler = new ClientHandler(serverSocket.accept());

            System.out.println("Nov klient: " + (++klient));

            thread = new Thread(clientHandler);
            thread.start();
        }
    }




}
package ch.he.arc.p1.g5.fi5t;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.LoginFilter;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class BlueFetch extends Services {
    //------------------------------------------------ON RECOIS----------------------------------------------//

    static String AuthorizedUsername = "banana" ;
    static String AuthorizedLogin = "king";

    static Boolean DoorStatus = true;

    static boolean postIt1 = true;
    static boolean postIt2 = true;
    static boolean postIt3 = true;

    static int numberMorePostIts = 1;

    static String postItMessage1 = "Je suis de sortie ce soir !";
    static String postItDate1 = "12:32 / 25.08.2014";

    static String postItFrom1 = "Franck";

    static String postItMessage2 = "Je rentre à la maison à 18h00";
    static String postItDate2 = "11:26 / 25.08.2014";

    static String postItFrom2 = "Maman";

    static String postItMessage3 = "Je fini un peu plus tôt l'école que prévu";
    static String postItDate3 = "11:21 / 25.08.2014";

    static String postItFrom3 = "Franck";



        TextView tvLabel;
        EditText etTextbox;
        BluetoothAdapter mBluetoothAdapter;
        BluetoothSocket mmSocket;
        BluetoothDevice mmDevice;
        OutputStream mmOutputStream;
        InputStream mmInputStream;
        Thread workerThread;

        byte[] readBuffer;
        int readBufferPosition;
        int counter;
        volatile boolean stopWorker;



/*
            Button openButton = (Button)findViewById(R.id.open);
            Button sendButton = (Button)findViewById(R.id.send);
            Button closeButton = (Button)findViewById(R.id.close);
            tvLabel = (TextView)findViewById(R.id.label);
            etTextbox = (EditText)findViewById(R.id.entry);

            //Open Button
            openButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                        findBT();
                        openBT();
                    }
                    catch (IOException ex) { }
                }
            });

            //Send Button
            sendButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                        sendData();
                    }
                    catch (IOException ex) {
                        showMessage("SEND FAILED");
                    }
                }
            });

            //Close button
            closeButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                        closeBT();
                    }
                    catch (IOException ex) { }
                }
            });
        */

        void findBT() {
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if(mBluetoothAdapter == null) {
                tvLabel.setText("No bluetooth adapter available");
            }

            if(!mBluetoothAdapter.isEnabled()) {
                Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBluetooth, 0);
            }

            Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
            if(pairedDevices.size() > 0) {
                for(BluetoothDevice device : pairedDevices) {
                    if(device.getName().equals("FireFly-108B")) {
                        mmDevice = device;
                        break;
                    }
                }
            }
            tvLabel.setText("Bluetooth Device Found");
        }

        void openBT() throws IOException {
            UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard //SerialPortService ID
            mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
            mmSocket.connect();
            mmOutputStream = mmSocket.getOutputStream();
            mmInputStream = mmSocket.getInputStream();
            beginListenForData();
            tvLabel.setText("Bluetooth Opened");
        }

        void beginListenForData() {
            final Handler handler = new Handler();
            final byte delimiter = 10; //This is the ASCII code for a newline character

            stopWorker = false;
            readBufferPosition = 0;
            readBuffer = new byte[1024];
            workerThread = new Thread(new Runnable() {
                public void run() {
                    while(!Thread.currentThread().isInterrupted() && !stopWorker) {
                        try {
                            int bytesAvailable = mmInputStream.available();
                            if(bytesAvailable > 0) {
                                byte[] packetBytes = new byte[bytesAvailable];
                                mmInputStream.read(packetBytes);
                                for(int i=0;i<bytesAvailable;i++) {
                                    byte b = packetBytes[i];
                                    if(b == delimiter) {
                                        byte[] encodedBytes = new byte[readBufferPosition];
                                        System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.length);
                                        final String data = new String(encodedBytes, "US-ASCII");
                                        readBufferPosition = 0;

                                        handler.post(new Runnable() {
                                            public void run() {
                                                tvLabel.setText(data);
                                            }
                                        });
                                    }
                                    else {
                                        readBuffer[readBufferPosition++] = b;
                                    }
                                }
                            }
                        }
                        catch (IOException ex) {
                            stopWorker = true;
                        }
                    }
                }
            });

            workerThread.start();
        }

        void sendData() throws IOException {
            String msg = etTextbox.getText().toString();
            msg += "\n";
            //mmOutputStream.write(msg.getBytes());
            mmOutputStream.write('A');
            tvLabel.setText("Data Sent");
        }

        void closeBT() throws IOException {
            stopWorker = true;
            mmOutputStream.close();
            mmInputStream.close();
            mmSocket.close();
            tvLabel.setText("Bluetooth Closed");
        }

        private void showMessage(String theMsg) {
            Toast msg = Toast.makeText(getBaseContext(),
                    theMsg, (Toast.LENGTH_LONG));
            msg.show();
        }


    //-----Nombre Utilisateur--------//
    static Integer BlfNombreUtilisateur = 4;

    //-----Nombre POSTIT--------//

    static Integer BlfNombrePOSTIT = 8;


    static Integer IDExternUser = 1;
    static String ExternPseudoName = "Schaffora";
    static String ExternUserFirstName="Raphaël";
    static String ExternUserName="Schaffo";
    static String ExterneMotDePasse="10001000";
    static String ExternUserRoles="Admin";

    static Integer POSTITACTUID = 1;
    static String POSTITSENDPseudo="Schaffora";
    static String POSTITMessage="Je suis en retard";
    static String POSTITDate="21/08/2014";
    static String POSTITHeure="12:13";
    static String POSTITStatus="NON LU";


       // Gestion des températures//
    static Integer TemperatureMinimum= 12;
    static Integer TemperatureActuelle = 18;
    static Integer TemperatureMaximum= 39;

    // --------------------------------------------------------ON ENVOIE----------------------------------//
    //ID Utilisateur Selectionner //
    static String DeleteUser="0";


    // ID Utilisateur Modifier //
    static String ExternIDModifier="0";
    static String ExternNomModifier="";
    static String ExternPrenomModifier="";
    static String ExternPseudoModifier="";
    static String ExternMDPModifier="";
    static String ExternRoleModifier="";




    // --------------------------------------------------------FONCTIONS----------------------------------//

    void checkUsernamePassword(String Username, String Password){



    }


}



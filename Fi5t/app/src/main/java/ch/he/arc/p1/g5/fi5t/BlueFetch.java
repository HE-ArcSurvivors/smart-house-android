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

    static String ReceivedResponse = "temp";

    static String AuthorizedUsername = "banana" ;
    static String AuthorizedPassword = "king";
    static String AuthorizedLogin = "CMD\r\n";

    static String DoorStatus = "false";

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




}



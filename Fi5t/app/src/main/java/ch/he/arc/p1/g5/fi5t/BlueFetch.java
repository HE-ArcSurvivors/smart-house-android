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

    static String DoorStatus = "0";

    static boolean postIt1 = true;
    static boolean postIt2 = true;
    static boolean postIt3 = true;

    static int numberMorePostIts = 1;

    static String postItMessage1 = "Je suis en retard";
    static String postItDate1 = "12:13 / 21.08.2014";

    static String postItFrom1 = "Schaffora";

    static String postItMessage2 = "Je suis en retard";
    static String postItDate2 = "12:13 / 21.08.2014";

    static String postItFrom2 = "Schaffora";

    static String postItMessage3 = "Je suis en retard";
    static String postItDate3 = "12:13 / 21.08.2014";

    static String postItFrom3 = "Schaffora";



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
    static Integer BlfNombreUtilisateur = 3;

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



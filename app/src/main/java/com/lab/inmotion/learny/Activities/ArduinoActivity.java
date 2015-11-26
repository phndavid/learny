package com.lab.inmotion.learny.Activities;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lab.inmotion.learny.R;

import java.io.IOException;
import java.util.UUID;

public class ArduinoActivity extends AppCompatActivity {

    Button btnOn, btnOff, btnDis;

    String address = null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    //SPP UUID. Look for it
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    //private  MediaPlayer sp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent newint = getIntent();
        address = newint.getStringExtra(DeviceActivity.EXTRA_ADDRESS); //receive the address of the bluetooth device

        setContentView(R.layout.activity_arduino);
        //sp = MediaPlayer.create(this, R.raw.sp);

        new ConnectBT().execute(); //Call the class to connect
    }
    /*
    public void playMusic(View view){
        if(!sp.isPlaying()){
            sp.start();
        }
        else{
            sp.reset();
        }

    }
    public void stopMusic(View view){
        if(sp.isPlaying()){
            sp.pause();
        }
    }*/
    public void btnAhead(View view){
        Toast.makeText(this, "Ahead", Toast.LENGTH_LONG).show();
        ahead();

    }
    public void btnBack(View view){
        Toast.makeText(this, "Back", Toast.LENGTH_LONG).show();
        back();
    }
    public void btnRight(View view){
        Toast.makeText(this, "Right", Toast.LENGTH_LONG).show();
        right();
    }
    public void btnLeft(View view){
        Toast.makeText(this, "Left", Toast.LENGTH_LONG).show();
        left();
    }

    private void Disconnect()

    {
        if (btSocket!=null) //If the btSocket is busy
        {
            try
            {
                btSocket.close(); //close connection
            }
            catch (IOException e)
            { msg("Error");}
        }
        finish(); //return to the first layout

    }

    private void left()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write('b');
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void right()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write('d');
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void ahead()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write('a');
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void back()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write('e');
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    // fast way to call Toast
    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ConnectBT extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean ConnectSuccess = true; //if it's here, it's almost connected

        @Override
        protected void onPreExecute()
        {
            progress = ProgressDialog.show(ArduinoActivity.this, "Connecting...", "Please wait!!!");  //show a progress dialog
        }

        @Override
        protected Void doInBackground(Void... devices) //while the progress dialog is shown, the connection is done in background
        {
            try
            {
                if (btSocket == null || !isBtConnected)
                {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice("20:14:05:19:37:41");//connects to the device's address and checks if it's available
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();//start connection
                }
            }
            catch (IOException e)
            {
                ConnectSuccess = false;//if the try failed, you can check the exception here
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Connection Failed. Is it a SPP Bluetooth? Try again.");
                finish();
            }
            else
            {
                msg("Connected.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }

}

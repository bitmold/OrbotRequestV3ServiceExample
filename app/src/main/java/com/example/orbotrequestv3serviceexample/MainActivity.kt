package com.example.orbotrequestv3serviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private val activityRequestCode = 1234

    private val localPort = 8008
    private val onionPort = 80

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivityForResult(Intent("org.torproject.android.REQUEST_V3_ONION_SERVICE").apply {
                `package` = "org.torproject.android"
                putExtra("localPort", localPort)
                putExtra("onionPort", onionPort)
                putExtra("name", "Test V3 $localPort @ $onionPort") }, activityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode != activityRequestCode) return
        if (resultCode == RESULT_OK) {
            val hostname = data?.getStringExtra("org.torproject.android.REQUESTED_V3_HOSTNAME")
            AlertDialog.Builder(this)
                .setTitle("V3 Onion Hostname")
                .setMessage(hostname)
                .show()
        } else {
            Toast.makeText(this, "Operation Aborted", Toast.LENGTH_LONG).show()
        }
    }

}
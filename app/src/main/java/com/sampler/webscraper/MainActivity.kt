package com.sampler.webscraper

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jsoup.Jsoup
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    class TestKotlinConstantClass {
        companion object {
            var ONE_VALUE = ""
            var TWO_VALUE = ""
            var THREE_VALUE = ""
            var FOUR_VALUE = ""
            var FIVE_VALUE = ""
            var SIX_VALUE = ""
            var SEVEN_VALUE = ""
            var EIGHT_VALUE = ""
            var NINE_VALUE = ""
            var TEN_VALUE = ""
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Network Connection Handler
        if(!hasInternetConnection()) {
            Toast.makeText(applicationContext,"network connection error...",
                Toast.LENGTH_LONG).show()
        } else {
            retrieveWebInfo()
        }

        // button
        btn_button?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, GraphActivity::class.java)
            startActivity(intent)
        })
    }


    // Retrieve Stock-Data (Web-Crawling)
    private fun retrieveWebInfo(){

        thread {
            val doc = Jsoup.connect("https://money.cnn.com/data/hotstocks/sp1500/").get()

            // i) Searching : list of class within "date"
            val date = doc.getElementsByClass("wsod_StockTimestamp").text() + " (Most Actives)"
            val goldTable = doc.getElementsByClass("wsod_dataTable wsod_dataTableBigAlt")

            // ii) Exact-Locating :
            val headers = goldTable[0]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[1]
                .getElementsByTag("td")

            val headers2 = goldTable[0]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[2]
                .getElementsByTag("td")

            val headers3 = goldTable[0]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[3]
                .getElementsByTag("td")

            val headers4 = goldTable[0]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[4]
                .getElementsByTag("td")

            val headers5 = goldTable[0]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[5]
                .getElementsByTag("td")

            val headers6 = goldTable[0]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[6]
                .getElementsByTag("td")

            val headers7 = goldTable[0]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[7]
                .getElementsByTag("td")

            val headers8 = goldTable[0]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[8]
                .getElementsByTag("td")

            val headers9 = goldTable[0]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[9]
                .getElementsByTag("td")

            val headers10 = goldTable[0]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[10]
                .getElementsByTag("td")

            this.runOnUiThread {

                // i) Set-up for retrieving data
                txtDate.text = date
                headerGoldUnit.text = "1. " + headers[0].text()
                headerGoldChange.text = "$" + headers[1].text() + " (" + headers[3].text() + ")"
                TestKotlinConstantClass.ONE_VALUE = headers[1].text()

                headerGoldUnit2.text = "2. " + headers2[0].text()
                headerGoldChange2.text = "$" + headers2[1].text() + " (" + headers2[3].text() + ")"
                TestKotlinConstantClass.TWO_VALUE = headers2[1].text()

                headerGoldUnit3.text = "3. " + headers3[0].text()
                headerGoldChange3.text = "$" + headers3[1].text() + " (" + headers3[3].text() + ")"
                TestKotlinConstantClass.THREE_VALUE = headers3[1].text()

                headerGoldUnit4.text = "4. " + headers4[0].text()
                headerGoldChange4.text = "$" + headers4[1].text() + " (" + headers4[3].text() + ")"
                TestKotlinConstantClass.FOUR_VALUE = headers4[1].text()

                headerGoldUnit5.text = "5. " + headers5[0].text()
                headerGoldChange5.text = "$" + headers5[1].text() + " (" + headers5[3].text() + ")"
                TestKotlinConstantClass.FIVE_VALUE = headers5[1].text()

                headerGoldUnit6.text = "6. " + headers6[0].text()
                headerGoldChange6.text = "$" + headers6[1].text() + " (" + headers6[3].text() + ")"
                TestKotlinConstantClass.SIX_VALUE = headers6[1].text()

                headerGoldUnit7.text = "7. " + headers7[0].text()
                headerGoldChange7.text = "$" + headers7[1].text() + " (" + headers7[3].text() + ")"
                TestKotlinConstantClass.SEVEN_VALUE = headers7[1].text()

                headerGoldUnit8.text = "8. " + headers8[0].text()
                headerGoldChange8.text = "$" + headers8[1].text() + " (" + headers8[3].text() + ")"
                TestKotlinConstantClass.EIGHT_VALUE = headers8[1].text()

                headerGoldUnit9.text = "9. " + headers9[0].text()
                headerGoldChange9.text = "$" + headers9[1].text() + " (" + headers9[3].text() + ")"
                TestKotlinConstantClass.NINE_VALUE = headers9[1].text()

                headerGoldUnit10.text = "10. " + headers10[0].text()
                headerGoldChange10.text = "$" + headers10[1].text() + " (" + headers10[3].text() + ")"
                TestKotlinConstantClass.TEN_VALUE = headers10[1].text()

            }
        }
    }

    // Inflate the menu to use in the action bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Handle presses on the action bar menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.btn_gainer -> {
                val intent = Intent(this@MainActivity, GainersActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }


    // for checking internet-connection...
    private fun hasInternetConnection(): Boolean {

        // getApplication() is only available in AndroidViewModel...
        val connectivityManager =
            getApplication()
                .getSystemService(
                    Context.CONNECTIVITY_SERVICE
                ) as ConnectivityManager

        // CASE 1: Version check (if higher than M)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork =
                connectivityManager.activeNetwork ?: return false       // if null...
            val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
                ?: return false    // return flase b/c we don't have internet connection

            // various kinds of internet-connection
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }

            // CASE 2: Version check (if higher than M)
        } else {
            connectivityManager.activeNetworkInfo?.run {
                return when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false
    }
}
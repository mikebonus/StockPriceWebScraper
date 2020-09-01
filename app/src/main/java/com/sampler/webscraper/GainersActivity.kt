package com.sampler.webscraper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.sampler.webscraper.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jsoup.Jsoup
import kotlin.concurrent.thread

class GainersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrieveWebInfo()
    }

    private fun retrieveWebInfo(){

        thread {
            val doc = Jsoup.connect("https://money.cnn.com/data/hotstocks/sp1500/").get()

            // i) Searching : list of class within "date"
            val date = doc.getElementsByClass("wsod_dateBlock clearfix")[0]
                .getElementsByClass("wsod_fRight wsod_disclaimer").text() + " (Gainers)"
            val goldTable = doc.getElementsByClass("wsod_dataTable wsod_dataTableBigAlt")

            // wsod_StockTimestamp

            // ii) Exact-Locating :
            val headers1 = goldTable[1]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[1]
                .getElementsByTag("td")
1
            val headers2 = goldTable[1]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[2]
                .getElementsByTag("td")

            val headers3 = goldTable[1]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[3]
                .getElementsByTag("td")

            val headers4 = goldTable[1]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[4]
                .getElementsByTag("td")

            val headers5 = goldTable[1]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[5]
                .getElementsByTag("td")

            val headers6 = goldTable[1]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[6]
                .getElementsByTag("td")

            val headers7 = goldTable[1]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[7]
                .getElementsByTag("td")

            val headers8 = goldTable[1]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[8]
                .getElementsByTag("td")

            val headers9 = goldTable[1]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[9]
                .getElementsByTag("td")

            val headers10 = goldTable[1]
                .getElementsByTag("tbody")[0]
                .getElementsByTag("tr")[10]
                .getElementsByTag("td")


            this.runOnUiThread {

//                // i) Set-up for retrieving data
                txtDate.text = date
                headerGoldUnit.text = headers1[0].text()
                headerGoldChange.text = "$" + headers1[1].text() + " (" + headers1[3].text() + ")"

                headerGoldUnit2.text = headers2[0].text()
                headerGoldChange2.text = "$" + headers2[1].text() + " (" + headers2[3].text() + ")"

                headerGoldUnit3.text = headers3[0].text()
                headerGoldChange3.text = "$" + headers3[1].text() + " (" + headers3[3].text() + ")"

                headerGoldUnit4.text = headers4[0].text()
                headerGoldChange4.text = "$" + headers4[1].text() + " (" + headers4[3].text() + ")"

                headerGoldUnit5.text = headers5[0].text()
                headerGoldChange5.text = "$" + headers5[1].text() + " (" + headers5[3].text() + ")"

                headerGoldUnit6.text = headers6[0].text()
                headerGoldChange6.text = "$" + headers6[1].text() + " (" + headers6[3].text() + ")"

                headerGoldUnit7.text = headers7[0].text()
                headerGoldChange7.text = "$" + headers7[1].text() + " (" + headers7[3].text() + ")"

                headerGoldUnit8.text = headers8[0].text()
                headerGoldChange8.text = "$" + headers8[1].text() + " (" + headers8[3].text() + ")"

                headerGoldUnit9.text = headers9[0].text()
                headerGoldChange9.text = "$" + headers9[1].text() + " (" + headers9[3].text() + ")"

                headerGoldUnit10.text = headers10[0].text()
                headerGoldChange10.text = "$" + headers10[1].text() + " (" + headers10[3].text() + ")"

            }
        }
    }


    // Inflate the menu to use in the action bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu_gainerside, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Handle presses on the action bar menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.btn_activer -> {
                val intent = Intent(this@GainersActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
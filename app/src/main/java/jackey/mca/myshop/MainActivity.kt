package jackey.mca.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var drawer =  findViewById<DrawerLayout>(R.id.drawer)

        toggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        var menu = arrayOf("Home", "Apple", "about")
        var adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, menu)
        var lv = findViewById<ListView>(R.id.listView)
        lv.adapter = adapter

        supportFragmentManager.beginTransaction().replace(R.id.frame,Home()).commit()
        lv.setOnItemClickListener{parent, view, postion, id->
            drawer.closeDrawers()

            when(postion){
                0 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, Home()).commit()
                }
                1 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, apple()).commit()
                }
                2 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, About()).commit()
                }
            }

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }
}
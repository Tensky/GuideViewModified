package id.tensky.guideviewmodified

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.tensky.guide_view.DefaultGuideView
import id.tensky.guide_view.GuideView
import id.tensky.guide_view.config.DismissType
import id.tensky.guide_view.config.Gravity
import id.tensky.guide_view.config.PointerType
import id.tensky.guideviewmodified.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val countryItemList = listOf(
        "Indonesia",
        "Jepang",
        "Negara Lain",
        "Belanda",
        "Franchise",
        "Indonesia",
        "Indonesia",
        "Jepang",
        "Negara Lain",
        "Belanda",
        "Belanda",
        "Belanda",
        "Belanda",
        "Belanda",
        "Belanda",
        "Belanda",
        "Belanda",
        "Belanda",
        "Belanda",
        "Belanda",
        "Franchise",
        "Indonesia",
    )

    private val exampleAdapter = ExampleAdapter(countryItemList, ::onExampleRecyclerItemClicked)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initView()
    }

    private fun initView() {
        binding.apply {
            btTry1.setOnClickListener {
                createGuide(it)
            }

            rvMain.layoutManager = LinearLayoutManager(baseContext)
            rvMain.adapter = exampleAdapter
        }
    }

    private fun createGuide(view: View) {
        val defaultGuideView = DefaultGuideView.Builder(this).apply {
            setButtonText("Ok, got it")
            setTitleText("Complete your information here.")
            setOnButtonClickedHof {
                Log.d("TAG", "createGuide: ButtonnyaKeclick cok")
            }
        }.build()
        GuideView.Builder(this)
            .setGravity(Gravity.auto) //optional
            .setPointerType(PointerType.arrow)
            .setDismissType(DismissType.anywhere) //optional - default DismissType.targetView
            .setTargetView(view)
            .setMessageView(defaultGuideView)
            .build()
            .show()
    }

    private fun onExampleRecyclerItemClicked(position: Int) {
        val view =
            (binding.rvMain.layoutManager as LinearLayoutManager).findViewByPosition(position)
        view?.let { it1 -> createGuide(view) }
    }
}


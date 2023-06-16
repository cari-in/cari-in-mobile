package com.example.cariinapp.result.button.badung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.cariinapp.R
import com.example.cariinapp.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

class badungmuseum : AppCompatActivity() {
    private val locationMap = mapOf(
        43 to "Tegal Wangi Beach",
        15 to "Geger Beach",
        21 to "Karma Kandara Beach",
        34 to "Nungnung Waterfall",
        46 to "The Abandoned Airplane",
        33 to "Natys Restaurants Seminyak",
        30 to "Mountain Abang",
        3 to "Bangkian Djaran Waterfall",
        47 to "The Amora Bali",
        35 to "Pantunan Valley",
        5 to "Batur Mountain",
        49 to "Tibumana Waterfall",
        16 to "Gitgit Waterfall",
        37 to "Rice Terrace Ambengan",
        27 to "Lovina Beach",
        10 to "Busungbiu Rice Terace",
        14 to "Gedong Kartya Museum",
        53 to "Wanagiri Peak",
        52 to "Ubud Monkey Forest",
        17 to "Goa Rang Reng Waterfall",
        0 to "Alas Harum Tourism",
        22 to "Keramas Beach",
        32 to "Museum Blanco Renaissance",
        2 to "Bali Bird Park",
        29 to "Medewi Beach",
        13 to "Cendikusuma Beach",
        7 to "Blod Berawah Beach",
        55 to "Yeh Embang Kangin Waterfall",
        18 to "Grojongan Waterfall",
        9 to "Bunut Bolong",
        36 to "Pura Majapahit",
        6 to "Bias Tugel Beach",
        38 to "Savana Tianyar",
        8 to "Bukit Cinta Viewpoint",
        25 to "Lahangan Sweet",
        20 to "Jemeluk Beach",
        19 to "Jakasatru Waterfall",
        42 to "Sukasada Garden",
        28 to "May Day Gili",
        40 to "Semarajaya Museum",
        31 to "Mundi Temple Peak",
        11 to "Caruban Peak",
        54 to "Wisata Bakas Village",
        51 to "Tukad Unda Dam",
        26 to "Leke Leke Waterfall",
        44 to "Teman Joger Luwus",
        45 to "Terasering Soka",
        48 to "The Sila's Agrotourism",
        41 to "Soka Beach",
        4 to "Batukaru Mountain",
        23 to "Krisna Oleh-oleh Bali Nusakambangan",
        24 to "Ku De Ta Beach",
        12 to "Cemara Beach",
        1 to "Badung Beach",
        50 to "Tukad Loloan Sanur",
        39 to "Sea Turtle Conservation and Education Center"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badungmuseum)

        val model = Model.newInstance(this)

        // Create a ByteBuffer and set its order to little endian
        val byteBuffer = ByteBuffer.allocateDirect(4 * 3) // Assuming each element is 4 bytes (float32)
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(3f)
        byteBuffer.putFloat(0f)
        byteBuffer.rewind()

        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 3), DataType.FLOAT32)
        inputFeature0.loadBuffer(byteBuffer)

        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer

        model.close()

        val resultTextView = findViewById<TextView>(R.id.recomendationbadungmun)

        // Get the index of the highest value in the output feature
        val maxIndex = outputFeature0.floatArray.indices.maxByOrNull { outputFeature0.floatArray[it] }

        // Get the corresponding location name from the locationMap
        val locationName = locationMap[maxIndex]

        // Display the location name in the resultTextView
        resultTextView.text = locationName
    }
}
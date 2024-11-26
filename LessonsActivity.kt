package com.example.islamicbasics

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LessonsActivity : AppCompatActivity() {

    private lateinit var buttonFeqah: Button
    private lateinit var buttonTauhid: Button
    private lateinit var buttonAkhlak: Button

    private lateinit var feqahNotes: TextView
    private lateinit var tauhidNotes: TextView
    private lateinit var akhlakNotes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons)

        // Initialize buttons and text views
        buttonFeqah = findViewById(R.id.buttonFeqah)
        buttonTauhid = findViewById(R.id.buttonTauhid)
        buttonAkhlak = findViewById(R.id.buttonAkhlak)

        feqahNotes = findViewById(R.id.feqahNotes)
        tauhidNotes = findViewById(R.id.tauhidNotes)
        akhlakNotes = findViewById(R.id.akhlakNotes)

        // Set onClickListeners for buttons
        buttonFeqah.setOnClickListener {
            toggleNotes(feqahNotes, getFeqahNotes())
            collapseOtherNotes(feqahNotes)
        }

        buttonTauhid.setOnClickListener {
            toggleNotes(tauhidNotes, getTauhidNotes())
            collapseOtherNotes(tauhidNotes)
        }

        buttonAkhlak.setOnClickListener {
            toggleNotes(akhlakNotes, getAkhlakNotes())
            collapseOtherNotes(akhlakNotes)
        }
    }

    // Toggle notes visibility and animate
    private fun toggleNotes(noteView: TextView, noteText: String) {
        if (noteView.visibility == View.GONE) {
            noteView.text = noteText
            noteView.alpha = 0f
            noteView.visibility = View.VISIBLE
            noteView.animate().alpha(1f).setDuration(300).start()
        } else {
            noteView.animate().alpha(0f).setDuration(300).withEndAction {
                noteView.visibility = View.GONE
            }.start()
        }
    }

    // Collapse other notes when one button is clicked
    private fun collapseOtherNotes(noteView: TextView) {
        if (noteView != feqahNotes && feqahNotes.visibility == View.VISIBLE) {
            feqahNotes.visibility = View.GONE
        }
        if (noteView != tauhidNotes && tauhidNotes.visibility == View.VISIBLE) {
            tauhidNotes.visibility = View.GONE
        }
        if (noteView != akhlakNotes && akhlakNotes.visibility == View.VISIBLE) {
            akhlakNotes.visibility = View.GONE
        }
    }

    // Feqah Notes content
    private fun getFeqahNotes(): String {
        return """
            1. Introduction to Feqah (Islamic Jurisprudence)
               Feqah is the understanding and application of Islamic law based on the Quran, Hadith, and consensus of scholars.

            2. The Five Pillars of Islam:
               - Shahada (Faith): The declaration of faith.
               - Salat (Prayer): Five daily prayers.
               - Zakat (Charity): Giving to the needy.
               - Sawm (Fasting): Fasting during Ramadan.
               - Hajj (Pilgrimage): A once-in-a-lifetime pilgrimage to Mecca.

            3. Types of Feqah:
               - Ibadat (Acts of Worship): Covers acts like prayer, fasting, and Hajj.
               - Muamalat (Social Transactions): Deals with business, marriage, inheritance.
               - Uqubat (Punishments): Legal punishments for criminal offenses.
               - Akhlaq (Morality): Develop good moral character and ethics.
        """
    }

    // Tauhid Notes content
    private fun getTauhidNotes(): String {
        return """
            1. What is Tauhid?
               Tauhid is the concept of the oneness of Allah in Islam, which is the foundation of the Islamic faith.

            2. The Three Categories of Tauhid:
               - Tauhid al-Rububiyyah (Oneness of Lordship): Belief that Allah is the sole creator and sustainer of the universe.
               - Tauhid al-Uluhiyyah (Oneness of Worship): Only Allah deserves worship.
               - Tauhid al-Asma wa al-Sifat (Oneness of Names and Attributes): Allah's attributes are unique and beyond comparison.

            3. Importance of Tauhid in Islam:
               It is essential for a Muslim to acknowledge and believe in the oneness of Allah to attain true faith and enter paradise.
        """
    }

    // Akhlak Notes content
    private fun getAkhlakNotes(): String {
        return """
            1. Definition of Akhlak (Morality):
               Akhlak is the study of moral and ethical behavior in Islam.

            2. Characteristics of Good Akhlak:
               - Honesty: Truthfulness in all aspects of life.
               - Patience: Showing resilience in difficult situations.
               - Respect: Treating others with kindness and respect.
               - Generosity: Giving to others without expecting anything in return.
               - Forgiveness: Forgiving others to maintain peace.

            3. Akhlak in Daily Life:
               Muslims are encouraged to embody good Akhlak in their interactions with others, in family life, and in community.
        """
    }
}

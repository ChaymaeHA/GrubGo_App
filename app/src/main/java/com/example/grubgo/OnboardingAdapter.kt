package com.example.grubgo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class OnboardingAdapter(
    private val pages: List<OnboardingPage>
) : RecyclerView.Adapter<OnboardingAdapter.PageViewHolder>() {

    inner class PageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
        val text = view.findViewById<TextView>(R.id.textView)
        val loginButton = view.findViewById<Button>(R.id.btnConnexion)
        val createAccount = view.findViewById<TextView>(R.id.btnCreateAccount)
        val googleButton = view.findViewById<Button>(R.id.googleButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_onboarding_page, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val page = pages[position]
        holder.image.setImageResource(page.imageResId)
        holder.text.text = page.text

        val context = holder.itemView.context
        holder.loginButton.setOnClickListener {
            Toast.makeText(context, "Se connecter", Toast.LENGTH_SHORT).show()
        }

        holder.createAccount.setOnClickListener {
            Toast.makeText(context, "Créer un compte", Toast.LENGTH_SHORT).show()
        }

        holder.googleButton.setOnClickListener {
            Toast.makeText(context, "Connexion avec Google", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = pages.size
}

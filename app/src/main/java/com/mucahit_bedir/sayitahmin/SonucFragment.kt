package com.mucahit_bedir.sayitahmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mucahit_bedir.sayitahmin.databinding.FragmentSonucBinding
import java.util.zip.Inflater

class SonucFragment : Fragment() {
    private lateinit var binding: FragmentSonucBinding

    private val args: SonucFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSonucBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sonuc = args.sonuc

        if (sonuc == "KAZANDIN") {
            binding.sonucTextView.text = "KAZANDIN"
            binding.sonucImageView.setImageResource(R.drawable.kazandin)
        } else if (sonuc == "KAYBETTİN") {
            binding.sonucTextView.text = "KAYBETTİN"
            binding.sonucImageView.setImageResource(R.drawable.kaybettin)
        } else {
            binding.sonucTextView.text = "NULL"
        }

    }
}
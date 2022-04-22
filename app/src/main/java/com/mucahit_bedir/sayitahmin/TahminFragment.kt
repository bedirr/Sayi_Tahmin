package com.mucahit_bedir.sayitahmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mucahit_bedir.sayitahmin.databinding.FragmentTahminBinding


class TahminFragment : Fragment() {

    private lateinit var binding: FragmentTahminBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTahminBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var hak = 5
        binding.hakTextView.text = "Kalan hak: $hak"

        val randomSayi = (0..10).random()


        binding.tahminButton.setOnClickListener {

            hak = hak - 1
            binding.hakTextView.text = "Kalan hak: $hak"

            var tahmin = 0

            if (binding.tahminEditText.text.toString().isEmpty() || binding.tahminEditText.text.toString()=="" ){
                Toast.makeText(context, "Lütfen bir tahminde bulunun", Toast.LENGTH_SHORT).show()
            }
            else{

                tahmin = binding.tahminEditText.text.toString().toInt()

                if (tahmin < randomSayi) {
                    binding.yardimciTextView.text = "Yardım: Arttır"
                } else if (tahmin > randomSayi) {
                    binding.yardimciTextView.text = "Yardım: Azalt"
                } else if (tahmin == randomSayi) {
                    val action1 = TahminFragmentDirections.actionTahminFragmentToSonucFragment("KAZANDIN")
                    findNavController().navigate(action1)
                }

            }
            if (hak == 0) {
                val action = TahminFragmentDirections.actionTahminFragmentToSonucFragment("KAYBETTİN")
                findNavController().navigate(action)
            }
        }
    }
}
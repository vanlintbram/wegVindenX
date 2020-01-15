package be.brussel.vanlintbram.wegvindenx

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import be.brussel.vanlintbram.wegvindenx.databinding.IntroFragmentBinding


class intro : Fragment() {



    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: IntroFragmentBinding
    lateinit var destination : String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = DataBindingUtil.inflate<IntroFragmentBinding>(
            inflater,
            R.layout.intro_fragment,
            container,
            false)
        viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)

        binding.introBtn.setOnClickListener {
            destination = binding.introDest.text.toString()
            viewModel.selectedItem(destination)
            binding.textView3.text = viewModel._beschrijving.value
        }


        /*val param1 : String = binding.introDest.toString()
        val param2 : String = viewModel._beschrijving.toString()


        binding.introBtn.setOnClickListener {
            it.findNavController().navigate(

            )
        }
        */


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.introTitel.setText("Intro Fragment")

    }

}

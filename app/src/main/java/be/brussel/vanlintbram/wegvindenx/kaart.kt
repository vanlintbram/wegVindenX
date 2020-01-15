package be.brussel.vanlintbram.wegvindenx

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import be.brussel.vanlintbram.wegvindenx.databinding.IntroFragmentBinding
import be.brussel.vanlintbram.wegvindenx.databinding.KaartFragmentBinding


class kaart : Fragment() {

    companion object {
        fun newInstance() = kaart()
    }
    private lateinit var binding: KaartFragmentBinding
    private lateinit var viewModel: SharedViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<KaartFragmentBinding>(
            inflater,
            R.layout.kaart_fragment,
            container,
            false)
        setHasOptionsMenu(true)
        return binding.root

    }

    private fun getShareIntent() : Intent {
        return ShareCompat.IntentBuilder.from(activity)
            .setText(viewModel._beschrijving.value)
            .setType("text/plain")
            .intent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.sharemenu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.kaartText.setText("Kaart Fragment")

    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

}

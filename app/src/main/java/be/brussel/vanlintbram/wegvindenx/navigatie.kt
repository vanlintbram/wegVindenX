package be.brussel.vanlintbram.wegvindenx

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import be.brussel.vanlintbram.wegvindenx.databinding.NavigatieFragmentBinding


class navigatie : Fragment() {

    companion object {
        fun newInstance() = navigatie()
    }
    private lateinit var binding: NavigatieFragmentBinding
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<NavigatieFragmentBinding>(
            inflater,
            R.layout.navigatie_fragment,
            container,
            false)
        viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
        viewModel._beschrijving.observe(this, Observer<String> { item ->
            binding.textView2.setText(item)
        })
        binding.textView2.text = viewModel.dest.value
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


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigatieText.setText("Navigatie Fragment")

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

}

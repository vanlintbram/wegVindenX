package be.brussel.vanlintbram.wegvindenx

import android.provider.Settings.Global.getString
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var dest = MutableLiveData<String>()
    val _beschrijving = MutableLiveData<String>()

    fun selectedItem(item: String) {
        dest.value = item
        navigate()
    }
    fun navigate() {
        //val string: String = getString(R.string.Grimbergen)


        when (dest.value) {
            "Grimbergen" -> _beschrijving.value = "Ga naar Rechts"
            "Beigem" -> _beschrijving.value = "Ga naar Links"
            "Humbeek" -> _beschrijving.value = "Ga naar Boven"
            "Vilvoorde" -> _beschrijving.value = "Ga naar Onder"
            "Kapelle" -> _beschrijving.value = "Ga Terug"
            "Diegem" -> _beschrijving.value = "Ga naar huis"
            "Molenbeek" -> _beschrijving.value = "Ga"
            else -> _beschrijving.value = "Deze bestemming ken ik niet"
        }

    }
}
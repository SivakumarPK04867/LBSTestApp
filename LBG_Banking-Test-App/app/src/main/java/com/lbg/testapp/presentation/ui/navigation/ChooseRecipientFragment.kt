package com.lbg.testapp.presentation.ui.navigation

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.lbg.testapp.R

class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    private var inputReceiptEditText: TextInputEditText? = null
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)

        inputReceiptEditText = view.findViewById<TextInputEditText>(R.id.input_recipient)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.next_btn -> {
                if(!TextUtils.isEmpty(inputReceiptEditText?.text.toString())){
                    val bundle = bundleOf("recipient" to inputReceiptEditText?.text.toString())
                    navController.navigate(
                        R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
                        bundle
                    )
                }
                else{
                    Toast.makeText(activity, "Please enter a name", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.cancel_btn -> requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}

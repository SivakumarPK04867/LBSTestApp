package com.lbg.testapp.presentation.ui.navigation

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.lbg.testapp.R
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private var inputAmountEditText: TextInputEditText? = null
    private var inputReceiptTextView: TextView? = null
    lateinit var navController: NavController
    lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
        val message = "Sending money to $recipient"
        inputReceiptTextView = view.findViewById<TextView>(R.id.recipient)
        inputAmountEditText = view.findViewById<TextInputEditText>(R.id.input_amount)
        inputReceiptTextView?.text = message
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.send_btn -> {
                if (!TextUtils.isEmpty(inputAmountEditText?.text.toString())) {

                    val amount = Money(BigDecimal(inputAmountEditText?.text.toString()))
                    val bundle = bundleOf(
                        "recipient" to recipient,
                        "amount" to amount
                    )
                    navController.navigate(
                        R.id.action_specifyAmountFragment_to_confirmationFragment,
                        bundle
                    )
                } else {
                    Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.cancel_btn -> requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}

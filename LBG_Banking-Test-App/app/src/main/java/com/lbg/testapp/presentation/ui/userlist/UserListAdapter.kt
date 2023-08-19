package com.lbg.testapp.presentation.ui.userlist

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lbg.testapp.R
import com.lbg.testapp.databinding.ItemUserBinding
import com.lbg.testapp.domain.entity.User
import com.lbg.testapp.presentation.ui.navigation.NavigationActivity

/**
 * Created by Siva kumar boddu 
 */
class UserListAdapter(
    val context: Context,
    private val onItemClick: (View, Long) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val userList = mutableListOf<User>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateUsers(userList: List<User>) {
        with(this.userList) {
            clear()
            addAll(userList)
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserListViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = userList[position]
        val binding = (holder as UserListViewHolder).binding

        binding.user = user
        binding.buttonPayment.setOnClickListener {
            navigateToPaymentPage()
        }
        binding.constraintLayout.setOnClickListener { onItemClick(it, user.id) }
    }

    private fun navigateToPaymentPage() {
        val changePage = Intent(context, NavigationActivity::class.java)
        context.startActivity(changePage)
    }

    override fun getItemCount() = userList.size

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)

        (holder as UserListViewHolder)
            .binding.constraintLayout.setOnClickListener(null)
    }

}

private class UserListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding: ItemUserBinding = ItemUserBinding.bind(view)

}

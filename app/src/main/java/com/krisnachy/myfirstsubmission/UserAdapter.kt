package com.krisnachy.myfirstsubmission

import android.content.Context
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class UserAdapter(private val context: Context, private val listUser: ArrayList<User>) : BaseAdapter() {
    override fun getCount(): Int {
        return listUser.size
    }

    override fun getItem(position: Int): Any {
        return listUser[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.user_item, null, true)
        }
        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val ivAvatar: CircleImageView = view.findViewById(R.id.avatar_image)
        private val tvName: TextView = view.findViewById(R.id.tv_name)
        private val tvUsername: TextView = view.findViewById(R.id.tv_username)
        private val tvCompany: TextView = view.findViewById(R.id.tv_company)
        private val tvLocation: TextView = view.findViewById(R.id.tv_location)

        internal fun bind(user: User) {
            user.avatar?.let { ivAvatar.setImageResource(it) }
            tvName.text = user.name
            tvUsername.text = user.username
            tvCompany.text = user.company
            tvLocation.text = user.location
        }
    }

}
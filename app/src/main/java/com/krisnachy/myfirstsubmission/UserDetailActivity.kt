package com.krisnachy.myfirstsubmission

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {

    companion object {
        var EXTRA_DATA = "extra_data"
    }
    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val listUser: User? = intent.getParcelableExtra(EXTRA_DATA)

        dt_avatar.setImageResource(listUser?.avatar!!)
        dt_name.text = listUser.name
        dt_username.text = getString(R.string.username, listUser.username)
        dt_location.text = getString(R.string.location, listUser.location)
        dt_repository.text = getString(R.string.repository, listUser.repository)
        dt_company.text = getString(R.string.company, listUser.company)
        dt_followers.text = getString(R.string.followers, listUser.followers)
        dt_following.text = getString(R.string.following, listUser.following)
    }
}
package com.example.ekse.messaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.splashscreen.R
import com.example.splashscreen.databinding.ActivityChatBinding
import com.example.splashscreen.databinding.ActivityChatFragmentBinding
import com.getstream.sdk.chat.viewmodel.MessageInputViewModel
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel
import io.getstream.chat.android.ui.message.input.viewmodel.bindView
import io.getstream.chat.android.ui.message.list.header.viewmodel.MessageListHeaderViewModel
import io.getstream.chat.android.ui.message.list.header.viewmodel.bindView
import io.getstream.chat.android.ui.message.list.viewmodel.bindView
import io.getstream.chat.android.ui.message.list.viewmodel.factory.MessageListViewModelFactory
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel.Mode.Normal
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel.Mode.Thread
import java.nio.channels.Channel

class MainActivity (chanel_id:String): AppCompatActivity() {

    private lateinit var binding: ActivityChatFragmentBinding
    var id:String=chanel_id

    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_fragment)

        binding = ActivityChatFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // grap cid
        val cid= checkNotNull(intent.getStringExtra(id))
        // Initialize ViewModel
        val viewModelheader: MessageListHeaderViewModel by viewModels {
            MessageListViewModelFactory(id)
        }

// Bind the View and ViewModel
        viewModelheader.bindView(binding.messageListHeaderView, this)

        // 1. Init message model
        val viewModel: MessageListViewModel by viewModels {
            MessageListViewModelFactory(id)
        }

        // 2. Bind view and viewModel
        viewModel.bindView(binding.messageListView, this)

        // Instantiate the ViewModel for a given channel

        val viewModelinput: MessageInputViewModel by viewModels {
            MessageListViewModelFactory(id) }
// Bind it with MessageInputView
        viewModelinput.bindView(binding.messageInputView, this)


    }


}
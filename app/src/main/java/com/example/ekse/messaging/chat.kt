package com.example.ekse.messaging

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.splashscreen.databinding.ActivityChatBinding
import com.example.splashscreen.databinding.ActivityMainBinding
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.client.models.Filters
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.livedata.ChatDomain
import io.getstream.chat.android.ui.channel.list.viewmodel.ChannelListViewModel
import io.getstream.chat.android.ui.channel.list.viewmodel.bindView
import io.getstream.chat.android.ui.channel.list.viewmodel.factory.ChannelListViewModelFactory
import io.getstream.chat.android.ui.channel.list.ChannelListView
class chat : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            // Step 0 - inflate binding
            binding = ActivityChatBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Step 1 - Set up the client for API calls and the domain for offline storage
            val client = ChatClient.Builder("px5vmbddv6vt", applicationContext)
                .logLevel(ChatLogLevel.ALL) // Set to NOTHING in prod
                .build()
            ChatDomain.Builder(client, applicationContext).build()

            // Step 2 - Authenticate and connect the user
            val user = User(
                id = "tshepo9",
                extraData = mutableMapOf(
                    "name" to "Tutorial Droid",

                    ),
            )
            client.connectUser(
                user = user,
                token = client.devToken(user.id)
            ).enqueue()
                //
            // Step 3 - Set the channel list filter and order
            // This can be read as requiring only channels whose "type" is "messaging" AND
            // whose "members" include our "user.id"
        // Instantiate the ViewModel
        val viewModel: ChannelListViewModel by viewModels {
            ChannelListViewModelFactory(
                filter = Filters.and(
                    Filters.eq("type", "messaging"),
                    Filters.`in`("members", listOf(user.id)),
                ),
                sort = ChannelListViewModel.DEFAULT_SORT,
                limit = 30,
            )
        }
// Bind the ViewModel with ChannelListView
        viewModel.bindView(binding.channelListView, this)

        }

}

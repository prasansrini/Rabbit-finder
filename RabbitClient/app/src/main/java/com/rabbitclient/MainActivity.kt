package com.rabbitclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.rabbitclient.ui.theme.RabbitClientTheme
import com.rabbitclient.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			RabbitClientTheme {
				Column(
					modifier = Modifier
						.fillMaxSize()
						.verticalScroll(rememberScrollState())
						.padding(32.dp)
				) {
					val viewModel: MainViewModel = hiltViewModel()
					val rabbit = viewModel.state.value.rabbit
					val isLoading = viewModel.state.value.isLoading

					rabbit?.let {
						Image(painter = rememberAsyncImagePainter(
							model = rabbit.imageUrl,
							imageLoader = ImageLoader
								.Builder(this@MainActivity)
								.apply { placeholder(R.drawable.rabbit4) }
								.crossfade(true)
								.build()),
							contentDescription = "rabbitsimage")

						Spacer(modifier = Modifier.height(8.dp))
						Text(
							text = rabbit.name,
							color = Color.Black,
							fontWeight = FontWeight.Bold,
							fontSize = 20.sp
						)
						Spacer(modifier = Modifier.height(8.dp))
						Text(
							text = rabbit.description,
							color = Color.Black,
						)
						Spacer(modifier = Modifier.height(8.dp))
					}
					Button(
						onClick = viewModel::getRandomRabbit,
						modifier = Modifier.align(
							Alignment.End
						)
					) {
						Text(
							color = Color.Black,
							text = "Next Rabbit"
						)
					}
					Spacer(modifier = Modifier.height(8.dp))
					if (isLoading) {
						CircularProgressIndicator()
					}
				}
			}
		}
	}
}

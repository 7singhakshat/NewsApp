package com.example.newsapp.presentation.screens

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.newsapp.R
import com.example.newsapp.presentation.NewsAppViewModel
import com.example.newsapp.presentation.navigation.Routes.CategoryScreen

//@Preview(showSystemUi = true)
@Composable
fun HomeScreenUI(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: NewsAppViewModel
) {
    val listState = rememberLazyListState()
    val searchTerm = rememberSaveable { mutableStateOf("") }
    val state = viewModel.state.collectAsState()
    val selectedCategory = rememberSaveable { mutableStateOf("") }
    val categoryToSearch = rememberSaveable {
        mutableStateOf(
            arrayListOf(
                "general",
                "sports",
                "technology",
                "business",
                "entertainment",
                "health",
                "science"
            )
        )
    }


    if (state.value.loading == true) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            CircularProgressIndicator()
        }


    } else if (state.value.error.isNullOrBlank().not()) {
        Text(text = state.value.error.toString())
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
            Row {
                OutlinedTextField(modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 5.dp),
                    singleLine = true,
                    shape = RoundedCornerShape(20.dp), value = searchTerm.value, onValueChange = {
                        searchTerm.value = it
                    }, placeholder = { Text(text = "Search") },
                    label = { Text(text = "Search") },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search, contentDescription = null,
                            modifier = modifier.clickable(
                                enabled = searchTerm.value.isNullOrBlank().not(),
                                onClick = { viewModel.getEverything(q = searchTerm.value) }

                            ))
                    })

            }


            Spacer(modifier = modifier.height(10.dp))


            LazyRow(
                modifier = modifier.fillMaxWidth(),
                state = listState
            ) {
                items(categoryToSearch.value) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = if (it == selectedCategory.value) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
                        ),
                        modifier = Modifier
                            .padding(10.dp, 10.dp, 10.dp, 10.dp)
                            .clickable { viewModel.getEverything(q = it)
                                selectedCategory.value=it }){
                        Text(
                            text = it,
                            fontSize = MaterialTheme.typography.labelLarge.fontSize,
                            modifier = modifier.padding(10.dp)
                        )
                    }
                }
            }
            val data = state.value.data
            if (data?.articles!!.isEmpty()) {
                Text(text = "No Data Found")
            } else {

                val articles = data.articles.filter { article ->
                    article.title?.contains("Removed") == false
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(articles) { article ->
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(8.dp)
                            .clickable {
                                navController.navigate(
                                    CategoryScreen(
                                        author = article.author,
                                        content = article.content,
                                        description = article.description,
                                        publishedAt = article.publishedAt,
                                        id = article.source!!.id,
                                        name = article.source.name,
                                        title = article.title,
                                        url = article.url,
                                        urlToImage = article.urlToImage

                                    )
                                )
                            }) {
                            Column {
                                if (article.urlToImage.isNullOrBlank()) {
                                    Image(
                                        painter = painterResource(R.drawable.ic_launcher_foreground),
                                        contentDescription = null
                                    )

                                } else {
                                    AsyncImage(
                                        model = article.urlToImage,
                                        contentDescription = null,
                                        placeholder = painterResource(R.drawable.ic_launcher_background)
                                    )

                                }
                                article.title?.let { Text(text = it) }
                            }
                        }
                    }
                }


            }
        }
    }

}
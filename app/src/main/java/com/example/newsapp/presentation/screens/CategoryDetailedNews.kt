package com.example.newsapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.newsapp.data.model.Article
@Preview(showSystemUi  = true, showBackground = true)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDeatiledNews(modifier: Modifier = Modifier,article: Article=Article()){
Scaffold(
    modifier =Modifier.fillMaxSize(),
    topBar={
        TopAppBar(
            title = {
                Text(text="News App")
            }
        )
    }
){
    Column(modifier=modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier=modifier.height(24.dp))
        Text(text = LoremIpsum(200).values.toString(), fontSize = MaterialTheme.typography.titleLarge.fontSize)
    }
}


}
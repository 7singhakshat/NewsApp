package com.example.newsapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.newsapp.R
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.model.Source

@Preview(showSystemUi  = true, showBackground = true)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDeatiledNews(modifier: Modifier = Modifier,article: Article=Article(
    source = Source(
        id = "bloomberg",
        name = "Bloomberg"
    ),
    author = "Jeannette Neumann",
    title = "Nordstrom Family to Take Company Private in $6.25 Billion Deal - Bloomberg",
    description = "The Nordstrom family is joining forces with a Mexican retailer to take its namesake department store private in an all-cash transaction valued at about $6.25 billion, including debt.",
    url = "https://www.bloomberg.com/news/articles/2024-12-23/nordstrom-family-to-take-company-private-in-6-25-billion-deal",
    urlToImage = "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/in5I.U93E0qg/v0/1200x800.jpg",
    content= "The Nordstrom family is joining forces with a Mexican retailer to take its namesake department store private in an all-cash transaction valued at about $6.25 billion, including debt.\r\nThe founding fa… [+243 chars]"


)){
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
        Text(text = article.title.toString(),
           // fontStyle= FontStyle.Italic,
            style = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight= FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                letterSpacing = 2.sp,
                lineHeight= 24.sp
            )

        )
        Spacer(modifier = modifier.height(24.dp))
        AsyncImage(
            model= article.urlToImage,
            contentDescription=null,
            modifier=modifier.size(300.dp)

        )
    }
}


}
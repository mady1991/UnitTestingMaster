package com.android.android_mvvm_unit_test.adapter

import android.widget.ImageView
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.android.android_mvvm_unit_test.models.ProductListItem
import com.bumptech.glide.Glide


@Composable
fun ProductItem(product: ProductListItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            // Use AndroidView to embed ImageView and load with Glide
            AndroidView(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                factory = { context ->
                    ImageView(context).apply {
                        scaleType = ImageView.ScaleType.CENTER_CROP
                    }
                },
                update = { imageView ->
                    Glide.with(imageView.context)
                        .load(product.image)
                        .into(imageView)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1
            )
        }
    }
}

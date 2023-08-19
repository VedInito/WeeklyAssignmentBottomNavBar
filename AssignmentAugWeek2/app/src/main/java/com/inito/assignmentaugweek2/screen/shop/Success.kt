package com.inito.assignmentaugweek2.screen.shop


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.inito.assignmentaugweek2.data.ProductEntity
import com.inito.assignmentaugweek2.ui.theme.Theme_Color_Dark
import com.inito.assignmentaugweek2.ui.theme.Theme_Color_Light


@Composable
fun Success(
    products: List<ProductEntity>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        item { TopBar() }
        items(products) { ProductCard(it) }
    }
}

@Composable
fun TopBar() {
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Shop",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Theme_Color_Dark
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Cart",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = null,
                tint = Color.DarkGray
            )
        }
    }
}

@Composable
fun ProductCard(product: ProductEntity) {
    Spacer(modifier = Modifier.height(36.dp))
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .height(180.dp),
            model = product.imageUrl,
            contentDescription = null,
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = product.title,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$${product.price}",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Button(
            modifier = Modifier
                .width(120.dp)
                .height(36.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Theme_Color_Dark,
                contentColor = Theme_Color_Light
            ),

            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Add",
                color = Theme_Color_Light
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = product.description,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .width(200.dp)
                .wrapContentWidth(align = Alignment.Start), overflow = TextOverflow.Visible
        )

        Button(
            modifier = Modifier
                .width(120.dp)
                .height(36.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Theme_Color_Dark,
                containerColor = Theme_Color_Light
            ),
            onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, Theme_Color_Dark)
        ) {
            Text("Subscribe")
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20))
            .width(300.dp)
            .height(54.dp)
            .background(color = Color(0xFFEFEFEF)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = product.shippingInfo,
            modifier = Modifier
                .wrapContentWidth(align = Alignment.Start),
            color = Color.DarkGray
        )
    }
    Spacer(modifier = Modifier.height(36.dp))
    Divider()
}


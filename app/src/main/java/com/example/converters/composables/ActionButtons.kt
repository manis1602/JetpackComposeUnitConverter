package com.example.converters.composables

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.converters.ui.theme.Cultured
import com.example.converters.ui.theme.RoseMadder
import com.example.converters.viewmodel.ConverterScreenViewModel

@Composable
fun ActionButtons(
    viewModel: ConverterScreenViewModel,
    converterTypeText: String,
    fromText: String,
    toText: String,
    amount: String,
    onReset: () -> Unit,
    onResultVisibilityChange: (Boolean) -> Unit,
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .weight(1f),
            elevation = ButtonDefaults.elevation(6.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary
            ),
            shape = RoundedCornerShape(10.dp),
            onClick = {
                if (!viewModel.validateFields(converterTypeText, fromText, toText)) {
                    onResultVisibilityChange(true)
                    viewModel.calculateResult(
                        converterType = converterTypeText,
                        convertFrom = fromText,
                        convertTo = toText,
                        amount = if (amount.isNotEmpty()) amount.toDouble() else 1.0
                    )
                } else {
                    Toast.makeText(context, "Please Select All Fields!!", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(
                text = "CONVERT",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick = {
                onResultVisibilityChange(false)
                onReset()
            },
            colors = ButtonDefaults.buttonColors(RoseMadder, Cultured),
            elevation = ButtonDefaults.elevation(6.dp),
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = Icons.Default.Delete,
                contentDescription = "",
                tint = Cultured
            )
        }
    }
}
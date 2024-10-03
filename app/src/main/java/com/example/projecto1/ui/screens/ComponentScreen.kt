package com.example.projecto1.ui.screens

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.coerceAtMost
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import java.time.LocalTime
import java.util.Calendar


@Composable
fun ComponentScreen(navController: NavController) {
    var component by remember { mutableStateOf("") } //Actualiza el valor de la variable
    val drawerSate = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerSate, //current state of drawer
        //drawer content
        drawerContent = {
            ModalDrawerSheet {
                Text(text = "Drawer title", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Content 1") },
                    selected = false,
                    onClick = {
                        component = "Content 1"
                        scope.launch {
                            drawerSate.apply {
                                close()
                            }
                        }
                    }
                )
                //Content2
                NavigationDrawerItem(
                    label = { Text(text = "Content 2") },
                    selected = false,
                    onClick = {
                        component = "Content 2"
                        scope.launch {
                            drawerSate.apply {
                                close()
                            }
                        }
                    }
                )
            }
        }
    ) {

    }
    Column {
        when (component) {
            "Content 1" -> content1()
            "Content 2" -> content2()
        }
    }
}

@Composable
fun content1(){
    Text(text = "Hola 1")
}

@Composable
fun content2(){
    Text(text = "Hola 2")
}

@Preview(showBackground = true)
@Composable
fun Buttons(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.
        fillMaxSize()
    ){
        Button(onClick = {}){
            Text(text = "Filled")
        }
        FilledTonalButton(onClick = {}){
            Text(text = "Tonal")
        }
        OutlinedButton(onClick = {}){
            Text(text = "Outlined")
        }
        ElevatedButton(onClick = {}){
            Text(text = "Elevated")
        }
        TextButton(onClick = {}) {
            Text(text = "Text")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun FloatingButtons() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add,"")
        }
        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add,"")
        }
        LargeFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add,"")
        }
        ExtendedFloatingActionButton(
            onClick = {},
            icon = {Icon(Icons.Filled.Add, "")},
            text = {Text("Extended FAB")}
        )
    }
}
@Preview(showBackground = true)
@Composable
fun Chips() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        AssistChip(
            onClick = {},
            label = { Text(text = "Assist Chips") },
            leadingIcon = {
                Icon(Icons.Filled.AccountBox,"",
                    Modifier.size(AssistChipDefaults.IconSize))
            }
        )
        var selected by remember { mutableStateOf(false)}
        FilterChip(
            selected = selected,
            onClick = {  },
            label = { Text(text = "Filter chip") },
            leadingIcon =
            if (selected) {
                {
                    Icon(
                        Icons.Filled.AccountBox, "",
                        Modifier.size(AssistChipDefaults.IconSize)
                    )
                }
            } else {
                null
            }
        )
    }
}
@Composable
fun InputChipsExample(
    text: String,
    onDismiss: () -> Unit
){
    var enabled by remember { mutableStateOf(true)}
    if (!enabled) return

    InputChip(
        label = { Text(text) },
        selected = enabled,
        onClick = { onDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)

            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }

    )
}

@Composable
fun Progress() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Sliders() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var sliderPosition by remember { mutableStateOf(50f)}
        Column {
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                steps = 10,
                valueRange = 0f..100f
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                text = "Slider position: $sliderPosition"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Switches() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var checked by remember { mutableStateOf(true)}
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
        var checked2 by remember { mutableStateOf(true)}
        Switch(
            checked = checked2,
            onCheckedChange = {
                checked2 = it
            },
            thumbContent = if (checked2) {
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }else{
                null
            }
        )
        var checked3 by remember { mutableStateOf(true)}
        Checkbox(
            checked = checked3,
            onCheckedChange = {
                checked3 = it
            }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun Badges(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        var itemCount by remember { mutableStateOf(0) }
        BadgedBox(
            badge = {
                if (itemCount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text(text = "$itemCount")
                    }
                }
            }
        ){
            Icon(imageVector = Icons.Filled.ShoppingCart,
                contentDescription = ""
            )

        }
        Button(
            onClick = { itemCount++ })
        {
            Text(text = "Add item")

        }


    }
}
//
//@Composable
//fun TimePickerDialog(
//    onTimeSet: (LocalTime) -> Unit,
//    onDismiss: () -> Unit
//) {
//    val context = LocalContext.current
//    val calendar = android.icu.util.Calendar.getInstance()
//    val hour = calendar[android.icu.util.Calendar.HOUR_OF_DAY]
//    val minute = calendar[android.icu.util.Calendar.MINUTE]
//
//    val time = remember {
//        mutableStateOf(
//            com.google.android.libraries.places.api.model.LocalTime.of(
//                hour,
//                minute
//            )
//        )
//    }
//
//    AlertDialog(
//        onDismissRequest = onDismiss,
//        title = { Text("Select Time") }, text = {
//            TimePicker(
//                initialTime = time.value,
//                onTimeChange = { newTime ->
//                    time.value = newTime
//                }
//            )
//        },
//        confirmButton = {
//            Button(onClick = {
//                onTimeSet(time.value)
//                onDismiss()
//            }) {
//                Text("OK")
//            }
//        },
//        dismissButton = {
//            Button(onClick = onDismiss) {
//                Text("Cancel")
//            }
//        }
//    )
//}
//@Preview(showBackground = true)
//@Composable
//fun TimePicker(initialTime: LocalTime, onTimeChange: (LocalTime) -> Unit) {
//    val time =
//        remember { mutableStateOf(initialTime) }
//
//    Column {
//        Row {
//            NumberPicker(
//                value = time.value.hour,
//                onValueChange = { newHour ->
//                    time.value = time.value.withHour(newHour)
//                    onTimeChange(time.value)
//                },
//                range = 0..23
//            )
//            Text(":")
//            NumberPicker(
//                value = time.value.minute, onValueChange = { newMinute ->
//                    time.value = time.value.withMinute(newMinute)
//                    onTimeChange(time.value)
//                },
//                range = 0..59
//            )
//        }
//    }
//}
//
//@Composable
//fun NumberPicker(value: Int, onValueChange: (Int) -> Unit, range: IntRange) {
//    var selectedValue by remember {
//        mutableStateOf(
//            value
//        )
//    }
//
//    Column {
//        IconButton(onClick = {
//            selectedValue = (selectedValue + 1).coerceAtMost(range.last)
//            onValueChange(selectedValue)
//        }) {
//            Icon(
//                Icons.Filled.KeyboardArrowUp,
//                contentDescription = "Increase"
//            )
//        }
//        Text(
//            selectedValue.toString(),
//            textAlign = TextAlign.Center
//        )
//        IconButton(onClick = {
//            selectedValue = (selectedValue - 1).coerceAtLeast(range.first)
//            onValueChange(selectedValue)
//        }) {
//            Icon(
//                Icons.Filled.KeyboardArrowDown,
//                contentDescription = "Decrease"
//            )
//        }
//    }
//}
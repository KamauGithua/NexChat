package com.kamau.nexchat.feature.auth.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kamau.nexchat.R

@Composable
fun SignUpScreen(navController: NavController){
    var email by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirm by remember {
        mutableStateOf("")
    }
    Scaffold(modifier = Modifier
        .fillMaxSize())
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(it)
            .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.White)
            )
            OutlinedTextField(value = name,
                onValueChange ={ name = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Full Name") })
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(value = email,
                onValueChange ={ email = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email") })
            Spacer(modifier = Modifier.size(16.dp))

            OutlinedTextField(value = password,
                onValueChange ={password = it },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                label = { Text(text = "Password") }
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(value = confirm,
                onValueChange ={confirm = it },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                isError = password.isNotEmpty() &&  confirm.isNotEmpty() && password != confirm,
                label = { Text(text = " Confirm Password") }
            )
            Spacer(modifier = Modifier.size(16.dp))
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(),
                enabled = name.isNotEmpty() && email.isNotEmpty() && confirm.isNotEmpty() && password == confirm
            ) {
                Text(text = "Sign Up")
            }
            TextButton(onClick = { navController.popBackStack()}) {
                Text(text = "Already have an account? Sign In")
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen(){
    SignUpScreen(navController = rememberNavController ())

}
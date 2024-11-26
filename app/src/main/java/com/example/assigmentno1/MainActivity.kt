package com.example.myapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import android.util.Patterns
import com.example.assigmentno1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        val nameInput: TextInputLayout = findViewById(R.id.textInputLayoutName)
        val contactInput: TextInputLayout = findViewById(R.id.textInputLayoutContact)
        val emailInput: TextInputLayout = findViewById(R.id.textInputLayoutEmail)
        val passwordInput: TextInputLayout = findViewById(R.id.textInputLayoutPassword)
        val addressInput: TextInputLayout = findViewById(R.id.textInputLayoutAddress)
        val submitButton: Button = findViewById(R.id.submitButton)

        // Handle Submit Button Click
        submitButton.setOnClickListener {
            // Clear previous error messages
            nameInput.error = null
            contactInput.error = null
            emailInput.error = null
            passwordInput.error = null
            addressInput.error = null

            // Get input values
            val name = nameInput.editText?.text.toString()
            val contact = contactInput.editText?.text.toString()
            val email = emailInput.editText?.text.toString()
            val password = passwordInput.editText?.text.toString()
            val address = addressInput.editText?.text.toString()

            // Validate Name
            if (name.isBlank()) {
                nameInput.error = "Name is required"
            }

            // Validate Contact
            if (contact.isBlank()) {
                contactInput.error = "Contact is required"
            } else if (contact.length != 10) {
                contactInput.error = "Phone number must be 10 digits"
            }

            // Validate Email
            if (email.isBlank()) {
                emailInput.error = "Email is required"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.error = "Enter a valid email"
            }

            // Validate Password
            if (password.isBlank()) {
                passwordInput.error = "Password is required"
            }

            // Validate Address
            if (address.isBlank()) {
                addressInput.error = "Address is required"
            }

            // If no errors, show a success message
            if (name.isNotBlank() && contact.length == 10 && Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                password.isNotBlank() && address.isNotBlank()) {
                Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

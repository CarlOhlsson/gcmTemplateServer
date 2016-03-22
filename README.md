# What is it?
This program will send ONE simple GCM message to your app providing you followed the setup guide below. It supports both topic and device unique messages.

This program was created by modifying Google's own startup template that can be found by following the link below.
https://developers.google.com/cloud-messaging/android/start

# Please note
This is not a server, only a program that is requerd to be run each time you want to send a message. The only function for this program is to test your app while under development.

# Setup
1: Find your api key in your google developer enviroment and put this in the API_KEY variable.

https://console.developers.google.com/


2: Enter the topic your app is listening to or the devices token

Example topic: /topics/Foo

Example token: xxxxxxx:xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

3: Make sure you are using the JSONObject library

Can be easaly downloaded with Maven in IntelliJ.

Project Structure -> Libraries -> New - From Maven ... -> Enter: org.json:json:20140107 -> OK

package com.example.app

import org.scalatra._

class MyScalatraServlet extends Scala_demoStack {

  get("/") {
    {"hello"}
  }

   get("/scala/square/:number") {
   	val number = params("number")
   	val num = number.toInt
   	val square = num * num
   	val statement = "Square of " + number + " is " + square.toString + "\n";
   	{statement}
   }
}

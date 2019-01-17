package com.sxg

import akka.actor.{Actor, ActorSystem, Props}

object AkkaDemo {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("Demo")
    val teacher = system.actorOf(Props[Teacher],"teacher")
    teacher ! "start"
  }
}


class Student extends Actor{
  override def receive:Receive = {
    case "class begin" => {
      println("student say: good morning,teacher")
      sender ! "good morning,teacher"
    }
  }
}

class Teacher extends Actor{

  val student = context.actorOf(Props[Student], "student")

  override def receive:Receive = {
    case "start" => {
      println("teacher say: class begin")
      student ! "class begin"
    }
    case "good morning,teacher" => {
      println("teacher say:ok")
    }

  }
}
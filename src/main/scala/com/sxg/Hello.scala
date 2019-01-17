package com.sxg

import akka.actor.{Actor, Props}


class Hello extends Actor {

  override def receive={
    case "hello" => {
      val listener = context.actorOf(Props[MessageListener],"listener");
      listener ! "hello"
      println("hello")
    }
    case "bye" => {
      println("bye")
    }
  }
}
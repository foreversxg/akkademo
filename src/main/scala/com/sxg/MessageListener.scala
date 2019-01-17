package com.sxg

import akka.actor.Actor

class MessageListener extends Actor{

  override def receive = {
    case "hello" => {
      println("listener hello")
    }
    case _ => {
      println("nothing")
    }
  }
}

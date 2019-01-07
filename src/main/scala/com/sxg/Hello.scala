package com.sxg

import akka.actor.Actor


class Hello extends Actor {

  override def receive={
    case "hello" => {
      println("hello")
    }
    case "bye" => {
      println("bye")
    }
  }
}
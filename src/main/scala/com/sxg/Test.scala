package com.sxg

import akka.actor.{Actor, ActorSystem, Props}


object Test {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("HelloSystem")
    val ha = system.actorOf(Props[Hello], name = "hello")
    ha ! "hello"
    system.terminate();
  }

}


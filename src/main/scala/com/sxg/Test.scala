package com.sxg

import akka.actor.{Actor, ActorSystem, Props}


object Test {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("Demo")
    val first = system.actorOf(Props[StartStopActor1], "first")
    first ! "stop"
    system.terminate();
  }

}


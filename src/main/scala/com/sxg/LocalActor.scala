package com.sxg

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import akka.util.Timeout
import com.typesafe.config.ConfigFactory

class LocalActor extends Actor{

//  val path = ConfigFactory.defaultApplication().getString("akka.tcp://RemoteDemoSystem@127.0.0.1:2552/user/RemoteActor")
//val remoteActor = context.actorOf(Props["akka.tcp://RemoteDemoSystem@127.0.0.1:2552/user/RemoteActor"])
//  implicit val timeout = Timeout(4.seconds)

  //远程Actor
  var remoteActor : ActorSelection = null

  @throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    remoteActor = context.actorSelection("akka.tcp://RemoteDemoSystem@127.0.0.1:2552/user/RemoteActor")
    println("远程服务端地址 : " + remoteActor)
  }

  def receive: Receive = {
    case "one" => "init local actor"
    case "two" => {
      remoteActor ! "hello remote actor"
    }
  }
}

object LocalDemo extends App {

  implicit val system = ActorSystem("LocalDemoSystem")
  val localActor = system.actorOf(Props[LocalActor], name = "LocalActor")

//  localActor ! "one"
  localActor ! "two"
}

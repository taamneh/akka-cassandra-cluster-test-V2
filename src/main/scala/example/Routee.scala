package example

import akka.actor.{PoisonPill, Props, Actor}
import akka.event.Logging

class Routee extends Actor {

  val log = Logging(context.system, this)
  def receive = {
    case i : Int => {
	   println("Recieved something wallah............ClusterTest2")
      log.error(s"${self.path} routing a calculation of $i")
      context.actorOf(Props[FactorialCalculator]) ! i
    }
    case _ =>     case _ => log.error(s"${self.path.address} received unknown message")

  }
}

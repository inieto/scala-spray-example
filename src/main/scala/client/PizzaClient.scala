package client

import spray.httpx.{SprayJsonSupport, RequestBuilding}
import akka.actor.ActorSystem

object PizzaClient extends App with RequestBuilding with SprayJsonSupport {
   import api.Pizza
   import api.PizzaProtocol._
   import spray.client.pipelining._
   import system.dispatcher

   implicit val system = ActorSystem("client-example")
   val pizzaClient = sendReceive ~> unmarshal[Pizza]
   val f = pizzaClient(Get("http://localhost:9290/pizza"))

   f onComplete(println)   //Ojo que onComplete es bloqueante
   //Success(Pizza(napo,muza))
 }

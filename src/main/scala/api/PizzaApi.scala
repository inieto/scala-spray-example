package api

import akka.actor.ActorSystem
import spray.httpx.SprayJsonSupport
import spray.json.DefaultJsonProtocol
import spray.routing.SimpleRoutingApp

case class Pizza(name: String, cheese: String)

object PizzaProtocol extends DefaultJsonProtocol {
  implicit val pizzaJsonProtocol = jsonFormat2(Pizza)
}

object PizzaApi extends App with SimpleRoutingApp with SprayJsonSupport{

  import PizzaProtocol._
  implicit val system = ActorSystem("spray-example")

  val getRoute =
    get {
      path("pizza") {
        complete {
          Pizza("napo","muza")
        }
      }
    }

  val postRoute =
    post {  //POST {"name": "parmesano","cheese": "parmesano"}
      entity(as[Pizza]) { pizza =>
        complete {
          "Post de: " + pizza.cheese + " name: " + pizza.name
        }
      }
    }

  startServer(interface="0.0.0.0", port = 9290) {
     getRoute ~ postRoute
  }
}

package api

import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp

object SimpleApi extends App with SimpleRoutingApp {

  implicit val system = ActorSystem("spray-example")

  startServer(interface="0.0.0.0", port = 9290) {

    get {
      path("test") {    //http://localhost:9290/test
        complete {
          "Ok desde Spray!"
        }
      } ~               //"~" concatena directivas
      path("other") {
        complete("Uhhhhhh")
      } ~
      path("unique" / IntNumber) { index =>   //http://localhost:9290/unique/{NBR}
        // pasa a ser una función que recibe un index y completa con el cuerpo de la directiva
        complete {
          "Unique ID: " + index
        }
      } ~
      path("querystring") {
        parameters('age.as[Int]) { age =>
          complete {
            "age: " + age
          }
        } ~
        parameters('optional.as[Int] ? 12345) { optional =>
          complete {
            "optional: " + optional
          }
        }
      }
    } ~
    post {
      complete {
        "Posteaste algo"
      }
    }
  }
}

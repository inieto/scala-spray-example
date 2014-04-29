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
      }
    } ~
    post {
      complete {
        "Posteaste algo"
      }
    }
  }

//  startServer(interface="0.0.0.0", port = 9291) {

//  }
}

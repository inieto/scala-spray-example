package client

import spray.httpx.RequestBuilding
import akka.actor.ActorSystem

object SprayClientExample extends App with RequestBuilding {

  import spray.client.pipelining._
  import system.dispatcher

  implicit val system = ActorSystem("client-example")
  val pipeline = sendReceive
  val f = pipeline(Get("http://localhost:9290/test"))

  f onComplete(println)   //Ojo que onComplete es bloqueante
  //Success(HttpResponse(200 OK,HttpEntity(text/plain; charset=UTF-8,Ok desde Spray!),List(Content-Length: 15, Content-Type: text/plain; charset=UTF-8, Date: Tue, 29 Apr 2014 22:07:11 GMT, Server: spray-can/1.3.1),HTTP/1.1))
}

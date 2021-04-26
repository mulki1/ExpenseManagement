//import akka.actor.ActorSystem
//import akka.actor.typed.Behavior
//import akka.http.scaladsl.Http
//import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
//import akka.http.scaladsl.server.Route
//import akka.http.scaladsl.server.Directives._
//
//import java.util.UUID
//
//case class Person(name:String, age: Int)
//case class UserAdded(name:String, time: Long)
//
//import spray.json
//import spray.json.DefaultJsonProtocol
//trait PersonJsonProtocol extends  DefaultJsonProtocol{
//  implicit val  personFormat = jsonFormat2(Person)
//  implicit val  userAddedFormat = jsonFormat2(UserAdded)
//}
//
//object Demo extends PersonJsonProtocol with SprayJsonSupport{
//
//
//  implicit  val system = ActorSystem("AkkaJson")
//  val route : Route = (path("api"/"user") & post)
//  {
//    entity(as[Person]) {person:Person =>
//      complete(UserAdded(UUID.randomUUID().toString,System.currentTimeMillis()))
//    }
//  }
//
//  def main(args: Array[String]): Unit = {
//    Http().newServerAt("localhost",8081).bind(route)
//  }
//
//
//}
//
//
//

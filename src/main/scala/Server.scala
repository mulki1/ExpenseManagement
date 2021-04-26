import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import  akka.http.scaladsl.Http.ServerBinding


import scala.concurrent.{ExecutionContext, Future}

class Server (route: Router,host : String, port : Int)(implicit system: ActorSystem , ex:ExecutionContext){
  def bind():Future[ServerBinding] = Http().newServerAt(host,port).bind(route.route)
}

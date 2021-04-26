import akka.actor.ActorSystem
import scala.util.{Failure, Success}
import scala.concurrent.Await

object main extends App {
  val host = "0.0.0.0"
  val port = 9000

  implicit val system = ActorSystem(name = "expenseApi")

  import system.dispatcher

  val expenseRepository = new ExpenseRepository
  val router = new ExpensesRouter(expenseRepository)
  val server = new Server(router, host, port)

  val binding = server.bind()
  binding.onComplete {
    case Success(_) => println("Success")
    case Failure(error) => println(s"Failed: ${error.getMessage}")
  }

  import scala.concurrent.duration._

  Await.result(binding, 3.seconds)

}

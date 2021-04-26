import akka.http.scaladsl.server.{Directives, Route}
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.auto._
import models.{Expenses, NewExpense, UpdateExpense}
import java.util.UUID


trait Router {
  def route: Route
}

class ExpensesRouter(expenseRepository: ExpenseRepository) extends Router with Directives {

  override def route: Route =
    concat(
      path("api" / "expenses") {
        get {
          var result = expenseRepository.getAllExpenses

          if (result != null)
            complete(result)
          else
            complete("done")
        }
      },
      path("api" / "addExpense") {
        post {
          entity(as[NewExpense]) { newExpense =>
            val expense = Expenses(
              UUID.randomUUID().toString,
              newExpense.title,
              newExpense.value,
              newExpense.reason,
              System.currentTimeMillis(),
              false
            )
            complete(expenseRepository.addExpenses(expense))
          }
        }
      },
      path("api" / "updateExpense") {
        post {
          entity(as[UpdateExpense]) { updateExpense =>
            val expense = Expenses(
              updateExpense.id,
              updateExpense.title,
              updateExpense.value,
              updateExpense.reason,
              System.currentTimeMillis(),
              false
            )
            complete(expenseRepository.updateExpenses(expense))
          }
        }
      },
      path("api" / "getExpenseById" / Segment) { id =>
        get {
          complete(expenseRepository.getExpenseById(id))
        }
      }
    )


}
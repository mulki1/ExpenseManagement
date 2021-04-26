import models.{NewExpense, Expenses}
import io.getquill._


class ExpenseRepository extends DbContext {

  import ctx._

 private val expenses: Quoted[EntityQuery[Expenses]] = quote(querySchema[Expenses]("expenses"))

  def getAllExpenses: List[Expenses] = run(expenses)
  def addExpenses(expense: Expenses) = run(expenses.insert(lift(expense)))
  def getExpenseById(id : String) = run(expenses.filter(f=> f.id ==id))
  def updateExpenses(expense: Expenses) = run(expenses.update(lift(expense)))
}

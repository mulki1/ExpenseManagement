package models
case class Expenses(id: String, title: String, value : Double, reason : String, date: Long, isDeleted : Boolean)
case class NewExpense(title: String, value : Double, reason : String)
case class UpdateExpense(id: String, title: String, value : Double, reason : String, date: Long)

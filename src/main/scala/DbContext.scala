import io.getquill.{SnakeCase, SqliteJdbcContext}

trait DbContext {
  lazy val ctx = new SqliteJdbcContext(SnakeCase, "ctx")

}

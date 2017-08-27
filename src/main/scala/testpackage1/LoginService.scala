package testpackage1

/**
  * Created by aschwartz on 1/11/16.
  */
// a very simple User class
case class User(name: String)

// a LoginService must have a 'login' method
trait LoginService {
  def login(name: String, password: String): Option[User] = {
    Some(User("Anders"))
  }
}

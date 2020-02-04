import java.util.concurrent.atomic.AtomicReference
import java.util.function.UnaryOperator

trait BankAccount {
  def closeAccount(): Unit

  def getBalance: Option[Int]

  def incrementBalance(increment: Int): Option[Int]
}

object Bank {
  def openAccount(): BankAccount = new BankAccount {
    val balance: AtomicReference[Option[Int]] = new AtomicReference(Some(0))

    override def closeAccount(): Unit = balance.set(None)

    override def getBalance: Option[Int] = balance.get()

    override def incrementBalance(increment: Int): Option[Int] = balance.updateAndGet(new UnaryOperator[Option[Int]] {
      override def apply(t: Option[Int]): Option[Int] = t.map(_ + increment)
    })
  }
}
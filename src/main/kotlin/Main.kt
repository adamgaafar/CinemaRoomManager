fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    val total = rows * seats
    var ticketCount: Int = 0
    var currIncome = 0
    var percent = 0.0
    println("1. Show the seats")
    println("2. Buy a ticket")
    println("3. Statistics")
    println("0. Exit")
    var choice = readln().toInt()

    val cinemaRoom = MutableList(rows) {
        MutableList(seats) {
            "S"
        }
    }

    while (choice != 0) {
        when (choice) {
            1 -> {
                showCinema(rows, seats, cinemaRoom)
                println("1. Show the seats")
                println("2. Buy a ticket")
                println("3. Statistics")
                println("0. Exit")
                choice = readln().toInt()

            }
            2 -> {
                println("Enter a row number:")
                val rowss = readln().toInt()
                println("Enter a seat number in that row:")
                val seatss = readln().toInt()

                try {
                    if (cinemaRoom[rowss - 1][seatss - 1] == "S") {
                        cinemaRoom[rowss - 1][seatss - 1] = "B"

                        ticketCount++

                        percent = (ticketCount.toDouble() / total.toDouble()) * 100
                        currIncome += if (total <= 60) {
                            println("Ticket price: \$10")
                            10
                        } else {
                            val id = rows / 2
                            println(id)
                            if (rowss in 0..id) {
                                println("Ticket price: \$10")
                                10
                            } else {
                                println("Ticket price: \$8")
                                8
                            }

                        }

                        println("1. Show the seats")
                        println("2. Buy a ticket")
                        println("3. Statistics")
                        println("0. Exit")
                        choice = readln().toInt()

                    } else {
                        println("That ticket has already been purchased!")
                        choice = 2
                    }
                } catch (e: Exception) {
                    println("Wrong input!")
                }

            }
            3 -> {
                println("Number of purchased tickets: ${ticketCount}")
                println("Percentage: ${"%.2f".format(percent)}%")
                println("Current income: \$${currIncome}")
                if (total <= 60) {
                    println("Total income: \$${total * 10}")
                } else {
                    val frontSeatPrice = (rows / 2) * seats * 10
                    val backSeatPrice = (rows - (rows / 2)) * seats * 8
                    println("Total income: \$${frontSeatPrice + backSeatPrice}")
                }
                println("1. Show the seats")
                println("2. Buy a ticket")
                println("3. Statistics")
                println("0. Exit")
                choice = readln().toInt()
            }
        }
    }
    println("")
}

fun showCinema(row: Int, seat: Int, cinemaRoom: MutableList<MutableList<String>>) {
    println("Cinema:")
    print(" ")
    for (x in 1..seat) {
        print(" $x")
    }
    println()
    for (y in 0 until row) {
        println("${y + 1} ${cinemaRoom[y].joinToString(" ")}")
    }
}
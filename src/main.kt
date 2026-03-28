fun main() {

    // Criando os pilotos
    val piloto1 = Piloto("Huilson", 39, 9)
    val piloto2 = Piloto("Cleiton", 26, 10)
    val piloto3 = Piloto("Rodirgo", 51, 7)

    // Criando os carros (marca, piloto, vel, acel, freio, tanque, consumo, resistencia)
    val carro1 = Carro("Mercedes", piloto1, 80, 8, 3, 50.0, 5.0, 8)
    val carro2 = Carro("Red Bull", piloto2, 85, 9, 4, 50.0, 6.0, 9)
    val carro3 = Carro("Ferrari", piloto3, 75, 7, 5, 20.0, 8.0, 3)

    // Colocando os carros no Grid de largada
    val gridDeLargada = listOf(carro1, carro2, carro3)

    // Criando a pista
    val interlagos = Pista(gridDeLargada, 5, "Chuvoso")

    // Dando a bandeirada (A mágica acontece aqui!)
    interlagos.iniciarCorrida()
}
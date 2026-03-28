// O Carro herda ( : ) de Veiculo. Ele tem tudo que o pai tem, mais os atributos dele.
class Carro(
    marca: String,
    val piloto: Piloto,
    val velocidade: Int,
    val aceleracao: Int,
    val freio: Int,
    tanque: Double,
    consumo: Double,
    val resistencia: Int // Nota de 1 a 10 para ver se quebra fácil
) : Veiculo(marca, tanque, consumo) {

    // A "distância" vai servir como os pontos do carro para definir a posição
    var distanciaTotal = 0

    // POLIMORFISMO na prática: reescrevendo a função da classe pai
    override fun gastarCombustivel() {
        super.gastarCombustivel() // Faz o que o pai já faz (diminuir o tanque)
        if (!naCorrida && tanque <= 0) {
            println("   -> Ixi! O carro do ${piloto.nome} ficou sem gasolina e saiu da corrida!")
        }
    }

    // Função que calcula o desempenho do carro em uma única volta
    fun correrVolta(clima: String) {
        if (!naCorrida) return // Se já saiu da corrida, nem tenta

        gastarCombustivel()

        if (naCorrida) {
            // A fórmula da corrida: mistura os atributos do carro e a habilidade do piloto
            var desempenho = (velocidade + aceleracao + piloto.habilidade) - freio

            // Adiciona um fator sorte (emoção da corrida!)
            val sorte = (1..5).random()
            desempenho += sorte

            // Se o clima for chuvoso e a resistência do carro for baixa, pode dar ruim
            if (clima == "Chuvoso" && resistencia < 5) {
                val chanceDeQuebrar = (1..10).random()
                if (chanceDeQuebrar > 8) { // 20% de chance de quebrar na chuva
                    naCorrida = false
                    println("   -> VIXI! O carro do ${piloto.nome} derrapou na chuva e quebrou!")
                    return
                }
            }

            // Soma o desempenho da volta na pontuação total
            distanciaTotal += desempenho
        }
    }
}
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Aluno ${usuario.nome} matriculado na formação ${this.nome}")
       
    }
}

fun Formacao.listCursos(){
   
    println()
    println("Curso: ${this.nome}")
    println("Conteudos: ")
        
    this.conteudos.forEach{ conteudo ->
        println("${conteudo.nome} -> ${conteudo.duracao} -> ${conteudo.nivel} ")            
    }
}

fun Formacao.listMatriculados(){
    
    println("MATRICULADOS em ${this.nome} ")

    this.inscritos.forEach{ user ->
         println("${user.nome}")
    }
}

fun main() {
    
    val conteudoList = listOf(
        ConteudoEducacional("conteudo 1", 30, Nivel.BASICO),
        ConteudoEducacional("conteudo 2", nivel= Nivel.DIFICIL),
		ConteudoEducacional("conteudo 2", 120, Nivel.INTERMEDIARIO)
    )
    
    val usuario = Usuario("Manteus")
    val usuario1 = Usuario("Marcos")
    val usuario2 = Usuario("João")
    val usuario3 = Usuario("Maria")
    val formacao1 = Formacao("Kotlin", conteudoList)
    val formacao2 = Formacao("java", conteudoList)

    formacao1.matricular(usuario)
    formacao1.matricular(usuario1)
    
    formacao2.matricular(usuario2)
    formacao2.matricular(usuario3)

    
    formacao1.listCursos()
    println()
	formacao1.listMatriculados()
    println()

    formacao2.listCursos()
    println()
	formacao2.listMatriculados()
   
    
    
   //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}

package space.basyk.numbers.models.randomtrivia

data class RandomTrivia(
    val found: Boolean,
    val number: Int,
    val text: String,
    val type: String
)
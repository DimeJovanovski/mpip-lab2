package mk.ukim.finki.mpip.domain.model

import kotlin.random.Random

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val director: String,
    val actors: List<String>
) {
    // secondary constructor, excludes the manual input of 'id',
    // it is randomly generated
    constructor(
        title: String,
        description: String,
        director: String,
        actors: List<String>
    ) : this(
        id = generateRandomId(),
        title = title,
        description = description,
        director = director,
        actors = actors
    )

    // function to generate a random ID
    private companion object {
        fun generateRandomId(): Int {
            return Random.nextInt(100, 1000)
        }
    }
}
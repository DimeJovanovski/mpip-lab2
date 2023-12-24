package mk.ukim.finki.mpip.data

import mk.ukim.finki.mpip.domain.model.Movie

class FakeApiProvider {
    companion object {
        @Volatile
        private var INSTANCE: FakeApi? = null

        @JvmStatic
        fun getFakeApi(): FakeApi {
            return INSTANCE ?: synchronized(this) {
                val instance = createFakeApi()
                INSTANCE = instance
                instance
            }
        }

        private fun createFakeApi(): FakeApi {
            val movies = FakeApi()

            movies.addMovie(
                Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.",
                "Christopher Nolan",
                listOf("Leonardo DiCaprio", "Ellen Page", "Tom Hardy", "Ken Watanabe"))
            )

            movies.addMovie(
                Movie("Good Will Hunting", "Will Hunting, a janitor at M.I.T., has a gift for mathematics, but needs help from a psychologist to find direction in his life.",
                "Gus Van Sant",
                listOf("Matt Damon", "Robin Williams", "Ben Affleck", "Stellan Skarsgard"))
            )

            movies.addMovie(
                Movie("Catch Me If You Can", "Barely 21 yet, Frank is a skilled forger who has passed as a doctor, lawyer and pilot. FBI agent Carl becomes obsessed with tracking down the con man, who only revels in the pursuit.",
                "Steven Spielberg",
                listOf("Leonardo DiCaprio", "Tom Hanks", "Christopher Walken"))
            )

            movies.addMovie(
                Movie("Forrest Gump", "The history of the United States from the 1950s to the '70s unfolds from the perspective of an Alabama man with an IQ of 75, who yearns to be reunited with his childhood sweetheart.",
                "Robert Zemeckis",
                listOf("Tom Hanks", "Robin Wright", "Gary Sinise"))
            )

            movies.addMovie(
                Movie("A Beautiful Mind", "After John Nash, a brilliant but asocial mathematician, accepts secret work in cryptography, his life takes a turn for the nightmarish.",
                "Ron Howard",
                listOf("Russell Crowe", "Ed Harris", "Jennifer Connelly"))
            )

            movies.addMovie(
                Movie("Ford v Ferrari", "American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at the 24 Hours of Le Mans in 1966.",
                "James Mangold",
                listOf("Matt Damon", "Christian Bale", "Jon Bernthal", "Josh Lucas"))
            )

            movies.addMovie(
                Movie("The Intouchables", "After he becomes a quadriplegic from a paragliding accident, an aristocrat hires a young man from the projects to be his caregiver.",
                "Olivier Nakache",
                listOf("Francois Cluzet", "Omar Sy"))
            )

            movies.addMovie(
                Movie("Fight Club", "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.",
                "David Fincher",
                listOf("Brad Pitt", "Edward Norton", "Helena Bonham Carter"))
            )

            movies.addMovie(
                Movie("Wonka", "With dreams of opening a shop in a city renowned for its chocolate, a young and poor Willy Wonka discovers that the industry is run by a cartel of greedy chocolatiers.",
                "Paul King",
                listOf("Timothee Chalamet", "Gustave Die", "Murray McArthur", "Paul G. Raymond", "Isy Suttie", "Bertie Caplan"))
            )

            return movies
        }
    }
}
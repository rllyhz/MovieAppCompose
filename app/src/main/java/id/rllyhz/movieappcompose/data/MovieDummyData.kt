package id.rllyhz.movieappcompose.data

import id.rllyhz.movieappcompose.data.model.Movie

fun getAllMovies(): List<Movie> {
    val movies = arrayListOf<Movie>()

    with(movies) {
        add(
            Movie(
                id = 1,
                title = "Black Adam (2022)",
                genres = listOf("Action", "Fantasy", "Science Fiction"),
                duration = "2h 5m",
                releasedAt = "Oct 19, 2022",
                overview = "Nearly 5,000 years after he was bestowed with the almighty powers of the Egyptian gods—and imprisoned just as quickly—Black Adam is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world",
                director = "Jaume Collet-Serra",
                rating = 7.3f
            )
        )

        add(
            Movie(
                id = 2,
                title = "Paradise City (2022)",
                genres = listOf("Crime", "Action", "Thriller"),
                duration = "1h 33m",
                releasedAt = "Nov 11, 2022",
                overview = "Renegade bounty hunter Ryan Swan must carve his way through the Hawaiian crime world to wreak vengeance on the kingpin who murdered his father",
                director = "Chuck Russell",
                rating = 5.6f
            )
        )

        add(
            Movie(
                id = 3,
                title = "Black Panther: Wakanda Forever (2022)",
                genres = listOf("Action", "Adventure", "Science Fiction"),
                duration = "2h 42m",
                releasedAt = "Nov 09, 2022",
                overview = "Queen Ramonda, Shuri, M’Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King T’Challa’s death. As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia and Everett Ross and forge a new path for the kingdom of Wakanda",
                director = "Ryan Coogler",
                rating = 5.6f
            )
        )

        add(
            Movie(
                id = 4,
                title = "Emily the Criminal (2022)",
                genres = listOf("Crime", "Drama", "Mystery", "Thriller"),
                duration = "1h 37m",
                releasedAt = "Aug 12, 2022",
                overview = "Emily, who is saddled with student debt and locked out of the job market due to a minor criminal record, gets involved in a credit card scam that pulls her into the criminal underworld of Los Angeles, ultimately leading to deadly consequences",
                director = "John Patton Ford",
                rating = 6.9f
            )
        )

        add(
            Movie(
                id = 5,
                title = "Disenchanted (2022)",
                genres = listOf("Comedy", "Family", "Fantasy"),
                duration = "2h",
                releasedAt = "Nov 16, 2022",
                overview = "Disillusioned with life in the city, feeling out of place in suburbia, and frustrated that her happily ever after hasn’t been so easy to find, Giselle turns to the magic of Andalasia for help. Accidentally transforming the entire town into a real-life fairy tale and placing her family’s future happiness in jeopardy, she must race against time to reverse the spell and determine what happily ever after truly means to her and her family",
                director = "Adam Shankman",
                rating = 7.4f
            )
        )

        add(
            Movie(
                id = 6,
                title = "Sniper: The White Raven (2022)",
                genres = listOf("Drama", "Action", "War"),
                duration = "2h",
                releasedAt = "May 03, 2022",
                overview = "Mykola is an eccentric pacifist who wants to be useful to humanity. When the war begins at Donbass, Mykola’s naive world is collapsing as the militants kill his pregnant wife and burn his home to the ground. Recovered, he makes a cardinal decision and gets enlisted in a sniper company. Having met his wife’s killers, he emotionally breaks down and arranges “sniper terror” for the enemy. He’s saved from a senseless death by his instructor who himself gets mortally wounded. The death of a friend leaves a “scar” and Mykola is ready to sacrifice his life",
                director = "Marian Bushan",
                rating = 7.5f
            )
        )

        add(
            Movie(
                id = 7,
                title = "Medieval (2022)",
                genres = listOf("History", "Drama", "Action"),
                duration = "2h 6m",
                releasedAt = "Sep 08, 2022",
                overview = "The story of 14th century Czech icon and warlord Jan Zizka who defeated armies of the Teutonic Order and the Holy Roman Empire",
                director = "Petr Jákl",
                rating = 7.3f
            )
        )

        add(
            Movie(
                id = 8,
                title = "Smile (2022)",
                genres = listOf("Horror", "Mystery", "Thriller"),
                duration = "1h 55m",
                releasedAt = "Sep 23, 2022",
                overview = "After witnessing a bizarre, traumatic incident involving a patient, Dr. Rose Cotter starts experiencing frightening occurrences that she can't explain. As an overwhelming terror begins taking over her life, Rose must confront her troubling past in order to survive and escape her horrifying new reality",
                director = "Parker Finn",
                rating = 6.8f
            )
        )

        add(
            Movie(
                id = 9,
                title = "The Woman King (2022)",
                genres = listOf("Action", "Drama", "History"),
                duration = "2h 15m",
                releasedAt = "Sep 15, 2022",
                overview = "The story of the Agojie, the all-female unit of warriors who protected the African Kingdom of Dahomey in the 1800s with skills and a fierceness unlike anything the world has ever seen, and General Nanisca as she trains the next generation of recruits and readies them for battle against an enemy determined to destroy their way of life",
                director = "Gina Prince-Bythewood",
                rating = 7.9f
            )
        )

        add(
            Movie(
                id = 10,
                title = "The Soccer Football Movie (2022)",
                genres = listOf("Animation", "Comedy", "Family"),
                duration = "1h 14m",
                releasedAt = "Nov 09, 2022",
                overview = "When mysterious green slime monsters start popping out of soccer balls, all-star athletes Zlatan Ibrahimović and Megan Rapinoe must team up with their four biggest fans to stop evil scientist \"Weird Al\" Yankovic from stealing their talent",
                director = "Mitch Schauer",
                rating = 7.0f
            )
        )

        add(
            Movie(
                id = 11,
                title = "Tom and Jerry Snowman's Land (2022)",
                genres = listOf("Family", "Comedy", "Animation", "Adventure"),
                duration = "1h 16m",
                releasedAt = "Sep 06, 2022",
                overview = "It’s time to chase that holiday spirit with Tom and Jerry! With magic in the air, Jerry and his nephew, Tuffy, make a snow mouse that miraculously comes to life! To keep their new friend, Larry the snow mouse from melting, Tuffy and Jerry must race him to the fabled Snowman’s Village. In hot pursuit, Tom and devious Dr. Doublevay have their own plans for Larry’s magic",
                director = "Darrell Van Citters",
                rating = 8.0f
            )
        )

        add(
            Movie(
                id = 12,
                title = "Slumberland (2022)",
                genres = listOf("Family", "Fantasy", "Adventure", "Drama"),
                duration = "1h 57m",
                releasedAt = "Nov 09, 2022",
                overview = "A young girl discovers a secret map to the dreamworld of Slumberland, and with the help of an eccentric outlaw, she traverses dreams and flees nightmares, with the hope that she will be able to see her late father again",
                director = "Francis Lawrence",
                rating = 7.9f
            )
        )
    }

    return movies
}
package com.example.animalquiz

object Constants{


    const val USER_NAME: String = "user_name"
    const val ALL_QUESTIONS: String = "all_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val q1 = Questions(
            1, "Platypuses belong to class of: ",
            R.drawable.platypuses,
            optionOne = "Reptiles",
            "Mammals",
            "Fish",
            "Amphibians",
            2)
        questionsList.add(q1)
        val q2 = Questions(
            1, "How much does a blue whale weight?",
            R.drawable.whale,
            optionOne = "50 000 – 90 000 kg",
            "200 000 – 300 000 kg",
            "100 000 – 120 000 kg",
            "130 000 – 150 000 kg",
            4
        )
        questionsList.add(q2)

        val q3 = Questions(
            1, "How tall is a male giraffe?",
            R.drawable.giraffe,
            optionOne = "5 – 5,9 m",
            "4 – 4,5 m",
            "10 - 11 m",
            "3 – 4,8 m",
            1
        )
        questionsList.add(q3)

        val q4 = Questions(
            1, "Where can you find Komodo dragons?",
            R.drawable.komodo,
            optionOne = "Europe",
            "North and South America",
            "Australia",
            "Asia and Africa",
            4
        )
        questionsList.add(q4)

        val q5 = Questions(
            1, "What animal is on the picture?",
            R.drawable.chinchilla,
            optionOne = "Hamster",
            "Chinchilla",
            "Dog",
            "Squirrel",
            2
        )
        questionsList.add(q5)

        val q6 = Questions(
            1, "What is the name of a first dog that went to space?",
            R.drawable.laika,
            optionOne = "Dogollo",
            "Lenny",
            "Laika",
            "Lettuce",
            3
        )
        questionsList.add(q6)

        val q7 = Questions(
            1, "What is the biggest bird in the world?",
            R.drawable.bigbird,
            optionOne = "Ostrich",
            "Albatross",
            "Pelican",
            "Bald Eagle",
            1
        )
        questionsList.add(q7)

        val q8 = Questions(
            1, "How many words did Koko know?",
            R.drawable.koko,
            optionOne = "500",
            "2000",
            "0",
            "She knew them all",
            2
        )
        questionsList.add(q8)

        val q9 = Questions(
            1, "What animal causes the most deaths in humans?",
            R.drawable.deadly,
            optionOne = "Pigeons",
            "Mosquitoes",
            "Sharks",
            "Cows",
            2
        )
        questionsList.add(q9)

        val q10 = Questions(
            1, "What great ape is closest to humans?",
            R.drawable.human,
            optionOne = "Orangutans",
            "Gorillas",
            "Chimpanzees",
            "Bonobo",
            3
        )
        questionsList.add(q10)

        questionsList.shuffle()
        return questionsList
    }
}
package com.example.quizonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizonline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var quizModelList: MutableList<QuizModel>
    private lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizModelList = mutableListOf()
        getDataFromFirebase()
    }

    private fun setupRecyclerView() {
        binding.progressBar.visibility = View.GONE
        adapter = QuizListAdapter(quizModelList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getDataFromFirebase() {
        // Programming Quiz
        val listQuestionModel1 = mutableListOf<QuestionModel>()
        listQuestionModel1.add(QuestionModel("What is Android?", mutableListOf("Language", "OS", "Product", "None"), "OS"))
        listQuestionModel1.add(QuestionModel("Which company developed Kotlin?", mutableListOf("Google", "JetBrains", "Microsoft", "Apple"), "JetBrains"))
        listQuestionModel1.add(QuestionModel("What does IDE stand for?", mutableListOf("Integrated Development Environment", "Internal Development Environment", "Internet Development Environment", "Integrated Design Environment"), "Integrated Development Environment"))
        listQuestionModel1.add(QuestionModel("What is the file extension for a Kotlin file?", mutableListOf(".java", ".kt", ".kotlin", ".kot"), ".kt"))
        listQuestionModel1.add(QuestionModel("Which language is used for Android development?", mutableListOf("Python", "Java", "Swift", "C++"), "Java"))
        quizModelList.add(QuizModel("1", "Programming", "All the basic programming", "10", listQuestionModel1))

        // Geography Quiz
        val listQuestionModel2 = mutableListOf<QuestionModel>()
        listQuestionModel2.add(QuestionModel("What is the capital of France?", mutableListOf("Paris", "London", "Berlin", "Madrid"), "Paris"))
        listQuestionModel2.add(QuestionModel("Which continent is Australia in?", mutableListOf("Asia", "Europe", "Australia", "Antarctica"), "Australia"))
        listQuestionModel2.add(QuestionModel("What is the longest river in the world?", mutableListOf("Nile", "Amazon", "Yangtze", "Mississippi"), "Nile"))
        listQuestionModel2.add(QuestionModel("Which is the largest ocean?", mutableListOf("Atlantic", "Indian", "Pacific", "Arctic"), "Pacific"))
        listQuestionModel2.add(QuestionModel("Which country has the largest population?", mutableListOf("India", "USA", "China", "Russia"), "China"))
        quizModelList.add(QuizModel("2", "Geography", "Test your geography knowledge", "10", listQuestionModel2))

        // History Quiz
        val listQuestionModel3 = mutableListOf<QuestionModel>()
        listQuestionModel3.add(QuestionModel("Who was the first President of the United States?", mutableListOf("George Washington", "Thomas Jefferson", "Abraham Lincoln", "John Adams"), "George Washington"))
        listQuestionModel3.add(QuestionModel("In which year did World War II end?", mutableListOf("1945", "1918", "1939", "1965"), "1945"))
        listQuestionModel3.add(QuestionModel("Who discovered America?", mutableListOf("Christopher Columbus", "Leif Erikson", "Vasco da Gama", "Marco Polo"), "Christopher Columbus"))
        listQuestionModel3.add(QuestionModel("Who was known as the Iron Lady?", mutableListOf("Margaret Thatcher", "Indira Gandhi", "Golda Meir", "Angela Merkel"), "Margaret Thatcher"))
        listQuestionModel3.add(QuestionModel("Which civilization built the pyramids?", mutableListOf("Greek", "Roman", "Egyptian", "Mayan"), "Egyptian"))
        quizModelList.add(QuizModel("3", "History", "Explore historical events and figures", "15", listQuestionModel3))

        // Science Quiz
        val listQuestionModel4 = mutableListOf<QuestionModel>()
        listQuestionModel4.add(QuestionModel("What is the chemical symbol for water?", mutableListOf("O2", "H2O", "CO2", "HO"), "H2O"))
        listQuestionModel4.add(QuestionModel("What planet is known as the Red Planet?", mutableListOf("Mars", "Jupiter", "Saturn", "Venus"), "Mars"))
        listQuestionModel4.add(QuestionModel("What is the speed of light?", mutableListOf("300,000 km/s", "150,000 km/s", "450,000 km/s", "600,000 km/s"), "300,000 km/s"))
        listQuestionModel4.add(QuestionModel("Who developed the theory of relativity?", mutableListOf("Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla"), "Albert Einstein"))
        listQuestionModel4.add(QuestionModel("What is the powerhouse of the cell?", mutableListOf("Nucleus", "Ribosome", "Mitochondria", "Golgi apparatus"), "Mitochondria"))
        quizModelList.add(QuizModel("4", "Science", "Dive into scientific facts and theories", "15", listQuestionModel4))

        // Literature Quiz
        val listQuestionModel5 = mutableListOf<QuestionModel>()
        listQuestionModel5.add(QuestionModel("Who wrote 'Romeo and Juliet'?", mutableListOf("William Shakespeare", "Charles Dickens", "J.K. Rowling", "Mark Twain"), "William Shakespeare"))
        listQuestionModel5.add(QuestionModel("What is the first book of the Old Testament?", mutableListOf("Genesis", "Exodus", "Leviticus", "Numbers"), "Genesis"))
        listQuestionModel5.add(QuestionModel("Who is the author of '1984'?", mutableListOf("George Orwell", "Aldous Huxley", "Ray Bradbury", "Isaac Asimov"), "George Orwell"))
        listQuestionModel5.add(QuestionModel("Which book is considered the world's first novel?", mutableListOf("Don Quixote", "The Tale of Genji", "The Iliad", "The Odyssey"), "The Tale of Genji"))
        listQuestionModel5.add(QuestionModel("Who wrote 'Pride and Prejudice'?", mutableListOf("Jane Austen", "Charlotte Bronte", "Emily Bronte", "Mary Shelley"), "Jane Austen"))
        quizModelList.add(QuizModel("5", "Literature", "Test your knowledge of literature", "20", listQuestionModel5))

        setupRecyclerView()
    }
}

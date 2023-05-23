package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.fragment.databinding.FragmentQuizBinding



class QuizFragment : Fragment() {
    var questions = arrayOf("APa yang kamu minum saat kerja?",
                            "Apa yang kamu minum jika ingin relax?",
                            "Apa yang kamu minum ketika bangun tidur?")

    var coffe_score = 0
    var tea_score = 0
    var current_q = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity ).supportActionBar?.title = "Quizz"
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_quiz, container, false)


        val binding : FragmentQuizBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_quiz,container,false);
        binding.questionText.text = questions[current_q]
        binding.coffeBtn.setOnClickListener{
            coffe_score++
            nextQuestion(binding)
        }
        binding.teaBtn.setOnClickListener{
            tea_score++
            nextQuestion(binding)
        }
        return binding.root
    }
    fun nextQuestion(binding: FragmentQuizBinding){
        current_q++

        if(current_q < questions.size){
            binding.questionText.text = questions[current_q]
            Toast.makeText(context,"berhasil| coffescore = $coffe_score, teascore = $tea_score",Toast.LENGTH_SHORT).show()
        }else{
//            Toast.makeText(context,"sudah max",Toast.LENGTH_SHORT).show()
            var result = ""
            if(coffe_score >= 1 && tea_score >=1){
                result = "kamu suka dua-duanya"
            }else if( coffe_score < 1){
                result = "kamu pecinta teh"
            }else{
                result = "kamu pecinta kopi"
            }
            view?.findNavController()?.navigate(QuizFragmentDirections.actionQuizFragmentToFinishFragment(result))
        }
    }
}
package com.example.dorixona

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dorixona.adapter.BookAdapter
import com.example.dorixona.adapter.FilterAdapter
import com.example.dorixona.databinding.FragmentHomeBinding
import com.example.dorixona.model.Books

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var listRoman: MutableList<Books>
    private lateinit var listFilter: MutableList<String>
    private lateinit var listDarslik: MutableList<Books>
    private lateinit var listQissa: MutableList<Books>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        listFilter = mutableListOf()
        listRoman = mutableListOf()
        listDarslik = mutableListOf()
        listQissa = mutableListOf()
        LoadFilter()
        LoadRoman()
        LoadDarslik()
        LoadQissa()
        val filter = FilterAdapter(listFilter, object : FilterAdapter.MyBook{
            override fun onItemClick(book: Books) {
                TODO("Not yet implemented")
            }
        }, requireContext())

        binding.filter.adapter = filter
        binding.filter.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val adapter = BookAdapter(listRoman, object : BookAdapter.MyBook {
            override fun onItemClick(book: Books) {
                TODO("Not yet implemented")
            }
        }, requireContext())

        binding.roman.adapter = adapter
        binding.roman.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val adapter2 = BookAdapter(listDarslik, object : BookAdapter.MyBook {
            override fun onItemClick(book: Books) {
                TODO("Not yet implemented")
            }
        }, requireContext())
        binding.darslik.adapter = adapter2
        binding.darslik.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val adapter3 = BookAdapter(listQissa, object : BookAdapter.MyBook {
            override fun onItemClick(book: Books) {
                TODO("Not yet implemented")
            }
        }, requireContext())
        binding.qissalar.adapter = adapter3
        binding.qissalar.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        return binding.root
    }

    private fun LoadRoman() {
        listRoman.add(
            Books(
                "O'tkan kunlar",
                "Abdulla Qodiriy",
                R.drawable.utkan_kunlar,
                roman = true
            )
        )
        listRoman.add(
            Books(
                "Ufq",
                "Said Ahmad",
                R.drawable.ufq,
                roman = true
            )
        )
        listRoman.add(
            Books(
                "Manaschi",
                "Abdulhamid Ismoil",
                R.drawable.manaschi,
                roman = true
            )
        )
        listRoman.add(
            Books(
                "Sarob",
                "Abdulla Qahhor",
                R.drawable.sarob,
                roman = true
            )
        )
    }

    private fun LoadDarslik() {
        listDarslik.add(
            Books(
                "Matematika",
                "6-sinf",
                R.drawable.matem,
                darslik = true
            )
        )
        listDarslik.add(
            Books(
                "Fizika",
                "7-sinf",
                R.drawable.fizika,
                darslik = true
            )
        )
    }

    private fun LoadQissa() {
        listQissa.add(
            Books(
                "Dunyoning ishlari",
                "O'tkir Hoshimov",
                R.drawable.dunyoning_ishlari,
                qissa = true
            )
        )
        listQissa.add(
            Books(
                "Qariya",
                "Abbos Said",
                R.drawable.apple,
                darslik = true
            )
        )
    }

    private fun LoadFilter(){
        listFilter.add("Barchasi")
        listFilter.add("Darsliklar")
        listFilter.add("Diniy kitoblar")
        listFilter.add("Bepul kitoblar")
        listFilter.add("Romanlar")
        listFilter.add("Qissalar")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
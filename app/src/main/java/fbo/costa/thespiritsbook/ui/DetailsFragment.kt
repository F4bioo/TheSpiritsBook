package fbo.costa.thespiritsbook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import fbo.costa.thespiritsbook.R
import fbo.costa.thespiritsbook.databinding.DetailsFragmentBinding

class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()

    private var _binding: DetailsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Get data from MainFragment
        args.queAnsArgs?.let { queAns ->
            binding.apply {
                textId.text = String.format(getString(R.string.text_question_id), queAns.id)
                textQuestion.text = queAns.question
                textAnswer.text = queAns.answer
            }
        }
    }
}

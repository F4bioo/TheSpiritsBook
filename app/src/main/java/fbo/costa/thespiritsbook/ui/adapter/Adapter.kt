package fbo.costa.thespiritsbook.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import fbo.costa.thespiritsbook.R
import fbo.costa.thespiritsbook.data.model.QueAns
import fbo.costa.thespiritsbook.databinding.AdapterItemBinding
import fbo.costa.thespiritsbook.util.ListDiffCallBack

class Adapter(
    private val queAnsList: ArrayList<QueAns>,
    private val onClickListener: (queAns: QueAns) -> Unit
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val biding = AdapterItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(context, biding, onClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(queAnsList[position])
    }

    override fun getItemCount(): Int {
        return queAnsList.size
    }

    fun submitList(newList: ArrayList<QueAns>) {
        val oldList = queAnsList
        val diffResult = DiffUtil.calculateDiff(
            ListDiffCallBack(oldList, newList)
        )

        queAnsList.clear()
        queAnsList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(
        private val context: Context,
        private val binding: AdapterItemBinding,
        private val onClickListener: (queAns: QueAns) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(queAns: QueAns) {
            with(queAns) {
                binding.apply {
                    textId.text = String.format(context.getString(R.string.text_question_id), id)
                    textQuestion.text = question
                    textAnswer.text = answer

                    cardItem.setOnClickListener {
                        onClickListener(queAns)
                    }
                }
            }
        }
    }
}

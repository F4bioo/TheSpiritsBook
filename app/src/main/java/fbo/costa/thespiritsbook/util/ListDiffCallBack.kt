package fbo.costa.thespiritsbook.util

import androidx.recyclerview.widget.DiffUtil
import fbo.costa.thespiritsbook.data.model.QueAns

class ListDiffCallBack(
    private var oldCList: List<QueAns>,
    private var newList: List<QueAns>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldCList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldCList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldCList[oldItemPosition] == newList[newItemPosition]
    }
}

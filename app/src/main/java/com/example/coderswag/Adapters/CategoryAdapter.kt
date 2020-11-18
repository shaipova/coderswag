package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.Model.Category
import com.example.coderswag.R

class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder: ViewHolder

        if (convertView == null) {
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage) // элемент из category_list_item
            holder.categoryName = categoryView.findViewById(R.id.categoryName) // элемент из category_list_item

            categoryView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }


        val category = categories[position] //одна из категорий из дата-сервиса, лежащая в списке категорий

        //указание на имя пакета с картинками. в дата-сервисе оно должно быть точно таким же, как пакет в дравабл
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)

        holder.categoryImage?.setImageResource(resourceId) // пихаем в элемент с картинкой саму эту картинку, найденную в дравабл

        // тут проще - картинку искать не надо, просто тягаем текст из категории
        holder.categoryName?.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }

}
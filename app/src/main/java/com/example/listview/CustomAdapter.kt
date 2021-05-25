package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CompoundButton
import com.example.listview.databinding.ListviewItemBinding

class CustomAdapter(context: Context,private val businessCardArraylist:ArrayList<BusinessCard>):BaseAdapter() {

    private val inflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: ListviewItemBinding
    private var onoff_list = BooleanArray(120){false}

    override fun getCount(): Int =businessCardArraylist.size

    override fun getItem(p0: Int): Any =businessCardArraylist[p0]

    override fun getItemId(p0: Int): Long =p0.toLong()

//    ※ Adapter의 getView() 의 문제점
//    listview는 화면에 보여줄수있는 아이템의 개수만큼 getview를 실행하여 아이템을 보여준다. ⇒ inflate를 반복적으로 실행해서 비효율적임
//    스크롤시에는 화면에서 사라진 view를 재사용하여 데이터만 새롭게 setting하는 방식임
//    따라서 view를 재사용하기때문에 아래로 스크롤했다가 올라오면 기존의 데이터가 새롭게 setting되기 때문에 초기화되는것임.

// view : 항목당 inflation할 view, viewgroup : 부모 view
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
//    attachToParent : 부모뷰에 바로 붙일것인지 말것인지?
        binding=ListviewItemBinding.inflate(inflater,p2,false)

        binding.nameListviewItem.text=businessCardArraylist[position].name
        binding.contentsListviewItem.text=businessCardArraylist[position].contents

// 스위치 버튼을 누를때마다 위의 onoff_list에 체크 여부를 저장해두고
        binding.btnSwitch.setOnCheckedChangeListener { _, isChecked ->
            onoff_list[position] = isChecked
        }
// 스위치 버튼의 체크 여부를 저장해둔 리스트의 체크 상태로 띄워줌
        binding.btnSwitch.isChecked = onoff_list[position];

        return binding.root
    }
}
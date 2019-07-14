package br.com.pantufa.testing_20190625

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_of_coffees_item.*

//ver https://developer.android.com/guide/topics/ui/layout/recyclerview
//    https://www.raywenderlich.com/1560485-android-recyclerview-tutorial-with-kotlin

class ListOfCoffeesAdapter(private val data: List<CoffeeBeanModel>) : RecyclerView.Adapter<ListOfCoffeesAdapter.ViewHolder>() {

    //ViewHolder eh uma classezinha que simplesmente guarda uma referencia pras views do item, pra nao precisar buscá-las por id ao reciclar.
    //se couberem 7 itens visíveis na lista, existirão 7 viewholders, mesmo que a lista tenha 865543 itens. quando um item eh scrollado pra fora
    //da tela, as views dele sao repositcionadas no outro extremo da tela e os dados sao substituidos. é isso que chamamos de reciclagem de views.
    //nao precisamos de views novas, apenas mudar a posicao da que saiu da tela e atualizar os dados pra mostrar o novo item.
    //este é o proposito do recyclerView. essa reciclagem melhora drasticamente a performance em relacao a criar views novas quando scrolla.
    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer

    //esta funcao eh invocada pela lista ao criar cada ViewHolder. aqui temos q inflar o layout do item e fornece-lo ao viewholder. tambem
    //eh o local onde devemos fazer inicializacoes dos itens (coisas q só devem executar uma vez)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.list_of_coffees_item, parent, false)
        
        return ViewHolder(layout)
    }

    //esta funcao eh invocada ao reciclar. no momento que o recyclerView vai trocar os dados de um item pra reciclar ele chama essa sua funcao
    //e te passa o viewholder (pra vc acessar as views daquele item) e a posicao do item q ele esta vinculando. aqui temos que fazer a troca
    //dos dados que estao sendo mostrados.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.producerNameTextView.text = data[position].producer
        holder.processTextView.text = data[position].process
    }

    // este metodo eh usado pelo layoutManager internamente, apenas temos que falar pra ele quantos itens nossa lista tem no total,
    // que geralmente eh o tamanho da lista que passamos pro adapter. as vezes pode ser maior se tiver um cabeçalho por exemplo, aí
    // teriamos que somar 1.
    override fun getItemCount() = data.size
}

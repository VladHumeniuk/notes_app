package masters.vlad.humeniuk.notesviper.presentation.base.list;

import android.widget.AdapterView;

public interface ItemLongClickSelectedListener<E> extends AdapterView.OnItemSelectedListener {

    void onItemLongClick(E entity);
}

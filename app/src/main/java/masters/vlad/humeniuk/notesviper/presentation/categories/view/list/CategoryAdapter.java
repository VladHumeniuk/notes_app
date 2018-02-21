package masters.vlad.humeniuk.notesviper.presentation.categories.view.list;

import android.content.Context;
import android.view.View;

import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.domain.entity.Category;
import masters.vlad.humeniuk.notesviper.presentation.base.list.BaseAdapter;
import masters.vlad.humeniuk.notesviper.presentation.base.list.BaseViewHolder;

public class CategoryAdapter extends BaseAdapter<Category> {

    public CategoryAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemLayout(int viewType) {
        return R.layout.simple_list_item;
    }

    @Override
    protected BaseViewHolder createViewHolder(View itemView, int viewType) {
        return new CategoryViewHolder(itemView);
    }
}

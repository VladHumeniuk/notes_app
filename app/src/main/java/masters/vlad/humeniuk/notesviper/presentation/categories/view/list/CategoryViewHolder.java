package masters.vlad.humeniuk.notesviper.presentation.categories.view.list;

import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import butterknife.BindView;
import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.domain.entity.Category;
import masters.vlad.humeniuk.notesviper.presentation.base.list.BaseViewHolder;

public class CategoryViewHolder extends BaseViewHolder<Category> {

    @BindView(R.id.title)
    protected AppCompatTextView titleView;

    @BindView(R.id.container_view)
    protected View containerView;

    public CategoryViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Category entity) {
        super.bind(entity);
        titleView.setText(entity.getName());
        containerView.setBackgroundColor(Color.parseColor(entity.getColor()));
    }
}

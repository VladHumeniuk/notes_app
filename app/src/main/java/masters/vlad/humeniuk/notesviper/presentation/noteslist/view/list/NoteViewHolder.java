package masters.vlad.humeniuk.notesviper.presentation.noteslist.view.list;

import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import butterknife.BindView;
import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.domain.entity.Note;
import masters.vlad.humeniuk.notesviper.presentation.base.list.BaseViewHolder;

public class NoteViewHolder extends BaseViewHolder<Note> {

    @BindView(R.id.title)
    protected AppCompatTextView titleView;

    @BindView(R.id.container_view)
    protected View containerView;

    public NoteViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Note entity) {
        super.bind(entity);
        titleView.setText(entity.getTitle());
        containerView.setBackgroundColor(Color.parseColor(entity.getCategory().getColor()));
    }
}

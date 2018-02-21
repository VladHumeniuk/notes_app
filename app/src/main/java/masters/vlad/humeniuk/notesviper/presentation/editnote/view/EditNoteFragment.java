package masters.vlad.humeniuk.notesviper.presentation.editnote.view;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.inject.Inject;

import butterknife.BindView;
import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.di.components.ActivityComponent;
import masters.vlad.humeniuk.notesviper.domain.entity.Note;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseFragment;
import masters.vlad.humeniuk.notesviper.presentation.editnote.presenter.EditNotePresenter;

public class EditNoteFragment extends BaseFragment implements EditNoteView {

    private static final String NOTE_EXTRA = "note";

    @BindView(R.id.title)
    protected AppCompatEditText titleEditText;

    @BindView(R.id.description)
    protected AppCompatEditText descriptionEditText;

    @BindView(R.id.date_created)
    protected AppCompatTextView createdTextView;

    @BindView(R.id.date_edited)
    protected AppCompatTextView editedTextView;

    @Inject
    protected EditNotePresenter presenter;

    private DateFormat dateFormat = new SimpleDateFormat();

    public static EditNoteFragment newInstance(Note note) {

        Bundle args = new Bundle();
        args.putParcelable(NOTE_EXTRA, note);

        EditNoteFragment fragment = new EditNoteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showNote(Note note) {
        titleEditText.setText(note.getTitle());
        descriptionEditText.setText(note.getDescription());
        createdTextView.setText(dateFormat.format(note.getDateCreated()));
        editedTextView.setText(dateFormat.format(note.getDateLastEdit()));
    }

    @Override
    public void showEmptyFieldsError() {
        new AlertDialog.Builder(getBaseActivity())
                .setTitle(R.string.empty_note_fields_error)
                .setCancelable(true)
                .show();
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_edit_note;
    }

    @Override
    protected int getTitle() {
        return 0;
    }
}

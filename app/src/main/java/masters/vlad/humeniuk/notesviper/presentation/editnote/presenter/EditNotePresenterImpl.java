package masters.vlad.humeniuk.notesviper.presentation.editnote.presenter;

import android.text.TextUtils;

import java.util.Calendar;
import java.util.Date;

import masters.vlad.humeniuk.notesviper.domain.entity.Note;
import masters.vlad.humeniuk.notesviper.presentation.editnote.router.EditNoteRouter;
import masters.vlad.humeniuk.notesviper.presentation.editnote.view.EditNoteView;

public class EditNotePresenterImpl implements EditNotePresenter {

    private EditNoteRouter router;

    private EditNoteView view;

    private Note note;

    public EditNotePresenterImpl(EditNoteRouter router) {
        this.router = router;
    }

    @Override
    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    public void saveNote(String title, String description) {
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            view.showEmptyFieldsError();
        } else {Note note = new Note();
            note.setTitle(title);
            note.setDescription(description);
            Date date = Calendar.getInstance().getTime();
            note.setDateLastEdit(date);
            saveNote(note);
        }
    }

    @Override
    public void setView(EditNoteView view) {
        this.view = view;
    }

    private void saveNote(Note note) {
        //TODO save
    }
}

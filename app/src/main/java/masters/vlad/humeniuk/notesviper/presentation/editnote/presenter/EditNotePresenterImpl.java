package masters.vlad.humeniuk.notesviper.presentation.editnote.presenter;

import android.text.TextUtils;

import java.util.Calendar;
import java.util.Date;

import io.reactivex.Scheduler;
import masters.vlad.humeniuk.notesviper.domain.entity.Note;
import masters.vlad.humeniuk.notesviper.domain.interactors.DeleteNoteInteractor;
import masters.vlad.humeniuk.notesviper.domain.interactors.EditNoteInteractor;
import masters.vlad.humeniuk.notesviper.presentation.base.RxPresenter;
import masters.vlad.humeniuk.notesviper.presentation.editnote.router.EditNoteRouter;
import masters.vlad.humeniuk.notesviper.presentation.editnote.view.EditNoteView;

public class EditNotePresenterImpl extends RxPresenter implements EditNotePresenter {

    private EditNoteRouter router;

    private EditNoteView view;

    private Note note;

    private Scheduler ioScheduler;

    private Scheduler uiSCheduler;

    private EditNoteInteractor editNoteInteractor;

    private DeleteNoteInteractor deleteNoteInteractor;

    public EditNotePresenterImpl(EditNoteRouter router, Scheduler ioScheduler,
                                 Scheduler uiSCheduler, EditNoteInteractor editNoteInteractor,
                                 DeleteNoteInteractor deleteNoteInteractor) {
        this.router = router;
        this.ioScheduler = ioScheduler;
        this.uiSCheduler = uiSCheduler;
        this.editNoteInteractor = editNoteInteractor;
        this.deleteNoteInteractor = deleteNoteInteractor;
    }

    @Override
    public void setNote(Note note) {
        this.note = note;
        view.showNote(note);
    }

    @Override
    public void saveNote(String title, String description) {
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            view.showEmptyFieldsError();
        } else {
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

    @Override
    public void deleteNote() {
        subscribe(1, deleteNoteInteractor.deleteNote(note)
                .subscribeOn(ioScheduler)
                .observeOn(uiSCheduler)
                .subscribe(result -> router.backToMain()));
    }

    private void saveNote(Note note) {
        subscribe(0, editNoteInteractor.editNote(note)
                .subscribeOn(ioScheduler)
                .observeOn(uiSCheduler)
                .subscribe(result -> router.backToMain()));
    }
}

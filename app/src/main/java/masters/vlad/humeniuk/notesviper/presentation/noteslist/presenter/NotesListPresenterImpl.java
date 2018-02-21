package masters.vlad.humeniuk.notesviper.presentation.noteslist.presenter;

import io.reactivex.Scheduler;
import masters.vlad.humeniuk.notesviper.domain.entity.Note;
import masters.vlad.humeniuk.notesviper.domain.interactors.NotesListInteractor;
import masters.vlad.humeniuk.notesviper.presentation.base.RxPresenter;
import masters.vlad.humeniuk.notesviper.presentation.noteslist.router.NotesListRouter;
import masters.vlad.humeniuk.notesviper.presentation.noteslist.view.NotesListView;

public class NotesListPresenterImpl extends RxPresenter implements NotesListPresenter {

    private NotesListRouter router;

    private NotesListView view;

    private Scheduler ioScheduler;

    private Scheduler uiScheduler;

    private NotesListInteractor notesListInteractor;

    public NotesListPresenterImpl(NotesListRouter router, Scheduler ioScheduler,
                                  Scheduler uiScheduler, NotesListInteractor notesListInteractor) {
        this.router = router;
        this.ioScheduler = ioScheduler;
        this.uiScheduler = uiScheduler;
        this.notesListInteractor = notesListInteractor;
    }

    public void setView(NotesListView notesListView) {
        this.view = notesListView;
    }

    @Override
    public void loadNotes() {
        subscribe(0, notesListInteractor.getNotesList()
                .subscribeOn(ioScheduler)
                .observeOn(uiScheduler)
                .subscribe(view::showNotesList));
    }

    @Override
    public void onNoteSelected(Note note) {
        router.openNotesDetails(note);
    }

    @Override
    public void onCreateNote() {
        router.openCreateNote();
    }
}

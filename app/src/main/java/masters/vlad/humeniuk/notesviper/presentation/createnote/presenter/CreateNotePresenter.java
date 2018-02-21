package masters.vlad.humeniuk.notesviper.presentation.createnote.presenter;

import masters.vlad.humeniuk.notesviper.presentation.createnote.view.CreateNoteView;

public interface CreateNotePresenter {

    void onSaveNote(String title, String description);

    void setView(CreateNoteView view);
}
